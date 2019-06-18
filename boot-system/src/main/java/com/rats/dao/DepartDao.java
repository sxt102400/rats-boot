package com.rats.dao;


import java.util.List;
import javax.annotation.Resource;

import com.rats.framework.common.page.Pageable;
import com.rats.framework.common.persistence.GeneratedExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.rats.entity.Depart;
import com.rats.mapper.DepartMapper;

/** Copyright (C) 2013 rats
 *
 * DepartDao
 * Description: t_sys_depart表对应dao操作接口实现类
 *
 * @version : v1.0
 * @author : Lu generator
 * @since :
 */
@Repository
public class DepartDao{
    /**
     * Field LOGGER : 日志操作类
     */
    private static final Logger logger = LoggerFactory.getLogger(DepartDao.class);

    /**
     * Field departMapper : Depart表的Mybatis Mapper操作映射类
     */
    @Resource
    private DepartMapper departMapper;

    /**
     * DepartDao.countByExample
     * Description: 根据查询条件，计算t_sys_depart个数
     *
     * @param example 通用查询条件类
     * @return int 结果个数
     */
    public long countByExample(GeneratedExample example) {
        long count = this.departMapper.countByExample(example);
        return count;
    }

    /**
     * DepartDao.deleteByExample
     * Description: 根据查询条件，删除t_sys_depart
     *
     * @param example 通用查询条件类
     * @return int  删除个数
     */
    public int deleteByExample(GeneratedExample example) {
        return this.departMapper.deleteByExample(example);
    }

    /**
     * DepartDao.deleteByPrimaryKey
     * Description: 根据属性名称，删除t_sys_depart
     *
     * @param id 主键
     * @return int  删除个数
     */
    public int deleteByPrimaryKey(Integer id ) {
        return this.departMapper.deleteByPrimaryKey(id);
    }

    /**
     * DepartDao.insert
     * Description: 插入一个t_sys_depart
     *
     * @param record t_sys_depart的bean对象
     * @return int  插入个数
     */
    public int insert(Depart record) {
        return this.departMapper.insert(record);
    }

    /**
     * DepartDao.insertSelective
     * Description: 插入一个只有部分字段的t_sys_depart
     *
     * @param record 只含部分字段的t_sys_depart的bean对象
     * @return int  插入个数
     */
    public int insertSelective(Depart record) {
        return this.departMapper.insertSelective(record);
    }

    /**
     * DepartDao.selectAllByExample
     * Description: 根据查询条件类，返回t_sys_depart结果集
     *
     * @param example 通用查询条件类
     * @return List<Depart>t_sys_depart结果集
     */
    public List<Depart> selectByExample(GeneratedExample example) {
        return this.departMapper.selectByExample(example);
    }

    /**
     * DepartDao.selectByExample
     * Description: 根据查询条件类，返回t_sys_depart结果集[分页]
     *
     * @param example 通用查询条件类
     * @param pageable mybatis分页参数
     * @return List<Depart>t_sys_depart结果集[分页]
     */
    public List<Depart> selectByExample(GeneratedExample example, Pageable pageable) {
        return this.departMapper.selectByExample(example, pageable);
    }

    /**
     * DepartDao.selectByPrimaryKey
     * Description: 根据主键类，返回t_sys_depart
     *
     * @param id 主键
     * @return Depart bean对象
     */
    public Depart selectByPrimaryKey(Integer id ) {
        return this.departMapper.selectByPrimaryKey(id);
    }


    /**
     * DepartDao.updateByExample
     * Description: 根据查询条件更新t_sys_depart全表字段
     *
     * @param record 要更新的Depart对象
     * @param example 更新记录的查询条件
     * @return int 更新记录数
     */
    public int updateByExample(Depart record, GeneratedExample example) {
        return this.departMapper.updateByExample(record, example);
    }

    /**
     * DepartDao.updateByExampleSelective
     * Description: 根据查询条件更新t_sys_depart部分字段
     *
     * @param record 要更新的Depart对象
     * @param example 更新记录的查询条件
     * @return int 更新记录数
     */
    public int updateByExampleSelective(Depart record, GeneratedExample example) {
        return this.departMapper.updateByExampleSelective(record, example);
    }

    /**
     * DepartDao.updateByPrimaryKeySelective
     * Description: 根据主键更新t_sys_depart部分字段
     *
     * @param record 要更新成为的Depart对象
     * @return int 更新记录数
     */
    public int updateByPrimaryKeySelective(Depart record) {
        return this.departMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * DepartDao.updateByPrimaryKey
     * Description: 根据主键更新t_sys_depart全部字段
     *
     * @param record 要更新成为的Depart对象
     * @return int 更新记录数
     */
    public int updateByPrimaryKey(Depart record) {
        return this.departMapper.updateByPrimaryKey(record);
    }

}