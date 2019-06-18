package com.rats.service;

import java.util.List;

import com.rats.entity.UserRole;
import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.Pageable;

/**
* UserRoleService
* Description:  
*
* @version : v1.0
* @author : Lu generator
* @since : 
*/
public interface UserRoleService {

    long count(UserRole userRole );

    int delete(UserRole  userRole );

    int deleteByPrimaryKey(Integer id  );

    int save(UserRole  userRole );

    int saveSelective(UserRole  userRole );

    List<UserRole> select(UserRole userRole );

    Page<UserRole> selectPage(UserRole userRole, Pageable pageable);

    UserRole selectByPrimaryKey(Integer id  );

    int update(UserRole update, UserRole conditon);

    int updateSelective(UserRole update, UserRole conditon);

    int updateByPrimaryKey(UserRole userRole );

    int updateByPrimaryKeySelective(UserRole userRole );

}

