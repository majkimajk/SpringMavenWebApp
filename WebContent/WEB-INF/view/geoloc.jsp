<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="button" value="Get the coordinates"
		onclick="window.location.href='geoloc/getcoordinates'; return false;"
		class="button-button" />

	<input type="button" value="Get the address"
		onclick="window.location.href='geoloc/getaddress'; return false;"
		class="button-button" />

</body>
</html>