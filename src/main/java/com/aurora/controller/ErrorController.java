package com.aurora.controller;

import com.aurora.domain.base.ResponseJSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author Yao
 * @Date 2021/3/27 19:25
 * @Description
 */
@Controller
public class ErrorController {

    @RequestMapping("/404")
    @ResponseBody
    Map<String, Object> page404() {
        return ResponseJSON.NOT_FOUND_ERROR_404.getJSON();
    }

    @RequestMapping("/500")
    @ResponseBody
    Map<String, Object> page500() {
        return ResponseJSON.SERVER_ERROR_500.getJSON();
    }

    @RequestMapping("/maxSizeError")
    @ResponseBody
    Map<String, Object> maxSizeError() {
        return ResponseJSON.MAX_SIZE_ERROR.getJSON();
    }
}
