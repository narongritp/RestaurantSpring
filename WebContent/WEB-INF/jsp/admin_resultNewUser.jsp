<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Information</title>
<%@include file="include/style.jsp"%>
</head>
<body style="font-family:'tahoma';">
<div class="content80">
<center>
	<fieldset style="width: 40%">
		<legend>Login</legend>
		<table align="center">
			<tr>
				<td>Username :</td>
				<td>${user.username}</td>
			</tr>
			<tr>
				<td>Password :</td>
				<td>${user.password}</td>
			</tr>
			<tr>
				<td>First Name :</td>
				<td>${user.firstName }</td>
			</tr>
			<tr>
				<td>Last Name :</td>
				<td>${user.lastName }</td>
			</tr>
			<tr>
				<td>Telephone :</td>
				<td>${user.telephone }</td>
			</tr>
			<tr>
				<td>Position :</td>
				<td>${user.type }</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="/RestaurantSpring/">Back to menu</a>
				</td>
			</tr>
		</table>
	</fieldset>
	</center>
	</div>
</body>
</html>