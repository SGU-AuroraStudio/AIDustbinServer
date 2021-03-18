package com.aurora.domain;

public class Moment {
    private String id;

    private String userId;

    private String sharingId;

    public Moment(String id, String userId, String sharingId) {
        this.id = id;
        this.userId = userId;
        this.sharingId = sharingId;
    }

    public Moment() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getSharingId() {
        return sharingId;
    }

    public void setSharingId(String sharingId) {
        this.sharingId = sharingId == null ? null : sharingId.trim();
    }
}