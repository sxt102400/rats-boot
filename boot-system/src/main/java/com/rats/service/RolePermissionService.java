package com.rats.service;

import java.util.List;

import com.rats.entity.RolePermission;
import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.Pageable;

/**
* RolePermissionService
* Description:  
*
* @version : v1.0
* @author : Lu generator
* @since : 
*/
public interface RolePermissionService {

    long count(RolePermission rolePermission );

    int delete(RolePermission  rolePermission );

    int deleteByPrimaryKey(Integer id  );

    int save(RolePermission  rolePermission );

    int saveSelective(RolePermission  rolePermission );

    List<RolePermission> select(RolePermission rolePermission );

    Page<RolePermission> selectPage(RolePermission rolePermission, Pageable pageable);

    RolePermission selectByPrimaryKey(Integer id  );

    int update(RolePermission update, RolePermission conditon);

    int updateSelective(RolePermission update, RolePermission conditon);

    int updateByPrimaryKey(RolePermission rolePermission );

    int updateByPrimaryKeySelective(RolePermission rolePermission );

}

