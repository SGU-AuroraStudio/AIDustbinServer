package com.aurora.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class MomentThumbRecord {
    private Integer id;

    private String userId;

    private String userNickname;

    private String userProfile;

    @JsonIgnore
    private Integer momentId;

    private Date createdTime;

    @JsonIgnore
    private Date updatedTime;

    @JsonIgnore
    private Boolean deleted;

    public MomentThumbRecord(){}

    public MomentThumbRecord(String userId, String userNickname, String userProfile, Integer momentId, Date createdTime) {
        this.userId = userId;
        this.userNickname = userNickname;
        this.userProfile = userProfile;
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

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(String userProfile) {
        this.userProfile = userProfile == null ? null : userProfile.trim();
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

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}