package com.meituan.waimai.common.domain;

/**
 * 操作码
 */
public enum ResultCode implements IErrorCode {

    /**
     * 系统错误码
     */
    SUCCESS("Success", "操作成功"),
    FAILED("Failed", "操作失败"),
    VALIDATE_FAILED("Validate.Failed", "参数检验失败"),
    UNAUTHORIZED("Unauthorized", "暂未登录或token已经过期"),
    FORBIDDEN("Forbidden", "没有相关权限"),
    VALIDATE_NULL("Validate.Null", "请求的数据格式不符"),
    SYSTEM_ERROR("System.Error", "服务器内部错误"),
    REPEAT_SUBMIT("Repeat.Submit", "请勿重复提交"),
    CAPTCHA_FAILED("Captcha.Failed", "验证码验证失败"),
    LOCATION_INVALID("Location.Failed", "定位失败"),
    ADDRESS_NOT_EXIST("Address.not.exist","地址不存在");


    private final String code;
    private final String message;

    private ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
