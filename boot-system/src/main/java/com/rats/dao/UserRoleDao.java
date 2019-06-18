package com.rats.dao;


import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.rats.framework.common.persistence.Example;
import com.rats.entity.UserRole;
import com.rats.mapper.UserRoleMapper;

/** Copyright (C) 2013 rats
 *
 * UserRoleDao
 * Description: t_sys_user_role表对应dao操作接口实现类
 *
 * @version : v1.0
 * @author : Lu generator
 * @since :
 */
@Repository
public class UserRoleDao{
    /**
     * Field LOGGER : 日志操作类
     */
    private static final Logger logger = LoggerFactory.getLogger(UserRoleDao.class);

    /**
     * Field userRoleMapper : UserRole表的Mybatis Mapper操作映射类
     */
    @Resource
    private UserRoleMapper userRoleMapper;

    /**
     * UserRoleDao.countByExample
     * Description: 根据查询条件，计算t_sys_user_role个数
     *
     * @param example 通用查询条件类
     * @return int 结果个数
     */
    public long countByExample(Example example) {
        long count = this.userRoleMapper.countByExample(example);
        return count;
    }

    /**
     * UserRoleDao.deleteByExample
     * Description: 根据查询条件，删除t_sys_user_role
     *
     * @param example 通用查询条件类
     * @return int  删除个数
     */
    public int deleteByExample(Example example) {
        return this.userRoleMapper.deleteByExample(example);
    }

    /**
     * UserRoleDao.deleteByPrimaryKey
     * Description: 根据属性名称，删除t_sys_user_role
     *
     * @param id 主键
     * @return int  删除个数
     */
    public int deleteByPrimaryKey(Integer id ) {
        return this.userRoleMapper.deleteByPrimaryKey(id);
    }

    /**
     * UserRoleDao.insert
     * Description: 插入一个t_sys_user_role
     *
     * @param record t_sys_user_role的bean对象
     * @return int  插入个数
     */
    public int insert(UserRole record) {
        return this.userRoleMapper.insert(record);
    }

    /**
     * UserRoleDao.insertSelective
     * Description: 插入一个只有部分字段的t_sys_user_role
     *
     * @param record 只含部分字段的t_sys_user_role的bean对象
     * @return int  插入个数
     */
    public int insertSelective(UserRole record) {
        return this.userRoleMapper.insertSelective(record);
    }

    /**
     * UserRoleDao.selectAllByExample
     * Description: 根据查询条件类，返回t_sys_user_role结果集
     *
     * @param example 通用查询条件类
     * @return List<UserRole>t_sys_user_role结果集
     */
    public List<UserRole> selectByExample(Example example) {
        return this.userRoleMapper.selectByExample(example);
    }

    /**
     * UserRoleDao.selectByExample
     * Description: 根据查询条件类，返回t_sys_user_role结果集[分页]
     *
     * @param example 通用查询条件类
     * @param rowBounds mybatis分页参数
     * @return List<UserRole>t_sys_user_role结果集[分页]
     */
    public List<UserRole> selectByExample(Example example, RowBounds rowBounds) {
        return this.userRoleMapper.selectByExample(example, rowBounds);
    }

    /**
     * UserRoleDao.selectByPrimaryKey
     * Description: 根据主键类，返回t_sys_user_role
     *
     * @param id 主键
     * @return UserRole bean对象
     */
    public UserRole selectByPrimaryKey(Integer id ) {
        return this.userRoleMapper.selectByPrimaryKey(id);
    }


    /**
     * UserRoleDao.updateByExample
     * Description: 根据查询条件更新t_sys_user_role全表字段
     *
     * @param record 要更新的UserRole对象
     * @param example 更新记录的查询条件
     * @return int 更新记录数
     */
    public int updateByExample(UserRole record, Example example) {
        return this.userRoleMapper.updateByExample(record, example);
    }

    /**
     * UserRoleDao.updateByExampleSelective
     * Description: 根据查询条件更新t_sys_user_role部分字段
     *
     * @param record 要更新的UserRole对象
     * @param example 更新记录的查询条件
     * @return int 更新记录数
     */
    public int updateByExampleSelective(UserRole record, Example example) {
        return this.userRoleMapper.updateByExampleSelective(record, example);
    }

    /**
     * UserRoleDao.updateByPrimaryKeySelective
     * Description: 根据主键更新t_sys_user_role部分字段
     *
     * @param record 要更新成为的UserRole对象
     * @return int 更新记录数
     */
    public int updateByPrimaryKeySelective(UserRole record) {
        return this.userRoleMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * UserRoleDao.updateByPrimaryKey
     * Description: 根据主键更新t_sys_user_role全部字段
     *
     * @param record 要更新成为的UserRole对象
     * @return int 更新记录数
     */
    public int updateByPrimaryKey(UserRole record) {
        return this.userRoleMapper.updateByPrimaryKey(record);
    }

}