package com.karl.login;

import javax.servlet.http.Cookie;

public class CookieUtil {
	public static boolean CheckCookie(Cookie[] cookies) {
		boolean sign = false;
		for (int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("username") && cookies[i].getValue().equals("yes")) {
				return true;
			}
		}
		return sign;
	}
}
