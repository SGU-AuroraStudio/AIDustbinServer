package com.aurora.domain;

/**
 * @Author Yao
 * @Date 2021/3/27 13:52
 * @Description 数据库里没有的类
 */
public class QNARank {
    String userId;
    String nickname;
    String profile;
    Integer right;
    Integer wrong;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Integer getRight() {
        return right;
    }

    public void setRight(Integer right) {
        this.right = right;
    }

    public Integer getWrong() {
        return wrong;
    }

    public void setWrong(Integer wrong) {
        this.wrong = wrong;
    }
}
