<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Order Detail</title>
<style type="text/css">
.heading {
	font-size: 18px;
	font: bold;
	background-color: orange;
	border: thick;
}
</style>
<%@include file="include/style.jsp"%>
</head>
<body style="font-family:'tahoma';">
	<h1>VIEW ORDER DETAIL</h1>
	<hr>
	<%@include file="include/navigatevalidate.jsp"%><br>
	<br>
	<div align='right'>
	
	</div>
	<hr>
	<div class="content">
	<table border="1" width="100%" align="center">
			<tr align="center">
				<td class="heading">ORDER ID</td>
				<td class="heading">STATUS</td>
				<td class="heading">ORDER DATE</td>
				<td class="heading"></td>
			</tr>
			<c:forEach var="order" items="${model.allOrder}">
				<tr align="center" style="border: 1px solid;background-color: #E6E6E6;">
					<td>${order.orderId}</td>
					<td>${order.status}</td>
					<td>${order.orderDate}</td>
					<td><a href="commit?orderId=${order.orderId}">
						<button style="width:100%;height:40px">Commit</button></a>
					</td>
				</tr>
				<c:forEach var="item" varStatus="i" items="${model.allItem[order.orderId] }">
					<tr  style="border: 0px solid;">
						<td >&nbsp;</td>
						<td colspan="2"]>${i.index+1 }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${item.foodName}</td>
						<td align="right">${item.amount} ea.</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
	</div>
</body>
</html>