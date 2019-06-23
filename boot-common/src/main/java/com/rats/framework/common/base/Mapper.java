package com.rats.framework.common.base;


import com.rats.framework.common.data.Example;
import com.rats.framework.common.page.Pageable;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * Mapper
 *
 * @author hanbing
 * @date 2019-06-18
 * @since 1.0.0
 */
public interface Mapper<T, ID extends Serializable> {

    /**
     * MenuMapper.countByExample
     *
     * @param example
     * @return int
     */
    long countByExample(Example example);

    /**
     * MenuMapper.deleteByExample
     *
     * @param example
     * @return int
     */
    int deleteByExample(Example example);

    /**
     * MenuMapper.deleteByPrimaryKey
     *
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(ID id);

    /**
     * MenuMapper.insert
     *
     * @param record
     * @return int
     */
    int insert(T record);

    /**
     * MenuMapper.insertSelective
     *
     * @param record
     * @return int
     */
    int insertSelective(T record);

    /**
     * MenuMapper.selectByExample
     *
     * @param example
     * @return List
     */
    List<T> selectByExample(Example example);


    /**
     * MenuMapper.selectByPrimaryKey
     *
     * @param id
     * @return Menu
     */
    T selectByPrimaryKey(ID id);

    /**
     * MenuMapper.updateByExampleSelective
     *
     * @param record
     * @param example
     * @return int
     */
    int updateByExampleSelective(@Param("record") T record, @Param("example") Example example);

    /**
     * MenuMapper.updateByExample
     *
     * @param record
     * @param example
     * @return int
     */
    int updateByExample(@Param("record") T record, @Param("example") Example example);

    /**
     * MenuMapper.updateByPrimaryKeySelective
     *
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * MenuMapper.updateByPrimaryKey
     *
     * @param record
     * @return int
     */
    int updateByPrimaryKey(T record);


    /**
     * MenuMapper.selectByExample
     *
     * @param example
     * @param pageable
     * @return List
     */
    List<T> selectByExample(Example example, Pageable pageable);
}