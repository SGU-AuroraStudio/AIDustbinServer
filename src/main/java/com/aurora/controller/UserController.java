package com.aurora.controller;

import com.aurora.domain.User;
import com.aurora.domain.base.Constants;
import com.aurora.domain.base.ResponseJSON;
import com.aurora.service.impl.UserServiceImpl;
import com.aurora.util.RandomNickName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

/**
 * @Author Yao
 * @Date 2021/3/21 19:50
 * @Description 用户控制类
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    /**
     * 登录前判断页面
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
    @RequestMapping(value = "/register", method = {RequestMethod.POST})
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
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    Map<String, Object> update(HttpServletRequest request, User user, @RequestParam(value = "file", required = false) @Validated MultipartFile file) {
        System.out.println("update...");
        //判断用户是否为session中的用户
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute(Constants.SESSION_USER);
        if (!user.getId().equals(loginUser.getId()))
            return ResponseJSON.FAIL.getJSON();
        File targetFile = null;
        boolean fileSaveSuccess = false;
        //尝试保存图片
        if (file != null) {
            //文件夹路径
            String folderPath = Constants.LOCAL_PROFILE_BASE_PATH;
            //----设置文件名----
            //格式化日期
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
            //文件名，例：userId_2021-03-29 11：38：30_阿巴阿巴.jpg
            String fileName = user.getId() + "_" + sdf.format(new Date()) + "_" + file.getOriginalFilename();
            //win文件名不能有<>?:"/\|*
            Pattern r = Pattern.compile("\\/.?\"<>|: "); //空格也一起匹配了
            fileName = r.matcher(fileName).replaceAll("");
            //----设置文件名----
            File folder = new File(folderPath);
            targetFile = new File(folderPath, fileName);
            //检查文件夹是否存在
            if (!folder.exists())
                folder.mkdirs();
            //保存文件，当前模式会覆盖旧文件
            try {
                file.transferTo(targetFile);
                System.out.println(folderPath + fileName);
                //设置用户图片url
                user.setProfile(Constants.SERVER_BASE_HTTP_URL + "/profile/" + fileName);
                fileSaveSuccess = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //如果更新数据库成功
        if (userService.updateById(user)) {
            //更新session里的用户信息并返回JSON
            User newUser = userService.selectById(user.getId());
            session.setAttribute(Constants.SESSION_USER, newUser);
            if (file != null && !fileSaveSuccess)
                return ResponseJSON.USER_UPDATE_SUCCESS_BUT_PROFILE_ERROR.getJSON(newUser);
            return ResponseJSON.SUCCESS.getJSON(newUser);
        } else {
            //把上传的图片删掉
            if (targetFile != null && targetFile.exists() && file!=null)
                targetFile.delete();
            return ResponseJSON.FAIL.getJSON();
        }

    }


}
