package com.aurora.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class User {
    private String id;

    private String account;

    private String password;

    private String nickname;

    private String status;

    @JsonIgnore
    private Date lastLogin;

    @JsonIgnore
    private Date dateJoined;

    //TODO:头像改成String，保存url。图片经过后台生成名字，保存在服务器硬盘，在tomcat设置路径。这样的话UserMapper也需要删除重建。
    private String profile;

    public User(String id, String account, String password, String nickname, String status, Date lastLogin, Date dateJoined, String profile) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.nickname = nickname;
        this.status = status;
        this.lastLogin = lastLogin;
        this.dateJoined = dateJoined;
        this.profile = profile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}