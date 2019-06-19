package com.rats.service.impl;


import javax.annotation.Resource;

import com.rats.framework.common.base.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rats.entity.Menu;
import com.rats.mapper.MenuMapper;
import com.rats.service.MenuService;

/** Copyright (C) 2013 rats
 *
 * MenuServiceImpl
 * Description: 
 *
 * @version : v1.0
 * @author : Lu generator
 * @since : 
 */
@Service(value = "menuService")
public class MenuServiceImpl extends BaseServiceImpl<Menu,Integer> implements MenuService  {

    /**
     * Field LOGGER : 日志操作类
     */
    private static final Logger logger = LoggerFactory.getLogger(MenuService.class);

    @Resource
    private MenuMapper menuMapper;

    @Override
    public MenuMapper getMapper() {
        return menuMapper;
    }
}



