package com.rats.framework.common.base;

import com.rats.framework.common.anno.ImportMapper;
import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.PageImpl;
import com.rats.framework.common.page.Pageable;
import com.rats.framework.common.reflect.ClassTypeAdapt;
import com.rats.framework.common.data.Example;
import com.rats.framework.utils.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.persistence.Id;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author hanbing
 * @date 2019-06-20
 * @since 1.0.0
 */
public abstract class BaseServiceImpl<T, ID extends Serializable> extends ClassTypeAdapt<T> implements BaseService<T, ID> {

    private static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

    public BaseMapper<T, ID> getMapper() {
        BaseMapper bean = null;
        Annotation anno = this.getClass().getAnnotation(ImportMapper.class);
        if (anno != null) {
            Class<?> mapperClazz = ((ImportMapper) anno).value();
            bean = (BaseMapper) SpringContextHolder.getBean(mapperClazz);
        }
        if (bean == null) {
            String beanName = String.format("%sMapper", StringUtils.uncapitalize(getClassType().getSimpleName()));
            bean = SpringContextHolder.getBean(beanName);
        }
        if (bean == null) {
            throw new RuntimeException("cant get the mapper class by " + this.getClass().getName());
        }
        return bean;
    }

    @Override
    public long count() {
        return this.getMapper().countByExample(null);
    }

    @Override
    public boolean existsById(ID id) {
        return this.getMapper().selectByPrimaryKey(id) != null;
    }

    @Override
    public List<T> findAll() {
        return this.getMapper().selectByExample(null);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        List<T> data = this.getMapper().selectByExample(null, pageable);
        return new PageImpl<T>(data, pageable);
    }

    @Override
    public List<T> findAllByIds(List<ID> ids) {
        Stream<ID> stream = StreamSupport.stream(ids.spliterator(), false);
        List<T> list = stream.map(id -> this.getMapper().selectByPrimaryKey(id)).collect(Collectors.toList());
        return list;
    }

    @Override
    public Optional<T> findOneById(ID id) {
        T data = this.getMapper().selectByPrimaryKey(id);
        return Optional.ofNullable(data);
    }

    @Override
    public void save(T entity) {
        this.getMapper().insert(entity);
    }

    @Override
    public void update(T entity) {
        this.getMapper().updateByPrimaryKey(entity);
    }

    @Override
    public void update(T entity, Example example) {
        this.getMapper().updateByExample(entity, example);
    }

    @Override
    public void saveOrUpdate(T entity) {
        ID id = getPrimaryKey(entity);
        Assert.notNull(id, "get id column is null");
        if (id != null) {
            T result = getMapper().selectByPrimaryKey(id);
            if (result != null) {
                this.update(entity);
            } else {
                this.save(entity);
            }
        }
    }


    @Override
    public void deleteAll() {
        this.getMapper().deleteByExample(null);
    }

    @Override
    public void deleteAll(List<T> entities) {
        entities.forEach(condition -> {
            Example example = Example.of(condition);
            this.getMapper().deleteByExample(example);
        });
    }

    @Override
    public void deleteById(ID id) {
        this.getMapper().deleteByPrimaryKey(id);
    }

    /* Example */
    @Override
    public long count(Example example) {
        return this.getMapper().countByExample(example);
    }

    @Override
    public boolean exists(Example example) {
        return this.getMapper().countByExample(example) > 0;
    }

    @Override
    public List<T> findAll(Example example) {
        return this.getMapper().selectByExample(example);
    }

    @Override
    public Page<T> findAll(Example example, Pageable pageable) {
        List<T> data = getMapper().selectByExample(example, pageable);
        return new PageImpl<T>(data, pageable);
    }

    @Override
    public void delete(Example example) {
        this.getMapper().deleteByExample(example);
    }

    @Override
    public Optional<T> findOne(Example example) {
        List<T> list = this.getMapper().selectByExample(example);
        if (list != null) {
            if (list.size() == 1) {
                return Optional.of(list.get(0));
            } else if (list.size() > 1) {
                logger.error("has duplicate items result more than one: {}", list.size());
            }
        }
        return Optional.empty();
    }


    private ID getPrimaryKey(T entity) {
        ID idValue = null;
        Field[] fileds = getClassType().getDeclaredFields();
        Optional<Field> optional = Arrays.stream(fileds).filter(field -> field.isAnnotationPresent(Id.class)).findFirst();
        if (optional.isPresent()) {
            Field field = optional.get();
            try {
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), getClassType());
                Method getMethod = pd.getReadMethod();
                idValue = (ID) getMethod.invoke(entity);
            } catch (IllegalAccessException | InvocationTargetException | IntrospectionException e) {
                throw new RuntimeException("serviceImpl getPrimaryKey error", e);
            }
        }
        return idValue;
    }

    /* Batch */
    @Override
    public void saveAllInBatch(List<T> entities) {

    }

    @Override
    public void deleteAllInBatch(List<T> entities) {

    }
}
