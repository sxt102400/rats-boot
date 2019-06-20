package com.rats.framework.base;

import com.rats.framework.common.anno.MapperBean;
import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.PageImpl;
import com.rats.framework.common.page.Pageable;
import com.rats.framework.common.reflect.ClassTypeAdapt;
import com.rats.framework.data.Example;
import com.rats.framework.utils.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Optional;

/**
 * @author hanbing
 * @date 2019-0620
 * @since 1.0.0
 */
public class BaseServiceImpl<T, ID extends Serializable> extends ClassTypeAdapt<T> implements BaseService<T, ID> {

    private static final Logger logger = LoggerFactory.getLogger(BaseService.class);

    public BaseMapper<T, ID> getMapper() {
        String entityClazz = getClassType().getSimpleName();
        Annotation anno = this.getClass().getAnnotation(MapperBean.class);
        Class<?> mapperClazz = ((MapperBean) anno).value();
        BaseMapper bean = (BaseMapper) SpringContextHolder.getBean(mapperClazz);
        if (bean == null) {
            String beanName = String.format("%sMapper", getClassType().getSimpleName());
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
        return this.getMapper().countByPrimaryKey(id) > 0;
    }

    @Override
    public List<T> findAll() {
        List<T> list = this.getMapper().selectByExample(null);
        return list;
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        List<T> data = this.getMapper().selectByExample(null, pageable);
        return new PageImpl<T>(data, pageable);
    }

    @Override
    public List<T> findAllByIds(List<ID> ids) {
        return null;
    }

    @Override
    public <S extends T> Optional<S> findOneById(ID id) {
        S data = (S) this.getMapper().selectByPrimaryKey(id);
        return Optional.ofNullable(data);
    }

    /* find Example */
    @Override
    public long count(Example example) {
        return this.getMapper().countByExample(example);
    }

    @Override
    public int delete(Example example) {
        return this.getMapper().deleteByExample(example);
    }

    @Override
    public boolean exists(Example example) {
        return false;
    }

    @Override
    public List<T> findAll(Example example) {
        return null;
    }

    @Override
    public Page<T> findAll(Example example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends T> Optional<S> findOne(Example example) {
        List<T> list = this.getMapper().selectByExample(example);
        if (list != null) {
            if (list.size() > 1) {
                logger.error("find more than one record:{}", list.size());
                return null;
            } else if (list.size() == 1) {
                S data = (S) list.get(0);
                return Optional.ofNullable(data);
            }
        }
        return Optional.empty();
    }

    /**
     * save or update
     */
    @Override
    public <S extends T> void save(S entity) {
        this.getMapper().insert(entity);
    }

    @Override
    public <S extends T> void update(S entity) {
        this.getMapper().updateByPrimaryKey(entity);
    }

    @Override
    public <S extends T> void update(S entity, Example example) {
        this.getMapper().updateByExample(entity, example);
    }

    @Override
    public <S extends T> void saveOrUpdate(S entity) {
    }

    @Override
    public <S extends T> void saveAll(List<S> entities) {
        entities.forEach(entity -> save(entity));

    }

    @Override
    public <S extends T> void saveAllInBatch(List<S> entities) {
        entities.forEach(entity -> save(entity));
    }


    /**
     * delete
     */
    @Override
    public void deleteAll() {
        this.getMapper().deleteByExample(null);
    }

    @Override
    public void deleteAllInBatch() {
        this.getMapper().deleteByExample(null);
    }

    @Override
    public void deleteById(ID id) {
        this.getMapper().deleteByPrimaryKey(id);
    }
}
