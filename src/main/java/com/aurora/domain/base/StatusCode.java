package com.aurora.domain.base;
/**
 * @Author Yao
 * @Date 2021/3/25 12:58
 * @Description
 */
public enum StatusCode {
    SUCCESS(200,"成功"),
    CHOOSE_RIGHT(200, "选择正确"),
    FAIL(400,"失败"),
    NOT_LOGIN(400, "没有登录"),
    USER_EXITS(400,"用户已存在"),
    USER_INFO_ERROR(400,"用户名或密码错误"),
    CHOOSE_WRONG(400, "选择错误"),
    CHOOSE_NOT_FOUND(400,"未知选项"),
    NOT_FOUND_ERROR_404(404, "请求资源不存在"),
    UNKNOWN_ERROR(499,"未知错误"),
    SERVER_ERROR_500(500, "服务器错误");

    private final Integer code;
    private final String msg;

    StatusCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
