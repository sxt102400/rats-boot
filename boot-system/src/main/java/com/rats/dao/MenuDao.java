package com.rats.dao;


import java.util.List;
import javax.annotation.Resource;

import com.rats.framework.common.page.Pageable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.rats.entity.Menu;
import com.rats.mapper.MenuMapper;

/** Copyright (C) 2013 rats
 *
 * MenuDao
 * Description: t_sys_menu表对应dao操作接口实现类
 *
 * @version : v1.0
 * @author : Lu generator
 * @since :
 */
@Repository
public class MenuDao{
    /**
     * Field LOGGER : 日志操作类
     */
    private static final Logger logger = LoggerFactory.getLogger(MenuDao.class);

    /**
     * Field menuMapper : Menu表的Mybatis Mapper操作映射类
     */
    @Resource
    private MenuMapper menuMapper;

    /**
     * MenuDao.countByExample
     * Description: 根据查询条件，计算t_sys_menu个数
     *
     * @param example 通用查询条件类
     * @return int 结果个数
     */
    public long countByExample(GeneratedExample example) {
        long count = this.menuMapper.countByExample(example);
        return count;
    }

    /**
     * MenuDao.deleteByExample
     * Description: 根据查询条件，删除t_sys_menu
     *
     * @param example 通用查询条件类
     * @return int  删除个数
     */
    public int deleteByExample(GeneratedExample example) {
        return this.menuMapper.deleteByExample(example);
    }

    /**
     * MenuDao.deleteByPrimaryKey
     * Description: 根据属性名称，删除t_sys_menu
     *
     * @param id 主键
     * @return int  删除个数
     */
    public int deleteByPrimaryKey(Integer id ) {
        return this.menuMapper.deleteByPrimaryKey(id);
    }

    /**
     * MenuDao.insert
     * Description: 插入一个t_sys_menu
     *
     * @param record t_sys_menu的bean对象
     * @return int  插入个数
     */
    public int insert(Menu record) {
        return this.menuMapper.insert(record);
    }

    /**
     * MenuDao.insertSelective
     * Description: 插入一个只有部分字段的t_sys_menu
     *
     * @param record 只含部分字段的t_sys_menu的bean对象
     * @return int  插入个数
     */
    public int insertSelective(Menu record) {
        return this.menuMapper.insertSelective(record);
    }

    /**
     * MenuDao.selectAllByExample
     * Description: 根据查询条件类，返回t_sys_menu结果集
     *
     * @param example 通用查询条件类
     * @return List<Menu>t_sys_menu结果集
     */
    public List<Menu> selectByExample(GeneratedExample example) {
        return this.menuMapper.selectByExample(example);
    }

    /**
     * MenuDao.selectByExample
     * Description: 根据查询条件类，返回t_sys_menu结果集[分页]
     *
     * @param example 通用查询条件类
     * @param pageable mybatis分页参数
     * @return List<Menu>t_sys_menu结果集[分页]
     */
    public List<Menu> selectByExample(GeneratedExample example, Pageable pageable) {
        return this.menuMapper.selectByExample(example, pageable);
    }

    /**
     * MenuDao.selectByPrimaryKey
     * Description: 根据主键类，返回t_sys_menu
     *
     * @param id 主键
     * @return Menu bean对象
     */
    public Menu selectByPrimaryKey(Integer id ) {
        return this.menuMapper.selectByPrimaryKey(id);
    }


    /**
     * MenuDao.updateByExample
     * Description: 根据查询条件更新t_sys_menu全表字段
     *
     * @param record 要更新的Menu对象
     * @param example 更新记录的查询条件
     * @return int 更新记录数
     */
    public int updateByExample(Menu record, GeneratedExample example) {
        return this.menuMapper.updateByExample(record, example);
    }

    /**
     * MenuDao.updateByExampleSelective
     * Description: 根据查询条件更新t_sys_menu部分字段
     *
     * @param record 要更新的Menu对象
     * @param example 更新记录的查询条件
     * @return int 更新记录数
     */
    public int updateByExampleSelective(Menu record, GeneratedExample example) {
        return this.menuMapper.updateByExampleSelective(record, example);
    }

    /**
     * MenuDao.updateByPrimaryKeySelective
     * Description: 根据主键更新t_sys_menu部分字段
     *
     * @param record 要更新成为的Menu对象
     * @return int 更新记录数
     */
    public int updateByPrimaryKeySelective(Menu record) {
        return this.menuMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * MenuDao.updateByPrimaryKey
     * Description: 根据主键更新t_sys_menu全部字段
     *
     * @param record 要更新成为的Menu对象
     * @return int 更新记录数
     */
    public int updateByPrimaryKey(Menu record) {
        return this.menuMapper.updateByPrimaryKey(record);
    }

}