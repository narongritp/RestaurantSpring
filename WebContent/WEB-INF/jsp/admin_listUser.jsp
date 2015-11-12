<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View User Food</title>

<%@include file="include/style.jsp"%>
</head>
<body style="font-family: 'tahoma';">
	<h1>User Management</h1>
	<hr>
	<%@include file="include/navigatevalidate.jsp"%><br>
	<br>
	<div align='right'>
	<a href="/RestaurantSpring/user-manage/create-user">
		<button>New User</button></a>
	</div>
	<hr>
	<div class="content80">
		<table width="100%" border="1" align="center">
			<tr align="center">
				<td class="heading" height="60px">NO.</td>
				<td class="heading">USERNAME</td>
				<td class="heading">PASSWORD</td>
				<td class="heading">FIRST NAME</td>
				<td class="heading">LAST NAME</td>
				<td class="heading">TELEPHONE</td>
				<td class="heading">JOB</td>
				<td class="heading">HIRE DATE</td>
				<td class="heading"></td>
			</tr>
			<c:forEach var="user" varStatus="i" items="${userList}">
				<tr style="border: 0px solid;" align="center">
					<td>${i.index+1}</td>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.telephone}</td>
					<td>${user.type}</td>
					<td>${user.timestamp}</td>
					<td><a
						href="/RestaurantSpring/admin/terminate-user?userId=${user.userId }">
							<button style="width: 100%; height: 60px"
							onclick="deleteItem(${user.userId},'${user.username}','${user.firstName}',
							'${user.lastName}','${user.type}')">Teminate!</button>
					</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script type="text/javascript">
		function deleteItem(userId, username, firstName, lastName, type) {
			if (confirm("User ID : " + userId + "\nName : " + username + "\n"
					+ "Name : " + firstName+" "+lastName + "\nType : " + type + 
					"\n\nAre you sure?") == true) {

				window.location = "/RestaurantSpring/admin/terminate-user?userId="+userId;
			}
		}
	</script>
</body>
</html>