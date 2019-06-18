package com.rats.service.impl;


import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rats.entity.User;
import com.rats.mapper.UserMapper;
import com.rats.service.UserService;
import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.Pageable;
import com.rats.framework.common.page.PageImpl;
import com.rats.framework.common.persistence.Example;

/** Copyright (C) 2013 rats
 *
 * UserServiceImpl
 * Description: 
 *
 * @version : v1.0
 * @author : Lu generator
 * @since : 
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    /**
     * Field LOGGER : 日志操作类
     */
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    /**
     * Field userMapper : userMapper
     */
    @Resource
    private UserMapper userMapper;

    /**
     * userService.count
     * Description: 根据查询条件，计算User个数
     *
     * @param condition User参数
     * @return int 结果个数
     */
    @Override
    public long count(User condition ) {
        Example example = buildExample(condition);
        return this.userMapper.countByExample(example);
    }

    /**
     * userService.delete
     * Description: 根据查询条件，删除user
     *
     * @param condition User参数，查询条件
     * @return void
     */
    @Override
    public int delete(User condition ) {
        Example example = buildExample(condition);
        return this.userMapper.deleteByExample(example);
    }

    /**
     * UserService.deleteByPrimaryKey
     * Description: 修改User
     *
     * @param id 主键
     * @return void
     */
    @Override
    public int deleteByPrimaryKey(String id ) {
        return this.userMapper.deleteByPrimaryKey(id);
    }

    /**
     * UserService.save
     * Description: 保存User,
     *
     * @param user User参数
     * @return void
     */
    @Override
    public int save(User user ) {
        return  this.userMapper.insert(user );
    }

    /**
     * UserService.saveSelective
     * Description: 保存User, 只插入User的非空字段
     *
     * @param user User参数
     * @return void
     */
    public int saveSelective(User user ) {
        return this.userMapper.insertSelective( user );
    }

    /**
     * UserService.select
     * Description: 根据查询条件类，返回User结果集
     *
     * @param condition User参数，查询条件
     * @return List<User> User结果集 [不分页]
     */
    @Override
    public List<User> select(User condition ) {
        Example example = buildExample(condition);
        return this.userMapper.selectByExample(example);
    }

    /**
     * UserService.select
     * Description: 根据查询条件类，返回User结果集 [分页]
     *
     * @param condition User参数，查询条件
     * @param page Page参数，分页条件
     * @return Page<User> User结果集
     */
    @Override
    public Page<User> selectPage(User condition, Pageable pageable) {
        Example example = buildExample(condition);
        RowBounds rowBounds = new RowBounds( (int)(pageable.getOffset()), (int)(pageable.getLimit()));
        long totalCount = userMapper.countByExample(example);
        List<User> data = userMapper.selectByExample(example, rowBounds);
        Page<User> page = new PageImpl(data,pageable,totalCount);
        return page;
    }

    /**
     * UserService.selectByPrimaryKey
     * Description: 根据主键，返回User
     *
     * @param id 主键
     * @return User参数
     */
    @Override
    public User selectByPrimaryKey(String id  ) {
        return userMapper.selectByPrimaryKey(id );
    }


    /**
     * UserService.update
     * Description: 修改User, 根据查询条件修改
     *
     * @param update    User参数需改的值
     * @param condition User查询条件
     * @return void

     */
    @Override
    public int update(User update, User  condition ) {
        Example example = buildExample(condition);
        return this.userMapper.updateByExample(update, example);
    }

    /**
     * UserService.updateSelective
     * Description: 修改User, 根据查询条件修改
     *
     * @param update    User参数需改的值
     * @param condition User查询条件
     * @return void
     */
    @Override
    public int updateSelective(User update, User  condition ) {
        Example example = buildExample(condition);
        return this.userMapper.updateByExampleSelective(update, example);
    }

    /**
     * UserService.updateByPrimaryKey
     * Description: 修改User, 根据主键修改
     *
     * @param user User参数
     * @return void
     */
    @Override
    public int updateByPrimaryKey(User user ) {
        return this.userMapper.updateByPrimaryKey(user );
    }

    /**
     * UserService.updateByPrimaryKeySelective
     * Description: 修改User, 根据主键修改，只修改非空参数字段
     *
     * @param user User参数
     * @return void
     */
    @Override
    public int updateByPrimaryKeySelective(User user ) {
        return this.userMapper.updateByPrimaryKeySelective(user );
    }


    public Example buildExample(User condition){
        Example example = new Example();
        Example.Criteria criteria = example.createCriteria();
        if (condition.getId() != null) {
            criteria.andEqualTo( "id",condition.getId() );
        }
        if (condition.getDepartId() != null) {
            criteria.andEqualTo( "depart_id",condition.getDepartId() );
        }
        if (condition.getUsername() != null) {
            criteria.andEqualTo( "username",condition.getUsername() );
        }
        if (condition.getPassword() != null) {
            criteria.andEqualTo( "password",condition.getPassword() );
        }
        if (condition.getUserNo() != null) {
            criteria.andEqualTo( "user_no",condition.getUserNo() );
        }
        if (condition.getName() != null) {
            criteria.andEqualTo( "name",condition.getName() );
        }
        if (condition.getEmail() != null) {
            criteria.andEqualTo( "email",condition.getEmail() );
        }
        if (condition.getMobile() != null) {
            criteria.andEqualTo( "mobile",condition.getMobile() );
        }
        if (condition.getUserType() != null) {
            criteria.andEqualTo( "user_type",condition.getUserType() );
        }
        if (condition.getPhoto() != null) {
            criteria.andEqualTo( "photo",condition.getPhoto() );
        }
        if (condition.getLoginIp() != null) {
            criteria.andEqualTo( "login_ip",condition.getLoginIp() );
        }
        if (condition.getLoginDate() != null) {
            criteria.andEqualTo( "login_date",condition.getLoginDate() );
        }
        if (condition.getCreator() != null) {
            criteria.andEqualTo( "creator",condition.getCreator() );
        }
        if (condition.getCreateDate() != null) {
            criteria.andEqualTo( "create_date",condition.getCreateDate() );
        }
        if (condition.getUpdater() != null) {
            criteria.andEqualTo( "updater",condition.getUpdater() );
        }
        if (condition.getUpdateDate() != null) {
            criteria.andEqualTo( "update_date",condition.getUpdateDate() );
        }
        if (condition.getRemarks() != null) {
            criteria.andEqualTo( "remarks",condition.getRemarks() );
        }
        if (condition.getState() != null) {
            criteria.andEqualTo( "state",condition.getState() );
        }
        return example;
    }
}



