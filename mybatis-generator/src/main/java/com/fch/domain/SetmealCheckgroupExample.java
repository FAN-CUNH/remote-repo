package com.fch.domain;

import java.util.ArrayList;
import java.util.List;

public class SetmealCheckgroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SetmealCheckgroupExample() {
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

        public Criteria andSetmealIdIsNull() {
            addCriterion("setmeal_id is null");
            return (Criteria) this;
        }

        public Criteria andSetmealIdIsNotNull() {
            addCriterion("setmeal_id is not null");
            return (Criteria) this;
        }

        public Criteria andSetmealIdEqualTo(Integer value) {
            addCriterion("setmeal_id =", value, "setmealId");
            return (Criteria) this;
        }

        public Criteria andSetmealIdNotEqualTo(Integer value) {
            addCriterion("setmeal_id <>", value, "setmealId");
            return (Criteria) this;
        }

        public Criteria andSetmealIdGreaterThan(Integer value) {
            addCriterion("setmeal_id >", value, "setmealId");
            return (Criteria) this;
        }

        public Criteria andSetmealIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("setmeal_id >=", value, "setmealId");
            return (Criteria) this;
        }

        public Criteria andSetmealIdLessThan(Integer value) {
            addCriterion("setmeal_id <", value, "setmealId");
            return (Criteria) this;
        }

        public Criteria andSetmealIdLessThanOrEqualTo(Integer value) {
            addCriterion("setmeal_id <=", value, "setmealId");
            return (Criteria) this;
        }

        public Criteria andSetmealIdIn(List<Integer> values) {
            addCriterion("setmeal_id in", values, "setmealId");
            return (Criteria) this;
        }

        public Criteria andSetmealIdNotIn(List<Integer> values) {
            addCriterion("setmeal_id not in", values, "setmealId");
            return (Criteria) this;
        }

        public Criteria andSetmealIdBetween(Integer value1, Integer value2) {
            addCriterion("setmeal_id between", value1, value2, "setmealId");
            return (Criteria) this;
        }

        public Criteria andSetmealIdNotBetween(Integer value1, Integer value2) {
            addCriterion("setmeal_id not between", value1, value2, "setmealId");
            return (Criteria) this;
        }

        public Criteria andCheckgroupIdIsNull() {
            addCriterion("checkgroup_id is null");
            return (Criteria) this;
        }

        public Criteria andCheckgroupIdIsNotNull() {
            addCriterion("checkgroup_id is not null");
            return (Criteria) this;
        }

        public Criteria andCheckgroupIdEqualTo(Integer value) {
            addCriterion("checkgroup_id =", value, "checkgroupId");
            return (Criteria) this;
        }

        public Criteria andCheckgroupIdNotEqualTo(Integer value) {
            addCriterion("checkgroup_id <>", value, "checkgroupId");
            return (Criteria) this;
        }

        public Criteria andCheckgroupIdGreaterThan(Integer value) {
            addCriterion("checkgroup_id >", value, "checkgroupId");
            return (Criteria) this;
        }

        public Criteria andCheckgroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("checkgroup_id >=", value, "checkgroupId");
            return (Criteria) this;
        }

        public Criteria andCheckgroupIdLessThan(Integer value) {
            addCriterion("checkgroup_id <", value, "checkgroupId");
            return (Criteria) this;
        }

        public Criteria andCheckgroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("checkgroup_id <=", value, "checkgroupId");
            return (Criteria) this;
        }

        public Criteria andCheckgroupIdIn(List<Integer> values) {
            addCriterion("checkgroup_id in", values, "checkgroupId");
            return (Criteria) this;
        }

        public Criteria andCheckgroupIdNotIn(List<Integer> values) {
            addCriterion("checkgroup_id not in", values, "checkgroupId");
            return (Criteria) this;
        }

        public Criteria andCheckgroupIdBetween(Integer value1, Integer value2) {
            addCriterion("checkgroup_id between", value1, value2, "checkgroupId");
            return (Criteria) this;
        }

        public Criteria andCheckgroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("checkgroup_id not between", value1, value2, "checkgroupId");
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