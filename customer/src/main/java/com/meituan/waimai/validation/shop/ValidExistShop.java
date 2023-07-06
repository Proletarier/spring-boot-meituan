package com.meituan.waimai.validation.shop;

import com.meituan.waimai.validation.captcha.CaptchaValidation;

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
@Constraint(validatedBy = ShopValidation.ExistShopValidator.class)
public @interface ValidExistShop {

    String message() default "输入错误，不存在的商户";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
