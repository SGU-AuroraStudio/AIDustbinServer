package com.aurora.controller;

import com.aurora.domain.QNARank;
import com.aurora.domain.QNARecord;
import com.aurora.domain.User;
import com.aurora.domain.WasteType;
import com.aurora.domain.base.RespJSON;
import com.aurora.domain.base.StatusCode;
import com.aurora.service.impl.QNARecordServiceImpl;
import com.aurora.service.impl.QNAServiceImpl;
import com.aurora.service.impl.WasteTypeServiceImpl;
import com.aurora.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

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
    @Autowired
    WasteTypeServiceImpl wasteTypeService;
    @Autowired
    QNARecordServiceImpl qnaRecordService;

    //TODO:需要修改成获取N道题，一道一道选可能会重复

    /**
     * 随机获取题目
     *
     * @return QNA
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    RespJSON getRandomQNA() {
        return new RespJSON(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), qnaService.getRandomQNA());
    }

    /**
     * 判断用户是否选对了
     *
     * @param qId    题目的id
     * @param choose 用户选的选项的内容（垃圾类型）
     * @return JSON
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    RespJSON judge(HttpServletRequest request,String uId, Integer qId, String choose) {
        //检查选项是否存在
        WasteType chooseType = wasteTypeService.selectByName(choose);
        if (chooseType == null)
            return new RespJSON(StatusCode.CHOOSE_NOT_FOUND.getCode(), StatusCode.CHOOSE_NOT_FOUND.getMsg(), null);
        //从session取得用户信息
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Constants.SESSION_USER);
        //判断是否选择正确
        if (qnaService.judge(qId, chooseType.getId())) {
            //选择正确就使数据库right记录+1
            qnaService.updateQNARightAddOneById(qId);
            //插入选择记录
            QNARecord qnaRecord = new QNARecord(uId, qId, chooseType.getId(), true, new Date());
            qnaRecordService.insertOne(qnaRecord);
            return new RespJSON(StatusCode.CHOOSE_RIGHT.getCode(), StatusCode.CHOOSE_RIGHT.getMsg(), null);
        } else {
            //选择错误就使数据库wrong记录+1
            qnaService.updateQNAWrongAddOneById(qId);
            //插入选择记录
            QNARecord qnaRecord = new QNARecord(uId, qId, chooseType.getId(), false, new Date());
            qnaRecordService.insertOne(qnaRecord);
            return new RespJSON(StatusCode.CHOOSE_WRONG.getCode(), StatusCode.CHOOSE_WRONG.getMsg(), null);
        }
    }

    /**
     * 排行榜
     *
     * @return List<QNA>
     */
    @RequestMapping(value = "/rank", method = RequestMethod.GET)
    @ResponseBody
    RespJSON getRankList() {
        List<QNARank> list = qnaRecordService.selectQNARank();
        return new RespJSON(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), list);
    }
}
