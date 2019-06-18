package com.rats.framework.common.page;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class PageHelper {

    public static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 构造方法，从request中获取:page,pageSize
     *
     * @param request  传递 page 参数，来记住页码
     */
    public static PageRequest getPage(HttpServletRequest request) {
        return PageHelper.getPage(request,  DEFAULT_PAGE_SIZE);
    }

    /**
     * 构造方法，从request中获取:page,pageSize
     *
     * @param request  传递 page 参数，来记住页码
     * @param pageSize 分页大小,pageSize<1不分页
     */
    public static PageRequest getPage(HttpServletRequest request, int pageSize) {
        // 设置页码参数（传递page参数，来记住页码）
        int pageNo;
        String no = request.getParameter("page");
        if (StringUtils.isNumeric(no)) {
            pageNo = Integer.parseInt(no);
            if (pageNo < 1) {
                pageNo = 1;
            }
        } else {
            pageNo = 1;
        }
        // 设置页面大小参数（传递pageSize参数，来记住页码大小）
        String size = request.getParameter("pageSize");
        if (StringUtils.isNumeric(size)) {
            pageSize = Integer.parseInt(size);
            if (pageSize < 1) {
                pageSize = Integer.MAX_VALUE;
            }
        } else {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        pageSize = pageSize;
        return PageRequest.of(pageNo, pageSize);

    }

}
