package com.rats.framework.utils;

import javax.servlet.http.HttpServletRequest;

public class HttpUtils {

    /**
     * 是否AJAX请求
     *
     * @param request
     * @return
     * @Title: isAjaxRequest
     * @Description:
     */
    public static boolean isAjaxRequest(HttpServletRequest request)
    {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }
}
