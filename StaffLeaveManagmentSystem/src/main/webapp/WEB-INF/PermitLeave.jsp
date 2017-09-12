<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Staff Leave Management System Permit Leave</title>
</head>
<body>
	<form action="" method="post">
		welcome ${username}<br><br>
		Staff Id<br>
		<input type="text" name="staffid" value="${staffId}" disabled="disabled"><br><br>
		To<br>
		<input type="date" name="to"><br><br>
		From<br>
		<input type="date" name="from"><br><br>
		Reason<br>
		<input type="text" name="reason"><br><br>
			
		<input type="submit" value="Grant Leave">
	</form>
</body>
</html>