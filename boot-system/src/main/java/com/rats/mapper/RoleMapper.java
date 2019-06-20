package com.rats.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.rats.entity.Role;

/** Copyright (C) 2013 rats
 *
 * RoleMapper
 * Description: 表对应的操作Mapper映射类
 *
 * @version : v1.0
 * @author : Lu generator
 * @since : 
 */
public interface RoleMapper {

    /**
     * Description: 根据查询条件，获取t_sys_role记录总数
     *
     * @param example 查询条件
     * @return long 结果个数
     */
    long countByExample(GeneratedExample example);

    /**
     * Description: 根据查询条件，删除t_sys_role中记录
     *
     * @param example 通用查询条件类
     * @return int 删除个数
     */
    int deleteByExample(GeneratedExample example);

    /**
     * Description: 根据主键删除t_sys_role中记录
     *
     * @param id 主键
     * @return int  删除个数
     */
    int deleteByPrimaryKey(String id );

    /**
     * Description: 插入一个记录到t_sys_role
     *
     * @param record 插入的bean对象
     * @return int  插入个数
     */
    int insert(Role record);

    /**
     * Description: 插入一个记录到t_sys_role：忽略null字段
     *
     * @param record 插入的bean对象
     * @return int  插入个数
     */
    int insertSelective(Role record);

    /**
     * Description: 根据查询条件，返回t_sys_role结果集
     *
     * @param example 查询条件
     * @return List<Role>t_sys_role结果集
     */
    List<Role> selectByExample(GeneratedExample example);

    /**
     * RoleMapper.selectByPrimaryKey
     * Description: 根据主键类，返回t_sys_role
     *
     * @param id 主键
     * @return Role t_sys_role对象
     */
    Role selectByPrimaryKey(String id );

    /**
     * RoleMapper.updateByExampleSelective
     * Description: 根据查询条件更新t_sys_role表记录的部分字段
     *
     * @param record 要更新成为的Role对象
     * @param example 更新记录的查询条件
     * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") Role record, @Param("example") GeneratedExample example);

    /**
     * RoleMapper.updateByExample
     * Description: 根据查询条件更新t_sys_role表记录全部字段
     *
     * @param record 要更新成为的Role对象
     * @param example 更新记录的查询条件
     * @return int 更新记录数
     */
    int updateByExample(@Param("record") Role record, @Param("example") GeneratedExample example);

    /**
     * RoleMapper.updateByPrimaryKeySelective
     * Description: 根据主键更新t_sys_role部分字段
     *
     * @param record 要更新成为的Role对象
     * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * RoleMapper.updateByPrimaryKey
     * Description: 根据主键更新t_sys_role全部字段
     *
     * @param record 要更新成为的Role对象
     * @return int 更新记录数
     */
    int updateByPrimaryKey(Role record);

    /**
     * Description: 根据查询条件，返回t_sys_role结果集，[分页查询]
     *
     * @param example 查询条件
     * @param rowBounds mybatis分页条件
     * @return List<Role>t_sys_role结果集
     */
    List<Role> selectByExample(GeneratedExample example, RowBounds rowBounds);

}