package com.rats.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rats.entity.RolePermission;
import com.rats.service.RolePermissionService;
import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.Pageable;
import com.rats.framework.base.BaseController;
import com.rats.framework.base.ResponseBean;
 import com.rats.framework.common.page.PageHelper;


/** Copyright (C) 2013 rats
 *
 * RolePermissionController
 * Description: 
 *
 * @version : v1.0
 * @author : Lu generator
 * @since : 
 */

@RestController
@RequestMapping
public class RolePermissionController extends BaseController {

    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * 查询一条数据
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/rolePermission/:id")
    public ResponseBean getById(@PathVariable Integer id ) {
        RolePermission rolePermission = rolePermissionService.selectByPrimaryKey(id);
        return successData(rolePermission);
    }

    /**
     * 分页查询，request中传递参数page,pageSize
     *
     * @param request
     * @param response
     * @param rolePermission
     * @return
     */
    @GetMapping(value = "/rolePermission/list")
    public String doList(HttpServletRequest request, HttpServletResponse response, RolePermission rolePermission) {
            Pageable pageable = PageHelper.getPage(request);
            Page page = rolePermissionService.selectPage(rolePermission, pageable);
            return page.toJSONString();
            }

    /**
     * 编辑
     *
     * @param id
     * @param rolePermission
     * @return
     */
    @PutMapping(value = "/rolePermission/:id")
    public ResponseBean doEdit(@PathVariable Integer id , RolePermission rolePermission) {
        rolePermissionService.updateByPrimaryKeySelective(rolePermission);
            return successData(null);
    }

    /**
     * 保存
     *
     * @param rolePermission
     * @return
     */
    @PostMapping(value = "/rolePermission")
    public ResponseBean doSave(RolePermission rolePermission) {
        rolePermissionService.save(rolePermission);
        return successData(null);
    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/rolePermission/:id")
    @ResponseBody
    public ResponseBean update(@PathVariable Integer id ) {
        rolePermissionService.deleteByPrimaryKey(id);
        return successData(null);
    }



}
