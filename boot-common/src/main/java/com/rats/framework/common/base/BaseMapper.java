package com.rats.framework.common.base;


import com.rats.framework.common.page.Pageable;
import com.rats.framework.common.data.Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author hanbing
 * @since 1.0.0
 * @date 2019-06-20
 */
public interface BaseMapper<T,ID>  {

    /**
     * MenuMapper.countByExample
     * Description: 根据查询条件，计算icy_menu记录总数
     *
     * @param example 通用查询条件类
     * @return int 结果个数
     */
    long countByExample(Example example);

    /**
     * MenuMapper.countByExample
     * Description: 根据查询条件，计算icy_menu记录总数
     *
     * @param id 通用查询条件类
     * @return int 结果个数
     */
    long countByPrimaryKey(ID id);

    /**
     * MenuMapper.deleteByExample
     * Description: 根据查询条件，删除icy_menu中记录
     *
     * @param example 通用查询条件类
     * @return int 删除个数
     */
    int deleteByExample(Example example);

    /**
     * MenuMapper.deleteByPrimaryKey
     * Description: 根据主键删除icy_menu中记录
     *
     * @param id 主键
     * @return int  删除个数
     */
    int deleteByPrimaryKey(ID id);

    /**
     * MenuMapper.insert
     * Description: 插入一个记录到icy_menu
     *
     * @param record icy_menu的bean对象
     * @return int  插入个数
     */
    int insert(T record);

    /**
     * MenuMapper.insertSelective
     * Description: 插入一个只有部分字段的记录到icy_menu
     *
     * @param record 只含部分字段的icy_menu的bean对象
     * @return int  插入个数
     */
    int insertSelective(T record);

    /**
     * MenuMapper.selectByExample
     * Description: 根据查询条件类，返回icy_menu结果集
     *
     * @param example 通用查询条件类
     * @return List<Menu>icy_menu结果集
     */
    <S extends T>  List<S> selectByExample(Example example);

    /**
     * MenuMapper.selectByExample
     * Description: 根据查询条件类，返回icy_menu结果集[分页查询]
     *
     * @param example 通用查询条件类
     * @param pageable mybatis分页条件
     * @return List<Menu>icy_menu结果集
     */
    List<T> selectByExample(Example example, Pageable pageable);

    /**
     * MenuMapper.selectByPrimaryKey
     * Description: 根据主键类，返回icy_menu
     *
     * @param id 主键
     * @return Menu icy_menu对象
     */
    T selectByPrimaryKey(ID id);

    /**
     * MenuMapper.updateByExampleSelective
     * Description: 根据查询条件更新icy_menu表记录的部分字段
     *
     * @param record 要更新成为的Menu对象
     * @param example 更新记录的查询条件
     * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") T record, @Param("example") Example example);

    /**
     * MenuMapper.updateByExample
     * Description: 根据查询条件更新icy_menu表记录全部字段
     *
     * @param record 要更新成为的Menu对象
     * @param example 更新记录的查询条件
     * @return int 更新记录数
     */
    int updateByExample(@Param("record") T record, @Param("example") Example example);

    /**
     * MenuMapper.updateByPrimaryKeySelective
     * Description: 根据主键更新icy_menu部分字段
     *
     * @param record 要更新成为的Menu对象
     * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * MenuMapper.updateByPrimaryKey
     * Description: 根据主键更新icy_menu全部字段
     *
     * @param record 要更新成为的Menu对象
     * @return int 更新记录数
     */
    int updateByPrimaryKey(T record);
}
