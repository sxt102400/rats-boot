package com.rats.service;

import java.util.List;

import com.rats.entity.Operation;
import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.Pageable;

/**
* OperationService
* Description:  
*
* @version : v1.0
* @author : Lu generator
* @since : 
*/
public interface OperationService {

    long count(Operation operation );

    int delete(Operation  operation );

    int deleteByPrimaryKey(Integer id  );

    int save(Operation  operation );

    int saveSelective(Operation  operation );

    List<Operation> select(Operation operation );

    Page<Operation> selectPage(Operation operation, Pageable pageable);

    Operation selectByPrimaryKey(Integer id  );

    int update(Operation update, Operation conditon);

    int updateSelective(Operation update, Operation conditon);

    int updateByPrimaryKey(Operation operation );

    int updateByPrimaryKeySelective(Operation operation );

}

