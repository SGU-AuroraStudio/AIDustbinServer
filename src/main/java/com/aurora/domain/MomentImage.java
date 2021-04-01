package com.aurora.domain;

import java.util.Date;

public class MomentImage {
    private Integer id;

    private Integer momentId;

    private Date createdTime;

    private Boolean deleted;

    private byte[] image;

    public MomentImage(Integer id, Integer momentId, Date createdTime, Boolean deleted, byte[] image) {
        this.id = id;
        this.momentId = momentId;
        this.createdTime = createdTime;
        this.deleted = deleted;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}