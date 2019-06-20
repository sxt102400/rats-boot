package com.rats.service.impl;


import java.util.List;
import javax.annotation.Resource;

import com.rats.framework.data.Example;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rats.entity.RolePermission;
import com.rats.mapper.RolePermissionMapper;
import com.rats.service.RolePermissionService;
import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.Pageable;
import com.rats.framework.common.page.PageImpl;

/** Copyright (C) 2013 rats
 *
 * RolePermissionServiceImpl
 * Description: 
 *
 * @version : v1.0
 * @author : Lu generator
 * @since : 
 */
@Service(value = "rolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService {

    /**
     * Field LOGGER : 日志操作类
     */
    private static final Logger logger = LoggerFactory.getLogger(RolePermissionService.class);

    /**
     * Field rolePermissionMapper : rolePermissionMapper
     */
    @Resource
    private RolePermissionMapper rolePermissionMapper;

    /**
     * rolePermissionService.count
     * Description: 根据查询条件，计算RolePermission个数
     *
     * @param condition RolePermission参数
     * @return int 结果个数
     */
    @Override
    public long count(RolePermission condition ) {
        GeneratedExample example = buildExample(condition);
        return this.rolePermissionMapper.countByExample(example);
    }

    /**
     * rolePermissionService.delete
     * Description: 根据查询条件，删除rolePermission
     *
     * @param condition RolePermission参数，查询条件
     * @return void
     */
    @Override
    public int delete(RolePermission condition ) {
        GeneratedExample example = buildExample(condition);
        return this.rolePermissionMapper.deleteByExample(example);
    }

    /**
     * RolePermissionService.deleteByPrimaryKey
     * Description: 修改RolePermission
     *
     * @param id 主键
     * @return void
     */
    @Override
    public int deleteByPrimaryKey(Integer id ) {
        return this.rolePermissionMapper.deleteByPrimaryKey(id);
    }

    /**
     * RolePermissionService.save
     * Description: 保存RolePermission,
     *
     * @param rolePermission RolePermission参数
     * @return void
     */
    @Override
    public int save(RolePermission rolePermission ) {
        return  this.rolePermissionMapper.insert(rolePermission );
    }

    /**
     * RolePermissionService.saveSelective
     * Description: 保存RolePermission, 只插入RolePermission的非空字段
     *
     * @param rolePermission RolePermission参数
     * @return void
     */
    public int saveSelective(RolePermission rolePermission ) {
        return this.rolePermissionMapper.insertSelective( rolePermission );
    }

    /**
     * RolePermissionService.select
     * Description: 根据查询条件类，返回RolePermission结果集
     *
     * @param condition RolePermission参数，查询条件
     * @return List<RolePermission> RolePermission结果集 [不分页]
     */
    @Override
    public List<RolePermission> select(RolePermission condition ) {
        GeneratedExample example = buildExample(condition);
        return this.rolePermissionMapper.selectByExample(example);
    }

    /**
     * RolePermissionService.select
     * Description: 根据查询条件类，返回RolePermission结果集 [分页]
     *
     * @param condition RolePermission参数，查询条件
     * @param pageable Page参数，分页条件
     * @return Page<RolePermission> RolePermission结果集
     */
    @Override
    public Page<RolePermission> selectPage(RolePermission condition, Pageable pageable) {
        GeneratedExample example = buildExample(condition);
        RowBounds rowBounds = new RowBounds( (int)(pageable.getOffset()), (int)(pageable.getLimit()));
        long totalCount = rolePermissionMapper.countByExample(example);
        List<RolePermission> data = rolePermissionMapper.selectByExample(example, rowBounds);
        Page<RolePermission> page = new PageImpl(data,pageable,totalCount);
        return page;
    }

    /**
     * RolePermissionService.selectByPrimaryKey
     * Description: 根据主键，返回RolePermission
     *
     * @param id 主键
     * @return RolePermission参数
     */
    @Override
    public RolePermission selectByPrimaryKey(Integer id  ) {
        return rolePermissionMapper.selectByPrimaryKey(id );
    }


    /**
     * RolePermissionService.update
     * Description: 修改RolePermission, 根据查询条件修改
     *
     * @param update    RolePermission参数需改的值
     * @param condition RolePermission查询条件
     * @return void

     */
    @Override
    public int update(RolePermission update, RolePermission  condition ) {
        GeneratedExample example = buildExample(condition);
        return this.rolePermissionMapper.updateByExample(update, example);
    }

    /**
     * RolePermissionService.updateSelective
     * Description: 修改RolePermission, 根据查询条件修改
     *
     * @param update    RolePermission参数需改的值
     * @param condition RolePermission查询条件
     * @return void
     */
    @Override
    public int updateSelective(RolePermission update, RolePermission  condition ) {
        GeneratedExample example = buildExample(condition);
        return this.rolePermissionMapper.updateByExampleSelective(update, example);
    }

    /**
     * RolePermissionService.updateByPrimaryKey
     * Description: 修改RolePermission, 根据主键修改
     *
     * @param rolePermission RolePermission参数
     * @return void
     */
    @Override
    public int updateByPrimaryKey(RolePermission rolePermission ) {
        return this.rolePermissionMapper.updateByPrimaryKey(rolePermission );
    }

    /**
     * RolePermissionService.updateByPrimaryKeySelective
     * Description: 修改RolePermission, 根据主键修改，只修改非空参数字段
     *
     * @param rolePermission RolePermission参数
     * @return void
     */
    @Override
    public int updateByPrimaryKeySelective(RolePermission rolePermission ) {
        return this.rolePermissionMapper.updateByPrimaryKeySelective(rolePermission );
    }

    public Example buildExample(RolePermission condition){
        Example<RolePermission> example = new Example();
        Example.Criteria<RolePermission> criteria = example.createCriteria();
        if (condition.getId() != null) {
            criteria.andEqualTo( RolePermission::getId,condition.getId() );
        }
        if (condition.getRoleId() != null) {
            criteria.andEqualTo( RolePermission::getRoleId,condition.getRoleId() );
        }
        if (condition.getResourceId() != null) {
            criteria.andEqualTo( RolePermission::getResourceId,condition.getResourceId() );
        }
        if (condition.getResourceType() != null) {
            criteria.andEqualTo( RolePermission::getResourceType,condition.getResourceType() );
        }
        return example;
    }
}



