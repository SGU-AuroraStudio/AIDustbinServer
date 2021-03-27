package com.aurora.controller;

import com.aurora.domain.base.RespJSON;
import com.aurora.domain.base.StatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Yao
 * @Date 2021/3/27 19:25
 * @Description
 */
@Controller
public class ErrorController {

    @RequestMapping("/404")
    @ResponseBody
    RespJSON page404() {
        return new RespJSON(StatusCode.NOT_FOUND_ERROR_404.getCode(), StatusCode.NOT_FOUND_ERROR_404.getMsg(), null);
    }

    @RequestMapping("/500")
    @ResponseBody
    RespJSON page500() {
        return new RespJSON(StatusCode.SERVER_ERROR_500.getCode(), StatusCode.SERVER_ERROR_500.getMsg(), null);
    }
}
