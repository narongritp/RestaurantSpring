<%@page import="th.co.aware.config.MYKEY"%>
<%@page import="th.co.aware.bean.OrderBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Order</title>
<%@include file="include/style.jsp"%>
<style>
.heading {
	font-size: 18px;
	font: bold;
	background-color: orange;
	border: thick;
}
</style>
</head>
<body style="font-family: 'tahoma';">
	<h1>LIST ORDER</h1>
	<hr>
	<%@include file="include/navigatevalidate.jsp"%><br>
	<br>
	<div align='right'>
	</div>
	<hr>
	<table align="center" border="1" width="90%">
		<tr align="center">
			<td class="heading" width="10%" height="60px">ID</td>
			<td class="heading" width="15%">RECIEVE ORDERS ID</td>
			<td class="heading" width="10%">COOKER ID</td>
			<td class="heading" >DETAIL</td>
			<td class="heading" >STATUS</td>
			<td class="heading" width="10%">ORDER DATE</td>
			<td class="heading" width="10%">COMMIT DATE</td>
			<td class="heading"></td>
		</tr>
		<%
			Object obj = request.getAttribute("listOrder");
			if (obj != null) {
				List<OrderBean> listOrder = (List<OrderBean>) obj;
				for (OrderBean ob : listOrder) {
					String color = "white";
					if(ob.getStatus().equals("Wait"))color="#E6E6E6";
					else if(ob.getStatus().equals("In progress"))color="#F3F781";
					else if(ob.getStatus().equals("Served"))color="#81BEF7";
					else if(ob.getStatus().equals("Checked out"))color="#ACFA58";
					out.print("<tr align='center' style='background-color:"+color+";'>");
					out.print("<td>" + ob.getOrderId() + "</td>");
					out.print("<td>" + ob.getUserIdOrdering() + "</td>");
					out.print("<td>" + ((ob.getUserIdCommit() > 0) ? ob.getUserIdCommit() : "--")
							+ "</td>");
					out.print("<td>" + ob.getDetail()+"</td>");
					out.print("<td>" + ob.getStatus() + "</td>");
					out.print("<td>" + ob.getOrderDate().toString() + "</td>");
					String commitdate = (ob.getCommitDate() != null) ? ob.getCommitDate().toString() : "--";
					out.print("<td>" + commitdate + "</td>");
					out.print("<a href=''>");
					%>
					<td><button style="width:100%;height:50px;">View</button></td>
					<%
					out.print("</a>");
					out.print("</tr>");
				}
			} else {
				out.print("<tr align='center'>");
				out.print("<td>--</td>");
				out.print("<td>--</td>");
				out.print("<td>--</td>");
				out.print("<td>--</td>");
				out.print("<td>--</td>");
				out.print("<td>--</td>");
				out.print("<td>--</td>");
				out.print("<td>--</td>");
				out.print("</tr>");
			}
		%>
	</table>


</body>
</html>