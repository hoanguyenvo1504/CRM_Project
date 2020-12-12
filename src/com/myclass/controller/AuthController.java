package com.myclass.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myclass.constants.UrlConstants;
import com.myclass.dto.UserDto;
import com.myclass.services.UserServices;

/*
 * Create by Hoang Nguyen
 */
@WebServlet(urlPatterns = { UrlConstants.URL_LOGIN, UrlConstants.URL_LOGOUT })
public class AuthController extends HttpServlet{
	private UserServices userService = null;
	public AuthController() {
		userService = new UserServices();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getServletPath();

		switch (action) {
		case UrlConstants.URL_LOGIN:
			req.getRequestDispatcher("/WEB-INF/views/auth/index.jsp").forward(req, resp);
			break;
		case UrlConstants.URL_LOGOUT:
			HttpSession session = req.getSession();
			if (session.getAttribute(UrlConstants.USER_LOGIN) != null) {
				session.removeAttribute(UrlConstants.USER_LOGIN);
			}
			resp.sendRedirect(req.getContextPath() + UrlConstants.URL_LOGIN);
			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");

		UserDto userDto = userService.checkLogin(email, pass);
		if (userDto == null) {
			req.setAttribute("message", "Email hoặc mật khẩu không đúng!");
			req.getRequestDispatcher("/WEB-INF/views/auth/index.jsp").forward(req, resp);
			return;
		}
		
		HttpSession session = req.getSession();
		session.setAttribute(UrlConstants.USER_LOGIN, userDto);

		resp.sendRedirect(req.getContextPath() + UrlConstants.URL_HOME);
	}
}
