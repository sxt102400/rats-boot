package com.rats.mapper;


import java.util.List;

import com.rats.framework.common.persistence.GeneratedExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.rats.entity.User;

/** Copyright (C) 2013 rats
 *
 * UserMapper
 * Description: 表对应的操作Mapper映射类
 *
 * @version : v1.0
 * @author : Lu generator
 * @since : 
 */
public interface UserMapper {

    /**
     * Description: 根据查询条件，获取t_sys_user记录总数
     *
     * @param example 查询条件
     * @return long 结果个数
     */
    long countByExample(GeneratedExample example);

    /**
     * Description: 根据查询条件，删除t_sys_user中记录
     *
     * @param example 通用查询条件类
     * @return int 删除个数
     */
    int deleteByExample(GeneratedExample example);

    /**
     * Description: 根据主键删除t_sys_user中记录
     *
     * @param id 主键
     * @return int  删除个数
     */
    int deleteByPrimaryKey(String id );

    /**
     * Description: 插入一个记录到t_sys_user
     *
     * @param record 插入的bean对象
     * @return int  插入个数
     */
    int insert(User record);

    /**
     * Description: 插入一个记录到t_sys_user：忽略null字段
     *
     * @param record 插入的bean对象
     * @return int  插入个数
     */
    int insertSelective(User record);

    /**
     * Description: 根据查询条件，返回t_sys_user结果集
     *
     * @param example 查询条件
     * @return List<User>t_sys_user结果集
     */
    List<User> selectByExample(GeneratedExample example);

    /**
     * UserMapper.selectByPrimaryKey
     * Description: 根据主键类，返回t_sys_user
     *
     * @param id 主键
     * @return User t_sys_user对象
     */
    User selectByPrimaryKey(String id );

    /**
     * UserMapper.updateByExampleSelective
     * Description: 根据查询条件更新t_sys_user表记录的部分字段
     *
     * @param record 要更新成为的User对象
     * @param example 更新记录的查询条件
     * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") GeneratedExample example);

    /**
     * UserMapper.updateByExample
     * Description: 根据查询条件更新t_sys_user表记录全部字段
     *
     * @param record 要更新成为的User对象
     * @param example 更新记录的查询条件
     * @return int 更新记录数
     */
    int updateByExample(@Param("record") User record, @Param("example") GeneratedExample example);

    /**
     * UserMapper.updateByPrimaryKeySelective
     * Description: 根据主键更新t_sys_user部分字段
     *
     * @param record 要更新成为的User对象
     * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * UserMapper.updateByPrimaryKey
     * Description: 根据主键更新t_sys_user全部字段
     *
     * @param record 要更新成为的User对象
     * @return int 更新记录数
     */
    int updateByPrimaryKey(User record);

    /**
     * Description: 根据查询条件，返回t_sys_user结果集，[分页查询]
     *
     * @param example 查询条件
     * @param rowBounds mybatis分页条件
     * @return List<User>t_sys_user结果集
     */
    List<User> selectByExample(GeneratedExample example, RowBounds rowBounds);

}