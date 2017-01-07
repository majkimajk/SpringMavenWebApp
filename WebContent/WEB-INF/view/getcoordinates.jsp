<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Get address</h2>
		</div>
	</div>



	<div id="container">
		<div id="content">
			<form:form action="showcoords" modelAttribute="getCoord"
				method="POST">
				<table>
					<tbody>
						<tr>
							<td><label>Street name:</label></td>
							<td><form:input path="street" /></td>
							<td>halo galo</td>
						</tr>
						<tr>
							<td><label>City:</label></td>
							<td><form:input path="city" /></td>
						</tr>
						<tr>
							<td><label>Country:</label></td>
							<td><form:input path="country" /></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Get coordinates!" class="save" /></td>
						</tr>
					</tbody>
				</table>

			</form:form>
		</div>
	</div>
</body>
</html>