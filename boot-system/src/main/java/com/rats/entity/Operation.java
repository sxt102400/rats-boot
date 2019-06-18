package com.rats.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;


/** Copyright (C) 2013 rats
 *
 * Operation
 * Description: 
 *
 * @version : v1.0
 * @author : Lu generator
 * @since : 
 */
@Table(name="t_sys_operation")
@Entity
public class Operation implements Serializable {
    /**
     * Field serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Field id : ID
     */
    @Column(name="id")
    private Integer id;

    /**
     * Field parentId : 父级ID
     */
    @Column(name="parent_id")
    private Integer parentId;

    /**
     * Field parentIds : 所有父级ID
     */
    @Column(name="parent_ids")
    private String parentIds;

    /**
     * Field name : 名称
     */
    @Column(name="name")
    private String name;

    /**
     * Field code : 名称
     */
    @Column(name="code")
    private String code;

    /**
     * Field state : 状态
     */
    @Column(name="state")
    private String state;

    public Operation(){}

    public void setId( Integer id ) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setParentId( Integer parentId ) {
        this.parentId = parentId;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentIds( String parentIds ) {
        this.parentIds = parentIds;
    }

    public String getParentIds() {
        return this.parentIds;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCode( String code ) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setState( String state ) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }


}

