package com.aurora.domain;

import java.util.Date;

public class QNARecord {
    private Integer id;

    private String userId;

    private Integer qnaId;

    private Integer choose;

    private Boolean judge;

    private Date createdTime;

    public QNARecord(String userId, Integer qnaId, Integer choose, Boolean judge, Date createdTime) {
        this.userId = userId;
        this.qnaId = qnaId;
        this.choose = choose;
        this.judge = judge;
        this.createdTime = createdTime;
    }

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

    public Boolean getJudge() {
        return judge;
    }

    public void setJudge(Boolean judge) {
        this.judge = judge;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}