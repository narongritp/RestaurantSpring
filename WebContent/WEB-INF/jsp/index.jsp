<%-- <%@page import="th.co.aware.bean.UserBean"%> --%>
<%-- <%@page import="th.co.aware.config.MYKEY"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
<%@include file="include/style.jsp"%>
<style type="text/css">
.menuBt{
	width: 200px;
	height: 40px;
}
</style>
</head>
<body style="font-family:'tahoma';">
	<center>
		<font size="6px" style="text-shadow: 5px 5px 5px #6E6E6E;" color='white'>
		<strong>Welcome to Restaurant Management System</strong>
		</font>
	</center>
	<hr>
	<div class="navbar" align="right">
	<%@include file="include/navigate.jsp"%>
	<a href="/RestaurantSpring/test/remove-session">
	<button style="width: 100px;height: 30px;margin-left: 20px;">Log out</button></a>
	</div>
	<hr>
	<div class="content80" style="background-color: #FFDFB9;">
	<table align="center" cellpadding="5px">
	<%
		if(type==1){
%>
			<tr align="center">
				<td><font class="fontH1">Administrator Menu</font></td>
			</tr>
			<tr align="center">
				<td><a href="/RestaurantSpring/admin/manage-user">
				<button class='menuBt'>User Management</button></a></td>
			</tr>
			<tr align="center">
				<td><a href="/RestaurantSpring/admin/manage-foodmenu">
				<button class='menuBt'>Food Management</button></a></td>
			</tr>
			<tr align="center">
				<td><a href="/RestaurantSpring/order-manage/view-listorder">
				<button class='menuBt'>Order Management</button></a></td>
			</tr>
<%
		}
		if(type==1||type==2){
%>
			<tr align="center">
				<td><font class="fontH1">Recieve Orders Menu</font></td>
			</tr>
				<%
					Object obj = session.getAttribute(MYKEY.SES_ORDER);
				if(obj==null){
					%>
					<tr align="center">
					<td><a href="/RestaurantSpring/order-manage/add-order">
					<button class='menuBt'>New Order</button></a></td></tr>
					<tr align="center">
					<td><a href="/RestaurantSpring/food-manage/list-food">
					<button class='menuBt'>Food Menu</button></a></td></tr>
					<tr align="center">
					<td><button class='menuBt' disabled>No Order</button></td></tr>
					<%
				}else{
					%>
					<tr align="center">
					<td><button class='menuBt' disabled>(Already order session)</button></td></tr>
					<tr align="center">
					<td><a href="/RestaurantSpring/order-manage/add-order">
					<button class='menuBt'>Food Menu</button></a></td></tr>
					<tr><td><a href="/RestaurantSpring/order-manage/commitOrder">
					<button class='menuBt'>Commit Order</button></a></td></tr>
					<%
				}
				%>
			
<%
		}
		if(type==1||type==3){
%>
			<tr align="center">
				<td><font class="fontH1">Cooker Menu</font></td></tr>
			<tr align="center">
			<td><a href="/RestaurantSpring/cooker/view-orderlist">
			<button class='menuBt'>View Order Remaining</button></a></td></tr>
<%
		}
		if(type==1||type==4){
%>
			<tr align="center">
				<td><font class="fontH1">Waitress Menu</font></td></tr>
				<tr align="center">
				<td><a href="/RestaurantSpring/waitress/view-orderlist">
				<button class='menuBt'>View Ready Order</button></a></td></tr>
			
<%
		}
		if(type==1||type==5){
%>
			<tr align="center">
				<td><font class="fontH1">Cashier Menu</font></td></tr>
			<tr align="center">
			<td><a href="/RestaurantSpring/cashier/view-orderlist">
			<button class='menuBt'>Manage Order</button></a></td></tr>
<%
		}
	%>
	</table>
	</div>
</body>
</html>