package com.meituan.waimai.common.filter;

import com.meituan.waimai.common.api.CommonResult;
import com.meituan.waimai.common.api.ResultCode;
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
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

@Slf4j
@Aspect
@Component
public class ControllerHandleAop {

	private final static Set<String> KEY = new ConcurrentSkipListSet<>();

	@Pointcut("public * com.meituan.waimai.*.controller.*.*(..)" +
	"|| public * com.meituan.waimai.*.controller.*.*(..)")
	public  void executeService(){
	}

	@Around("executeService()")
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
		String format =  String.format("%s%s%s%s",ip,methodName,className,args);
		int hashCode = Math.abs(format.hashCode());
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
