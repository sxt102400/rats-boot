package com.rats.framework.common.base;


import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.Pageable;
import com.rats.framework.common.persistence.Example;
import com.rats.framework.common.persistence.GeneratedExample;

import java.io.Serializable;
import java.util.Optional;

public interface BaseService<T, ID extends Serializable> {

    long count();

    void deleteAll();

    void deleteAllInBatch();

    void deleteById(ID id);

    boolean existsById(ID id);

    Iterable<T> findAll();

    Page<T> findAll(Pageable pageable);

    Iterable<T>  findAllById(Iterable<ID> ids);

    Optional<T> findById(ID id);

    <S extends T> Optional<S> findOne(GeneratedExample<S> example);

    /**
     *  save or update
     */
    <S extends T> S save(S entity);

    <S extends T> S update(S entity);

    <S extends T> S update(S entity,Example<S> example);

    <S extends T> S saveOrUpdate(S entity);

    <S extends T> Iterable<S> saveAll(Iterable<S> entities);

    <S extends T> Iterable<S> saveAllInBatch(Iterable<S> entities);

    /** Example **/
    long count(T entity);

    void delete(T entity);

    boolean exists(Example<T> example);

    boolean exists(T entity);

    void deleteAll(Iterable<? extends T> entities);

    void deleteInBatch(Iterable<T> entities);

    <S extends T> Iterable<S> findAll(S entity);

    <S extends T> Iterable<S> findAll(Example<S> example);

    <S extends T> Page<S> findAll(S entity, Pageable pageable);

    <S extends T> Page<S> findAll(Example<S> example, Pageable pageable);


}