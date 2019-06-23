package com.rats.framework.common.page;

import com.rats.framework.common.page.prop.Paging;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hanbing
 * @date 2019-06-20
 * @since 1.0.0
 */
@Component
public class PageHelper extends Paging {

    /**
     * getPage
     *
     * @return
     */
    public static PageRequest getPage() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        Assert.notNull(servletRequestAttributes, "servletRequestAttributes must not be null");
        HttpServletRequest request = servletRequestAttributes.getRequest();
        return getPage(request);
    }

    /**
     * getPage
     *
     * @param request
     * @return
     */
    public static PageRequest getPage(HttpServletRequest request) {
        Assert.notNull(request, "request must not be null");
        int page = getPageNo(request);
        int size = getPageSize(request);
        return PageHelper.getPage(page, size);
    }

    /**
     * getPage
     *
     * @param page
     * @return
     */
    public static PageRequest getPage(int page) {
        return PageRequest.of(page, defaultValue().getPageSize());
    }

    /**
     *  getPage
     *
     * @param page
     * @param size
     * @return
     */
    public static PageRequest getPage(int page, int size) {
        return PageRequest.of(page, size);
    }

    private static int getPageNo(HttpServletRequest request) {
        int pageNo;
        String no = request.getParameter(paramName().getPageNo());
        if (StringUtils.isNumeric(no)) {
            pageNo = Integer.parseInt(no);
            if (pageNo < 1) {
                pageNo = 1;
            }
        } else {
            pageNo = defaultValue().getPageNo();
        }
        return pageNo;
    }

    private static int getPageSize(HttpServletRequest request) {
        int pageSize;
        String size = request.getParameter(paramName().getPageSize());
        if (StringUtils.isNumeric(size)) {
            pageSize = Integer.parseInt(size);
        } else {
            pageSize = defaultValue().getPageSize();
        }
        return pageSize;
    }

}
