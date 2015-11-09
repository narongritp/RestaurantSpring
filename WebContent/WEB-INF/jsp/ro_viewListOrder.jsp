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

</head>
<body style="font-family: 'tahoma';">
	<h1>List Order</h1>
	<hr>
	<table width="80%" align="center" border="1">
		<th>ID</th>
		<th>Recieve Orders ID</th>
		<th>Cooker ID</th>
		<th>Detail</th>
		<th>Status</th>
		<th>Order Date</th>
		<th>Commit Date</th>
		<th></th>
		<%
			Object objSes = session.getAttribute(MYKEY.SES_ORDER);
			if (objSes != null) {
				OrderBean ob = (OrderBean) objSes;
				out.print("<tr align='center'>");
				out.print("<td><font color='red'>Wait commit..</font></td>");
				out.print("<td>" + ob.getUserIdOrdering() + "</td>");
				out.print("<td>--</td>");
				out.print("<td>(table:" + ob.getDetail().split("&")[0] + ")&nbsp;" + ob.getDetail().split("&")[1]
						+ "</td>");
				out.print("<td>" + ob.getStatus() + "</td>");
				out.print("<td>--</td>");
				out.print("<td>--</td>");
				out.print("<td>--</td>");
				out.print("</tr>");
			}
			Object obj = request.getAttribute("listOrder");
			if (obj != null) {
				List<OrderBean> listOrder = (List<OrderBean>) obj;
				for (OrderBean ob : listOrder) {
					out.print("<tr align='center'>");
					out.print("<td>" + ob.getOrderId() + "</td>");
					out.print("<td>" + ob.getUserIdOrdering() + "</td>");
					out.print("<td>" + ob.getUserIdCommit() + "</td>");
					out.print("<td>(table:" + ob.getDetail().split("&")[0] + ")&nbsp;" + ob.getDetail().split("&")[1]
							+ "</td>");
					out.print("<td>" + ob.getStatus() + "</td>");
					out.print("<td>" + ob.getOrderDate().toString() + "</td>");
					String commitdate = (ob.getCommitDate() != null) ? ob.getCommitDate().toString() : "--";
					out.print("<td>" + commitdate + "</td>");
					out.print("<button>View</button");
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
	<p id="amount"></p>


	<button onclick="add()">+</button>
	<button onclick="minus()">-</button>

	<script type="text/javascript">
		var num = 1;
		document.getElementById("amount").innerHTML = num;
		
		
		function add() {
			var x = num;
			x = num++;
			document.getElementById("amount").innerHTML = num;
		}

		function minus() {
			var x = num;
			x = num--;
			document.getElementById("amount").innerHTML = num;
		}
	</script>

</body>
</html>