package com.aurora.controller;

import com.aurora.domain.MomentImage;
import com.aurora.service.impl.MomentImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Yao
 * @Date 2021/4/2 0:05
 * @Description
 */
@Controller
@RequestMapping("moment/image")
public class MomentImageController {
    @Autowired
    MomentImageServiceImpl momentImageService;

    //TODO:目前的评论是一次性获取图片和内容，不太好，这样一次加载太久。考虑改成一次加载内容，一次加载图片。
    @GetMapping("/{momentId}/{imageNo}")
    public void getImages(HttpServletResponse response, @PathVariable Integer momentId, @PathVariable Integer imageNo) throws IOException {
        MomentImage momentImage = momentImageService.selectByMomentIdAndImageNo(momentId, imageNo);
        if (momentImage != null && momentImage.getImage() != null && momentImage.getImage().length > 10)
            response.getOutputStream().write(momentImage.getImage());
        else {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().print("{\"code\":400,\"message\":\"图片不存在\",\"data\":null}");
        }
    }
}
