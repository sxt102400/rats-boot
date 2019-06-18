package com.rats.dao;


import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.rats.framework.common.persistence.Example;
import com.rats.entity.User;
import com.rats.mapper.UserMapper;

/** Copyright (C) 2013 rats
 *
 * UserDao
 * Description: t_sys_user表对应dao操作接口实现类
 *
 * @version : v1.0
 * @author : Lu generator
 * @since :
 */
@Repository
public class UserDao{
    /**
     * Field LOGGER : 日志操作类
     */
    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    /**
     * Field userMapper : User表的Mybatis Mapper操作映射类
     */
    @Resource
    private UserMapper userMapper;

    /**
     * UserDao.countByExample
     * Description: 根据查询条件，计算t_sys_user个数
     *
     * @param example 通用查询条件类
     * @return int 结果个数
     */
    public long countByExample(Example example) {
        long count = this.userMapper.countByExample(example);
        return count;
    }

    /**
     * UserDao.deleteByExample
     * Description: 根据查询条件，删除t_sys_user
     *
     * @param example 通用查询条件类
     * @return int  删除个数
     */
    public int deleteByExample(Example example) {
        return this.userMapper.deleteByExample(example);
    }

    /**
     * UserDao.deleteByPrimaryKey
     * Description: 根据属性名称，删除t_sys_user
     *
     * @param id 主键
     * @return int  删除个数
     */
    public int deleteByPrimaryKey(String id ) {
        return this.userMapper.deleteByPrimaryKey(id);
    }

    /**
     * UserDao.insert
     * Description: 插入一个t_sys_user
     *
     * @param record t_sys_user的bean对象
     * @return int  插入个数
     */
    public int insert(User record) {
        return this.userMapper.insert(record);
    }

    /**
     * UserDao.insertSelective
     * Description: 插入一个只有部分字段的t_sys_user
     *
     * @param record 只含部分字段的t_sys_user的bean对象
     * @return int  插入个数
     */
    public int insertSelective(User record) {
        return this.userMapper.insertSelective(record);
    }

    /**
     * UserDao.selectAllByExample
     * Description: 根据查询条件类，返回t_sys_user结果集
     *
     * @param example 通用查询条件类
     * @return List<User>t_sys_user结果集
     */
    public List<User> selectByExample(Example example) {
        return this.userMapper.selectByExample(example);
    }

    /**
     * UserDao.selectByExample
     * Description: 根据查询条件类，返回t_sys_user结果集[分页]
     *
     * @param example 通用查询条件类
     * @param rowBounds mybatis分页参数
     * @return List<User>t_sys_user结果集[分页]
     */
    public List<User> selectByExample(Example example, RowBounds rowBounds) {
        return this.userMapper.selectByExample(example, rowBounds);
    }

    /**
     * UserDao.selectByPrimaryKey
     * Description: 根据主键类，返回t_sys_user
     *
     * @param id 主键
     * @return User bean对象
     */
    public User selectByPrimaryKey(String id ) {
        return this.userMapper.selectByPrimaryKey(id);
    }


    /**
     * UserDao.updateByExample
     * Description: 根据查询条件更新t_sys_user全表字段
     *
     * @param record 要更新的User对象
     * @param example 更新记录的查询条件
     * @return int 更新记录数
     */
    public int updateByExample(User record, Example example) {
        return this.userMapper.updateByExample(record, example);
    }

    /**
     * UserDao.updateByExampleSelective
     * Description: 根据查询条件更新t_sys_user部分字段
     *
     * @param record 要更新的User对象
     * @param example 更新记录的查询条件
     * @return int 更新记录数
     */
    public int updateByExampleSelective(User record, Example example) {
        return this.userMapper.updateByExampleSelective(record, example);
    }

    /**
     * UserDao.updateByPrimaryKeySelective
     * Description: 根据主键更新t_sys_user部分字段
     *
     * @param record 要更新成为的User对象
     * @return int 更新记录数
     */
    public int updateByPrimaryKeySelective(User record) {
        return this.userMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * UserDao.updateByPrimaryKey
     * Description: 根据主键更新t_sys_user全部字段
     *
     * @param record 要更新成为的User对象
     * @return int 更新记录数
     */
    public int updateByPrimaryKey(User record) {
        return this.userMapper.updateByPrimaryKey(record);
    }

}