package com.rats.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;


/** Copyright (C) 2013 rats
 *
 * Depart
 * Description: 
 *
 * @version : v1.0
 * @author : Lu generator
 * @since : 
 */
@Table(name="t_sys_depart")
@Entity
public class Depart implements Serializable {
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
     * Field parentId : 父级编号
     */
    @Column(name="parent_id")
    private Integer parentId;

    /**
     * Field parentIds : 所有父级编号
     */
    @Column(name="parent_ids")
    private String parentIds;

    /**
     * Field name : 名称
     */
    @Column(name="name")
    private String name;

    /**
     * Field sort : 排序
     */
    @Column(name="sort")
    private Integer sort;

    /**
     * Field departType : 机构类型
     */
    @Column(name="depart_type")
    private String departType;

    /**
     * Field grade : 机构等级
     */
    @Column(name="grade")
    private String grade;

    /**
     * Field address : 联系地址
     */
    @Column(name="address")
    private String address;

    /**
     * Field master : 负责人
     */
    @Column(name="master")
    private String master;

    /**
     * Field mobile : 手机
     */
    @Column(name="mobile")
    private String mobile;

    /**
     * Field email : 邮箱
     */
    @Column(name="email")
    private String email;

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

    public Depart(){}

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

    public void setSort( Integer sort ) {
        this.sort = sort;
    }

    public Integer getSort() {
        return this.sort;
    }

    public void setDepartType( String departType ) {
        this.departType = departType;
    }

    public String getDepartType() {
        return this.departType;
    }

    public void setGrade( String grade ) {
        this.grade = grade;
    }

    public String getGrade() {
        return this.grade;
    }

    public void setAddress( String address ) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setMaster( String master ) {
        this.master = master;
    }

    public String getMaster() {
        return this.master;
    }

    public void setMobile( String mobile ) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
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

