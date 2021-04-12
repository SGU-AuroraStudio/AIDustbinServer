package com.aurora.interceptor;

import com.aurora.domain.base.Constants;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Yao
 * @Date 2021/3/26 22:30
 * @Description
 */

public class SessionInterceptor implements HandlerInterceptor {

    /**
     * 拦截器，防止未登录进行操作
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //因为这里只能返回true或false，所以跳转到login，让login返回没登录的信息。也因此不能拦截login页面
        if(request.getSession().getAttribute(Constants.SESSION_USER)==null) {
            request.getRequestDispatcher("/user/login").forward(request, response);
            return false;
        }else {
            return true;
        }
    }

}
