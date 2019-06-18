package com.rats.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rats.entity.Role;
import com.rats.service.RoleService;
import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.Pageable;
import com.rats.framework.common.base.BaseController;
import com.rats.framework.common.base.ResponseBean;
 import com.rats.framework.common.page.PageHelper;


/** Copyright (C) 2013 rats
 *
 * RoleController
 * Description: 
 *
 * @version : v1.0
 * @author : Lu generator
 * @since : 
 */

@RestController
@RequestMapping
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    /**
     * 查询一条数据
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/role/:id")
    public ResponseBean getById(@PathVariable String id ) {
        Role role = roleService.selectByPrimaryKey(id);
        return successData(role);
    }

    /**
     * 分页查询，request中传递参数page,pageSize
     *
     * @param request
     * @param response
     * @param role
     * @return
     */
    @GetMapping(value = "/role/list")
    public String doList(HttpServletRequest request, HttpServletResponse response, Role role) {
            Pageable pageable = PageHelper.getPage(request);
            Page page = roleService.selectPage(role, pageable);
            return page.toJSONString();
     }

    /**
     * 编辑
     *
     * @param id
     * @param role
     * @return
     */
    @PutMapping(value = "/role/:id")
    public ResponseBean doEdit(@PathVariable String id , Role role) {
        roleService.updateByPrimaryKeySelective(role);
            return successData(null);
    }

    /**
     * 保存
     *
     * @param role
     * @return
     */
    @PostMapping(value = "/role")
    public ResponseBean doSave(Role role) {
        roleService.save(role);
        return successData(null);
    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/role/:id")
    @ResponseBody
    public ResponseBean update(@PathVariable String id ) {
        roleService.deleteByPrimaryKey(id);
        return successData(null);
    }



}
