package com.rats.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rats.entity.Operation;
import com.rats.service.OperationService;
import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.Pageable;
import com.rats.framework.common.base.BaseController;
import com.rats.framework.common.base.ResponseBean;
 import com.rats.framework.common.page.PageHelper;


/** Copyright (C) 2013 rats
 *
 * OperationController
 * Description: 
 *
 * @version : v1.0
 * @author : Lu generator
 * @since : 
 */

@RestController
@RequestMapping
public class OperationController extends BaseController {

    @Autowired
    private OperationService operationService;

    /**
     * 查询一条数据
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/operation/:id")
    public ResponseBean getById(@PathVariable Integer id ) {
        Operation operation = operationService.selectByPrimaryKey(id);
        return successData(operation);
    }

    /**
     * 分页查询，request中传递参数page,pageSize
     *
     * @param request
     * @param response
     * @param operation
     * @return
     */
    @GetMapping(value = "/operation/list")
    public String doList(HttpServletRequest request, HttpServletResponse response, Operation operation) {
            Pageable pageable = PageHelper.getPage(request);
            Page page = operationService.selectPage(operation, pageable);
            return page.toJSONString();
            }

    /**
     * 编辑
     *
     * @param id
     * @param operation
     * @return
     */
    @PutMapping(value = "/operation/:id")
    public ResponseBean doEdit(@PathVariable Integer id , Operation operation) {
        operationService.updateByPrimaryKeySelective(operation);
            return successData(null);
    }

    /**
     * 保存
     *
     * @param operation
     * @return
     */
    @PostMapping(value = "/operation")
    public ResponseBean doSave(Operation operation) {
        operationService.save(operation);
        return successData(null);
    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/operation/:id")
    @ResponseBody
    public ResponseBean update(@PathVariable Integer id ) {
        operationService.deleteByPrimaryKey(id);
        return successData(null);
    }



}
