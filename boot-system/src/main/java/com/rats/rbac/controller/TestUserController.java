package com.rats.rbac.controller;

import com.rats.framework.common.data.Example;
import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.PageHelper;
import com.rats.framework.common.response.ResponseBean;
import com.rats.framework.common.response.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rats.rbac.entity.TestUser;
import com.rats.rbac.service.TestUserService;
import com.rats.framework.common.base.BaseController;

/** Copyright (C) 2013 rats
 *
 * TestUserController  
 *
 * @author Lu generator
 * @since 1.0.0
 * @date 2019-6-23 10:12:22
 */

@RestController
public class TestUserController extends BaseController {

    @Autowired
    private TestUserService testUserService;

    /**
     * 查询一条数据
     *
     * @param testUserKey
     * @return
     */
    @GetMapping("/testUser/:id/:sid")
    public ResponseBean get(TestUser.Key testUserKey) {
        TestUser testUser = testUserService.findOneById(testUserKey).get();
        return ResponseFactory.getSuccessResponse(testUser);
    }

    /**
     * ajax分页查询，request中传递条件参数page,pageSize
     *
     * @param testUser
     * @return
     */
    @GetMapping( "/testUser/page")
    public ResponseBean page(TestUser testUser) {
        Page page = testUserService.findAll(Example.of(testUser),  PageHelper.getPage());
        return ResponseFactory.getSuccessResponse(page);
    }

    /**
     * 保存
     *
     * @param testUser
     * @return
     */
    @PostMapping("/testUser")
    public ResponseBean add(TestUser testUser) {
        testUserService.save(testUser);
        return ResponseFactory.getDefaultSuccessResponse();
    }

    /**
     * 编辑
     *
     * @param testUserKey
     * @param testUser
     * @return
     */
    @PutMapping("/testUser/:id")
    public ResponseBean edit(@PathVariable TestUser.Key testUserKey, TestUser testUser) {
        testUserService.update(testUser);
        return ResponseFactory.getDefaultSuccessResponse();
    }

    /**
     * 删除
     *
     * @param testUserKey
     * @return
     */
    @DeleteMapping(value = "/testUser/:id")
    public ResponseBean remove(@PathVariable TestUser.Key testUserKey) {
        testUserService.deleteById(testUserKey);
        return ResponseFactory.getDefaultSuccessResponse();
    }

 }














