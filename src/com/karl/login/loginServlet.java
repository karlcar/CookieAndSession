package com.karl.login;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1、从页面获取信息，包括用户名，密码，是否免登录，检查是否有cookie，如果有，生成一个session
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String havecookie = request.getParameter("havecookie");

		Cookie[] cookies = request.getCookies();
		boolean sign = CookieUtil.CheckCookie(cookies);

		HttpSession session = request.getSession();
		if(session.getAttribute("username") != null) {
			if(!username.equals(session.getAttribute("username"))) {
				session.setAttribute("username", "username");
			}
		}
		
		if (sign) {
			// 已经登录过,自动创建一个session
			session.setAttribute("username", username);
			response.sendRedirect("admin/admin.jsp");
			return;
		}

		// 2、判断用户账号密码是否正确
		if (username.equals("admin") && password.equals("1234")) {
			session.setAttribute("username", username);
			// 之后再检查是否有cookie
			if (havecookie != null && havecookie.equals("yes")) {
				Cookie cookie = new Cookie("username", "yes");
				response.addCookie(cookie);
			}
			response.sendRedirect("admin/admin.jsp");
			return;
		}
		response.sendRedirect("login.jsp");
		return;

		// 3、账号密码正确，写cookie给客户端，写一个session给服务端
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
