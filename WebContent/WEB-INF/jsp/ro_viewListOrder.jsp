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
.tdId {
	width: 10%;
}

.tdUIdO {
	width: 15%;
}

.tdUIdC {
	width: 15%;
}

.tdStat {
	width: 5%;
}

.tdD1 {
	width: 10%;
}

.tdD2 {
	width: 10%;
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
	<table width="90%" align="center" border="1">
		<th>ID</th>
		<th>RECIEVE ORDERS ID</th>
		<th>COOKER ID</th>
		<th>DETAIL</th>
		<th>STATUS</th>
		<th>ORDER DATE</th>
		<th>COMMIT DATE</th>
		<th></th>
		<%
			Object obj = request.getAttribute("listOrder");
			if (obj != null) {
				List<OrderBean> listOrder = (List<OrderBean>) obj;
				for (OrderBean ob : listOrder) {
					out.print("<tr align='center'>");
					out.print("<td class='tdId'>" + ob.getOrderId() + "</td>");
					out.print("<td class='tdUIdO'>" + ob.getUserIdOrdering() + "</td>");
					out.print("<td class='tdUIdC'>" + ((ob.getUserIdCommit() > 0) ? ob.getUserIdCommit() : "--")
							+ "</td>");
					out.print("<td>(table:" + ob.getDetail().split("&")[0] + ")&nbsp;" + ob.getDetail().split("&")[1]
							+ "</td>");
					out.print("<td class='tdStat'>" + ob.getStatus() + "</td>");
					out.print("<td class='tdD1'>" + ob.getOrderDate().toString() + "</td>");
					String commitdate = (ob.getCommitDate() != null) ? ob.getCommitDate().toString() : "--";
					out.print("<td class='tdD2'>" + commitdate + "</td>");
					out.print("<td><button>View</button></td>");
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