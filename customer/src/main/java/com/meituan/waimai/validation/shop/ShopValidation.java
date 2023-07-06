package com.meituan.waimai.validation.shop;

import com.meituan.waimai.mapper.ShopMapper;
import com.meituan.waimai.model.Shop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.function.Predicate;

@Slf4j
public class ShopValidation  <T extends Annotation, K> implements ConstraintValidator<T, K> {

    @Autowired
    ShopMapper shopMapper;

    protected Predicate<K> predicate = s -> true;

    @Override
    public boolean isValid(K value, ConstraintValidatorContext context) {
        return  predicate.test(value);
    }

    public static class ExistShopValidator extends ShopValidation<ValidExistShop,Integer> {

        @Override
        public void initialize(ValidExistShop validExistShop) {
            predicate = shopId -> {
                Shop shop = shopMapper.selectById(shopId);
                return shop != null;
            };
        }
    }
}
