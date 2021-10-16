package com.meituan.waimai.common.exception;

import com.meituan.waimai.common.api.IErrorCode;

public class Asserts  {

    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }

}
