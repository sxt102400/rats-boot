package com.rats.service;

import java.util.List;

import com.rats.entity.User;
import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.Pageable;

/**
* UserService
* Description:  
*
* @version : v1.0
* @author : Lu generator
* @since : 
*/
public interface UserService {

    long count(User user );

    int delete(User  user );

    int deleteByPrimaryKey(String id  );

    int save(User  user );

    int saveSelective(User  user );

    List<User> select(User user );

    Page<User> selectPage(User user, Pageable pageable);

    User selectByPrimaryKey(String id  );

    int update(User update, User conditon);

    int updateSelective(User update, User conditon);

    int updateByPrimaryKey(User user );

    int updateByPrimaryKeySelective(User user );

}

