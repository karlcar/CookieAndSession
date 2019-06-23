<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="loginServlet" method="post">
		<input type="text" name="username"><br>
		<input type="password" name="password"><br>
		<input type="checkbox" name="havecookie" value="yes">免登录<br>
		<input type="submit" value="提交">
	</form>
</body>
</html>