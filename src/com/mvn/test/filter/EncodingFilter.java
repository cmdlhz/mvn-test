package com.mvn.test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebFilter("/EncodingFilter")
public class EncodingFilter implements Filter {
	private String charSet = "UTF-8";
	
	// 누군가 바로 호출하는 것
    public EncodingFilter() {
//    	System.out.println("나 무조건 실행 (EncodingFiter())");
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 요청할 때
		HttpServletRequest req = (HttpServletRequest)request;
		req.setCharacterEncoding(this.charSet);
		System.out.println("1.doFilter() @ EncodingFilter");
//		System.out.println(req.getCharacterEncoding());
		
		// 결과값은 따로 찍어줘야 함
		HttpServletResponse res = (HttpServletResponse)response;
		// 항상 "json"이 좋은 것은 아님. html이 필요할 수도
		res.setContentType("application/json;charset=" + this.charSet);
		chain.doFilter(request, response);
	}

	// 메모리가 생긴 후 실행되기 때문에, 서버가 켜져있으면 무조건 실행됨
	public void init(FilterConfig fConfig) throws ServletException {
		String className = "com.mvn.test.filter.EncodingFilter";
		// web-xml 에서 
		String charSet = fConfig.getInitParameter("charSet");
		if(charSet != null) {
			this.charSet = charSet;
		}
		System.out.println("charSet : " + charSet); // charSet : UTF-8
	}
}
