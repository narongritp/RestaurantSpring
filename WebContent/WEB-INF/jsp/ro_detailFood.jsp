<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Food Details</title>
	<style type="text/css">
		p {
			font-size:16px;
		}
	</style>
</head>
<body style="font-family:'tahoma';">
	<table border="1" align="center">
		<tr align="center">
			<td colspan="2"><img src=${food.picture } width="350px" height="250px"/></td>
		</tr>
		<tr>
			<td align="right"><p>Name :</p></td>
			<td style="padding-left:30px" ><p>${food.name }</p></td>
		</tr>
		<tr>
			<td align="right"><p>Category :</p></td>
			<td style="padding-left:30px" ><p>${food.type }</p></td>
		</tr>
		<tr>
			<td align="right"><p>Price :</p></td>
			<td style="padding-left:30px" ><p>${food.price }</p></td>
		</tr>
		<tr align="center">
			<td></td>
			<td><button style="width:240px;height:70px">SELECT</button></td>
		</tr>
	</table>
</body>
</html>