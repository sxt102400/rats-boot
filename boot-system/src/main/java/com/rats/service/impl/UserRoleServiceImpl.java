package com.rats.service.impl;


import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rats.entity.UserRole;
import com.rats.mapper.UserRoleMapper;
import com.rats.service.UserRoleService;
import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.Pageable;
import com.rats.framework.common.page.PageImpl;
import com.rats.framework.common.persistence.Example;

/** Copyright (C) 2013 rats
 *
 * UserRoleServiceImpl
 * Description: 
 *
 * @version : v1.0
 * @author : Lu generator
 * @since : 
 */
@Service(value = "userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

    /**
     * Field LOGGER : 日志操作类
     */
    private static final Logger logger = LoggerFactory.getLogger(UserRoleService.class);

    /**
     * Field userRoleMapper : userRoleMapper
     */
    @Resource
    private UserRoleMapper userRoleMapper;

    /**
     * userRoleService.count
     * Description: 根据查询条件，计算UserRole个数
     *
     * @param condition UserRole参数
     * @return int 结果个数
     */
    @Override
    public long count(UserRole condition ) {
        Example example = buildExample(condition);
        return this.userRoleMapper.countByExample(example);
    }

    /**
     * userRoleService.delete
     * Description: 根据查询条件，删除userRole
     *
     * @param condition UserRole参数，查询条件
     * @return void
     */
    @Override
    public int delete(UserRole condition ) {
        Example example = buildExample(condition);
        return this.userRoleMapper.deleteByExample(example);
    }

    /**
     * UserRoleService.deleteByPrimaryKey
     * Description: 修改UserRole
     *
     * @param id 主键
     * @return void
     */
    @Override
    public int deleteByPrimaryKey(Integer id ) {
        return this.userRoleMapper.deleteByPrimaryKey(id);
    }

    /**
     * UserRoleService.save
     * Description: 保存UserRole,
     *
     * @param userRole UserRole参数
     * @return void
     */
    @Override
    public int save(UserRole userRole ) {
        return  this.userRoleMapper.insert(userRole );
    }

    /**
     * UserRoleService.saveSelective
     * Description: 保存UserRole, 只插入UserRole的非空字段
     *
     * @param userRole UserRole参数
     * @return void
     */
    public int saveSelective(UserRole userRole ) {
        return this.userRoleMapper.insertSelective( userRole );
    }

    /**
     * UserRoleService.select
     * Description: 根据查询条件类，返回UserRole结果集
     *
     * @param condition UserRole参数，查询条件
     * @return List<UserRole> UserRole结果集 [不分页]
     */
    @Override
    public List<UserRole> select(UserRole condition ) {
        Example example = buildExample(condition);
        return this.userRoleMapper.selectByExample(example);
    }

    /**
     * UserRoleService.select
     * Description: 根据查询条件类，返回UserRole结果集 [分页]
     *
     * @param condition UserRole参数，查询条件
     * @param page Page参数，分页条件
     * @return Page<UserRole> UserRole结果集
     */
    @Override
    public Page<UserRole> selectPage(UserRole condition, Pageable pageable) {
        Example example = buildExample(condition);
        RowBounds rowBounds = new RowBounds( (int)(pageable.getOffset()), (int)(pageable.getLimit()));
        long totalCount = userRoleMapper.countByExample(example);
        List<UserRole> data = userRoleMapper.selectByExample(example, rowBounds);
        Page<UserRole> page = new PageImpl(data,pageable,totalCount);
        return page;
    }

    /**
     * UserRoleService.selectByPrimaryKey
     * Description: 根据主键，返回UserRole
     *
     * @param id 主键
     * @return UserRole参数
     */
    @Override
    public UserRole selectByPrimaryKey(Integer id  ) {
        return userRoleMapper.selectByPrimaryKey(id );
    }


    /**
     * UserRoleService.update
     * Description: 修改UserRole, 根据查询条件修改
     *
     * @param update    UserRole参数需改的值
     * @param condition UserRole查询条件
     * @return void

     */
    @Override
    public int update(UserRole update, UserRole  condition ) {
        Example example = buildExample(condition);
        return this.userRoleMapper.updateByExample(update, example);
    }

    /**
     * UserRoleService.updateSelective
     * Description: 修改UserRole, 根据查询条件修改
     *
     * @param update    UserRole参数需改的值
     * @param condition UserRole查询条件
     * @return void
     */
    @Override
    public int updateSelective(UserRole update, UserRole  condition ) {
        Example example = buildExample(condition);
        return this.userRoleMapper.updateByExampleSelective(update, example);
    }

    /**
     * UserRoleService.updateByPrimaryKey
     * Description: 修改UserRole, 根据主键修改
     *
     * @param userRole UserRole参数
     * @return void
     */
    @Override
    public int updateByPrimaryKey(UserRole userRole ) {
        return this.userRoleMapper.updateByPrimaryKey(userRole );
    }

    /**
     * UserRoleService.updateByPrimaryKeySelective
     * Description: 修改UserRole, 根据主键修改，只修改非空参数字段
     *
     * @param userRole UserRole参数
     * @return void
     */
    @Override
    public int updateByPrimaryKeySelective(UserRole userRole ) {
        return this.userRoleMapper.updateByPrimaryKeySelective(userRole );
    }


    public Example buildExample(UserRole condition){
        Example example = new Example();
        Example.Criteria criteria = example.createCriteria();
        if (condition.getId() != null) {
            criteria.andEqualTo( "id",condition.getId() );
        }
        if (condition.getRoleId() != null) {
            criteria.andEqualTo( "role_id",condition.getRoleId() );
        }
        if (condition.getUserId() != null) {
            criteria.andEqualTo( "user_id",condition.getUserId() );
        }
        return example;
    }
}



