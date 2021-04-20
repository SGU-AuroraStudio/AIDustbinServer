package com.aurora.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Comment {
    private Integer id;

    private String fromUserId;

    private String fromUserNickname;

    private String fromUserProfile;

    @JsonIgnore
    private Integer momentId;

    private String content;

    private Integer baseCommentId;

    private Integer pid;

    //数据库没有的字段
    private List<Comment> replies = new LinkedList<>();

    private Date createdTime;

    @JsonIgnore
    private Boolean deleted;

    public Comment(){}

    public Comment(String fromUserId, String fromUserNickname, String fromUserProfile, Integer momentId, String content, Integer baseCommentId, Integer pid, Date createdTime) {
        this.fromUserId = fromUserId;
        this.fromUserNickname = fromUserNickname;
        this.fromUserProfile = fromUserProfile;
        this.momentId = momentId;
        this.content = content;
        this.baseCommentId = baseCommentId;
        this.pid = pid;
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
        this.fromUserNickname = fromUserNickname == null ? null : fromUserNickname.trim();
    }

    public String getFromUserProfile() {
        return fromUserProfile;
    }

    public void setFromUserProfile(String fromUserProfile) {
        this.fromUserProfile = fromUserProfile == null ? null : fromUserProfile.trim();
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

    public Integer getBaseCommentId() {
        return baseCommentId;
    }

    public void setBaseCommentId(Integer baseCommentId) {
        this.baseCommentId = baseCommentId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<Comment> getReplies() {
        return replies;
    }

    public void setReplies(List<Comment> replies) {
        this.replies = replies;
    }

    public void addReply(Comment reply){
        this.replies.add(reply);
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