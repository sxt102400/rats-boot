package com.rats.framework.common.page;

import com.rats.framework.common.page.prop.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author hanbing
 * @since 1.0.0
 * @date 2019-06-20
 */
@Component
public class PageHelper extends PageInfo {

    public static PageRequest getPage() {
        return PageRequest.of(pageNo().getDefaultValue(), pageSize().getDefaultValue());
    }

    public static PageRequest getPage(int page) {
        return PageRequest.of(page, pageSize().getDefaultValue());
    }

    public static PageRequest getPage(int page, int size) {
        return PageRequest.of(page, size);
    }

    /**
     * 构造方法，从request中获取:page,pageSize
     *
     * @param request 传递 page 参数，来记住页码
     */
    public static PageRequest getPage(HttpServletRequest request) {
        int page = getPageNo(request);
        int size = getPageSize(request);
        return PageHelper.getPage(page, size);
    }

    private static int getPageNo(HttpServletRequest request) {
        // 设置页码参数（传递page参数，来记住页码）
        int pageNo;
        String no = request.getParameter(pageNo().getParamName());
        if (StringUtils.isNumeric(no)) {
            pageNo = Integer.parseInt(no);
            if (pageNo < 1) {
                pageNo = 1;
            }
        } else {
            pageNo = 1;
        }
        return pageNo;
    }

    private static int getPageSize(HttpServletRequest request) {
        // 设置页面大小参数（传递pageSize参数，来记住页码大小）
        int pageSize;
        String size = request.getParameter(pageSize().getParamName());
        if (StringUtils.isNumeric(size)) {
            pageSize = Integer.parseInt(size);
        } else {
            throw new RuntimeException("pageSize convert error:" + size);
        }
        return pageSize;
    }


}
