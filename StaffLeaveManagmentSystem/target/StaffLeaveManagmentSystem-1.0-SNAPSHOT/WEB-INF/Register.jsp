<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Staff Leave Management System Registration</title>
</head>
<body>
	<form action="/Register" method="post">
		Name:<br>
		<input type="text" name="name" required><br>
		Email:<br>
		<input type="text" name="email" required><br>
		Username:<br>
		<input type="text" name="username" required><br>
		Password:<br>
		<input type="password" name="password" required><br>
		Contact No:<br>
		<input type="text" name="contactno" required><br><br>
		
		<input type="submit" value="Register">
	</form>
	<br>
	<a href="/Login">Click Here If Already Register </a>
</body>
</html>