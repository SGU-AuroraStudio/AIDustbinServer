package com.aurora.domain;

import java.util.Date;

public class MomentImage extends MomentImageKey {
    private Integer momentId;

    private Date createdTime;

    private byte[] image;

    public MomentImage() {
        super();
    }

    public MomentImage(Integer id, Integer imageNo, Integer momentId, Date createdTime, byte[] image) {
        super(id, imageNo);
        this.momentId = momentId;
        this.createdTime = createdTime;
        this.image = image;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}