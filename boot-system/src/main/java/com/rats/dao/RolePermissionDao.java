package com.rats.dao;


import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.rats.framework.common.persistence.Example;
import com.rats.entity.RolePermission;
import com.rats.mapper.RolePermissionMapper;

/** Copyright (C) 2013 rats
 *
 * RolePermissionDao
 * Description: t_sys_role_permission表对应dao操作接口实现类
 *
 * @version : v1.0
 * @author : Lu generator
 * @since :
 */
@Repository
public class RolePermissionDao{
    /**
     * Field LOGGER : 日志操作类
     */
    private static final Logger logger = LoggerFactory.getLogger(RolePermissionDao.class);

    /**
     * Field rolePermissionMapper : RolePermission表的Mybatis Mapper操作映射类
     */
    @Resource
    private RolePermissionMapper rolePermissionMapper;

    /**
     * RolePermissionDao.countByExample
     * Description: 根据查询条件，计算t_sys_role_permission个数
     *
     * @param example 通用查询条件类
     * @return int 结果个数
     */
    public long countByExample(Example example) {
        long count = this.rolePermissionMapper.countByExample(example);
        return count;
    }

    /**
     * RolePermissionDao.deleteByExample
     * Description: 根据查询条件，删除t_sys_role_permission
     *
     * @param example 通用查询条件类
     * @return int  删除个数
     */
    public int deleteByExample(Example example) {
        return this.rolePermissionMapper.deleteByExample(example);
    }

    /**
     * RolePermissionDao.deleteByPrimaryKey
     * Description: 根据属性名称，删除t_sys_role_permission
     *
     * @param id 主键
     * @return int  删除个数
     */
    public int deleteByPrimaryKey(Integer id ) {
        return this.rolePermissionMapper.deleteByPrimaryKey(id);
    }

    /**
     * RolePermissionDao.insert
     * Description: 插入一个t_sys_role_permission
     *
     * @param record t_sys_role_permission的bean对象
     * @return int  插入个数
     */
    public int insert(RolePermission record) {
        return this.rolePermissionMapper.insert(record);
    }

    /**
     * RolePermissionDao.insertSelective
     * Description: 插入一个只有部分字段的t_sys_role_permission
     *
     * @param record 只含部分字段的t_sys_role_permission的bean对象
     * @return int  插入个数
     */
    public int insertSelective(RolePermission record) {
        return this.rolePermissionMapper.insertSelective(record);
    }

    /**
     * RolePermissionDao.selectAllByExample
     * Description: 根据查询条件类，返回t_sys_role_permission结果集
     *
     * @param example 通用查询条件类
     * @return List<RolePermission>t_sys_role_permission结果集
     */
    public List<RolePermission> selectByExample(Example example) {
        return this.rolePermissionMapper.selectByExample(example);
    }

    /**
     * RolePermissionDao.selectByExample
     * Description: 根据查询条件类，返回t_sys_role_permission结果集[分页]
     *
     * @param example 通用查询条件类
     * @param rowBounds mybatis分页参数
     * @return List<RolePermission>t_sys_role_permission结果集[分页]
     */
    public List<RolePermission> selectByExample(Example example, RowBounds rowBounds) {
        return this.rolePermissionMapper.selectByExample(example, rowBounds);
    }

    /**
     * RolePermissionDao.selectByPrimaryKey
     * Description: 根据主键类，返回t_sys_role_permission
     *
     * @param id 主键
     * @return RolePermission bean对象
     */
    public RolePermission selectByPrimaryKey(Integer id ) {
        return this.rolePermissionMapper.selectByPrimaryKey(id);
    }


    /**
     * RolePermissionDao.updateByExample
     * Description: 根据查询条件更新t_sys_role_permission全表字段
     *
     * @param record 要更新的RolePermission对象
     * @param example 更新记录的查询条件
     * @return int 更新记录数
     */
    public int updateByExample(RolePermission record, Example example) {
        return this.rolePermissionMapper.updateByExample(record, example);
    }

    /**
     * RolePermissionDao.updateByExampleSelective
     * Description: 根据查询条件更新t_sys_role_permission部分字段
     *
     * @param record 要更新的RolePermission对象
     * @param example 更新记录的查询条件
     * @return int 更新记录数
     */
    public int updateByExampleSelective(RolePermission record, Example example) {
        return this.rolePermissionMapper.updateByExampleSelective(record, example);
    }

    /**
     * RolePermissionDao.updateByPrimaryKeySelective
     * Description: 根据主键更新t_sys_role_permission部分字段
     *
     * @param record 要更新成为的RolePermission对象
     * @return int 更新记录数
     */
    public int updateByPrimaryKeySelective(RolePermission record) {
        return this.rolePermissionMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * RolePermissionDao.updateByPrimaryKey
     * Description: 根据主键更新t_sys_role_permission全部字段
     *
     * @param record 要更新成为的RolePermission对象
     * @return int 更新记录数
     */
    public int updateByPrimaryKey(RolePermission record) {
        return this.rolePermissionMapper.updateByPrimaryKey(record);
    }

}