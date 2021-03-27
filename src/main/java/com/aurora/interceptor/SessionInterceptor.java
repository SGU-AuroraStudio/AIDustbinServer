package com.aurora.interceptor;

import com.aurora.util.Constants;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Yao
 * @Date 2021/3/26 22:30
 * @Description
 */

public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute(Constants.SESSION_KEY)==null) {
            request.getRequestDispatcher("/user/login").forward(request, response);
            return false;
        }else {
            return true;
        }
    }

}
