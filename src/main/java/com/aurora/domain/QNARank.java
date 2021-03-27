package com.aurora.domain;

/**
 * @Author Yao
 * @Date 2021/3/27 13:52
 * @Description
 */
public class QNARank {
    String userId;
    String nickname;
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
