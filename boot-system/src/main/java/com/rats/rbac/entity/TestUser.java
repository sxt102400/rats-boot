package com.rats.rbac.entity;
import com.rats.framework.common.base.BaseBean;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;

/** Copyright (C) 2013 rats
 *
 * TestUser: 
 *
 * @author Lu generator
 * @since 1.0.0
 * @date 2019-6-23 10:12:22
 */
@Entity
@Table(name="tb_test_user")
public class TestUser extends BaseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *  Id: id   IDXXXX
     */
    @Id
    @Column(name="id")
    private Integer id;

    /**
     *  Id: sid   
     */
    @Id
    @Column(name="sid")
    private Integer sid;

    /**
     * username 登录名
     */
    @Column(name="username")
    private String username;

    /**
     * password 密码
     */
    @Column(name="password")
    private String password;

    /**
     * nickname 昵称
     */
    @Column(name="nickname")
    private String nickname;

    /**
     * email 邮箱
     */
    @Column(name="email")
    private String email;

    /**
     * phone 电话
     */
    @Column(name="phone")
    private String phone;

    /**
     * mobile 手机
     */
    @Column(name="mobile")
    private String mobile;

    /**
     * userType 用户类型
     */
    @Column(name="user_type")
    private String userType;

    /**
     * photo 用户头像
     */
    @Column(name="photo")
    private String photo;

    /**
     * loginIp 最后登陆IP
     */
    @Column(name="login_ip")
    private String loginIp;

    /**
     * loginDate 最后登陆时间
     */
    @Column(name="login_date")
    private java.util.Date loginDate;

    /**
     * loginFlag 是否可登录
     */
    @Column(name="login_flag")
    private String loginFlag;

    /**
     * createBy 创建者
     */
    @Column(name="create_by")
    private String createBy;

    /**
     * createDate 创建时间
     */
    @Column(name="create_date")
    private java.util.Date createDate;

    /**
     * updateBy 更新者
     */
    @Column(name="update_by")
    private String updateBy;

    /**
     * updateDate 更新时间
     */
    @Column(name="update_date")
    private java.util.Date updateDate;

    /**
     * remarks 备注信息
     */
    @Column(name="remarks")
    private String remarks;

    /**
     * delFlag 删除标记
     */
    @Column(name="del_flag")
    private String delFlag;

    /**
     * qrcode 二维码
     */
    @Column(name="qrcode")
    private String qrcode;

    /**
     * sign 个性签名
     */
    @Column(name="sign")
    private String sign;

    /**
     * realName 
     */
    @Column(name="real_name")
    private String realName;

    public TestUser(){}

    public void setId( Integer id ) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setSid( Integer sid ) {
        this.sid = sid;
    }

    public Integer getSid() {
        return this.sid;
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

    public void setNickname( String nickname ) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPhone( String phone ) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
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

    public void setLoginDate( java.util.Date loginDate ) {
        this.loginDate = loginDate;
    }

    public java.util.Date getLoginDate() {
        return this.loginDate;
    }

    public void setLoginFlag( String loginFlag ) {
        this.loginFlag = loginFlag;
    }

    public String getLoginFlag() {
        return this.loginFlag;
    }

    public void setCreateBy( String createBy ) {
        this.createBy = createBy;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public void setCreateDate( java.util.Date createDate ) {
        this.createDate = createDate;
    }

    public java.util.Date getCreateDate() {
        return this.createDate;
    }

    public void setUpdateBy( String updateBy ) {
        this.updateBy = updateBy;
    }

    public String getUpdateBy() {
        return this.updateBy;
    }

    public void setUpdateDate( java.util.Date updateDate ) {
        this.updateDate = updateDate;
    }

    public java.util.Date getUpdateDate() {
        return this.updateDate;
    }

    public void setRemarks( String remarks ) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setDelFlag( String delFlag ) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return this.delFlag;
    }

    public void setQrcode( String qrcode ) {
        this.qrcode = qrcode;
    }

    public String getQrcode() {
        return this.qrcode;
    }

    public void setSign( String sign ) {
        this.sign = sign;
    }

    public String getSign() {
        return this.sign;
    }

    public void setRealName( String realName ) {
        this.realName = realName;
    }

    public String getRealName() {
        return this.realName;
    }

    public static class Key implements Serializable {

        private Integer id;

        private Integer sid;

        public void setId( Integer id ) {
            this.id = id;
        }

        public Integer getId() {
            return this.id;
        }

        public void setSid( Integer sid ) {
            this.sid = sid;
        }

        public Integer getSid() {
            return this.sid;
        }

    }

}

