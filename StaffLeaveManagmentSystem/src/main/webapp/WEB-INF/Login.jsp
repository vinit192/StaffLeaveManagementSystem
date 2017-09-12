<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Staff Leave Management System</title>
</head>
<body>
	<p><font color="red">${errorMessage }</font></p>
	<form action="/Login" method="post">
		Username:<br>
		<input type="text" name="username" required="required"><br>
		Password:<br>
		<input type="password" name="password" required="required"><br><br>
		<input type="submit" value="Login" name="login">
	</form>
	<br>
	<a href="/Register">Click Here To Register </a>
	
</body>
</html>