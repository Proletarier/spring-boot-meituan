package com.meituan.waimai.validation.captcha;

import com.meituan.waimai.common.util.DateUtil;
import com.meituan.waimai.model.dto.CustomerLoginForm;
import com.meituan.waimai.server.ConsumeCacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.function.Predicate;

@Slf4j
public class CaptchaValidation<T extends Annotation, K> implements ConstraintValidator<T, K> {

    @Autowired
    ConsumeCacheService cacheService;

    protected Predicate<K> predicate = s -> true;

    @Override
    public boolean isValid(K value, ConstraintValidatorContext context) {
       return  predicate.test(value);
    }

    public static class OverSendCaptchaValidator extends CaptchaValidation<OverSendCaptcha,String> {

        @Value("${captcha.limit.count}")
        private Integer captchaMaxCount;

        @Value("${captcha.limit.interval}")
        private Integer captchaTimeInterval;

        public void initialize(OverSendCaptcha constraintAnnotation) {
            predicate = phone -> {
                int count = cacheService.getSendCaptchaCount(phone);
                if(count > captchaMaxCount){
                    return  false;
                }
                long lastTime = cacheService.getSendCaptchaLastTime(phone);
                return DateUtil.getCurrentSeconds() - lastTime > captchaTimeInterval;
            };
        }
    }

    public static class ValidCaptchaValidator extends CaptchaValidation<ValidCaptcha, CustomerLoginForm> {

        public void initialize(ValidCaptcha constraintAnnotation) {
            predicate = loginForm -> {
                String captchaCode = cacheService.getCaptcha(loginForm.getPhone());
                return  loginForm.getCaptcha().equals(captchaCode);
            };
        }
    }

}
