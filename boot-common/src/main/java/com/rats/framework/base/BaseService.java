package com.rats.framework.base;


import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.Pageable;
import com.rats.framework.data.Example;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @author hanbing
 * @date 2019-0620
 * @since 1.0.0
 */
public interface BaseService<T, ID extends Serializable> {

    long count();

    int deleteAll();

    int deleteAllInBatch();

    int deleteById(ID id);

    boolean existsById(ID id);

    List<T> findAll();

    Page<T> findAll(Pageable pageable);

    List<T> findAllByIds(Iterable<ID> ids);

    <S extends T> Optional<S> findOneById(ID id);

    <S extends T> Optional<S> findOne(Example example);

    /**
     * save or update
     */
    <S extends T> int save(S entity);

    <S extends T> int update(S entity);

    <S extends T> int update(S entity, Example example);

    <S extends T> int saveOrUpdate(S entity);

    <S extends T> int saveAll(List<S> entities);

    <S extends T> int saveAllInBatch(List<S> entities);

    /**
     * Example
     **/
    long count(Example example);

    int delete(Example example);

    boolean exists(Example example);

    List<T> findAll(Example example);

    Page<T> findAll(Example example, Pageable pageable);


}