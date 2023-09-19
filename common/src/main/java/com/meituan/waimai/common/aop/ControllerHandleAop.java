package com.meituan.waimai.common.aop;

import com.meituan.waimai.common.domain.CommonResult;
import com.meituan.waimai.common.domain.ResultCode;
import com.meituan.waimai.common.util.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

@Slf4j
@Aspect
@Component
public class ControllerHandleAop {

	private static final Set<String> KEY = new ConcurrentSkipListSet<>();

	@Pointcut("execution(public * com.meituan.waimai.*.controller.*.*(..))")
	public  void executeService(){
	}

	@Pointcut("execution(public * com.meituan.waimai.controller.*.*(..))")
	public  void execute(){
	}

	@Around("executeService() || execute()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		ServletRequestAttributes requestAttributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		//获取ip
		String ip  = RequestUtil.getRequestIp(request);
		//获取请求参数
		Object[] args = joinPoint.getArgs();
		//获取方法签名
		MethodSignature  signature =(MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		// 获取方法名、类名、
		String methodName = method.getName();
		String className =  method.getDeclaringClass().getName();
		String format =  String.format("%s%s%s%s",ip,methodName,className, Arrays.toString(args));
		int hashCode = format.hashCode();
		hashCode = (hashCode == Integer.MIN_VALUE) ? 0 : Math.abs(hashCode);
		String key = String.format("%s%s",ip,hashCode);
		if (!KEY.add(key)){
			return CommonResult.failed(ResultCode.REPEAT_SUBMIT);
		}
		try {
			return joinPoint.proceed();
		} finally {
			KEY.remove(key);
		}
	}
}
