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
		<font size="6px" style="text-shadow: 5px 5px 5px #6E6E6E;" color='white'>
		<strong>Restaurant Management System</strong>
		</font>
	</center>
	<hr>
	<br>
	<br>
	<div class="content30" >
			<form:form method="POST" action="/RestaurantSpring/validate/login"
				modelAttribute="user">
				<table align="center" cellpadding="15px" style="box-shadow: 5px 10px 100px #9A7143;">
					<tr style="background-color: #91B331">
						<td colspan="2" align="center">
							<font color='white' size='10px' style="text-shadow: 5px 5px 5px #6E6E6E;">
							LOG IN</font>
						</td>
					</tr>
					<tr style="background-color: #677F24;height:5px "><td colspan="2"></td></tr>
					<tr style="background-color: #CE8C41">
<!-- 						<td> -->
<!-- 						<font color='white' size='4px' style="text-shadow: 5px 5px 5px #6E6E6E;"> -->
<!-- 						USERNAME :</font></td> -->
						<td colspan="2"><form:input path="username" style="height:40px;width:240px;font-size:20px;margin-left:80px;margin-right:80px;box-shadow: 5px 5px 10px #9A7143;" placeholder='Username'/></td>
					</tr>
					<tr style="background-color: #CE8C41">
<!-- 						<td> -->
<!-- 						<font color='white' size='4px' style="text-shadow: 5px 5px 5px #6E6E6E;"> -->
<!-- 						PASSWORD :</font></td> -->
						<td colspan="2"><form:input path="password" type="password" style="height:40px;width:240px;font-size:20px;margin-left:80px;margin-right:80px;box-shadow: 5px 5px 10px #9A7143;" placeholder='Password'/></td>
					</tr>
					<tr style="background-color: #AA7D4A;height:5px;"><td colspan="2"></td></tr>
					<tr style="background-color: #CE8C41">
						<td colspan="2"><input type="submit" value="LOG IN" 
						style="width: 100%;height: 50px;background-color: #9A7143;font-size: 20px;color: white;text-shadow: 5px 5px 5px #6E6E6E;
						border-radius:10px;box-shadow: 0px 5px 5px #9A7143;"/></td>
					</tr>
				</table>
			</form:form>
	</div>
</body>
</html>