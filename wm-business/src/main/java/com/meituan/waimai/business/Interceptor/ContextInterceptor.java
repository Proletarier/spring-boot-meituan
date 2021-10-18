package com.meituan.waimai.business.Interceptor;

import cn.hutool.core.util.StrUtil;
import com.meituan.waimai.common.api.ResultCode;
import com.meituan.waimai.common.exception.AutoTokenException;
import com.meituan.waimai.common.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ContextInterceptor implements HandlerInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContextInterceptor.class);

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Value("${jwt.tokenHeader}")
	private String tokenHeader;
	@Value("${jwt.tokenHeader}")
	private List<String> urls = new ArrayList<>();


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		String authToken = request.getHeader(this.tokenHeader);
		LOGGER.info("checking authHeader:{}", authToken);

		LOGGER.info("ContextPath={}",request.getContextPath());
		LOGGER.info("getRequestURL={}",request.getRequestURL().toString());

		if (StrUtil.isBlank(authToken) || jwtTokenUtil.isTokenExpired(authToken)){
			throw new AutoTokenException(ResultCode.UNAUTHORIZED);
		}

		return false;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}
}
