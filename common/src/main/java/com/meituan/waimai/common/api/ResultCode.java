package com.meituan.waimai.common.api;

/**
 * 操作码
 */
public enum ResultCode implements IErrorCode {

    /**
     * 系统错误码
     */
    SUCCESS("00000", "操作成功"),
    FAILED("S9999", "操作失败"),
    VALIDATE_FAILED("S0001", "参数检验失败"),
    UNAUTHORIZED("S0002", "暂未登录或token已经过期"),
    FORBIDDEN("S0003", "没有相关权限"),
    VALIDATE_NULL("S0004", "请求的数据格式不符"),
    SYSTEM_ERROR("S0005", "服务器内部错误");



    private String code;
    private String message;

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
