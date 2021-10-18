package com.meituan.waimai.business.Interceptor;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.meituan.waimai.common.WmContext;
import com.meituan.waimai.common.api.ResultCode;
import com.meituan.waimai.common.exception.AutoTokenException;
import com.meituan.waimai.common.util.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContextInterceptor implements HandlerInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContextInterceptor.class);

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Value("${jwt.tokenHeader}")
	private String tokenHeader;
	@Value("${jwt.ignored.urls}")
	private List<String> urls = new ArrayList<>();


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
		LOGGER.info("checking authHeader:{}", authToken);

		if (StrUtil.isNotBlank(authToken)){
			Claims claims = jwtTokenUtil.getClaimsFromToken(authToken);
			if (Objects.isNull(claims) || jwtTokenUtil.isTokenExpired(authToken)){
				throw new AutoTokenException(ResultCode.UNAUTHORIZED);
			}
			JSONObject jsonObject = JSONObject.parseObject(claims.getSubject());
			WmContext.setUserID(jsonObject.getInteger("id"));
			WmContext.setUserAccount(jsonObject.getString("account"));
			WmContext.setUserName(jsonObject.getString("userName"));
			return  true;
		}
		return false;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}
}
