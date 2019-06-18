package com.rats.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rats.entity.UserRole;
import com.rats.service.UserRoleService;
import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.Pageable;
import com.rats.framework.common.base.BaseController;
import com.rats.framework.common.base.ResponseBean;
 import com.rats.framework.common.page.PageHelper;


/** Copyright (C) 2013 rats
 *
 * UserRoleController
 * Description: 
 *
 * @version : v1.0
 * @author : Lu generator
 * @since : 
 */

@RestController
@RequestMapping
public class UserRoleController extends BaseController {

    @Autowired
    private UserRoleService userRoleService;

    /**
     * 查询一条数据
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/userRole/:id")
    public ResponseBean getById(@PathVariable Integer id ) {
        UserRole userRole = userRoleService.selectByPrimaryKey(id);
        return successData(userRole);
    }

    /**
     * 分页查询，request中传递参数page,pageSize
     *
     * @param request
     * @param response
     * @param userRole
     * @return
     */
    @GetMapping(value = "/userRole/list")
    public String doList(HttpServletRequest request, HttpServletResponse response, UserRole userRole) {
            Pageable pageable = PageHelper.getPage(request);
            Page page = userRoleService.selectPage(userRole, pageable);
            return page.toJSONString();
            }

    /**
     * 编辑
     *
     * @param id
     * @param userRole
     * @return
     */
    @PutMapping(value = "/userRole/:id")
    public ResponseBean doEdit(@PathVariable Integer id , UserRole userRole) {
        userRoleService.updateByPrimaryKeySelective(userRole);
            return successData(null);
    }

    /**
     * 保存
     *
     * @param userRole
     * @return
     */
    @PostMapping(value = "/userRole")
    public ResponseBean doSave(UserRole userRole) {
        userRoleService.save(userRole);
        return successData(null);
    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/userRole/:id")
    @ResponseBody
    public ResponseBean update(@PathVariable Integer id ) {
        userRoleService.deleteByPrimaryKey(id);
        return successData(null);
    }



}
