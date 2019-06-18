package com.rats.framework.common.base;


import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.Pageable;
import com.rats.framework.common.persistence.Example;
import com.rats.framework.common.persistence.GeneratedExample;

import java.io.Serializable;
import java.util.Optional;

public interface BaseService<T, ID extends Serializable> {

    long count();

    long count(T entity);

    void delete(T entity);

    void deleteAll();

    void deleteAll(Iterable<? extends T> entities);

    void deleteAllInBatch();

    void deleteById(ID id);

    void deleteInBatch(Iterable<T> entities);

    boolean exists(Example<T> example);

    boolean exists(T entity);

    boolean existsById(ID id);

    Iterable<T> findAll();

    Page<T> findAll(Pageable pageable);

    <S extends T> Iterable<S> findAll(S entity);

    <S extends T> Iterable<S> findAll(Example<S> example);

    <S extends T> Page<S> findAll(S entity, Pageable pageable);

    <S extends T> Page<S> findAll(Example<S> example, Pageable pageable);

    Iterable<T>  findAllById(Iterable<ID> ids);

    Optional<T> findById(ID id);

    <S extends T> Optional<S> findOne(GeneratedExample<S> example);

    /**
     *  save =  insert or  update
     * @param entity
     * @param <S>
     * @return
     */
    <S extends T> S save(S entity);

    <S extends T> S insert(S entity);

    <S extends T> S update(S entity);

    <S extends T> S update(S entity,S condition);

    <S extends T> S update(S entity,Example<S> example);

    <S extends T> Iterable<S> saveAll(Iterable<S> entities);

}