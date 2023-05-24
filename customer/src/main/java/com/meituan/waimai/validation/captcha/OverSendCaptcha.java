package com.meituan.waimai.validation.captcha;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target({FIELD, METHOD, PARAMETER, TYPE})
@Constraint(validatedBy = CaptchaValidation.OverSendCaptchaValidator.class)
public @interface OverSendCaptcha {

    String message() default "发送频繁，请稍后再试";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
