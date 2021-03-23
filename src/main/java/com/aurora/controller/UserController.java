package com.aurora.controller;

import com.aurora.domain.User;
import com.aurora.service.IUserService;
import com.aurora.service.impl.UserServiceImpl;
import com.aurora.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/login")
    @ResponseBody
    Boolean login(
            HttpServletRequest request,
            @RequestParam(value = "account", required = false) String id,
            @RequestParam(value = "password", required = false) String password) {
        System.out.println("login...");
        System.out.println("用户名：" + id);
        System.out.println("密码：" + password);
        User user = userService.login(id, password);
        if (user != null || request.getSession().getAttribute(Constants.SESSION_KEY) != null) {
            String sessionId = request.getSession().getId();
            request.getSession().setAttribute(Constants.SESSION_KEY, sessionId);
            System.out.println(sessionId);
            return true;
        } else
            return false;
    }


    @RequestMapping("/register")
    @ResponseBody
    String register(@RequestParam("account") String id, String password, String name) {
        System.out.println("register...");
        if (userService.findById(id) != null)
            return "用户名已存在";
        if (userService.register(id, password, name))
            return "true";
        else
            return "false";
    }

}
