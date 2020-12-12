package com.myclass.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myclass.constants.UrlConstants;
import com.myclass.dto.UserDto;
/*
 * Create by Hoang Nguyen
 */
@WebFilter(urlPatterns = {"/*"})
public class AuthFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String action = req.getServletPath();
		if(action.equals(UrlConstants.URL_LOGIN)) {
			chain.doFilter(request, response);
			return;
		}
		HttpSession session = req.getSession();
		if(session.getAttribute(UrlConstants.USER_LOGIN)==null) {
			resp.sendRedirect(req.getContextPath() + UrlConstants.URL_LOGIN);
			return;
		}
		
		UserDto user = (UserDto)session.getAttribute(UrlConstants.USER_LOGIN);
		
		String roleName = user.getRoleDesc();
		if(action.startsWith(UrlConstants.URL_ROLE) && !roleName.equals(UrlConstants.ROLE_ADMIN)) {
			resp.sendRedirect(req.getContextPath() + "/error/403");
			return;
		}
		if(action.startsWith(UrlConstants.URL_USER) && (roleName.equals(UrlConstants.ROLE_ADMIN)|| roleName.equals(UrlConstants.ROLE_MANAGER))){
			resp.sendRedirect(req.getContextPath() + "/error/403");
			return;
		}
		chain.doFilter(request, response);
	}
	
}
