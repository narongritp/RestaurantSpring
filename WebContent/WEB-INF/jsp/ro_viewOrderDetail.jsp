<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="th.co.aware.bean.OrderListBean"%>
<%@page import="java.util.List"%>
<%@page import="th.co.aware.bean.OrderBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Order Detail</title>
<%@include file="include/style.jsp"%>
</head>
<body style="font-family:'tahoma';">
<hr>
<%@include file="include/navigatevalidate.jsp"%><br><br>
<div align='right'>
<a href='/RestaurantSpring/order-manage/commitOrder'>
<button style="height:40px;width:100px">Submit Order</button></a>

</div>
<hr>
<center><h3>ORDER</h3></center>
<div class="content80">
	<table align="center" border="1" width="100%">
		<th>TABLE</th>
		<th width="80%" height="60px">DETAIL</th>
		<%
			Object objSes = session.getAttribute(MYKEY.SES_ORDER);
			Object objlistSes = session.getAttribute(MYKEY.SES_ORDERLIST);
			if (objSes != null) {
				OrderBean ob = (OrderBean) objSes;
				out.print("<tr align='center' height='40px'>");
				out.print("<td colspan='2'>" + ob.getDetail()+"</td>");
				out.print("</tr>");
			}
		%>
	</table>
	<br><br><hr>
	<center><h3>FOOD LIST</h3></center>
	<table width="60%" border="1" align="center">
		<th height="60px">NO.</th>
		<th>FOOD NAME</th>
		<th>PRICE</th>
		<th>AMOUNT</th>
		<th>TOTAL</th>
		<%
			if(objlistSes!=null){
				double netTotal = 0;
				Map<Integer,OrderListBean> list = (Map<Integer,OrderListBean>)objlistSes;
				Set<Integer> key = list.keySet();
				Iterator<Integer> ite = key.iterator();
				DecimalFormat df = new DecimalFormat("#,###");
				for(int i=0;ite.hasNext();i++){
					Integer foodId = (Integer)ite.next();
					OrderListBean olb = list.get(foodId);
					out.print("<tr align='center' height='40px'>");
					out.print("<td>"+(i+1)+"</td>");
					out.print("<td>"+olb.getFoodName()+"</td>");
					out.print("<td>"+olb.getPrice()+"</td>");
					out.print("<td>"+olb.getAmount()+"</td>");
					out.print("<td>"+df.format(olb.getTotalPrice())+"</td>");
					out.print("</tr>");
					netTotal+=olb.getTotalPrice();
				}
				out.print("<tr align='center'>");
				out.print("<td colspan='4'><b>Net Total(THB)</b></td>");
				out.print("<td>"+df.format(netTotal)+"</td>");
				out.print("</tr>");
			}
		%>
	</table>
	</div>
</body>
</html>