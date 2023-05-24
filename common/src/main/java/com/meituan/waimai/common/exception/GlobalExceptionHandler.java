package com.meituan.waimai.common.exception;


import cn.hutool.core.util.StrUtil;
import com.meituan.waimai.common.domain.CommonResult;
import com.meituan.waimai.common.domain.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public CommonResult<Void> handle(ApiException e) {
        if (e.getErrorCode() != null) {
            return CommonResult.failed(e.getErrorCode());
        }
        return CommonResult.failed(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = AMapErrorException.class)
    public CommonResult<Void> handle(AMapErrorException e) {
        if (e.getError() != null) {
            return CommonResult.failed(e.getError().getErrorMsg());
        }
        return CommonResult.failed(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = AutoTokenException.class)
    public CommonResult<Void> handle(AutoTokenException e) {
        if (e.getErrorCode() != null) {
            return CommonResult.failed(e.getErrorCode());
        }
        return CommonResult.failed(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public CommonResult<Void> handle(MissingServletRequestParameterException e) {
        return CommonResult.failed(ResultCode.VALIDATE_NULL, e.getMessage());
    }

    /**
     * 处理空指针的异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public CommonResult<Void> exceptionHandler(HttpServletRequest req, NullPointerException e) {
        logger.error("null point exception！cause:", e);
        return CommonResult.failed(ResultCode.VALIDATE_NULL);
    }


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public CommonResult<Void> exceptionHandler(HttpServletRequest req, MethodArgumentNotValidException e) {
        logger.error("other MethodArgumentNotValidException ！cause:", e);
        List<FieldError> fieldErrorList = e.getFieldErrors();
        if (!CollectionUtils.isEmpty(fieldErrorList)) {
            StringBuilder message = new StringBuilder();
            for (FieldError fieldError : fieldErrorList) {
                if (fieldError != null && fieldError.getDefaultMessage() != null) {
                    message.append(fieldError.getDefaultMessage()).append(" ");
                }
            }
            if (StrUtil.isNotEmpty(message.toString())) {
                return CommonResult.failed(ResultCode.VALIDATE_FAILED, message.toString());
            }
        } else if(e.getGlobalError() != null) {
            ObjectError error = e.getGlobalError();
            if (error != null) {
                return new CommonResult<>(error.getCode(), error.getDefaultMessage(), null);
            }
        }
        return CommonResult.failed(ResultCode.VALIDATE_FAILED);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public CommonResult<Void> handleConstraintViolationException(ConstraintViolationException ex) {
        logger.warn("params verify invalid: {}", ex.getMessage());
        String msg = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("；"));
        return CommonResult.failed(ResultCode.VALIDATE_FAILED,msg);
    }


    /**
     * 处理其他异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResult<Void> exceptionHandler(HttpServletRequest req, Exception e) {
        logger.error("other exception！cause:", e);
        return CommonResult.failed(ResultCode.SYSTEM_ERROR);
    }
}
