<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prepare Check Out</title>
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
<body style="font-family: 'tahoma';">
	<h1>PREPARE CHECK OUT</h1>
	<hr>
	<%@include file="include/navigatevalidate.jsp"%><br>
	<br>
	<div align='right'>
		<a href="">
		<button style="width:100px;height:60px">CHECK OUT!</button></a>
	</div>
	<hr>
<div class="content">
	<table border="1" width="100" align="center">
		<tr align="center">
			<td class="heading">ORDER ID ${order.orderId}</td>
			<td class="heading">ORDER DATE ${order.commitDate}</td>
			<td colspan="2" class="heading">DETAIL ${order.detail}</td>
		</tr>
		
		<c:set var="sum" value="${0}" />
		<c:forEach var="item" varStatus="i" items="${model.allItem[order.orderId] }">
			<tr style="border: 0px solid; background-color: #CEE3F6;">
				<td>${i.index+1 }</td>
				<td colspan="2">${item.foodName}   (THB&nbsp;${item.getPriceFormat()})</td>
				<td align="right">${item.amount}ea.
					(THB&nbsp;${item.getTotalPriceFormat()})</td>
				<td>
			</tr>
			<c:set var="sum" value="${sum + item.getTotalPrice()}" />
		</c:forEach>
		<tr>
			<td colspan="3" align="right"><b>NET TOTAL  :</b></td>
			<td>THB 
				<fmt:formatNumber type="number" maxFractionDigits="3"value="${sum}" />		
			</td>
		</tr>
	</table>
	</div>
</body>
</html>