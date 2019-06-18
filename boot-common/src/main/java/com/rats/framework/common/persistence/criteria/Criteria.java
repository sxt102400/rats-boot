package com.rats.framework.common.persistence.criteria;

import java.io.Serializable;
import java.util.*;

/**
 * @author hanbing
 * @ClassName: Criteria
 * @Description: 查询条件类，参考org.hibernate.Criteria实现
 */
public class Criteria {

    private String entityOrClassName;
    private String rootAlias;
    private List<CriterionEntry> criterionEntries;
    private List<OrderEntry> orderEntries;
    private Criteria projectionCriteria;
    private Integer firstResult;
    private Integer maxResults;
    private Integer timeout;
    private Integer fetchSize;
    private boolean cacheable;
    private String comment;
    private List<String> queryHints;
    private Boolean readOnly;

    private boolean distinct;

    public Criteria() {
        this(null, "this");
    }

    public Criteria(String entityOrClassName) {
        this(entityOrClassName, "this");
    }

    public Criteria(String entityOrClassName, String alias) {
        this.criterionEntries = new ArrayList();
        this.orderEntries = new ArrayList();
        this.queryHints = new ArrayList();
        this.entityOrClassName = entityOrClassName;
        this.cacheable = false;
        this.rootAlias = alias;
    }

    public static Criteria createCriteria() {
        return new Criteria();
    }

    public String toString() {
        return "Criteria(" + this.entityOrClassName + ":" + (this.rootAlias == null ? "" : this.rootAlias) + ')';
    }

    public boolean isValid() {
        return criterionEntries.size() > 0;
    }

    public boolean isOrder() {
        return orderEntries.size() > 0;
    }

    public List<CriterionEntry> getCriterionEntries() {
        return this.criterionEntries;
    }

    public List<OrderEntry> getOrderEntries() {
        return this.orderEntries;
    }

    public String getEntityOrClassName() {
        return this.entityOrClassName;
    }


    public Criteria getProjectionCriteria() {
        return this.projectionCriteria;
    }


    public Iterator<CriterionEntry> iterateExpressionEntries() {
        return this.criterionEntries.iterator();
    }

    public Iterator<OrderEntry> iterateOrderings() {
        return this.orderEntries.iterator();
    }

    public Criteria add(Criteria criteriaInst, Criterion expression) {
        this.criterionEntries.add(new CriterionEntry(expression, criteriaInst));
        return this;
    }

    public String getAlias() {
        return this.rootAlias;
    }

    public Criteria add(Criterion expression) {
        this.add(this, expression);
        return this;
    }

    public Criteria addOrder(Order ordering) {
        this.orderEntries.add(new OrderEntry(ordering, this));
        return this;
    }

    public Integer getFirstResult() {
        return this.firstResult;
    }

    public Criteria setFirstResult(int firstResult) {
        this.firstResult = Integer.valueOf(firstResult);
        return this;
    }

    public Integer getMaxResults() {
        return this.maxResults;
    }

    public Criteria setMaxResults(int maxResults) {
        this.maxResults = Integer.valueOf(maxResults);
        return this;
    }

    public Integer getFetchSize() {
        return this.fetchSize;
    }

    public Criteria setFetchSize(int fetchSize) {
        this.fetchSize = Integer.valueOf(fetchSize);
        return this;
    }

    public Integer getTimeout() {
        return this.timeout;
    }

    public Criteria setTimeout(int timeout) {
        this.timeout = Integer.valueOf(timeout);
        return this;
    }

    public boolean isReadOnlyInitialized() {
        return this.readOnly != null;
    }

    public boolean isReadOnly() {
        return this.isReadOnlyInitialized();
    }

    public Criteria setReadOnly(boolean readOnly) {
        this.readOnly = Boolean.valueOf(readOnly);
        return this;
    }

    public boolean getCacheable() {
        return this.cacheable;
    }

    public Criteria setCacheable(boolean cacheable) {
        this.cacheable = cacheable;
        return this;
    }

    public String getComment() {
        return this.comment;
    }

    public Criteria setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public List<String> getQueryHints() {
        return this.queryHints;
    }

    public Criteria addQueryHint(String queryHint) {
        this.queryHints.add(queryHint);
        return this;
    }

    /**
     * @param distinct 是否排重
     * @Title: setDistinct
     * @Description: 是否需要结果排重
     */
    public void setDistinct(final boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * @return 是否排重
     * @Title: isDistinct
     * @Description: 查询结果是否排重
     */
    public boolean isDistinct() {
        return distinct;
    }

    public static final class OrderEntry implements Serializable {
        private final Order order;
        private final Criteria criteria;

        private OrderEntry(Order order, Criteria criteria) {
            this.criteria = criteria;
            this.order = order;
        }

        public Order getOrder() {
            return this.order;
        }

        public Criteria getCriteria() {
            return this.criteria;
        }

        public String toString() {
            return this.order.toString();
        }
    }

    public static final class CriterionEntry implements Serializable {
        private final Criterion criterion;
        private final Criteria criteria;

        private CriterionEntry(Criterion criterion, Criteria criteria) {
            this.criteria = criteria;
            this.criterion = criterion;
        }

        public Criterion getCriterion() {
            return this.criterion;
        }

        public Criteria getCriteria() {
            return this.criteria;
        }

        public String toString() {
            return this.criterion.toString();
        }

    }

}
