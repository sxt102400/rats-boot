package com.rats.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rats.entity.User;
import com.rats.service.UserService;
import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.Pageable;
import com.rats.framework.base.BaseController;
import com.rats.framework.base.ResponseBean;
 import com.rats.framework.common.page.PageHelper;


/** Copyright (C) 2013 rats
 *
 * UserController
 * Description: 
 *
 * @version : v1.0
 * @author : Lu generator
 * @since : 
 */

@RestController
@RequestMapping
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 查询一条数据
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/user/:id")
    public ResponseBean getById(@PathVariable String id ) {
        User user = userService.selectByPrimaryKey(id);
        return successData(user);
    }

    /**
     * 分页查询，request中传递参数page,pageSize
     *
     * @param request
     * @param response
     * @param user
     * @return
     */
    @GetMapping(value = "/user/list")
    public String doList(HttpServletRequest request, HttpServletResponse response, User user) {
            Pageable pageable = PageHelper.getPage(request);
            Page page = userService.selectPage(user, pageable);
            return page.toJSONString();
            }

    /**
     * 编辑
     *
     * @param id
     * @param user
     * @return
     */
    @PutMapping(value = "/user/:id")
    public ResponseBean doEdit(@PathVariable String id , User user) {
        userService.updateByPrimaryKeySelective(user);
            return successData(null);
    }

    /**
     * 保存
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/user")
    public ResponseBean doSave(User user) {
        userService.save(user);
        return successData(null);
    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/user/:id")
    @ResponseBody
    public ResponseBean update(@PathVariable String id ) {
        userService.deleteByPrimaryKey(id);
        return successData(null);
    }



}
