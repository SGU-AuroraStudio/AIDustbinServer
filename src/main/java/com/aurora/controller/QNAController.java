package com.aurora.controller;

import com.aurora.domain.QNA;
import com.aurora.service.impl.QNAServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/QNA")
public class QNAController {
    @Autowired
    QNAServiceImpl qnaService;

    @RequestMapping("/randomQNA")
    @ResponseBody
    QNA getRandomQNA(){
        return qnaService.getRandomQNA();
    }
}
