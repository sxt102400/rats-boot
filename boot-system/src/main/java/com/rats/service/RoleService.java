package com.rats.service;

import java.util.List;

import com.rats.entity.Role;
import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.Pageable;

/**
* RoleService
* Description:  
*
* @version : v1.0
* @author : Lu generator
* @since : 
*/
public interface RoleService {

    long count(Role role );

    int delete(Role  role );

    int deleteByPrimaryKey(String id  );

    int save(Role  role );

    int saveSelective(Role  role );

    List<Role> select(Role role );

    Page<Role> selectPage(Role role, Pageable pageable);

    Role selectByPrimaryKey(String id  );

    int update(Role update, Role conditon);

    int updateSelective(Role update, Role conditon);

    int updateByPrimaryKey(Role role );

    int updateByPrimaryKeySelective(Role role );

}

