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

@Controller
@RequestMapping("/qna")
public class QNAController {
    @Autowired
    QNAServiceImpl qnaService;

    @RequestMapping("")
    @ResponseBody
    RespJSON getRandomQNA(HttpServletRequest request){
        if(request.getSession().getAttribute(Constants.SESSION_KEY) == null)
            return new RespJSON(StatusCode.NOT_LOGIN.getCode(), StatusCode.NOT_LOGIN.getMsg(), null);
        else
            return new RespJSON(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), qnaService.getRandomQNA());
    }
}
