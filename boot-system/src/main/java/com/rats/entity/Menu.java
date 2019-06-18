package com.rats.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;


/** Copyright (C) 2013 rats
 *
 * Menu
 * Description: 
 *
 * @version : v1.0
 * @author : Lu generator
 * @since : 
 */
@Table(name="t_sys_menu")
@Entity
public class Menu implements Serializable {
    /**
     * Field serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Field id : ID
     */
    @Id
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
     * Field sort : 排序
     */
    @Column(name="sort")
    private Integer sort;

    /**
     * Field href : 链接
     */
    @Column(name="href")
    private String href;

    /**
     * Field target : 目标
     */
    @Column(name="target")
    private String target;

    /**
     * Field icon : 图标
     */
    @Column(name="icon")
    private String icon;

    /**
     * Field isShow : 是否在菜单中显示
     */
    @Column(name="is_show")
    private String isShow;

    /**
     * Field permission : 权限标识
     */
    @Column(name="permission")
    private String permission;

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
     * Field state : 状态
     */
    @Column(name="state")
    private String state;

    public Menu(){}

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

    public void setHref( String href ) {
        this.href = href;
    }

    public String getHref() {
        return this.href;
    }

    public void setTarget( String target ) {
        this.target = target;
    }

    public String getTarget() {
        return this.target;
    }

    public void setIcon( String icon ) {
        this.icon = icon;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIsShow( String isShow ) {
        this.isShow = isShow;
    }

    public String getIsShow() {
        return this.isShow;
    }

    public void setPermission( String permission ) {
        this.permission = permission;
    }

    public String getPermission() {
        return this.permission;
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

    public void setState( String state ) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }


}

