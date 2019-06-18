package com.rats.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;


/** Copyright (C) 2013 rats
 *
 * UserRole
 * Description: 
 *
 * @version : v1.0
 * @author : Lu generator
 * @since : 
 */
@Table(name="t_sys_user_role")
@Entity
public class UserRole implements Serializable {
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
     * Field userId : 用户编号
     */
    @Column(name="user_id")
    private String userId;

    public UserRole(){}

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

    public void setUserId( String userId ) {
        this.userId = userId;
    }

    public String getUserId() {
        return this.userId;
    }


}

