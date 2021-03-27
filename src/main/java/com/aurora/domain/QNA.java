package com.aurora.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class QNA {
    private Integer id;

    private String q;

    @JsonIgnore
    private Integer answer;

    @JsonIgnore
    private Integer right;

    @JsonIgnore
    private Integer wrong;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q == null ? null : q.trim();
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
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