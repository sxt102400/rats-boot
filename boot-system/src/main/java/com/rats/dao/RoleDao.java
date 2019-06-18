package com.rats.dao;


import java.util.List;
import javax.annotation.Resource;

import com.rats.framework.common.persistence.GeneratedExample;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.rats.entity.Role;
import com.rats.mapper.RoleMapper;

/** Copyright (C) 2013 rats
 *
 * RoleDao
 * Description: t_sys_role表对应dao操作接口实现类
 *
 * @version : v1.0
 * @author : Lu generator
 * @since :
 */
@Repository
public class RoleDao{
    /**
     * Field LOGGER : 日志操作类
     */
    private static final Logger logger = LoggerFactory.getLogger(RoleDao.class);

    /**
     * Field roleMapper : Role表的Mybatis Mapper操作映射类
     */
    @Resource
    private RoleMapper roleMapper;

    /**
     * RoleDao.countByExample
     * Description: 根据查询条件，计算t_sys_role个数
     *
     * @param example 通用查询条件类
     * @return int 结果个数
     */
    public long countByExample(GeneratedExample example) {
        long count = this.roleMapper.countByExample(example);
        return count;
    }

    /**
     * RoleDao.deleteByExample
     * Description: 根据查询条件，删除t_sys_role
     *
     * @param example 通用查询条件类
     * @return int  删除个数
     */
    public int deleteByExample(GeneratedExample example) {
        return this.roleMapper.deleteByExample(example);
    }

    /**
     * RoleDao.deleteByPrimaryKey
     * Description: 根据属性名称，删除t_sys_role
     *
     * @param id 主键
     * @return int  删除个数
     */
    public int deleteByPrimaryKey(String id ) {
        return this.roleMapper.deleteByPrimaryKey(id);
    }

    /**
     * RoleDao.insert
     * Description: 插入一个t_sys_role
     *
     * @param record t_sys_role的bean对象
     * @return int  插入个数
     */
    public int insert(Role record) {
        return this.roleMapper.insert(record);
    }

    /**
     * RoleDao.insertSelective
     * Description: 插入一个只有部分字段的t_sys_role
     *
     * @param record 只含部分字段的t_sys_role的bean对象
     * @return int  插入个数
     */
    public int insertSelective(Role record) {
        return this.roleMapper.insertSelective(record);
    }

    /**
     * RoleDao.selectAllByExample
     * Description: 根据查询条件类，返回t_sys_role结果集
     *
     * @param example 通用查询条件类
     * @return List<Role>t_sys_role结果集
     */
    public List<Role> selectByExample(GeneratedExample example) {
        return this.roleMapper.selectByExample(example);
    }

    /**
     * RoleDao.selectByExample
     * Description: 根据查询条件类，返回t_sys_role结果集[分页]
     *
     * @param example 通用查询条件类
     * @param rowBounds mybatis分页参数
     * @return List<Role>t_sys_role结果集[分页]
     */
    public List<Role> selectByExample(GeneratedExample example, RowBounds rowBounds) {
        return this.roleMapper.selectByExample(example, rowBounds);
    }

    /**
     * RoleDao.selectByPrimaryKey
     * Description: 根据主键类，返回t_sys_role
     *
     * @param id 主键
     * @return Role bean对象
     */
    public Role selectByPrimaryKey(String id ) {
        return this.roleMapper.selectByPrimaryKey(id);
    }


    /**
     * RoleDao.updateByExample
     * Description: 根据查询条件更新t_sys_role全表字段
     *
     * @param record 要更新的Role对象
     * @param example 更新记录的查询条件
     * @return int 更新记录数
     */
    public int updateByExample(Role record, GeneratedExample example) {
        return this.roleMapper.updateByExample(record, example);
    }

    /**
     * RoleDao.updateByExampleSelective
     * Description: 根据查询条件更新t_sys_role部分字段
     *
     * @param record 要更新的Role对象
     * @param example 更新记录的查询条件
     * @return int 更新记录数
     */
    public int updateByExampleSelective(Role record, GeneratedExample example) {
        return this.roleMapper.updateByExampleSelective(record, example);
    }

    /**
     * RoleDao.updateByPrimaryKeySelective
     * Description: 根据主键更新t_sys_role部分字段
     *
     * @param record 要更新成为的Role对象
     * @return int 更新记录数
     */
    public int updateByPrimaryKeySelective(Role record) {
        return this.roleMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * RoleDao.updateByPrimaryKey
     * Description: 根据主键更新t_sys_role全部字段
     *
     * @param record 要更新成为的Role对象
     * @return int 更新记录数
     */
    public int updateByPrimaryKey(Role record) {
        return this.roleMapper.updateByPrimaryKey(record);
    }

}