package com.rats.service.impl;



import com.rats.framework.common.anno.ImportMapper;
import com.rats.framework.common.anno.WithMapper;
import com.rats.framework.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import com.rats.entity.Depart;
import com.rats.mapper.DepartMapper;
import com.rats.service.DepartService;

/**
 * Copyright (C) 2013 rats
 * <p>
 * DepartServiceImpl
 * Description:
 *
 * @author : Lu generator
 * @version : v1.0
 * @since :
 */
@Service(value = "departService")
@ImportMapper(DepartMapper.class)
public class DepartServiceImpl extends BaseServiceImpl<Depart, Integer> implements DepartService {


    @Override
    public <S extends Depart> S saveOrUpdate(S entity) {
        return null;
    }

    @Override
    public <S extends Depart> Iterable<S> saveAllInBatch(Iterable<S> entities) {
        return null;
    }
}



