package com.rats.framework.common.base;


import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.PageImpl;
import com.rats.framework.common.page.Pageable;
import com.rats.framework.common.persistence.Example;
import com.rats.framework.common.persistence.GeneratedExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Id;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public abstract class CommonServiceImpl<T, ID> extends ClassTypeAdapt<T> implements CommonService<T, ID> {

    private static final Logger logger = LoggerFactory.getLogger(BaseService.class);

    public abstract BaseMapper<T, ID> getMapper();

    public Example buildExample(T condition) {
        Example example = new Example();
        Example.Criteria criteria = example.createCriteria();
        Field[] fileds = getClassType().getDeclaredFields();
        Arrays.stream(fileds).forEach(field -> {
            try {
                Object value = null;
                String columnName = null;
                if (field.isAnnotationPresent(Id.class) || field.isAnnotationPresent(Column.class)) {
                    PropertyDescriptor pd = new PropertyDescriptor(field.getName(), getClassType());
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

    @Override
    public long count() {
        return this.getMapper().countByExample(null);
    }

    @Override
    public long count(T entity) {
        GeneratedExample example = buildExample(entity);
        return this.getMapper().countByExample(example);
    }

    @Override
    public void delete(T entity) {
        GeneratedExample example = buildExample(entity);
        this.getMapper().deleteByExample(example);
    }

    @Override
    public void deleteAll() {
        this.getMapper().deleteByExample(null);
    }

    @Override
    public void deleteAll(Iterable<? extends T> entities) {
        entities.forEach(entity -> {
            GeneratedExample example = buildExample(entity);
            this.getMapper().deleteByExample(example);
        });
    }

    @Override
    public void deleteAllInBatch() {
        this.getMapper().deleteByExample(null);
    }

    @Override
    public void deleteInBatch(Iterable<T> entities) {
        //
    }

    @Override
    public void deleteById(ID id) {
        this.getMapper().deleteByPrimaryKey(id);
    }

    @Override
    public boolean exists(Example<T> example) {
        return false;
    }

    @Override
    public boolean exists(T entity) {
        GeneratedExample example = buildExample(entity);
        return this.getMapper().countByExample(example) > 0;
    }

    @Override
    public boolean existsById(ID id) {
        return this.getMapper().countByPrimaryKey(id) > 0;
    }

    @Override
    public Iterable<T> findAll() {
        return this.getMapper().selectByExample(null);
    }

    @Override
    public <S extends T> Iterable<S> findAll(S entity) {
        GeneratedExample example = this.buildExample(entity);
        return this.getMapper().selectByExample(example);
    }

    @Override
    public <S extends T> Iterable<S> findAll(Example<S> example) {
        return this.getMapper().selectByExample(example);
    }

    @Override
    public <S extends T> Page<S> findAll(S entity, Pageable pageable) {
        GeneratedExample example = this.buildExample(entity);
        List data = this.getMapper().selectByExample(example, pageable);
        return new PageImpl(data, pageable);
    }

    @Override
    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
        List<T> data = getMapper().selectByExample(example, pageable);
        return new PageImpl(data, pageable);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        List<T> data = getMapper().selectByExample(null, pageable);
        return new PageImpl(data, pageable);
    }

    @Override
    public Iterable<T> findAllById(Iterable<ID> ids) {
        Stream<ID> stream = StreamSupport.stream(ids.spliterator(), false);
        List<T> list = stream.map(id -> getMapper().selectByPrimaryKey(id)).collect(Collectors.toList());
        return list;
    }

    @Override
    public Optional<T> findById(ID id) {
        T entity = getMapper().selectByPrimaryKey(id);
        return Optional.ofNullable(entity);
    }

    @Override
    public <S extends T> Optional<S> findOne(GeneratedExample<S> example) {
        List<S> data = getMapper().selectByExample(example);
        if (data != null && data.get(0) != null) {
            return Optional.of(data.get(0));
        }
        return Optional.empty();
    }

    @Override
    public <S extends T> S insert(S entity) {
        this.getMapper().insert(entity);
        return entity;
    }

    @Override
    public <S extends T> S update(S entity) {
        this.getMapper().updateByPrimaryKey(entity);
        return entity;
    }

    @Override
    public <S extends T> S update(S entity, S condition) {
        GeneratedExample example = this.buildExample(entity);
        this.getMapper().updateByExample(entity, example);
        return entity;
    }

    @Override
    public <S extends T> S update(S entity, Example<S> example) {
        this.getMapper().updateByExample(entity, example);
        return entity;
    }

    @Override
    public <S extends T> S save(S entity) {
        //TODO
        return null;
    }

    @Override
    public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
        entities.forEach(entity -> {
            save(entity);
        });
        return entities;
    }


}
