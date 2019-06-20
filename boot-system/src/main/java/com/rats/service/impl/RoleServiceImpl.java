package com.rats.service.impl;


import java.util.List;
import javax.annotation.Resource;

import com.rats.framework.data.Example;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rats.entity.Role;
import com.rats.mapper.RoleMapper;
import com.rats.service.RoleService;
import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.Pageable;
import com.rats.framework.common.page.PageImpl;

/** Copyright (C) 2013 rats
 *
 * RoleServiceImpl
 * Description: 
 *
 * @version : v1.0
 * @author : Lu generator
 * @since : 
 */
@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    /**
     * Field LOGGER : 日志操作类
     */
    private static final Logger logger = LoggerFactory.getLogger(RoleService.class);

    /**
     * Field roleMapper : roleMapper
     */
    @Resource
    private RoleMapper roleMapper;

    /**
     * roleService.count
     * Description: 根据查询条件，计算Role个数
     *
     * @param condition Role参数
     * @return int 结果个数
     */
    @Override
    public long count(Role condition ) {
        GeneratedExample example = buildExample(condition);
        return this.roleMapper.countByExample(example);
    }

    /**
     * roleService.delete
     * Description: 根据查询条件，删除role
     *
     * @param condition Role参数，查询条件
     * @return void
     */
    @Override
    public int delete(Role condition ) {
        GeneratedExample example = buildExample(condition);
        return this.roleMapper.deleteByExample(example);
    }

    /**
     * RoleService.deleteByPrimaryKey
     * Description: 修改Role
     *
     * @param id 主键
     * @return void
     */
    @Override
    public int deleteByPrimaryKey(String id ) {
        return this.roleMapper.deleteByPrimaryKey(id);
    }

    /**
     * RoleService.save
     * Description: 保存Role,
     *
     * @param role Role参数
     * @return void
     */
    @Override
    public int save(Role role ) {
        return  this.roleMapper.insert(role );
    }

    /**
     * RoleService.saveSelective
     * Description: 保存Role, 只插入Role的非空字段
     *
     * @param role Role参数
     * @return void
     */
    public int saveSelective(Role role ) {
        return this.roleMapper.insertSelective( role );
    }

    /**
     * RoleService.select
     * Description: 根据查询条件类，返回Role结果集
     *
     * @param condition Role参数，查询条件
     * @return List<Role> Role结果集 [不分页]
     */
    @Override
    public List<Role> select(Role condition ) {
        Example example = buildExample(condition);
        return this.roleMapper.selectByExample(example);
    }

    /**
     * RoleService.select
     * Description: 根据查询条件类，返回Role结果集 [分页]
     *
     * @param condition Role参数，查询条件
     * @param pageable Pageable参数，分页条件
     * @return Page<Role> Role结果集
     */
    @Override
    public Page<Role> selectPage(Role condition, Pageable pageable) {
        Example example = buildExample(condition);
        RowBounds rowBounds = new RowBounds( (int)(pageable.getOffset()), (int)(pageable.getLimit()));
        long totalCount = roleMapper.countByExample(example);
        List<Role> data = roleMapper.selectByExample(example, rowBounds);
        Page<Role> page = new PageImpl(data,pageable,totalCount);
        return page;
    }

    /**
     * RoleService.selectByPrimaryKey
     * Description: 根据主键，返回Role
     *
     * @param id 主键
     * @return Role参数
     */
    @Override
    public Role selectByPrimaryKey(String id  ) {
        return roleMapper.selectByPrimaryKey(id );
    }


    /**
     * RoleService.update
     * Description: 修改Role, 根据查询条件修改
     *
     * @param update    Role参数需改的值
     * @param condition Role查询条件
     * @return void

     */
    @Override
    public int update(Role update, Role  condition ) {
        GeneratedExample example = buildExample(condition);
        return this.roleMapper.updateByExample(update, example);
    }

    /**
     * RoleService.updateSelective
     * Description: 修改Role, 根据查询条件修改
     *
     * @param update    Role参数需改的值
     * @param condition Role查询条件
     * @return void
     */
    @Override
    public int updateSelective(Role update, Role  condition ) {
        GeneratedExample example = buildExample(condition);
        return this.roleMapper.updateByExampleSelective(update, example);
    }

    /**
     * RoleService.updateByPrimaryKey
     * Description: 修改Role, 根据主键修改
     *
     * @param role Role参数
     * @return void
     */
    @Override
    public int updateByPrimaryKey(Role role ) {
        return this.roleMapper.updateByPrimaryKey(role );
    }

    /**
     * RoleService.updateByPrimaryKeySelective
     * Description: 修改Role, 根据主键修改，只修改非空参数字段
     *
     * @param role Role参数
     * @return void
     */
    @Override
    public int updateByPrimaryKeySelective(Role role ) {
        return this.roleMapper.updateByPrimaryKeySelective(role );
    }


    public Example buildExample(Role condition){
        Example example = new Example();
        Example.Criteria criteria = example.createCriteria();
        if (condition.getId() != null) {
            criteria.andEqualTo( "Role.id",condition.getId() );
        }
        if (condition.getName() != null) {
            criteria.andEqualTo( "Role.name",condition.getName() );
        }
        if (condition.getRoleType() != null) {
            criteria.andEqualTo( "Role.roleType",condition.getRoleType() );
        }
        if (condition.getDepartId() != null) {
            criteria.andEqualTo( "Role.departId",condition.getDepartId() );
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
        if (condition.getRemark() != null) {
            criteria.andEqualTo( "remark",condition.getRemark() );
        }
        if (condition.getEnable() != null) {
            criteria.andEqualTo( "enable",condition.getEnable() );
        }
        if (condition.getState() != null) {
            criteria.andEqualTo( "state",condition.getState() );
        }
        return example;
    }
}



