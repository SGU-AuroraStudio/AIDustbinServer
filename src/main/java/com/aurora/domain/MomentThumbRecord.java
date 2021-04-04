package com.aurora.domain;

import java.util.Date;

public class MomentThumbRecord {
    private Integer id;

    private String userId;

    private Integer momentId;

    private Date createdTime;

    private Boolean deleted;

    public MomentThumbRecord() {
    }

    public MomentThumbRecord(String userId, Integer momentId, Date createdTime) {
        this.userId = userId;
        this.momentId = momentId;
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

    public Integer getMomentId() {
        return momentId;
    }

    public void setMomentId(Integer momentId) {
        this.momentId = momentId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}