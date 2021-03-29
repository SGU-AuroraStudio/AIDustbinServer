package com.aurora.controller;

import com.aurora.domain.base.Constants;
import com.aurora.domain.base.RespJSON;
import com.aurora.domain.base.StatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Yao
 * @Date 2021/3/29 11:54
 * @Description
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {

    @RequestMapping("/{fileName}")
    @ResponseBody
    public RespJSON getProfile(@PathVariable String fileName) throws Exception {
        //-----图片转byte[]转base64 开始-----
        File profile = new File(Constants.LOCAL_PROFILE_BASE_PATH + "/" + fileName);
        //检查图片存不存在
        if(!profile.exists())
            return new RespJSON(StatusCode.NOT_FOUND_ERROR_404.getCode(),StatusCode.NOT_FOUND_ERROR_404.getMsg(), null);;
        FileInputStream in = new FileInputStream(profile);
        byte[] bytes = new byte[in.available()];
        in.read(bytes);
        in.close();
        BASE64Encoder encoder = new BASE64Encoder();
        String profile_base64 = encoder.encode(bytes);
        //-----图片转byte[]转base64 结束-----

        //-----base64转byte[]转图片 开始-----
//        BASE64Decoder decoder = new BASE64Decoder();
//        byte[] bytes1 = decoder.decodeBuffer(profile_base64);
//        BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(new File(Constants.LOCAL_PROFILE_BASE_PATH + "/" + fileName));
//        bout.write(bytes1);
//        bout.close();
        //-----base64转byte[]转图片 结束-----

        //把文件名和图片base封装到data里
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("fileName", fileName);
        data.put("profile", profile_base64);
        return new RespJSON(StatusCode.SUCCESS.getCode(),StatusCode.SUCCESS.getMsg(), data);
    }
}
