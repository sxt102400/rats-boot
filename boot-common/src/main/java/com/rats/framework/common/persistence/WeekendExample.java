package com.rats.framework.common.persistence;
import com.rats.framework.common.base.ClassTypeAdapt;

import java.util.ArrayList;
import java.util.List;

/**
 * form tk.mybatis.mapper.weekend
 *
 * @author Frank
 */

public class WeekendExample<T>  extends Example  {


    protected List<WeekendCriteria> oredCriteria;

    protected boolean distinct;

    protected String orderByClause;

    protected Class<?> entityClass;

  /*  public static<T> WeekendCriteria<T> createCriteria(Class<T> Clazz) {
        WeekendExample<T> weekendExample = new WeekendExample<T>();
        WeekendCriteria<T> criteria = weekendExample.createCriteria();
        return criteria;
    }*/

    public WeekendExample() {
        this.entityClass = getClassType();
        oredCriteria = new ArrayList<>();
    }

    public WeekendExample setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
        return this;
    }

    public WeekendExample setDistinct(boolean distinct) {
        this.distinct = distinct;
        return this;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<WeekendCriteria> getWeekendOredCriteria() {
        return oredCriteria;
    }

    public void or(WeekendCriteria criteria) {
        oredCriteria.add(criteria);
    }

    public WeekendCriteria or() {
        WeekendCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }


    public WeekendCriteria<T> createCriteria() {
        WeekendCriteria<T> criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected WeekendCriteria createCriteriaInternal() {
        WeekendCriteria<T> criteria = new WeekendCriteria<>();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }


}
