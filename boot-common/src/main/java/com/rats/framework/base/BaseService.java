package com.rats.framework.base;


import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.Pageable;
import com.rats.framework.data.Example;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author hanbing
 * @since 1.0.0
 * @date 2019-06-20
 */
public interface BaseService<T, ID extends Serializable> {

    /* find */
    long count();

    boolean existsById(ID id);

    List<T> findAll();

    Page<T> findAll(Pageable pageable);

    List<T> findAllByIds(List<ID> ids);

    <S extends T> Optional<S> findOneById(ID id);

    /* find Example */
    long count(Example example);

    int delete(Example example);

    boolean exists(Example example);

    List<T> findAll(Example example);

    Page<T> findAll(Example example, Pageable pageable);

    <S extends T> Optional<S> findOne(Example example);

    /* save or update */
    <S extends T> void save(S entity);

    <S extends T> void update(S entity);

    <S extends T> void update(S entity, Example example);

    <S extends T> void saveOrUpdate(S entity);

    <S extends T> void saveAll(List<S> entities);

    <S extends T> void saveAllInBatch(List<S> entities);

    /* delete */
    void deleteAll();

    void deleteAllInBatch();

    void deleteById(ID id);


}