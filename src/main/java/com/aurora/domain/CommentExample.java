package com.aurora.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFromUserIdIsNull() {
            addCriterion("from_user_id is null");
            return (Criteria) this;
        }

        public Criteria andFromUserIdIsNotNull() {
            addCriterion("from_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andFromUserIdEqualTo(String value) {
            addCriterion("from_user_id =", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdNotEqualTo(String value) {
            addCriterion("from_user_id <>", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdGreaterThan(String value) {
            addCriterion("from_user_id >", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("from_user_id >=", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdLessThan(String value) {
            addCriterion("from_user_id <", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdLessThanOrEqualTo(String value) {
            addCriterion("from_user_id <=", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdLike(String value) {
            addCriterion("from_user_id like", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdNotLike(String value) {
            addCriterion("from_user_id not like", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdIn(List<String> values) {
            addCriterion("from_user_id in", values, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdNotIn(List<String> values) {
            addCriterion("from_user_id not in", values, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdBetween(String value1, String value2) {
            addCriterion("from_user_id between", value1, value2, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdNotBetween(String value1, String value2) {
            addCriterion("from_user_id not between", value1, value2, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserNicknameIsNull() {
            addCriterion("from_user_nickname is null");
            return (Criteria) this;
        }

        public Criteria andFromUserNicknameIsNotNull() {
            addCriterion("from_user_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andFromUserNicknameEqualTo(String value) {
            addCriterion("from_user_nickname =", value, "fromUserNickname");
            return (Criteria) this;
        }

        public Criteria andFromUserNicknameNotEqualTo(String value) {
            addCriterion("from_user_nickname <>", value, "fromUserNickname");
            return (Criteria) this;
        }

        public Criteria andFromUserNicknameGreaterThan(String value) {
            addCriterion("from_user_nickname >", value, "fromUserNickname");
            return (Criteria) this;
        }

        public Criteria andFromUserNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("from_user_nickname >=", value, "fromUserNickname");
            return (Criteria) this;
        }

        public Criteria andFromUserNicknameLessThan(String value) {
            addCriterion("from_user_nickname <", value, "fromUserNickname");
            return (Criteria) this;
        }

        public Criteria andFromUserNicknameLessThanOrEqualTo(String value) {
            addCriterion("from_user_nickname <=", value, "fromUserNickname");
            return (Criteria) this;
        }

        public Criteria andFromUserNicknameLike(String value) {
            addCriterion("from_user_nickname like", value, "fromUserNickname");
            return (Criteria) this;
        }

        public Criteria andFromUserNicknameNotLike(String value) {
            addCriterion("from_user_nickname not like", value, "fromUserNickname");
            return (Criteria) this;
        }

        public Criteria andFromUserNicknameIn(List<String> values) {
            addCriterion("from_user_nickname in", values, "fromUserNickname");
            return (Criteria) this;
        }

        public Criteria andFromUserNicknameNotIn(List<String> values) {
            addCriterion("from_user_nickname not in", values, "fromUserNickname");
            return (Criteria) this;
        }

        public Criteria andFromUserNicknameBetween(String value1, String value2) {
            addCriterion("from_user_nickname between", value1, value2, "fromUserNickname");
            return (Criteria) this;
        }

        public Criteria andFromUserNicknameNotBetween(String value1, String value2) {
            addCriterion("from_user_nickname not between", value1, value2, "fromUserNickname");
            return (Criteria) this;
        }

        public Criteria andFromUserProfileIsNull() {
            addCriterion("from_user_profile is null");
            return (Criteria) this;
        }

        public Criteria andFromUserProfileIsNotNull() {
            addCriterion("from_user_profile is not null");
            return (Criteria) this;
        }

        public Criteria andFromUserProfileEqualTo(String value) {
            addCriterion("from_user_profile =", value, "fromUserProfile");
            return (Criteria) this;
        }

        public Criteria andFromUserProfileNotEqualTo(String value) {
            addCriterion("from_user_profile <>", value, "fromUserProfile");
            return (Criteria) this;
        }

        public Criteria andFromUserProfileGreaterThan(String value) {
            addCriterion("from_user_profile >", value, "fromUserProfile");
            return (Criteria) this;
        }

        public Criteria andFromUserProfileGreaterThanOrEqualTo(String value) {
            addCriterion("from_user_profile >=", value, "fromUserProfile");
            return (Criteria) this;
        }

        public Criteria andFromUserProfileLessThan(String value) {
            addCriterion("from_user_profile <", value, "fromUserProfile");
            return (Criteria) this;
        }

        public Criteria andFromUserProfileLessThanOrEqualTo(String value) {
            addCriterion("from_user_profile <=", value, "fromUserProfile");
            return (Criteria) this;
        }

        public Criteria andFromUserProfileLike(String value) {
            addCriterion("from_user_profile like", value, "fromUserProfile");
            return (Criteria) this;
        }

        public Criteria andFromUserProfileNotLike(String value) {
            addCriterion("from_user_profile not like", value, "fromUserProfile");
            return (Criteria) this;
        }

        public Criteria andFromUserProfileIn(List<String> values) {
            addCriterion("from_user_profile in", values, "fromUserProfile");
            return (Criteria) this;
        }

        public Criteria andFromUserProfileNotIn(List<String> values) {
            addCriterion("from_user_profile not in", values, "fromUserProfile");
            return (Criteria) this;
        }

        public Criteria andFromUserProfileBetween(String value1, String value2) {
            addCriterion("from_user_profile between", value1, value2, "fromUserProfile");
            return (Criteria) this;
        }

        public Criteria andFromUserProfileNotBetween(String value1, String value2) {
            addCriterion("from_user_profile not between", value1, value2, "fromUserProfile");
            return (Criteria) this;
        }

        public Criteria andMomentIdIsNull() {
            addCriterion("moment_id is null");
            return (Criteria) this;
        }

        public Criteria andMomentIdIsNotNull() {
            addCriterion("moment_id is not null");
            return (Criteria) this;
        }

        public Criteria andMomentIdEqualTo(Integer value) {
            addCriterion("moment_id =", value, "momentId");
            return (Criteria) this;
        }

        public Criteria andMomentIdNotEqualTo(Integer value) {
            addCriterion("moment_id <>", value, "momentId");
            return (Criteria) this;
        }

        public Criteria andMomentIdGreaterThan(Integer value) {
            addCriterion("moment_id >", value, "momentId");
            return (Criteria) this;
        }

        public Criteria andMomentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("moment_id >=", value, "momentId");
            return (Criteria) this;
        }

        public Criteria andMomentIdLessThan(Integer value) {
            addCriterion("moment_id <", value, "momentId");
            return (Criteria) this;
        }

        public Criteria andMomentIdLessThanOrEqualTo(Integer value) {
            addCriterion("moment_id <=", value, "momentId");
            return (Criteria) this;
        }

        public Criteria andMomentIdIn(List<Integer> values) {
            addCriterion("moment_id in", values, "momentId");
            return (Criteria) this;
        }

        public Criteria andMomentIdNotIn(List<Integer> values) {
            addCriterion("moment_id not in", values, "momentId");
            return (Criteria) this;
        }

        public Criteria andMomentIdBetween(Integer value1, Integer value2) {
            addCriterion("moment_id between", value1, value2, "momentId");
            return (Criteria) this;
        }

        public Criteria andMomentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("moment_id not between", value1, value2, "momentId");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andBaseCommentIdIsNull() {
            addCriterion("base_comment_id is null");
            return (Criteria) this;
        }

        public Criteria andBaseCommentIdIsNotNull() {
            addCriterion("base_comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andBaseCommentIdEqualTo(Integer value) {
            addCriterion("base_comment_id =", value, "baseCommentId");
            return (Criteria) this;
        }

        public Criteria andBaseCommentIdNotEqualTo(Integer value) {
            addCriterion("base_comment_id <>", value, "baseCommentId");
            return (Criteria) this;
        }

        public Criteria andBaseCommentIdGreaterThan(Integer value) {
            addCriterion("base_comment_id >", value, "baseCommentId");
            return (Criteria) this;
        }

        public Criteria andBaseCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("base_comment_id >=", value, "baseCommentId");
            return (Criteria) this;
        }

        public Criteria andBaseCommentIdLessThan(Integer value) {
            addCriterion("base_comment_id <", value, "baseCommentId");
            return (Criteria) this;
        }

        public Criteria andBaseCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("base_comment_id <=", value, "baseCommentId");
            return (Criteria) this;
        }

        public Criteria andBaseCommentIdIn(List<Integer> values) {
            addCriterion("base_comment_id in", values, "baseCommentId");
            return (Criteria) this;
        }

        public Criteria andBaseCommentIdNotIn(List<Integer> values) {
            addCriterion("base_comment_id not in", values, "baseCommentId");
            return (Criteria) this;
        }

        public Criteria andBaseCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("base_comment_id between", value1, value2, "baseCommentId");
            return (Criteria) this;
        }

        public Criteria andBaseCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("base_comment_id not between", value1, value2, "baseCommentId");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Boolean value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Boolean value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Boolean value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Boolean value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Boolean> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Boolean> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("deleted not between", value1, value2, "deleted");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}