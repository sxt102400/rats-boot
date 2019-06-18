package com.rats.framework.common.persistence;

import java.beans.Introspector;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;

/**
 * refer to tk.mybatis.mapper.weekend
 *
 * @author Frank
 */

public class Example<T> extends GeneratedExample {

    protected List<Criteria> oredCriteria;

    protected boolean distinct;

    protected String orderByClause;

    protected Class<?> entityClass;

    public Example() {
        this.entityClass = getClassType();
        oredCriteria = new ArrayList<>();
    }

    public Example setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
        return this;
    }

    public Example setDistinct(boolean distinct) {
        this.distinct = distinct;
        return this;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getCriteria() {
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


    public Criteria<T> createCriteria() {
        Criteria<T> criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria<T> criteria = new Criteria<>();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public static class Criteria<A> extends GeneratedExample.Criteria {

        protected Criteria() {
            super();
        }

        public Criteria<A> andIsNull(Function<A, Object> fn) {
            this.andIsNull(Reflections.fnToFieldName(fn));
            return this;
        }

        public Criteria<A> andIsNotNull(Function<A, Object> fn) {
            super.andIsNotNull(Reflections.fnToFieldName(fn));
            return this;
        }

        public Criteria<A> andEqualTo(Function<A, Object> fn, Object value) {
            super.andEqualTo(Reflections.fnToFieldName(fn), value);
            return this;
        }

        public Criteria<A> andNotEqualTo(Function<A, Object> fn, Object value) {
            super.andNotEqualTo(Reflections.fnToFieldName(fn), value);
            return this;
        }

        public Criteria<A> andGreaterThan(Function<A, Object> fn, Object value) {
            super.andGreaterThan(Reflections.fnToFieldName(fn), value);
            return this;
        }

        public Criteria<A> andGreaterThanOrEqualTo(Function<A, Object> fn, Object value) {
            super.andGreaterThanOrEqualTo(Reflections.fnToFieldName(fn), value);
            return this;
        }

        public Criteria<A> andLessThan(Function<A, Object> fn, Object value) {
            super.andLessThan(Reflections.fnToFieldName(fn), value);
            return this;
        }

        public Criteria<A> andLessThanOrEqualTo(Function<A, Object> fn, Object value) {
            super.andLessThanOrEqualTo(Reflections.fnToFieldName(fn), value);
            return this;
        }

        public Criteria<A> andIn(Function<A, Object> fn, Iterable values) {
            super.andIn(Reflections.fnToFieldName(fn), values);
            return this;
        }

        public Criteria<A> andNotIn(Function<A, Object> fn, Iterable values) {
            super.andNotIn(Reflections.fnToFieldName(fn), values);
            return this;
        }

        public Criteria<A> andBetween(Function<A, Object> fn, Object value1, Object value2) {
            super.andBetween(Reflections.fnToFieldName(fn), value1, value2);
            return this;
        }

        public Criteria<A> andNotBetween(Function<A, Object> fn, Object value1, Object value2) {
            super.andNotBetween(Reflections.fnToFieldName(fn), value1, value2);
            return this;
        }

        public Criteria<A> andLike(Function<A, Object> fn, String value) {
            super.andLike(Reflections.fnToFieldName(fn), value);
            return this;
        }

        public Criteria<A> andNotLike(Function<A, Object> fn, String value) {
            super.andNotLike(Reflections.fnToFieldName(fn), value);
            return this;
        }

    }

    public static class Reflections {
        private static final Pattern GET_PATTERN = Pattern.compile("^get[A-Z].*");
        private static final Pattern IS_PATTERN = Pattern.compile("^is[A-Z].*");

        private Reflections() {
        }

        public static String fnToFieldName(Function fn) {
            try {
                Method method = fn.getClass().getDeclaredMethod("writeReplace");
                method.setAccessible(Boolean.TRUE);
                SerializedLambda serializedLambda = (SerializedLambda) method.invoke(fn);
                String getter = serializedLambda.getImplMethodName();
                if (GET_PATTERN.matcher(getter).matches()) {
                    getter = getter.substring(3);
                } else if (IS_PATTERN.matcher(getter).matches()) {
                    getter = getter.substring(2);
                }
                return Introspector.decapitalize(getter);
            } catch (ReflectiveOperationException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
