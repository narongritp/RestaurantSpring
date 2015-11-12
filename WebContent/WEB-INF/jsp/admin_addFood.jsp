<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Food</title>
<%@include file="include/style.jsp"%>
</head>
<body style="font-family:'tahoma';">
<div>
	<center>
		<fieldset style="width:40%">
			<legend>Food Information</legend>
			<form:form method="POST" action="/RestaurantSpring/admin/addFood"
				modelAttribute="food">
				<table cellpadding="20px">
					<tr>
						<td>Name :</td>
						<td><form:input path="name" /></td>
					</tr>
					<tr>
						<td>Type :</td>
						<td><form:select path="type" items="${model.type}" style="width:100%"/></td>
					</tr>
					<tr>
						<td>Price :</td>
						<td><form:input path="price" /></td>
					</tr>
					<tr>
						<td>Detail :</td>
						<td><form:input path="detail" /></td>
					</tr>
					<tr>
						<td>Picture :</td>
						<td><form:input id="pic" path="picture" onchange="setImg()"/></td>
					</tr>
					<tr>
						<td colspan="2">
						<img id="showimg" src="http://localhost/tmppicture/empty.png" width="270" height="230px"/>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td colspan="2"><input type="submit" value="Submit" style="width: 100%;height: 60px" /></td>
					</tr>
				</table>
			</form:form>
		</fieldset>
	</center>
	</div>
	<script type="text/javascript">
		function setImg(){
			document.getElementById("showimg").src = document.getElementById("pic").value;
		}
	
	</script>
</body>
</html>