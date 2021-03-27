package com.aurora.domain.base;

/**
 * @Author Yao
 * @Date 2021/3/25 12:38
 * @Description
 */
public class RespJSON {
    Integer status;
    String msg;
    Object data;

    public RespJSON(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
