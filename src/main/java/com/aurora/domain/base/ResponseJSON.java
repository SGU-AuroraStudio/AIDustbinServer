package com.aurora.domain.base;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Yao
 * @Date 2021/3/25 12:58
 * @Description
 */
public enum ResponseJSON {
    SUCCESS(200,"成功"),
    CHOOSE_RIGHT(200, "选择正确"),
    FAIL(400,"失败"),
    NOT_LOGIN(400, "没有登录"),
    USER_EXITS(400,"用户已存在"),
    USER_INFO_ERROR(400,"用户名或密码错误"),
    USER_UPDATE_SUCCESS_BUT_PROFILE_ERROR(400,"用户信息修改成功，但是头像上传失败"),
    CHOOSE_WRONG(400, "选择错误"),
    CHOOSE_NOT_FOUND(400,"未知选项"),
    NOT_FOUND_ERROR_404(404, "资源不存在"),
    UNKNOWN_ERROR(499,"未知错误"),
    SERVER_ERROR_500(500, "服务器错误");

    private final Integer code;
    private final String msg;

    ResponseJSON(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Map<String, Object> getJSON(){
        Map<String, Object> map = new HashMap<>();
        map.put("code", this.code);
        map.put("message", this.getMsg());
        map.put("data", null);
        return map;
    }

    public Map<String, Object> getJSON(Object data){
        Map<String, Object> map = new HashMap<>();
        map.put("code", this.code);
        map.put("message", this.getMsg());
        map.put("data", data);
        return map;
    }


}
