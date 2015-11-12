<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View List Food</title>
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
	<h1>Food Management</h1>
	<hr>
	<%@include file="include/navigatevalidate.jsp"%><br>
	<br>
	<div align='right'>
		<a href="/RestaurantSpring/admin/add-food">
		<button>Add Food Menu</button></a>
	</div>
	<hr>
	<div style="width: 95%; float: right;">
		<br> 
		<select id="dropdown" onchange="searchType()" style="width: 150px;height: 40px">
			<option>-- Search Type --</option>
			<option value='All'>All</option>
			<c:forEach var="type" items="${type}">
				<option value='${type }'>${type}</option>
			</c:forEach>
		</select>
	</div>
	<div style="margin-top: 100px" class="content">
		<table width="100%" border="1" align="center">
			<tr align="center">
				<td class="heading">NO.</td>
				<td class="heading">NAME</td>
				<td class="heading">TYPE</td>
				<td class="heading">PRICE</td>
				<td class="heading">DETAIL</td>
				<td class="heading">PICTURE</td>
				<td class="heading">UPDATE TIME</td>
				<td class="heading"></td>
			</tr>
			<c:forEach var="food" varStatus="i" items="${list}">
				<tr style="border: 0px solid;" align="center">
					<td>${i.index+1}</td>
					<td>${food.name}</td>
					<td>${food.type}</td>
					<td>${food.price}</td>
					<td>${food.detail}</td>
					<td><img src="${food.picture}" width="100px" height="80px" /></td>
					<td>${food.updateTime}</td>
					<td>
<!-- 					<a href="/RestaurantSpring/admin/deleteFood?foodId="> -->
						<button style="width: 100%;height: 100%" 
						onclick="deleteItem(${food.foodId},'${food.name}','${food.type}',${food.price},'${food.detail}')">Delete</button></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<script type="text/javascript">
		function searchType(){
			var search = document.getElementById("dropdown").value;
			if(search == 'All'){
				window.location = "/RestaurantSpring/admin/manage-foodmenu/";
			}else{
				window.location = "/RestaurantSpring/admin/manage-foodmenu/search?type="+search;
			}
		}
		
		function deleteItem(foodId,foodName,foodType,foodPrice,foodDetail){
			if(confirm("Food ID : "+foodId+"\nName : "+foodName+"\n"+
					"Type : "+foodType+"\nPrice : "+foodPrice+"\n"+
					"Detail : "+foodDetail+"\n\nAre you sure?")==true){
				
				window.location = "/RestaurantSpring/admin/deleteFood?foodId="+foodId;
			}
		}
	
	</script>
</body>
</html>