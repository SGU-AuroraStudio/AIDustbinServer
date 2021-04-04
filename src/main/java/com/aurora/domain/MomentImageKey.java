package com.aurora.domain;

public class MomentImageKey {
    private Integer id;

    private Integer imageNo;

    public MomentImageKey() {
    }

    public MomentImageKey(Integer id, Integer imageNo) {
        this.id = id;
        this.imageNo = imageNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImageNo() {
        return imageNo;
    }

    public void setImageNo(Integer imageNo) {
        this.imageNo = imageNo;
    }
}