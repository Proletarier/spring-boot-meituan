package com.meituan.waimai.Interceptor;

import cn.hutool.core.util.StrUtil;
import com.meituan.waimai.bean.CustomerContext;
import com.meituan.waimai.common.domain.ResultCode;
import com.meituan.waimai.common.exception.AutoTokenException;
import com.meituan.waimai.common.util.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

public class ContextInterceptor implements HandlerInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContextInterceptor.class);

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	@Qualifier("jwtIgnoredUrls")
	private List<String> urls;
	@Value("${jwt.tokenHeader}")
	private String tokenHeader;


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

		LOGGER.info("ContextPath={}",request.getContextPath());
		LOGGER.info("getRequestURL={}",request.getRequestURL().toString());

		PathMatcher pathMatcher = new AntPathMatcher();
		for (String path : urls) {
			if(pathMatcher.match(path,request.getRequestURI())){
				return true;
			}
		}
		String authToken = request.getHeader(this.tokenHeader);
		LOGGER.debug("checking authHeader:{}", authToken);

		if (StrUtil.isBlank(authToken)){
			throw new AutoTokenException(ResultCode.UNAUTHORIZED);
		}

		Claims claims = jwtTokenUtil.getClaimsFromToken(authToken);
		if (Objects.isNull(claims) || jwtTokenUtil.isTokenExpired(authToken)){
			throw new AutoTokenException(ResultCode.UNAUTHORIZED);
		}
		CustomerContext.setCustomerId(claims.get("customerId",Integer.class));
		CustomerContext.setKeyCustomerTelephone(claims.get("phone",String.class));
		return  true;
	}
}
