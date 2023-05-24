package com.meituan.waimai.validation;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.meituan.waimai.bean.CustomerContext;
import com.meituan.waimai.common.domain.ResultCode;
import com.meituan.waimai.mapper.CustomerAddressMapper;
import com.meituan.waimai.model.CustomerAddress;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Slf4j
@Component
public class AddressValidator implements Validator {

    @Autowired
    CustomerAddressMapper customerAddressMapper;

    @Override
    public boolean supports(Class<?> clazz) {
        return CustomerAddress.class.equals(clazz) || Integer.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Integer addressId;
        if(target instanceof CustomerAddress){
            addressId  = ((CustomerAddress) target).getId();
        }else {
            addressId = (Integer) target;
        }
        if(addressId == null){
            errors.reject(ResultCode.ADDRESS_NOT_EXIST.getCode(),ResultCode.ADDRESS_NOT_EXIST.getMessage());
        }
        Integer customerId = CustomerContext.getCustomerId();
        LambdaQueryWrapper<CustomerAddress> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(CustomerAddress::getCustomerId,customerId);
        queryWrapper.eq(CustomerAddress::getId,addressId);
        long ret = customerAddressMapper.selectCount(queryWrapper);
        if(ret == 0){
            errors.reject(ResultCode.ADDRESS_NOT_EXIST.getCode(),ResultCode.ADDRESS_NOT_EXIST.getMessage());
        }
    }

}
