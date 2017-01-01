<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>User Management Panel</h2>
		</div>
	</div>


	<div id="container">
		<div id="content">

			<input type="button" value="Add User"
				onclick="window.location.href='showAddUser'; return false;"
				class="add-button" />

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Phone Number</th>
					<th>Action</th>
				</tr>

				<c:forEach var="tempUser" items="${users}">
				
					<c:url var="updateLink" value="/user/updateUser">
						<c:param name="userId" value="${tempUser.id }"></c:param>
					</c:url>
					
					<c:url var="deleteLink" value="/user/deleteUser">
						<c:param name="userId" value="${tempUser.id }"></c:param>
					</c:url>
					
					<tr>
						<td>${tempUser.firstName }</td>
						<td>${tempUser.lastName }</td>
						<td>${tempUser.email }</td>
						<td>${tempUser.phoneNumber }</td>
						<td>
							<a href="${updateLink }">Update</a>
							<a href="${deleteLink }">Delete</a>
						</td>
					</tr>
				</c:forEach>


			</table>
		</div>
	</div>
</body>
</html>