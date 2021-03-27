package com.aurora.controller;

import com.aurora.domain.base.RespJSON;
import com.aurora.domain.base.StatusCode;
import com.aurora.service.impl.QNAServiceImpl;
import com.aurora.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Yao
 * @Date 2021/3/23 12:10
 * @Description 问答Q&A控制类
 */
@Controller
@RequestMapping("/qna")
public class QNAController {
    @Autowired
    QNAServiceImpl qnaService;

    @RequestMapping("")
    @ResponseBody
    RespJSON getRandomQNA(HttpServletRequest request){
        return new RespJSON(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), qnaService.getRandomQNA());
    }

    RespJSON judge(){
        return new RespJSON(StatusCode.NOT_LOGIN.getCode(), StatusCode.NOT_LOGIN.getMsg(), null);
    }
}
