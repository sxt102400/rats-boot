package com.rats.controller;


import com.rats.framework.base.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.query.MongoRegexCreator;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rats.entity.Depart;
import com.rats.service.DepartService;
import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.Pageable;
import com.rats.framework.base.BaseController;
import com.rats.framework.base.ResponseBean;
 import com.rats.framework.common.page.PageHelper;


/** Copyright (C) 2013 rats
 *
 * DepartController
 * Description: 
 *
 * @version : v1.0
 * @author : Lu generator
 * @since : 
 */

@RestController
@RequestMapping
public class DepartController extends BaseController {

    @Autowired
    private DepartService departService;

    /**
     * 查询一条数据
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/depart/:id")
    public ResponseBean<Boolean> getById(@PathVariable Integer id ) {
        Depart depart = departService.findById(id).get();
        return ResponseFactory.getSuccessResult(depart);
    }

    /**
     * 分页查询，request中传递参数page,pageSize
     *
     * @param request
     * @param response
     * @param depart
     * @return
     */
    @GetMapping(value = "/depart/list")
    public ResponseBean<Page> doList(HttpServletRequest request, HttpServletResponse response, Depart depart) {
            Pageable pageable = PageHelper.getPage(request);
            Page page = departService.findAll(depart, pageable);
            return ResponseFactory.getSuccessResult(page);
     }

    /**
     * 编辑
     *
     * @param id
     * @param depart
     * @return
     */
    @PutMapping(value = "/depart/:id")
    public ResponseBean doEdit(@PathVariable Integer id , Depart depart) {
        departService.save(depart);
            return successData(null);
    }

    /**
     * 保存
     *
     * @param depart
     * @return
     */
    @PostMapping(value = "/depart")
    public ResponseBean<Boolean> doSave(Depart depart) {
        departService.save(depart);
        return successData(null);
    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/depart/:id")
    @ResponseBody
    public ResponseBean update(@PathVariable Integer id ) {
        departService.deleteById(id);
        return successData(null);
    }



}
