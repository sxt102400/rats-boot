package com.rats.framework.data;

import com.rats.framework.data.persistence.fn.FnReflections;

import javax.persistence.Column;
import javax.persistence.Id;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Example {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public static <T> Example of(T condition) {
        Example example = new Example();
        Example.Criteria<T> criteria = example.<T>createCriteria();
        Class clazz = condition.getClass();
        Field[] fileds = condition.getClass().getDeclaredFields();
        Arrays.stream(fileds).forEach(field -> {
            try {
                Object value = null;
                String columnName = null;
                if (field.isAnnotationPresent(Id.class) || field.isAnnotationPresent(Column.class)) {
                    PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                    Method getMethod = pd.getReadMethod();
                    value = getMethod.invoke(condition);
                    columnName = field.getName();
                }
                if (field.isAnnotationPresent(Column.class)) {
                    columnName = field.getAnnotation(Column.class).name();
                }
                if (columnName != null && value != null) {
                    criteria.andEqualTo(columnName, value);
                }
            } catch (IllegalAccessException | InvocationTargetException | IntrospectionException e) {
                e.printStackTrace();
            }
        });
        return example;
    }

    public Example() {
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

    public <T> Criteria<T> or() {
        Criteria<T> criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public <T> Criteria<T> createCriteria() {
        Criteria<T> criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected <T> Criteria<T> createCriteriaInternal() {
        Criteria<T> criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * GeneratedCriteria
     */
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

        public Criteria andIsNull(String property) {
            addCriterion(property + " is null");
            return (Criteria) this;
        }

        public Criteria andIsNotNull(String property) {
            addCriterion(property + " is not null");
            return (Criteria) this;
        }


        public Criteria andEqualTo(String property, Object value) {
            addCriterion(property + " =", value, property);
            return (Criteria) this;
        }

        public Criteria andNotEqualTo(String property, Object value) {
            addCriterion(property + " <>", value, property);
            return (Criteria) this;
        }

        public Criteria andGreaterThan(String property, Object value) {
            addCriterion(property + " >", value, property);
            return (Criteria) this;
        }

        public Criteria andGreaterThanOrEqualTo(String property, Object value) {
            addCriterion(property + " >=", value, property);
            return (Criteria) this;
        }

        public Criteria andLessThan(String property, Object value) {
            addCriterion(property + " <", value, property);
            return (Criteria) this;
        }

        public Criteria andLessThanOrEqualTo(String property, Object value) {
            addCriterion(property + " <=", value, property);
            return (Criteria) this;
        }

        public Criteria andLike(String property, Object value) {
            addCriterion(property + " like", value, property);
            return (Criteria) this;
        }

        public Criteria andNotLike(String property, String value) {
            addCriterion(property + " not like", value, property);
            return (Criteria) this;
        }

        public Criteria andIn(String property, Iterable values) {
            addCriterion(property + " in", values, property);
            return (Criteria) this;
        }

        public Criteria andNotIn(String property, Iterable values) {
            addCriterion(property + " not in", values, property);
            return (Criteria) this;
        }

        public Criteria andBetween(String property, Object value1, Object value2) {
            addCriterion(property + " between", value1, value2, property);
            return (Criteria) this;
        }

        public Criteria andNotBetween(String property, Object value1, Object value2) {
            addCriterion(property + " not between", value1, value2, property);
            return (Criteria) this;
        }

    }

    /**
     * Criteria
     */
    public static class Criteria<T> extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andIsNull(Function<T, Object> fn) {
            return andIsNull(FnReflections.fnToFieldName(fn));
        }

        public Criteria andIsNotNull(Function<T, Object> fn) {
            return andIsNotNull(FnReflections.fnToFieldName(fn));
        }

        public Criteria andEqualTo(Function<T, Object> fn, Object value) {
            return andEqualTo(FnReflections.fnToFieldName(fn), value);
        }

        public Criteria andNotEqualTo(Function<T, Object> fn, Object value) {
            return andNotEqualTo(FnReflections.fnToFieldName(fn), value);
        }

        public Criteria andGreaterThan(Function<T, Object> fn, Object value) {
            return andGreaterThan(FnReflections.fnToFieldName(fn), value);
        }

        public Criteria andGreaterThanOrEqualTo(Function<T, Object> fn, Object value) {
            return andGreaterThanOrEqualTo(FnReflections.fnToFieldName(fn), value);
        }

        public Criteria andLessThan(Function<T, Object> fn, Object value) {
            return andLessThan(FnReflections.fnToFieldName(fn), value);
        }

        public Criteria andLessThanOrEqualTo(Function<T, Object> fn, Object value) {
            return andLessThanOrEqualTo(FnReflections.fnToFieldName(fn), value);
        }

        public Criteria andLike(Function<T, Object> fn, Object value) {
            return andLike(FnReflections.fnToFieldName(fn), value);
        }

        public Criteria andNotLike(Function<T, Object> fn, String value) {
            return andNotLike(FnReflections.fnToFieldName(fn), value);
        }

        public Criteria andIn(Function<T, Object> fn, Iterable values) {
            return andIn(FnReflections.fnToFieldName(fn), values);
        }

        public Criteria andNotIn(Function<T, Object> fn, Iterable values) {
            return andNotIn(FnReflections.fnToFieldName(fn), values);
        }

        public Criteria andBetween(Function<T, Object> fn, Object value1, Object value2) {
            return andBetween(FnReflections.fnToFieldName(fn), value1, value2);
        }

        public Criteria andNotBetween(Function<T, Object> fn, Object value1, Object value2) {
            return andNotBetween(FnReflections.fnToFieldName(fn), value1, value2);
        }
    }


    /**
     * Criterion
     */
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
