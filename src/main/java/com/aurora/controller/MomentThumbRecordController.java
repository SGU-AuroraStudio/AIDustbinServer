package com.aurora.controller;

import com.aurora.domain.MomentThumbRecord;
import com.aurora.domain.User;
import com.aurora.domain.base.Constants;
import com.aurora.domain.base.ResponseJSON;
import com.aurora.service.impl.MomentServiceImpl;
import com.aurora.service.impl.MomentThumbRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author Yao
 * @Date 2021/4/4 12:58
 * @Description
 */
@Controller
@RequestMapping("/moment/thumb")
public class MomentThumbRecordController {
    @Autowired
    MomentThumbRecordServiceImpl momentThumbRecordService;
    @Autowired
    MomentServiceImpl momentService;

    /**
     * 点赞。只需要传入点赞哪个动态，用户信息在后台session获取。
     * 实现为：请求->查询有没有点赞记录->有->翻转deleted 无->插入点赞为true
     *
     * @param momentId momentId
     * @return JSON
     */
    @PostMapping
    @ResponseBody
    public Map<String, Object> doThumb(HttpServletRequest request, Integer momentId) {
        //检查动态是否存在
        if (momentService.selectById(momentId) == null)
            return ResponseJSON.FAIL.getJSON();
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
        //查询数据库里是否有记录
        MomentThumbRecord momentThumbRecord = momentThumbRecordService.selectByUserIdAndMomentId(user.getId(), momentId);
        //如果点赞表没有记录
        if (momentThumbRecord == null) {
            momentThumbRecord = new MomentThumbRecord(user.getId(), user.getNickname(), user.getProfile(), momentId, new Date());
            if (momentThumbRecordService.insert(momentThumbRecord))
                return ResponseJSON.SUCCESS.getJSON();
        }
        //有记录就把deleted改为翻转
        else {
            if (momentThumbRecordService.updateDeleted(user.getId(), momentId))
                return ResponseJSON.SUCCESS.getJSON();
        }
        return ResponseJSON.FAIL.getJSON();
    }

    /**
     * 获取点赞记录
     *
     * @param momentId momentId
     * @return JSON
     */
    @GetMapping
    @ResponseBody
    public Map<String, Object> getThumbRecord(Integer momentId) {
        List<MomentThumbRecord> momentThumbRecords = momentThumbRecordService.selectByMomentId(momentId);
        return ResponseJSON.SUCCESS.getJSON(momentThumbRecords);
    }

}
