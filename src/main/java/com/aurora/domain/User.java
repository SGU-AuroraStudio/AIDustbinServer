package com.aurora.domain;

import java.util.Date;

public class User {
    private String id;

    private String password;

    private String name;

    private Date lastLogin;

    private Date dateJoined;

    private byte[] profile;

    public User(String id, String password, String name, Date lastLogin, Date dateJoined, byte[] profile) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.lastLogin = lastLogin;
        this.dateJoined = dateJoined;
        this.profile = profile;
    }

    public User() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public byte[] getProfile() {
        return profile;
    }

    public void setProfile(byte[] profile) {
        this.profile = profile;
    }
}