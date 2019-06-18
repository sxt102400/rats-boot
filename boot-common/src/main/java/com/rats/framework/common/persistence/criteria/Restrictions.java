package com.rats.framework.common.persistence.criteria;

import java.util.Collection;

/**
 * @author hanbing
 * @ClassName: Restrictions
 * @Description: 查询条件操作类，参考实现org.hibernate.criterion.Restrictions
 */
public class Restrictions {

    public static Criterion idEq(Object value) {
        return new Criterion("id", value, "=");
    }

    public static Criterion eq(String propertyName, Object value) {
        return new Criterion(propertyName, value, "=");
    }

    public static Criterion eqOrIsNull(String propertyName, Object value) {
        return (Criterion) (value == null ? isNull(propertyName) : eq(propertyName, value));
    }

    public static Criterion ne(String propertyName, Object value) {
        return new Criterion(propertyName, value, "<>");
    }

    public static Criterion neOrIsNotNull(String propertyName, Object value) {
        return (Criterion) (value == null ? isNotNull(propertyName) : ne(propertyName, value));
    }

    public static Criterion like(String propertyName, Object value) {
        return new Criterion(propertyName, value, " like ");
    }

    public static Criterion like(String propertyName, String value, MatchMode matchMode) {
        return new Criterion(propertyName, matchMode.toMatchString(value), " like ");
    }


    //public static Criterion ilike(String propertyName, Object value) {
    //    if(value == null) {
    //        throw new IllegalArgumentException("Comparison value passed to ilike cannot be null");
    //    } else {
    //        return ilike(propertyName, value.toString(), MatchMode.EXACT);
    //    }
    //}

    //public static Criterion ilike(String propertyName, String value, MatchMode matchMode) {
    //    if(value == null) {
    //        throw new IllegalArgumentException("Comparison value passed to ilike cannot be null");
    //    } else {
    //        return new Criterion(propertyName, value, matchMode, (Character)null, true);
    //    }
    // }

    public static Criterion gt(String propertyName, Object value) {
        return new Criterion(propertyName, value, ">");
    }

    public static Criterion lt(String propertyName, Object value) {
        return new Criterion(propertyName, value, "<");
    }

    public static Criterion le(String propertyName, Object value) {
        return new Criterion(propertyName, value, "<=");
    }

    public static Criterion ge(String propertyName, Object value) {
        return new Criterion(propertyName, value, ">=");
    }

    public static Criterion between(String propertyName, Object lo, Object hi) {
        return new Criterion(propertyName, lo, hi, "between");
    }

    public static Criterion in(String propertyName, Object[] values) {
        return new Criterion(propertyName, values, "in");
    }

    public static Criterion in(String propertyName, Collection values) {
        return new Criterion(propertyName, values.toArray(), "in");
    }

    public static Criterion isNull(String propertyName) {
        return new Criterion(propertyName, "is null");
    }

    public static Criterion isNotNull(String propertyName) {
        return new Criterion(propertyName, "is not null");
    }

    public static Criterion eqProperty(String propertyName, String otherPropertyName) {
        return new Criterion(propertyName, otherPropertyName, "=");
    }

    public static Criterion neProperty(String propertyName, String otherPropertyName) {
        return new Criterion(propertyName, otherPropertyName, "<>");
    }

    public static Criterion ltProperty(String propertyName, String otherPropertyName) {
        return new Criterion(propertyName, otherPropertyName, "<");
    }

    public static Criterion leProperty(String propertyName, String otherPropertyName) {
        return new Criterion(propertyName, otherPropertyName, "<=");
    }

    public static Criterion gtProperty(String propertyName, String otherPropertyName) {
        return new Criterion(propertyName, otherPropertyName, ">");
    }

    public static Criterion geProperty(String propertyName, String otherPropertyName) {
        return new Criterion(propertyName, otherPropertyName, ">=");
    }

//    public static LogicalExpression and(Criterion lhs, Criterion rhs) {
//        return new LogicalExpression(lhs, rhs, "and");
//    }
//
//    public static Conjunction and(Criterion... predicates) {
//        return conjunction(predicates);
//    }
//
//    public static LogicalExpression or(Criterion lhs, Criterion rhs) {
//        return new LogicalExpression(lhs, rhs, "or");
//    }
//
//    public static Disjunction or(Criterion... predicates) {
//        return disjunction(predicates);
//    }
//
//    public static Criterion not(Criterion expression) {
//        return new NotExpression(expression);
//    }

//    public static Criterion sqlRestriction(String sql, Object[] values, Type[] types) {
//        return new SQLCriterion(sql, values, types);
//    }
//
//    public static Criterion sqlRestriction(String sql, Object value, Type type) {
//        return new SQLCriterion(sql, value, type);
//    }
//
//    public static Criterion sqlRestriction(String sql) {
//        return new SQLCriterion(sql);
//    }
//
//    public static Conjunction conjunction() {
//        return new Conjunction();
//    }
//
//    public static Conjunction conjunction(Criterion... conditions) {
//        return new Conjunction(conditions);
//    }
//
//    public static Disjunction disjunction() {
//        return new Disjunction();
//    }
//
//    public static Disjunction disjunction(Criterion... conditions) {
//        return new Disjunction(conditions);
//    }

//    public static Criterion allEq(Map<String, ?> propertyNameValues) {
//        Conjunction conj = conjunction();
//        Iterator i$ = propertyNameValues.entrySet().iterator();
//
//        while(i$.hasNext()) {
//            Map.Entry entry = (Map.Entry)i$.next();
//            conj.add(eq((String)entry.getKey(), entry.getValue()));
//        }
//
//        return conj;
//    }

    public static Criterion isEmpty(String propertyName) {
        return new Criterion(propertyName, "is empty");
    }

    public static Criterion isNotEmpty(String propertyName) {
        return new Criterion(propertyName, "is not empty");
    }

//    public static Criterion sizeEq(String propertyName, int size) {
//        return new SizeExpression(propertyName, size, "=");
//    }
//
//    public static Criterion sizeNe(String propertyName, int size) {
//        return new SizeExpression(propertyName, size, "<>");
//    }
//
//    public static Criterion sizeGt(String propertyName, int size) {
//        return new SizeExpression(propertyName, size, "<");
//    }
//
//    public static Criterion sizeLt(String propertyName, int size) {
//        return new SizeExpression(propertyName, size, ">");
//    }
//
//    public static Criterion sizeGe(String propertyName, int size) {
//        return new SizeExpression(propertyName, size, "<=");
//    }
//
//    public static Criterion sizeLe(String propertyName, int size) {
//        return new SizeExpression(propertyName, size, ">=");
//    }
//
//    public static NaturalIdentifier naturalId() {
//        return new NaturalIdentifier();
//    }

    protected Restrictions() {
    }
}
