package com.aurora.domain.base;

/**
 * @Author Yao
 * @Date 2021/4/2 18:44
 * @Description
 */
public enum CommentType {
    comment("comment"),
    reply("reply");
    String type;

    CommentType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
