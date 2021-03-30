package com.aurora.controller;

import com.aurora.domain.User;
import com.aurora.domain.base.Constants;
import com.aurora.domain.base.ResponseJSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;

/**
 * @Author Yao
 * @Date 2021/3/29 11:54
 * @Description 通过Controller获取图片，可以防止未登录操作
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {

    @RequestMapping("/{fileName}")
//    @ResponseBody
    public void getProfile(@PathVariable String fileName, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("utf-8");
        //-----图片转byte[] 开始-----
        File profile = new File(Constants.LOCAL_PROFILE_BASE_PATH + "/" + fileName);
        //检查图片存不存在
//        if(!profile.exists())
//            return new RespJSON(StatusCode.NOT_FOUND_ERROR_404.getCode(),StatusCode.NOT_FOUND_ERROR_404.getMsg(), null);
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER);
        String userRealProfileName = user.getProfile().split("/")[5];
        if (!profile.exists() || !userRealProfileName.equals(fileName)) {
            response.setContentType("application/json");
            response.getWriter().print("{\"code\":400,\"message\":\"失败\",\"data\":null}");
            return;
        }
        FileInputStream in = new FileInputStream(profile);
        byte[] bytes = new byte[in.available()];
        in.read(bytes);
        in.close();
        response.getOutputStream().write(bytes);

        //-----图片转byte[] 结束-----

        //图片转byte[]转base64
//        BASE64Encoder encoder = new BASE64Encoder();
//        String profile_base64 = encoder.encode(bytes);

        //-----base64转byte[]转图片 开始-----
//        BASE64Decoder decoder = new BASE64Decoder();
//        byte[] bytes1 = decoder.decodeBuffer(profile_base64);
//        BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(new File(Constants.LOCAL_PROFILE_BASE_PATH + "/" + fileName)));
//        bout.write(bytes1);
//        bout.close();
        //-----base64转byte[]转图片 结束-----

        //把文件名和图片base封装到data里
//        Map<String, Object> data = new HashMap<String, Object>();
//        data.put("fileName", fileName);
//        data.put("profile", profile_base64);
    }
}
