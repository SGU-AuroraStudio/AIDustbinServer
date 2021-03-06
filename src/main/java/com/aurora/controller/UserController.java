package com.aurora.controller;

import com.aurora.domain.Comment;
import com.aurora.domain.Moment;
import com.aurora.domain.User;
import com.aurora.domain.base.Constants;
import com.aurora.domain.base.ResponseJSON;
import com.aurora.service.impl.CommentServiceImpl;
import com.aurora.service.impl.MomentServiceImpl;
import com.aurora.service.impl.UserServiceImpl;
import com.aurora.util.RandomNickName;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;

/**
 * @Author Yao
 * @Date 2021/3/21 19:50
 * @Description 用户控制类
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LogManager.getLogger(UserController.class);
    @Autowired
    UserServiceImpl userService;
    @Autowired
    MomentServiceImpl momentService;
    @Autowired
    CommentServiceImpl commentService;

    /**
     * 登录前判断页面，检查有没有登录
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    Map<String, Object> login(HttpServletRequest request) {
        System.out.println("loginPage...");
        if (request.getSession().getAttribute(Constants.SESSION_KEY) != null)
            return ResponseJSON.SUCCESS.getJSON(Constants.SESSION_USER);
        else
            return ResponseJSON.NOT_LOGIN.getJSON();
    }

    /**
     * 执行登录
     *
     * @param id       用户名/手机号/邮箱
     * @param password 密码
     */
    //TODO:id和account需要限制，详情见github提交记录
    @RequestMapping(value = "/doLogin", method = {RequestMethod.POST})
    @ResponseBody
    Map<String, Object> doLogin(
            HttpServletRequest request, String id, String password) {
        System.out.println("doLogin...");
        User user = userService.login(id, password);
        //如果user!=null，登录成功
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute(Constants.SESSION_KEY, session.getId());
            session.setAttribute(Constants.SESSION_USER, user);
            return ResponseJSON.SUCCESS.getJSON(user);
        } else
            return ResponseJSON.USER_INFO_ERROR.getJSON();
    }

    /**
     * 注册
     *
     * @param id       用户名
     * @param account  手机号或邮箱
     * @param password 密码
     */
    @PostMapping("/register")
    @ResponseBody
    Map<String, Object> register(String id, String account, String password) {
        System.out.println("register...");
        //用户存在，直接返回
        if (userService.selectById(id) != null)
            return ResponseJSON.USER_EXITS.getJSON();
        User user = new User(id, account, password, RandomNickName.generateName(), null, null, new Date(), null);
        //注册
        if (userService.register(user))
            return ResponseJSON.SUCCESS.getJSON(user);
        else
            return ResponseJSON.FAIL.getJSON(user);
    }

    /**
     * 更新用户数据，注意：id一定要有，其它随意
     * MultipartFile需要在spring-mvc.xml配置解析器
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    Map<String, Object> update(HttpServletRequest request, User user, MultipartFile file) {
        System.out.println("update...");
        //TODO:临时调试用
        log.debug(user.getNickname());
        log.debug(user.getPassword());
        log.debug(file);
        //判断是不是图片
        if (file!=null && !file.getContentType().contains("image"))
            return ResponseJSON.PARAM_ERROR.getJSON();
        //给参数加上id，从session获取用户
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute(Constants.SESSION_USER);
        user.setId(loginUser.getId());

        File targetFile = null;
        boolean fileSaveSuccess = false;
        //尝试保存图片
        if(file!=null) {
            //限制图片大小为5M
            if (file.getSize() > 5 * 1024 * 1024)
                return ResponseJSON.MAX_SIZE_ERROR.getJSON();
            //----设置文件名----
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
            //文件名，例：userId_2021-03-29 11：38：30_阿巴阿巴.jpg
            String fileName = user.getId() + "_" + sdf.format(new Date()) + "_" + file.getOriginalFilename();
            //win文件名不能有<>?:"/\|*
            Pattern r = Pattern.compile("\\/.?\"<>|: "); //空格也一起匹配了
            fileName = r.matcher(fileName).replaceAll("");
            //----设置文件名----
            File folder = new File(Constants.LOCAL_PROFILE_BASE_PATH);
            targetFile = new File(Constants.LOCAL_PROFILE_BASE_PATH, fileName);
            if (!folder.exists())
                folder.mkdirs();
            //保存文件，当前模式会覆盖旧文件
            try {
                file.transferTo(targetFile);
                //设置用户图片url
                user.setProfile(Constants.SERVER_BASE_HTTP_URL + "/profile/" + fileName);
                fileSaveSuccess = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //如果更新数据库成功
        if (userService.updateById(user)) {
            //因为不知道更新了什么，所以新用户信息从数据库加载
            //更新session里的用户信息并返回JSON
            User newUser = userService.selectById(user.getId());
            session.setAttribute(Constants.SESSION_USER, newUser);
            //更新Moment和Comment里响应的发表者信息
            Moment moment = new Moment();
            moment.setUserId(newUser.getId());
            moment.setUserNickname(newUser.getNickname());
            moment.setUserProfile(newUser.getProfile());
            momentService.updateUserByUserId(moment);
            Comment comment = new Comment();
            comment.setFromUserId(newUser.getId());
            comment.setFromUserNickname(newUser.getNickname());
            comment.setFromUserProfile(newUser.getProfile());
            commentService.updateFromUserByUserId(comment);
            //有传图片，但是却保存失败
            if (file != null && !fileSaveSuccess)
                return ResponseJSON.USER_UPDATE_SUCCESS_BUT_PROFILE_ERROR.getJSON(newUser);
            return ResponseJSON.SUCCESS.getJSON(newUser);
        } else {
            //上传数据库失败，把保存的图片删掉
            if (targetFile != null && targetFile.exists() && file != null)
                targetFile.delete();
            return ResponseJSON.FAIL.getJSON();
        }

    }

}
