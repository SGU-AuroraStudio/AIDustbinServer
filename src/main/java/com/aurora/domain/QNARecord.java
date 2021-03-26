package com.aurora.domain;

import java.util.Date;

public class QNARecord {
    private Integer id;

    private String userId;

    private Integer qnaId;

    private Integer choose;

    private Date createdTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getQnaId() {
        return qnaId;
    }

    public void setQnaId(Integer qnaId) {
        this.qnaId = qnaId;
    }

    public Integer getChoose() {
        return choose;
    }

    public void setChoose(Integer choose) {
        this.choose = choose;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}