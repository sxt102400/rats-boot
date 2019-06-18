package com.rats.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;


/** Copyright (C) 2013 rats
 *
 * User
 * Description: 
 *
 * @version : v1.0
 * @author : Lu generator
 * @since : 
 */
@Table(name="t_sys_user")
@Entity
public class User implements Serializable {
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
     * Field departId : 归属部门
     */
    @Column(name="depart_id")
    private String departId;

    /**
     * Field username : 登录名
     */
    @Column(name="username")
    private String username;

    /**
     * Field password : 密码
     */
    @Column(name="password")
    private String password;

    /**
     * Field userNo : 工号
     */
    @Column(name="user_no")
    private String userNo;

    /**
     * Field name : 姓名
     */
    @Column(name="name")
    private String name;

    /**
     * Field email : 邮箱
     */
    @Column(name="email")
    private String email;

    /**
     * Field mobile : 手机
     */
    @Column(name="mobile")
    private String mobile;

    /**
     * Field userType : 用户类型
     */
    @Column(name="user_type")
    private String userType;

    /**
     * Field photo : 用户头像
     */
    @Column(name="photo")
    private String photo;

    /**
     * Field loginIp : 最后登陆IP
     */
    @Column(name="login_ip")
    private String loginIp;

    /**
     * Field loginDate : 最后登陆时间
     */
    @Column(name="login_date")
    private Date loginDate;

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
     * Field remarks : 备注信息
     */
    @Column(name="remarks")
    private String remarks;

    /**
     * Field state : 状态
     */
    @Column(name="state")
    private String state;

    public User(){}

    public void setId( String id ) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setDepartId( String departId ) {
        this.departId = departId;
    }

    public String getDepartId() {
        return this.departId;
    }

    public void setUsername( String username ) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUserNo( String userNo ) {
        this.userNo = userNo;
    }

    public String getUserNo() {
        return this.userNo;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setMobile( String mobile ) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setUserType( String userType ) {
        this.userType = userType;
    }

    public String getUserType() {
        return this.userType;
    }

    public void setPhoto( String photo ) {
        this.photo = photo;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setLoginIp( String loginIp ) {
        this.loginIp = loginIp;
    }

    public String getLoginIp() {
        return this.loginIp;
    }

    public void setLoginDate( Date loginDate ) {
        this.loginDate = loginDate;
    }

    public Date getLoginDate() {
        return this.loginDate;
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

    public void setRemarks( String remarks ) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setState( String state ) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }


}

