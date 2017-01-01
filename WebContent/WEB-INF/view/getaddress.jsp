<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

get address

<form:form action="showaddress" modelAttribute="getAdr" method="POST">
	
			<table>
				<tbody>
					<tr>
						<td><label>Lattitude:</label></td>
						<td><form:input path="lattitude" /></td>
					</tr>
					<tr>
						<td><label>Longitude:</label></td>
						<td><form:input path="longitude" /></td>
					</tr>
				

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
				</tbody>
			</table>

		</form:form>
</body>
</html>