package com.rats.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;


/** Copyright (C) 2013 rats
 *
 * RolePermission
 * Description: 
 *
 * @version : v1.0
 * @author : Lu generator
 * @since : 
 */
@Table(name="t_sys_role_permission")
@Entity
public class RolePermission implements Serializable {
    /**
     * Field serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Field id : 编号
     */
    @Column(name="id")
    private Integer id;

    /**
     * Field roleId : 角色编号
     */
    @Column(name="role_id")
    private String roleId;

    /**
     * Field resourceId : 资源编号
     */
    @Column(name="resource_id")
    private String resourceId;

    /**
     * Field resourceType : 资源类型
     */
    @Column(name="resource_type")
    private String resourceType;

    public RolePermission(){}

    public void setId( Integer id ) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setRoleId( String roleId ) {
        this.roleId = roleId;
    }

    public String getRoleId() {
        return this.roleId;
    }

    public void setResourceId( String resourceId ) {
        this.resourceId = resourceId;
    }

    public String getResourceId() {
        return this.resourceId;
    }

    public void setResourceType( String resourceType ) {
        this.resourceType = resourceType;
    }

    public String getResourceType() {
        return this.resourceType;
    }


}

