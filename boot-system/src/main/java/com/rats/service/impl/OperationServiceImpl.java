package com.rats.service.impl;


import java.util.List;
import javax.annotation.Resource;

import com.rats.framework.common.persistence.Example;
import com.rats.framework.common.persistence.GeneratedExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rats.entity.Operation;
import com.rats.mapper.OperationMapper;
import com.rats.service.OperationService;
import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.Pageable;
import com.rats.framework.common.page.PageImpl;

/** Copyright (C) 2013 rats
 *
 * OperationServiceImpl
 * Description: 
 *
 * @version : v1.0
 * @author : Lu generator
 * @since : 
 */
@Service(value = "operationService")
public class OperationServiceImpl implements OperationService {

    /**
     * Field LOGGER : 日志操作类
     */
    private static final Logger logger = LoggerFactory.getLogger(OperationService.class);

    /**
     * Field operationMapper : operationMapper
     */
    @Resource
    private OperationMapper operationMapper;

    /**
     * operationService.count
     * Description: 根据查询条件，计算Operation个数
     *
     * @param condition Operation参数
     * @return int 结果个数
     */
    @Override
    public long count(Operation condition ) {
        GeneratedExample example = buildExample(condition);
        return this.operationMapper.countByExample(example);
    }

    /**
     * operationService.delete
     * Description: 根据查询条件，删除operation
     *
     * @param condition Operation参数，查询条件
     * @return void
     */
    @Override
    public int delete(Operation condition ) {
        GeneratedExample example = buildExample(condition);
        return this.operationMapper.deleteByExample(example);
    }

    /**
     * OperationService.deleteByPrimaryKey
     * Description: 修改Operation
     *
     * @param id 主键
     * @return void
     */
    @Override
    public int deleteByPrimaryKey(Integer id ) {
        return this.operationMapper.deleteByPrimaryKey(id);
    }

    /**
     * OperationService.save
     * Description: 保存Operation,
     *
     * @param operation Operation参数
     * @return void
     */
    @Override
    public int save(Operation operation ) {
        return  this.operationMapper.insert(operation );
    }

    /**
     * OperationService.saveSelective
     * Description: 保存Operation, 只插入Operation的非空字段
     *
     * @param operation Operation参数
     * @return void
     */
    public int saveSelective(Operation operation ) {
        return this.operationMapper.insertSelective( operation );
    }

    /**
     * OperationService.select
     * Description: 根据查询条件类，返回Operation结果集
     *
     * @param condition Operation参数，查询条件
     * @return List<Operation> Operation结果集 [不分页]
     */
    @Override
    public List<Operation> select(Operation condition ) {
        GeneratedExample example = buildExample(condition);
        return this.operationMapper.selectByExample(example);
    }

    /**
     * OperationService.select
     * Description: 根据查询条件类，返回Operation结果集 [分页]
     *
     * @param condition Operation参数，查询条件
     * @param pageable Page参数，分页条件
     * @return Page<Operation> Operation结果集
     */
    @Override
    public Page<Operation> selectPage(Operation condition, Pageable pageable) {
        GeneratedExample example = buildExample(condition);
        List<Operation> data = operationMapper.selectByExample(example, pageable);
        Page<Operation> page = new PageImpl(data,pageable);
        return page;
    }

    /**
     * OperationService.selectByPrimaryKey
     * Description: 根据主键，返回Operation
     *
     * @param id 主键
     * @return Operation参数
     */
    @Override
    public Operation selectByPrimaryKey(Integer id  ) {
        return operationMapper.selectByPrimaryKey(id );
    }


    /**
     * OperationService.update
     * Description: 修改Operation, 根据查询条件修改
     *
     * @param update    Operation参数需改的值
     * @param condition Operation查询条件
     * @return void

     */
    @Override
    public int update(Operation update, Operation  condition ) {
        GeneratedExample example = buildExample(condition);
        return this.operationMapper.updateByExample(update, example);
    }

    /**
     * OperationService.updateSelective
     * Description: 修改Operation, 根据查询条件修改
     *
     * @param update    Operation参数需改的值
     * @param condition Operation查询条件
     * @return void
     */
    @Override
    public int updateSelective(Operation update, Operation  condition ) {
        GeneratedExample example = buildExample(condition);
        return this.operationMapper.updateByExampleSelective(update, example);
    }

    /**
     * OperationService.updateByPrimaryKey
     * Description: 修改Operation, 根据主键修改
     *
     * @param operation Operation参数
     * @return void
     */
    @Override
    public int updateByPrimaryKey(Operation operation ) {
        return this.operationMapper.updateByPrimaryKey(operation );
    }

    /**
     * OperationService.updateByPrimaryKeySelective
     * Description: 修改Operation, 根据主键修改，只修改非空参数字段
     *
     * @param operation Operation参数
     * @return void
     */
    @Override
    public int updateByPrimaryKeySelective(Operation operation ) {
        return this.operationMapper.updateByPrimaryKeySelective(operation );
    }


    public Example buildExample(Operation condition){
        Example example = new Example();
        Example.Criteria<Operation> criteria = example.createCriteria();
        if (condition.getId() != null) {
            criteria.andEqualTo( Operation::getId,condition.getId() );
        }
        if (condition.getParentId() != null) {
            criteria.andEqualTo( "parent_id",condition.getParentId() );
        }
        if (condition.getParentIds() != null) {
            criteria.andEqualTo( "parent_ids",condition.getParentIds() );
        }
        if (condition.getName() != null) {
            criteria.andEqualTo( "name",condition.getName() );
        }
        if (condition.getCode() != null) {
            criteria.andEqualTo( "code",condition.getCode() );
        }
        if (condition.getState() != null) {
            criteria.andEqualTo( "state",condition.getState() );
        }
        return example;
    }
}



