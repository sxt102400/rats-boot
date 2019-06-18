package com.rats.framework.common.persistence;

import java.beans.Introspector;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;
import java.util.function.Function;
import java.util.regex.Pattern;

public  class WeekendCriteria<A> extends Example.Criteria {

    protected WeekendCriteria() {
        super();
    }



    public WeekendCriteria<A> andIsNull(Function<A, Object> fn) {
        this.andIsNull(Reflections.fnToFieldName(fn));
        return this;
    }

    public WeekendCriteria<A> andIsNotNull(Function<A, Object> fn) {
        super.andIsNotNull(Reflections.fnToFieldName(fn));
        return this;
    }

    public WeekendCriteria<A> andEqualTo(Function<A, Object> fn, Object value) {
        super.andEqualTo(Reflections.fnToFieldName(fn), value);
        return this;
    }

    public WeekendCriteria<A> andNotEqualTo(Function<A, Object> fn, Object value) {
        super.andNotEqualTo(Reflections.fnToFieldName(fn), value);
        return this;
    }

    public WeekendCriteria<A> andGreaterThan(Function<A, Object> fn, Object value) {
        super.andGreaterThan(Reflections.fnToFieldName(fn), value);
        return this;
    }

    public WeekendCriteria<A> andGreaterThanOrEqualTo(Function<A, Object> fn, Object value) {
        super.andGreaterThanOrEqualTo(Reflections.fnToFieldName(fn), value);
        return this;
    }

    public WeekendCriteria<A> andLessThan(Function<A, Object> fn, Object value) {
        super.andLessThan(Reflections.fnToFieldName(fn), value);
        return this;
    }

    public WeekendCriteria<A> andLessThanOrEqualTo(Function<A, Object> fn, Object value) {
        super.andLessThanOrEqualTo(Reflections.fnToFieldName(fn), value);
        return this;
    }

    public WeekendCriteria<A> andIn(Function<A, Object> fn, Iterable values) {
        super.andIn(Reflections.fnToFieldName(fn), values);
        return this;
    }

    public WeekendCriteria<A> andNotIn(Function<A, Object> fn, Iterable values) {
        super.andNotIn(Reflections.fnToFieldName(fn), values);
        return this;
    }

    public WeekendCriteria<A> andBetween(Function<A, Object> fn, Object value1, Object value2) {
        super.andBetween(Reflections.fnToFieldName(fn), value1, value2);
        return this;
    }

    public WeekendCriteria<A> andNotBetween(Function<A, Object> fn, Object value1, Object value2) {
        super.andNotBetween(Reflections.fnToFieldName(fn), value1, value2);
        return this;
    }

    public WeekendCriteria<A> andLike(Function<A, Object> fn, String value) {
        super.andLike(Reflections.fnToFieldName(fn), value);
        return this;
    }

    public WeekendCriteria<A> andNotLike(Function<A, Object> fn, String value) {
        super.andNotLike(Reflections.fnToFieldName(fn), value);
        return this;
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