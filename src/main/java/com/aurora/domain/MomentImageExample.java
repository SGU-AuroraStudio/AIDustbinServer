package com.aurora.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MomentImageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MomentImageExample() {
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

        public Criteria andImageNoIsNull() {
            addCriterion("image_no is null");
            return (Criteria) this;
        }

        public Criteria andImageNoIsNotNull() {
            addCriterion("image_no is not null");
            return (Criteria) this;
        }

        public Criteria andImageNoEqualTo(Integer value) {
            addCriterion("image_no =", value, "imageNo");
            return (Criteria) this;
        }

        public Criteria andImageNoNotEqualTo(Integer value) {
            addCriterion("image_no <>", value, "imageNo");
            return (Criteria) this;
        }

        public Criteria andImageNoGreaterThan(Integer value) {
            addCriterion("image_no >", value, "imageNo");
            return (Criteria) this;
        }

        public Criteria andImageNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("image_no >=", value, "imageNo");
            return (Criteria) this;
        }

        public Criteria andImageNoLessThan(Integer value) {
            addCriterion("image_no <", value, "imageNo");
            return (Criteria) this;
        }

        public Criteria andImageNoLessThanOrEqualTo(Integer value) {
            addCriterion("image_no <=", value, "imageNo");
            return (Criteria) this;
        }

        public Criteria andImageNoIn(List<Integer> values) {
            addCriterion("image_no in", values, "imageNo");
            return (Criteria) this;
        }

        public Criteria andImageNoNotIn(List<Integer> values) {
            addCriterion("image_no not in", values, "imageNo");
            return (Criteria) this;
        }

        public Criteria andImageNoBetween(Integer value1, Integer value2) {
            addCriterion("image_no between", value1, value2, "imageNo");
            return (Criteria) this;
        }

        public Criteria andImageNoNotBetween(Integer value1, Integer value2) {
            addCriterion("image_no not between", value1, value2, "imageNo");
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private final String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private final String typeHandler;

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