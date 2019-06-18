package com.rats.dao;


import java.util.List;
import javax.annotation.Resource;

import com.rats.framework.common.persistence.GeneratedExample;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.rats.entity.Operation;
import com.rats.mapper.OperationMapper;

/** Copyright (C) 2013 rats
 *
 * OperationDao
 * Description: t_sys_operation表对应dao操作接口实现类
 *
 * @version : v1.0
 * @author : Lu generator
 * @since :
 */
@Repository
public class OperationDao{
    /**
     * Field LOGGER : 日志操作类
     */
    private static final Logger logger = LoggerFactory.getLogger(OperationDao.class);

    /**
     * Field operationMapper : Operation表的Mybatis Mapper操作映射类
     */
    @Resource
    private OperationMapper operationMapper;

    /**
     * OperationDao.countByExample
     * Description: 根据查询条件，计算t_sys_operation个数
     *
     * @param example 通用查询条件类
     * @return int 结果个数
     */
    public long countByExample(GeneratedExample example) {
        long count = this.operationMapper.countByExample(example);
        return count;
    }

    /**
     * OperationDao.deleteByExample
     * Description: 根据查询条件，删除t_sys_operation
     *
     * @param example 通用查询条件类
     * @return int  删除个数
     */
    public int deleteByExample(GeneratedExample example) {
        return this.operationMapper.deleteByExample(example);
    }

    /**
     * OperationDao.deleteByPrimaryKey
     * Description: 根据属性名称，删除t_sys_operation
     *
     * @param id 主键
     * @return int  删除个数
     */
    public int deleteByPrimaryKey(Integer id ) {
        return this.operationMapper.deleteByPrimaryKey(id);
    }

    /**
     * OperationDao.insert
     * Description: 插入一个t_sys_operation
     *
     * @param record t_sys_operation的bean对象
     * @return int  插入个数
     */
    public int insert(Operation record) {
        return this.operationMapper.insert(record);
    }

    /**
     * OperationDao.insertSelective
     * Description: 插入一个只有部分字段的t_sys_operation
     *
     * @param record 只含部分字段的t_sys_operation的bean对象
     * @return int  插入个数
     */
    public int insertSelective(Operation record) {
        return this.operationMapper.insertSelective(record);
    }

    /**
     * OperationDao.selectAllByExample
     * Description: 根据查询条件类，返回t_sys_operation结果集
     *
     * @param example 通用查询条件类
     * @return List<Operation>t_sys_operation结果集
     */
    public List<Operation> selectByExample(GeneratedExample example) {
        return this.operationMapper.selectByExample(example);
    }

    /**
     * OperationDao.selectByExample
     * Description: 根据查询条件类，返回t_sys_operation结果集[分页]
     *
     * @param example 通用查询条件类
     * @param rowBounds mybatis分页参数
     * @return List<Operation>t_sys_operation结果集[分页]
     */
    public List<Operation> selectByExample(GeneratedExample example, RowBounds rowBounds) {
        return this.operationMapper.selectByExample(example, rowBounds);
    }

    /**
     * OperationDao.selectByPrimaryKey
     * Description: 根据主键类，返回t_sys_operation
     *
     * @param id 主键
     * @return Operation bean对象
     */
    public Operation selectByPrimaryKey(Integer id ) {
        return this.operationMapper.selectByPrimaryKey(id);
    }


    /**
     * OperationDao.updateByExample
     * Description: 根据查询条件更新t_sys_operation全表字段
     *
     * @param record 要更新的Operation对象
     * @param example 更新记录的查询条件
     * @return int 更新记录数
     */
    public int updateByExample(Operation record, GeneratedExample example) {
        return this.operationMapper.updateByExample(record, example);
    }

    /**
     * OperationDao.updateByExampleSelective
     * Description: 根据查询条件更新t_sys_operation部分字段
     *
     * @param record 要更新的Operation对象
     * @param example 更新记录的查询条件
     * @return int 更新记录数
     */
    public int updateByExampleSelective(Operation record, GeneratedExample example) {
        return this.operationMapper.updateByExampleSelective(record, example);
    }

    /**
     * OperationDao.updateByPrimaryKeySelective
     * Description: 根据主键更新t_sys_operation部分字段
     *
     * @param record 要更新成为的Operation对象
     * @return int 更新记录数
     */
    public int updateByPrimaryKeySelective(Operation record) {
        return this.operationMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * OperationDao.updateByPrimaryKey
     * Description: 根据主键更新t_sys_operation全部字段
     *
     * @param record 要更新成为的Operation对象
     * @return int 更新记录数
     */
    public int updateByPrimaryKey(Operation record) {
        return this.operationMapper.updateByPrimaryKey(record);
    }

}