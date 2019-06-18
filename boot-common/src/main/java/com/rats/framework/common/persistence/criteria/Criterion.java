package com.rats.framework.common.persistence.criteria;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;
/**
 * @author hanbing
 * @ClassName: Criterion
 * @Description: 单个查询条件描述类，参考实现org.hibernate.criterion.Criterion
 */
public class Criterion implements Serializable {
    private String propertyName;
    private Object value;
    private Object secondValue;
    private String op;

    /**
     * @Fields noValue : 无需参数
     */
    private boolean noValue;

    /**
     * @Fields singleValue :只有一个参数
     */
    private boolean singleValue;

    /**
     * @Fields betweenValue : 是否是between两个参数
     */
    private boolean betweenValue;

    /**
     * @Fields listValue : 是否参数是列表值
     */
    private boolean listValue;

    /**
     * @Fields dateValue : 是否参数是日期类型
     */
    private boolean dateValue;

    /**
     * @Fields typeHandler : 类型转换处理
     */
    private final String typeHandler;

    /**
     * Title: 没有参数的原子条件类构造
     * Description: 只有一个条件
     *
     * @param propertyName 条件字段
     */
    protected Criterion(final String propertyName, final String op) {
        super();
        this.propertyName = propertyName;
        this.op = op;
        this.typeHandler = null;
        this.noValue = true;
    }

    /**
     * Title: 有一个参数的原子条件类构造
     * Description: 包含一个参数的条件
     *
     * @param propertyName 条件字段
     * @param value        参数1
     * @param op           操作数
     */
    protected Criterion(final String propertyName, final Object value, final String op) {
        this(propertyName, value, op, null);
    }

    /**
     * Title: 有一个参数的原子条件类构造
     * Description: 包含一个参数的条件
     *
     * @param propertyName 条件字段
     * @param value        参数1
     * @param op           操作数
     * @param typeHandler  类型转换处理
     */
    protected Criterion(final String propertyName, final Object value, final String op, final String typeHandler) {
        super();
        this.propertyName = propertyName;
        this.value = value;
        this.op = op;
        this.typeHandler = typeHandler;
        if (value instanceof Object[]) {
            this.listValue = true;
        } else if (value instanceof Date) {
            this.dateValue = true;
        } else {
            this.singleValue = true;
        }
    }


    /**
     * Title: 包含两个参数的原子条件类构造
     * Description: 包含两个参数条件和制定类型转换
     *
     * @param propertyName 条件字段
     * @param value        参数1
     * @param secondValue  参数2
     * @param typeHandler  类型转换
     */
    protected Criterion(final String propertyName, final Object value, final Object secondValue, final String op, final String typeHandler) {
        super();
        this.propertyName = propertyName;
        this.value = value;
        this.secondValue = secondValue;
        this.op = op;
        this.typeHandler = typeHandler;
        this.betweenValue = true;
    }

    /**
     * Title: 包含两个参数的原子条件类构造
     * Description: 包含两个参数条件
     *
     * @param propertyName 条件
     * @param value        参数1
     * @param secondValue  参数2
     */
    protected Criterion(final String propertyName, final Object value, final Object secondValue, final String op) {
        this(propertyName, value, secondValue, op, null);
    }

    /**
     * @return 判断条件
     * @Title: getCondition
     * @Description: 获取判断条件
     */
    public String getCondition() {
        return propertyName + " " + this.op;
    }

    /**
     * @return 第一个参数值
     * @Title: getValue
     * @Description: 获取第一个参数值
     */
    public Object getValue() {
        return value;
    }

    /**
     * @return 第二个参数值
     * @Title: getSecondValue
     * @Description: 获取第二个参数值
     */
    public Object getSecondValue() {
        return secondValue;
    }

    /**
     * @return 是否没有参数值
     * @Title: isNoValue
     * @Description: 是否没有参数值
     */
    public boolean isNoValue() {
        return noValue;
    }

    /**
     * @return 是否只有一个参数
     * @Title: isSingleValue
     * @Description: 是否只有一个参数
     */
    public boolean isSingleValue() {
        return singleValue;
    }

    /**
     * @return 是否between两个参数
     * @Title: isBetweenValue
     * @Description: 是否between两个参数
     */
    public boolean isBetweenValue() {
        return betweenValue;
    }

    /**
     * @return 是否列表参数
     * @Title: isListValue
     * @Description: 是否列表参数
     */
    public boolean isListValue() {
        return listValue;
    }

    /**
     * @return 参数是否日期类型
     * @Title: isDateValue
     * @Description: 参数是否日期类型
     */
    public boolean isDateValue() {
        return dateValue;
    }

    /**
     * @return 类型转换处理
     * @Title: getTypeHandler
     * @Description: 类型转换处理
     */
    public String getTypeHandler() {
        return typeHandler;
    }

    public String toString() {
        if (this.noValue) {
            return this.propertyName + " " + this.op;
        } else if (this.singleValue) {
            return this.propertyName + " " + this.op + this.value;
        } else if (this.betweenValue) {
            return this.propertyName + " " + this.op + " and" + this.value;
        } else if (this.listValue) {
            return this.propertyName + " " + this.op + " (" + StringUtils.join(listValue, ",") + ") ";
        } else if (this.dateValue) {
            return this.propertyName + " " + this.op  + this.value;
        }
        return "";
    }
}
