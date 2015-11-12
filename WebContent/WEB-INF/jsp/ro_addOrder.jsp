<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Order</title>
<%@include file="include/style.jsp"%>
</head>
<body style="font-family:'tahoma';">
<div class="content">
	<center>
		<fieldset style="width:40%">
			<legend>Information form</legend>
			<form method="POST" action="/RestaurantSpring/order-manage/addOrder">
				<table>
					<tr>
						<td>Table:</td>
						<td><input type="text" name="table" /></td>
					</tr>
					<tr>
						<td>Detail:</td>
						<td><input type="text" name="detail" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td colspan="2"><input type="submit" name="value" value="Select" /></td>
					</tr>
				</table>
			</form>
		</fieldset>
	</center>
	</div>
</body>
</html>