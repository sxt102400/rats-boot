package com.rats.controller;


import com.rats.framework.common.base.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import com.rats.entity.Menu;
import com.rats.service.MenuService;
import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.Pageable;
import com.rats.framework.common.base.BaseController;
import com.rats.framework.common.base.ResponseBean;
 import com.rats.framework.common.page.PageHelper;


/** Copyright (C) 2013 rats
 *
 * MenuController
 * Description: 
 *
 * @version : v1.0
 * @author : Lu generator
 * @since : 
 */

@RestController
@RequestMapping
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    /**
     * 查询一条数据
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/menu/:id")
    public ResponseBean getById(@PathVariable Integer id ) {
        Menu menu = menuService.findById(id).get();
        return successData(menu);
    }

    /**
     * 分页查询，request中传递参数page,pageSize
     *
     * @param request
     * @param menu
     * @return
     */
    @GetMapping(value = "/menu/list")
    public ResponseBean doList(HttpServletRequest request,  Menu menu) {
            Pageable pageable = PageHelper.getPage(request);

            Menu query = new Menu();
            query.setName("首页");
            query.setSort(2);
            query.setState("0");
            Page<Menu> page = menuService.findAll(query, pageable);
            return ResponseFactory.getSuccessResult(page);
     }

    /**
     * 编辑
     *
     * @param id
     * @param menu
     * @return
     */
    @PutMapping(value = "/menu/:id")
    public ResponseBean doEdit(@PathVariable Integer id , Menu menu) {
        menuService.save(menu);
        return successData(null);
    }

    /**
     * 保存
     *
     * @param menu
     * @return
     */
    @PostMapping(value = "/menu")
    public ResponseBean doSave(Menu menu) {
        menuService.save(menu);
        return successData(null);
    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/menu/:id")
    @ResponseBody
    public ResponseBean update(@PathVariable Integer id ) {
        menuService.deleteById(id);
        return successData(null);
    }



}
