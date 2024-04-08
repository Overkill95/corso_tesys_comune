package com.controller.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LatrinaFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 	HttpServletRequest httpReq = (HttpServletRequest) request;
		    HttpServletResponse httpResp = (HttpServletResponse) response;
		    HttpSession session = httpReq.getSession(false);
		    chain.doFilter(request, response);
		
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	  System.out.println("init");
	}
	
	@Override
	  public void destroy() {
		System.out.println("destroy");
	}

}
