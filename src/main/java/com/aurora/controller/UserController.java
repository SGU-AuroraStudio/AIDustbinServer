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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(value = "/login")
    @ResponseBody
    RespJSON login(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("loginPage...");
        if(request.getSession().getAttribute(Constants.SESSION_KEY)==null)
            return new RespJSON(StatusCode.NOT_LOGIN.getCode(), StatusCode.NOT_LOGIN.getMsg(), request.getSession().getAttribute(Constants.SESSION_USER));
        else
            return new RespJSON(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), request.getSession().getAttribute(Constants.SESSION_USER));
    }

    //TODO:只传两个参数，id和password，实现根据用户名或手机号或邮箱登录
    @RequestMapping(value = "/doLogin", method = {RequestMethod.POST})
    @ResponseBody
    RespJSON doLogin(
            HttpServletRequest request,
            @RequestParam(value = "id", required = false) String id,
            @RequestParam(value = "account", required = false) String account,
            @RequestParam(value = "password", required = false) String password) {
        System.out.println("doLogin...");
        User user = userService.login(id, account, password);
        //user==null，登录失败
        if(user == null)
            return new RespJSON(StatusCode.USER_INFO_ERROR.getCode(),StatusCode.USER_INFO_ERROR.getMsg(),null);
        //登录成功
        else {
            HttpSession session = request.getSession();
            session.setAttribute(Constants.SESSION_KEY,session.getId());
            session.setAttribute(Constants.SESSION_USER,user);
            return new RespJSON(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), user);
        }
    }

    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    @ResponseBody
    RespJSON register(String id, String account, String password) {
        System.out.println("register...");
        User user=null;
        //用户存在，直接返回
        if (userService.findById(id) != null) {
            return new RespJSON(StatusCode.USER_EXITS.getCode(),StatusCode.USER_EXITS.getMsg(),null);
        }
        user = new User(id, account, password, RandomNickName.generateName(), null, null, new Date(), null);
        //注册
        if (userService.register(user))
            return new RespJSON(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), user);
        else
            return new RespJSON(StatusCode.FAIL.getCode(), StatusCode.FAIL.getMsg(), user);
    }

}
