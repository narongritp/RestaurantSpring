<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<%@include file="include/style.jsp"%>
</head>
<body style="font-family:'tahoma';">
	<center>
		<h1>Welcome to Restaurant Management System</h1>
	</center>
	<hr>
	<center>
		<fieldset style="width:40%">
			<legend>Login</legend>
			<form:form method="POST" action="/RestaurantSpring/validate/login"
				modelAttribute="user">
				<table>
					<tr>
						<td>Username :</td>
						<td><form:input path="username" /></td>
					</tr>
					<tr>
						<td>Password :</td>
						<td><form:input path="password" type="password" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Login" /></td>
					</tr>
				</table>
			</form:form>
		</fieldset>
	</center>
</body>
</html>