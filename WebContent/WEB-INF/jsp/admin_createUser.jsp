<%@page import="th.co.aware.config.MYKEY"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New User</title>
<%@include file="include/style.jsp"%>
</head>
<body style="font-family:'tahoma';">
<div class="content80">
	<center>
		<fieldset style="width:40%">
			<legend>Information form</legend>
			<font color="red">${map.message}</font>
			<form:form method="POST" action="/RestaurantSpring/user-manage/createUser"
				modelAttribute="user">
				<table>
					<tr>
						<td>Username:</td>
						<td><form:input path="username" /></td>
					</tr>
					<tr>
						<td>First Name:</td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td>Last Name:</td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td>Telephone:</td>
						<td><form:input path="telephone" /></td>
					</tr>
					<tr>
						<td>Position:</td>
						<td><form:select path="type" items="${map.position}" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td colspan="2"><input type="submit" value="Submit" /></td>
					</tr>
				</table>
			</form:form>
		</fieldset>
	</center>
	</div>
</body>
</html>