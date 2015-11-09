<%-- <%@page import="th.co.aware.bean.UserBean"%> --%>
<%-- <%@page import="th.co.aware.config.MYKEY"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
<style type="text/css">
table, th {
	align: center;
	border: 1px solid;
	border-collapse: collapse;
}

td {
	width: 25%;
	border: 1px solid;
}
</style>
</head>
<body style="font-family:'tahoma';">
	<h1>Welcome to Restaurant Management System</h1>
	<hr>
	<%@include file="include/navigate.jsp"%>
	<hr>
	<table width="100%" align="center">
		<th><h2>General</h2></th>
		<th><h2>Administrator</h2></th>
		<th><h2>User</h2></th>
		<th><h2>System Test menu</h2></th>
		<tr align="center">
			<td>
				<h3>
					<a href="login"><b>login</b></a>
				</h3>
				<br>
			</td>
			<!-- ==================================================== -->
			<td>

				<h3>
					<a href="user-manage/create-user"><b>new user</b></a>
				</h3>
				<br>
			</td>
			<!-- ==================================================== -->
			<td>
				<h3><a href="food-manage/list-food"><b>list food</b></a></h3><br>
<!-- 				<h3><a href="food-manage/list-food"><b>list food</b></a></h3><br> -->
				-----<br>
				<h3><a href="order-manage/add-order"><b>new order</b></a></h3><br>
				<h3><a href="order-manage/view-listorder"><b>list order</b></a></h3><br>
			</td>
			<!-- ==================================================== -->
			<td>
				<h3>
					<a href="test/print"><b>test print</b></a>
				</h3>
				<br>
				<h3>
					<a href="test/remove-session"><b>clear session</b></a>
				</h3>
				<br>
			</td>
		</tr>
	</table>
</body>
</html>