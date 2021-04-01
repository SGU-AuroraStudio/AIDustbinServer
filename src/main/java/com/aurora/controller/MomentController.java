package com.aurora.controller;

import com.aurora.domain.Moment;
import com.aurora.domain.MomentImage;
import com.aurora.domain.User;
import com.aurora.domain.base.Constants;
import com.aurora.domain.base.ResponseJSON;
import com.aurora.service.impl.MomentImageServiceImpl;
import com.aurora.service.impl.MomentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author Yao
 * @Date 2021/4/1 18:42
 * @Description
 */
@Controller
@RequestMapping("/moment")
public class MomentController {

    @Autowired
    MomentServiceImpl momentService;
    @Autowired
    MomentImageServiceImpl momentImageService;

    @GetMapping
    @ResponseBody
    public Map<String, Object> getMoment(){
        List<Moment> moments = momentService.selectAll();
        return ResponseJSON.SUCCESS.getJSON(moments);
    }

    @PostMapping("delete/{id}")
    @ResponseBody
    public Map<String, Object> deleteMoment(HttpServletRequest request,@PathVariable Integer id){
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
        Moment moment = momentService.selectById(id);
        //检查登录人id和动态的发表人id是否相同，不同就不给操作
        if(moment.getUserId().equals(user.getId()))
            return ResponseJSON.FAIL.getJSON();

        if(momentService.deleteById(id))
            return ResponseJSON.SUCCESS.getJSON();
        else
            return ResponseJSON.FAIL.getJSON();
    }


    @PostMapping()
    @ResponseBody
    public Map<String, Object> addMoment(HttpServletRequest request, @RequestParam(value = "content") String content, MultipartFile[] images) throws IOException {

        //插入动态内容
        Moment moment = new Moment();
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
        moment.setUserId(user.getId());
        moment.setContent(content);
        moment.setCreatedTime(new Date());
        momentService.insert(moment);
        //插入图片
        if(images!=null && images.length>0) {
            for (MultipartFile image : images) {
                if(image.getSize()<10)
                    continue;
                MomentImage momentImage = new MomentImage(null, moment.getId(), new Date(), false, image.getBytes());
                if(!momentImageService.insert(momentImage))
                    return ResponseJSON.FAIL.getJSON();
            }
        }
        return ResponseJSON.SUCCESS.getJSON(moment);
    }
}
