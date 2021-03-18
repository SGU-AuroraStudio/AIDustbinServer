package com.aurora.domain;

public class DustbinInfo {
    private Integer id;

    private String longitude;

    private String latitude;

    private String detail;

    public DustbinInfo(Integer id, String longitude, String latitude, String detail) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.detail = detail;
    }

    public DustbinInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}