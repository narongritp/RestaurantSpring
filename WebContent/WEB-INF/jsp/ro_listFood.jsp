<%@page import="th.co.aware.bean.UserBean"%>
<%@page import="th.co.aware.config.MYKEY"%>
<%@page import="th.co.aware.bean.FoodBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Food Menu</title>
<%@include file="include/style.jsp"%>
</head>
<body style="font-family:'tahoma';">
<h1>Food Menu</h1>
<hr>
<%@include file="include/navigatevalidate.jsp"%>
<hr>
	<table width="60%" align="center" border="1">
		<%
			Object obj = request.getAttribute("listFood");
			if (obj != null) {
				List<FoodBean> list = (List<FoodBean>) obj;
				int idx = 0;
				for (int row = 0; row <= list.size() / 4; row++) {
					out.print("<tr align='center'>");
					for (int col = 0; col < 4; col++) {
						if (idx < list.size()) {
							out.print("<td>");
							out.print("<a href='detail-food?foodId="+list.get(idx).getFoodId()+" '>");
							String pic = list.get(idx).getPicture()!=null?list.get(idx).getPicture():"http://localhost/tmppicture/empty.png";
							out.print("<img src='"+pic+"' width='240px' height='190px'/>");
							out.print("</a><br>");
							out.print("<b>"+list.get(idx).getFoodId() +"||"+ list.get(idx).getName() + "</b>");
							out.print("</td>");
							idx++;
						}
					}
					out.print("</tr>");
				}
			} else {
				out.print("<font size='10' color='red'>data is empty</font>");
			}
		%>

	</table>
</body>
</html>