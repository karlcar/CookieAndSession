<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
out.print(session.getId());
Cookie cookie = new Cookie("name","car");
cookie.setMaxAge(5);
response.addCookie(cookie);

Cookie[]  cookies = request.getCookies();
for(int i=0; i<cookies.length; i++){
	Cookie ck = cookies[i];
	String name = ck.getName();
	String value = ck.getValue();
	out.print(name + "=" + value);
}
%>
</body>
</html>