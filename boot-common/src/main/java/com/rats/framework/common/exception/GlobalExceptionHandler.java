package com.rats.framework.common.exception;

import com.rats.framework.common.response.ResponseBean;
import com.rats.framework.common.response.ResponseCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author hanbing
 * @since 1.0.0
 * @date 2019-06-20
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler()
    @ResponseBody
    public ResponseBean handleException(Exception e){
        ResponseBean<String> responseBean = new ResponseBean<>();
        responseBean.setCode(ResponseCode.ERROR.code());
        responseBean.setMessage(e.getMessage());
        return responseBean;
    }
}