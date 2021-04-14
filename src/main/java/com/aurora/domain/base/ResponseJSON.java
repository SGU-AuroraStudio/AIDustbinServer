package com.aurora.domain.base;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Yao
 * @Date 2021/3/25 12:58
 * @Description
 */
public enum ResponseJSON {
    SUCCESS(200, "成功"),
    CHOOSE_RIGHT(200, "选择正确"),
    CHOOSE_WRONG(200, "选择错误"),
    FAIL(400, "失败"),
    PARAM_ERROR(400, "参数错误"),
    NOT_LOGIN(400, "没有登录"),
    USER_EXITS(400, "用户已存在"),
    USER_INFO_ERROR(400, "用户名或密码错误"),
    USER_UPDATE_SUCCESS_BUT_PROFILE_ERROR(400, "用户信息修改成功，但是头像上传失败"),
    CHOOSE_NOT_FOUND(400, "未知选项"),
    MAX_SIZE_ERROR(400, "文件大小超过限制"),
    MAX_FILE_COUNT_ERROR(400, "文件数量超过限制"),
    COMMENT_NOT_FOUNT(400, "评论不存在"),
    NOT_FOUND_ERROR_404(404, "资源不存在"),
    UNKNOWN_ERROR(499, "未知错误"),
    SERVER_ERROR_500(500, "服务器错误");

    private Integer code;
    private String msg;

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

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getJSON() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", this.code);
        map.put("message", this.getMsg());
        map.put("data", null);
        return map;
    }

    public Map<String, Object> getJSON(Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", this.code);
        map.put("message", this.getMsg());
        map.put("data", data);
        return map;
    }


}
