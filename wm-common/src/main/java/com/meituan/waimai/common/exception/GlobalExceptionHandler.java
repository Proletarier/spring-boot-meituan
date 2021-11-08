package com.meituan.waimai.common.exception;


import com.meituan.waimai.common.api.CommonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

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
}
