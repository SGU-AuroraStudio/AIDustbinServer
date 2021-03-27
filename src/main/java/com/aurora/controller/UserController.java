package com.aurora.controller;

import com.aurora.domain.User;
import com.aurora.domain.base.RespJSON;
import com.aurora.domain.base.StatusCode;
import com.aurora.service.impl.UserServiceImpl;
import com.aurora.util.Constants;
import com.aurora.util.RandomNickName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

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
    RespJSON login(HttpServletRequest request) {
        System.out.println("loginPage...");
        if (request.getSession().getAttribute(Constants.SESSION_KEY) == null)
            return new RespJSON(StatusCode.NOT_LOGIN.getCode(), StatusCode.NOT_LOGIN.getMsg(), null);
        return new RespJSON(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), request.getSession().getAttribute(Constants.SESSION_USER));
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
    RespJSON doLogin(
            HttpServletRequest request, String id, String password) {
        System.out.println("doLogin...");
        User user = userService.login(id, password);
        //user==null，返回登录失败
        if (user == null)
            return new RespJSON(StatusCode.USER_INFO_ERROR.getCode(), StatusCode.USER_INFO_ERROR.getMsg(), null);
            //登录成功
        else {
            HttpSession session = request.getSession();
            session.setAttribute(Constants.SESSION_KEY, session.getId());
            session.setAttribute(Constants.SESSION_USER, user);
            return new RespJSON(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), user);
        }
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
    RespJSON register(String id, String account, String password) {
        System.out.println("register...");
        User user = null;
        //用户存在，直接返回
        if (userService.selectById(id) != null) {
            return new RespJSON(StatusCode.USER_EXITS.getCode(), StatusCode.USER_EXITS.getMsg(), null);
        }
        user = new User(id, account, password, RandomNickName.generateName(), null, null, new Date(), null);
        //注册
        if (userService.register(user))
            return new RespJSON(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), user);
        else
            return new RespJSON(StatusCode.FAIL.getCode(), StatusCode.FAIL.getMsg(), user);
    }

    /**
     * 更新用户数据，注意：id一定要有，其它随意
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    RespJSON update(HttpServletRequest request, User user) {
        System.out.println("update...");
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute(Constants.SESSION_USER);
        if (!user.getId().equals(loginUser.getId())) {
            return new RespJSON(StatusCode.FAIL.getCode(), StatusCode.FAIL.getMsg(), null);
        }
        //如果更新数据库成功
        if (userService.updateById(user)) {
            //更新session里的用户信息并返回JSON
            User newUser = userService.selectById(user.getId());
            session.setAttribute(Constants.SESSION_USER, newUser);
            return new RespJSON(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), newUser);
        }
        return new RespJSON(StatusCode.FAIL.getCode(), StatusCode.FAIL.getMsg(), null);
    }

}
