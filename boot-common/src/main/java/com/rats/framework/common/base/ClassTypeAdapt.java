package com.rats.framework.common.base;

import java.lang.reflect.ParameterizedType;

public abstract class ClassTypeAdapt<T> {

    public Class<T> getClassType() {
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class<T> clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        return clazz;
    }
}
