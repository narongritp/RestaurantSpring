<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
				<td class="heading">DETAIL</td>
				<td class="heading"></td>
			</tr>
			<c:forEach var="order" items="${model.allOrderServed}">
				<tr align="center" style="border: 1px solid;background-color: #81BEF7;">
					<td>${order.orderId}</td>
					<td>${order.status}</td>
					<td>${order.orderDate}</td>
					<td>${order.detail}</td>
					<td><a href="checkout?orderId=${order.orderId}">
						<button style="width:100%;height:40px">Check out!</button></a>
					</td>
				</tr>
				<c:set var="sum" value="${0}"/>  
				<c:forEach var="item" varStatus="i" items="${model.allItemServed[order.orderId] }">
					<tr  style="border: 0px solid;background-color: #CEE3F6;">
						<td >&nbsp;</td>
						<td colspan="2">${i.index+1 }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${item.foodName}
						&nbsp;&nbsp;&nbsp;(THB&nbsp;${item.getPriceFormat()}) </td>
						<td align="right">${item.amount} ea.   (THB&nbsp;${item.getTotalPriceFormat()})</td>
						<td></td>
					</tr>
					<c:set var="sum" value="${sum + item.getTotalPrice()}"/> 
				</c:forEach>
				<tr>
					<td colspan="3" align="right"><b>NET TOTAL   :</b></td>
					<td align="center"><fmt:formatNumber type="number" maxFractionDigits="3" value="${sum}" /> THB</td>
					<td>&nbsp;</td>
				</tr>
			</c:forEach>
			
			<c:forEach var="order" items="${model.allOrderCheck}">
				<tr align="center" style="border: 1px solid;background-color: #ACFA58;height:40px">
					<td>${order.orderId}</td>
					<td>${order.status}</td>
					<td>${order.orderDate}</td>
					<td>${order.detail}</td>
					<td><strong><font color='green'>Success</font></strong></td>
<!-- 					<td> -->
<%-- 					<a href="view?orderId=${order.orderId}"> --%>
<!-- 						<button style="width:100%;height:40px">View</button></a> -->
<!-- 					</td> -->
				</tr>
				<c:set var="sum" value="${0}"/>  
				<c:forEach var="item" varStatus="i" items="${model.allItemCheck[order.orderId] }">
					<tr  style="border: 0px solid;background-color: #D0F5A9;">
						<td >&nbsp;</td>
						<td colspan="2">${i.index+1 }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${item.foodName}
						&nbsp;&nbsp;&nbsp;(THB&nbsp;${item.getPriceFormat()}) </td>
						<td align="right">${item.amount} ea.   (THB&nbsp;${item.getTotalPriceFormat()})</td>
						<td></td>
					</tr>
					<c:set var="sum" value="${sum + item.getTotalPrice()}"/> 
				</c:forEach>
				<tr>
					<td colspan="3" align="right"><b>NET TOTAL   :</b></td>
					<td align="center"><fmt:formatNumber type="number" maxFractionDigits="3" value="${sum}" /> THB</td>
					<td>&nbsp;</td>
				</tr>
			</c:forEach>
		</table>
		</div>
</body>
</html>