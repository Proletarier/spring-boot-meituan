package com.meituan.waimai.common.exception;


import com.meituan.waimai.common.domain.CommonResult;
import com.meituan.waimai.common.domain.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = ApiException.class)

    public CommonResult handle(ApiException e) {
        if (e.getErrorCode() != null) {
            return CommonResult.failed(e.getErrorCode());
        }
        return CommonResult.failed(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = AMapErrorException.class)
    public CommonResult handle(AMapErrorException e) {
        if (e.getError() != null) {
            return CommonResult.failed(e.getError().getErrorMsg());
        }
        return CommonResult.failed(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = AutoTokenException.class)
    public CommonResult handle(AutoTokenException e) {
        if (e.getErrorCode() != null) {
            return CommonResult.failed(e.getErrorCode());
        }
        return CommonResult.failed(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public CommonResult handle(MissingServletRequestParameterException e) {
        return CommonResult.failed(ResultCode.VALIDATE_NULL,e.getMessage());
    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public CommonResult exceptionHandler(HttpServletRequest req, NullPointerException e){
        logger.error("null point exception！cause:",e);
        return CommonResult.failed(ResultCode.VALIDATE_NULL);
    }


    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public CommonResult exceptionHandler(HttpServletRequest req, Exception e){
        logger.error("other exception！cause:",e);
        return CommonResult.failed(ResultCode.SYSTEM_ERROR);
    }
}
