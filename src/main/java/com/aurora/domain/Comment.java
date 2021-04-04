package com.aurora.domain;

import com.aurora.domain.base.CommentType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class Comment {
    private Integer id;

    private String fromUserId;

    private String fromUserNickname;

    private String fromUserProfile;

    private Integer momentId;

    private String content;

    private Integer toCommentId;

    private String commentType;

    private Date createdTime;

    @JsonIgnore
    private Boolean deleted;

    public Comment() {
    }

    public Comment(String fromUserId, Integer momentId, String content, Integer toCommentId, CommentType commentType, Date createdTime) {
        this.fromUserId = fromUserId;
        this.momentId = momentId;
        this.content = content;
        this.toCommentId = toCommentId;
        this.commentType = commentType.getType();
        this.createdTime = createdTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId == null ? null : fromUserId.trim();
    }

    public String getFromUserNickname() {
        return fromUserNickname;
    }

    public void setFromUserNickname(String fromUserNickname) {
        this.fromUserNickname = fromUserNickname;
    }

    public String getFromUserProfile() {
        return fromUserProfile;
    }

    public void setFromUserProfile(String fromUserProfile) {
        this.fromUserProfile = fromUserProfile;
    }

    public Integer getMomentId() {
        return momentId;
    }

    public void setMomentId(Integer momentId) {
        this.momentId = momentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getToCommentId() {
        return toCommentId;
    }

    public void setToCommentId(Integer toCommentId) {
        this.toCommentId = toCommentId;
    }

    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(CommentType commentType) {
        this.commentType = commentType.getType();
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