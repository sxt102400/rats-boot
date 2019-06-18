package com.rats.framework.common.exception;

import com.rats.framework.common.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GlobalExceptionHandler extends SimpleMappingExceptionResolver {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    public static final String FAKE_AJAX = "_fakeAjax";

    private ModelAndView empty = new ModelAndView();

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response,
                                              Object handler, Exception ex) {
        logger.error("", ex);

        if(Exception.class.equals(ex.getClass())) {
            ex = ex;
        } else {
            // 其他未捕获的异常返回"1-系统异常"
            ex = new BaseException(1, ex);
        }

        // ajax请求直接返回消息内容
        if(HttpUtils.isAjaxRequest(request) || "1".equals(request.getParameter(FAKE_AJAX))) {
            try {
                response.setStatus(501);
                PrintWriter writer = response.getWriter();
                writer.write(ex.getMessage());
                writer.flush();
                writer.close();
            } catch (IOException e) {
                logger.error("System-Exception: ", e);
            }
            return empty;
        }

        String viewName = determineViewName(ex, request);
        // 对配置了匹配视图的异常,返回匹配的视图
        if (viewName != null) {
            Integer statusCode = determineStatusCode(request, viewName);
            if (statusCode != null) {
                applyStatusCodeIfPossible(request, response, statusCode);
            }
            return getModelAndView(viewName, ex, request);
        }
        return null;
    }



}