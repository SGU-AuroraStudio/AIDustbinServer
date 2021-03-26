package com.aurora.domain;

import java.util.Date;

public class User {
    private String id;

    private String account;

    private String password;

    private String nickname;

    private String status;

    private Date lastLogin;

    private Date dateJoined;

    private byte[] profile;

    public User(String id, String account, String password, String nickname, String status, Date lastLogin, Date dateJoined, byte[] profile) {
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

    public byte[] getProfile() {
        return profile;
    }

    public void setProfile(byte[] profile) {
        this.profile = profile;
    }
}