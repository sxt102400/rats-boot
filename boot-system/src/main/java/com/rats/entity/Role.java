package com.rats.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;


/** Copyright (C) 2013 rats
 *
 * Role
 * Description: 
 *
 * @version : v1.0
 * @author : Lu generator
 * @since : 
 */
@Table(name="t_sys_role")
@Entity
public class Role implements Serializable {
    /**
     * Field serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Field id : 编号
     */
    @Column(name="id")
    private String id;

    /**
     * Field name : 角色名称
     */
    @Column(name="name")
    private String name;

    /**
     * Field roleType : 角色类型
     */
    @Column(name="role_type")
    private String roleType;

    /**
     * Field departId : 归属部门
     */
    @Column(name="depart_id")
    private String departId;

    /**
     * Field creator : 创建者
     */
    @Column(name="creator")
    private String creator;

    /**
     * Field createDate : 创建时间
     */
    @Column(name="create_date")
    private Date createDate;

    /**
     * Field updater : 更新者
     */
    @Column(name="updater")
    private String updater;

    /**
     * Field updateDate : 更新时间
     */
    @Column(name="update_date")
    private Date updateDate;

    /**
     * Field remark : 备注信息
     */
    @Column(name="remark")
    private String remark;

    /**
     * Field enable : 是否可用
     */
    @Column(name="enable")
    private String enable;

    /**
     * Field state : 状态
     */
    @Column(name="state")
    private String state;

    public Role(){}

    public void setId( String id ) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setRoleType( String roleType ) {
        this.roleType = roleType;
    }

    public String getRoleType() {
        return this.roleType;
    }

    public void setDepartId( String departId ) {
        this.departId = departId;
    }

    public String getDepartId() {
        return this.departId;
    }

    public void setCreator( String creator ) {
        this.creator = creator;
    }

    public String getCreator() {
        return this.creator;
    }

    public void setCreateDate( Date createDate ) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setUpdater( String updater ) {
        this.updater = updater;
    }

    public String getUpdater() {
        return this.updater;
    }

    public void setUpdateDate( Date updateDate ) {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setRemark( String remark ) {
        this.remark = remark;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setEnable( String enable ) {
        this.enable = enable;
    }

    public String getEnable() {
        return this.enable;
    }

    public void setState( String state ) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }


}

