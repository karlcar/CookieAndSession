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
		// 1����ҳ���ȡ��Ϣ�������û��������룬�Ƿ����¼������Ƿ���cookie������У�����һ��session
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
			// �Ѿ���¼��,�Զ�����һ��session
			session.setAttribute("username", username);
			response.sendRedirect("admin/admin.jsp");
			return;
		}

		// 2���ж��û��˺������Ƿ���ȷ
		if (username.equals("admin") && password.equals("1234")) {
			session.setAttribute("username", username);
			// ֮���ټ���Ƿ���cookie
			if (havecookie != null && havecookie.equals("yes")) {
				Cookie cookie = new Cookie("username", "yes");
				response.addCookie(cookie);
			}
			response.sendRedirect("admin/admin.jsp");
			return;
		}
		response.sendRedirect("login.jsp");
		return;

		// 3���˺�������ȷ��дcookie���ͻ��ˣ�дһ��session�������
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
