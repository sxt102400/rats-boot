package com.rats.mapper;


import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.rats.framework.common.persistence.Example;
import com.rats.entity.Operation;

/** Copyright (C) 2013 rats
 *
 * OperationMapper
 * Description: 表对应的操作Mapper映射类
 *
 * @version : v1.0
 * @author : Lu generator
 * @since : 
 */
public interface OperationMapper {

    /**
     * Description: 根据查询条件，获取t_sys_operation记录总数
     *
     * @param example 查询条件
     * @return long 结果个数
     */
    long countByExample(Example example);

    /**
     * Description: 根据查询条件，删除t_sys_operation中记录
     *
     * @param example 通用查询条件类
     * @return int 删除个数
     */
    int deleteByExample(Example example);

    /**
     * Description: 根据主键删除t_sys_operation中记录
     *
     * @param id 主键
     * @return int  删除个数
     */
    int deleteByPrimaryKey(Integer id );

    /**
     * Description: 插入一个记录到t_sys_operation
     *
     * @param record 插入的bean对象
     * @return int  插入个数
     */
    int insert(Operation record);

    /**
     * Description: 插入一个记录到t_sys_operation：忽略null字段
     *
     * @param record 插入的bean对象
     * @return int  插入个数
     */
    int insertSelective(Operation record);

    /**
     * Description: 根据查询条件，返回t_sys_operation结果集
     *
     * @param example 查询条件
     * @return List<Operation>t_sys_operation结果集
     */
    List<Operation> selectByExample(Example example);

    /**
     * OperationMapper.selectByPrimaryKey
     * Description: 根据主键类，返回t_sys_operation
     *
     * @param id 主键
     * @return Operation t_sys_operation对象
     */
    Operation selectByPrimaryKey(Integer id );

    /**
     * OperationMapper.updateByExampleSelective
     * Description: 根据查询条件更新t_sys_operation表记录的部分字段
     *
     * @param record 要更新成为的Operation对象
     * @param example 更新记录的查询条件
     * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") Operation record, @Param("example") Example example);

    /**
     * OperationMapper.updateByExample
     * Description: 根据查询条件更新t_sys_operation表记录全部字段
     *
     * @param record 要更新成为的Operation对象
     * @param example 更新记录的查询条件
     * @return int 更新记录数
     */
    int updateByExample(@Param("record") Operation record, @Param("example") Example example);

    /**
     * OperationMapper.updateByPrimaryKeySelective
     * Description: 根据主键更新t_sys_operation部分字段
     *
     * @param record 要更新成为的Operation对象
     * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(Operation record);

    /**
     * OperationMapper.updateByPrimaryKey
     * Description: 根据主键更新t_sys_operation全部字段
     *
     * @param record 要更新成为的Operation对象
     * @return int 更新记录数
     */
    int updateByPrimaryKey(Operation record);

    /**
     * Description: 根据查询条件，返回t_sys_operation结果集，[分页查询]
     *
     * @param example 查询条件
     * @param rowBounds mybatis分页条件
     * @return List<Operation>t_sys_operation结果集
     */
    List<Operation> selectByExample(Example example,RowBounds rowBounds);

}