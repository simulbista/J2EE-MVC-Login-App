<!-- User login form  = passes control to controller i.e. EmployeeController.java-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form method="post" action="EmployeeController" >
		<pre>
			<b>User Login</b>
			Username: <input type="text" name="uname"/>
			Password: <input type="password" name="pass"/>
			<input type="submit" value="login"/>
		</pre>
	</form>
</body>
</html>