package com.rats.framework.common.base;


import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.Pageable;
import com.rats.framework.common.data.Example;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @author hanbing
 * @date 2019-06-20
 * @since 1.0.0
 */
public interface BaseService<T, ID extends Serializable> {

    /* find */
    long count();

    boolean existsById(ID id);

    List<T> findAll();

    Page<T> findAll(Pageable pageable);

    List<T> findAllByIds(List<ID> ids);

    Optional<T> findOneById(ID id);

    /* save or update */
    void save(T entity);

    void update(T entity);

    void update(T entity, Example example);

    void saveOrUpdate(T entity);

    /* delete */
    void deleteAll();

    void deleteAll(List<T> entities);

    void deleteById(ID id);

    /* find Example */
    long count(Example example);

    boolean exists(Example example);

    void delete(Example example);

    List<T> findAll(Example example);

    Page<T> findAll(Example example, Pageable pageable);

    Optional<T> findOne(Example example);

    /* batch */
    void saveAllInBatch(List<T> entities);

    void deleteAllInBatch(List<T> entities);


}