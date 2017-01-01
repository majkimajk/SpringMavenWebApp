<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


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
			<h2>Main Panel</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">

			<p>User Management Panel displays current list of users and allows adding deleting and updating the list</p>
			
			<input type="button" value="Management Panel"
				onclick="window.location.href='user/list'; return false;"
				class="button-button" />
				
			<input type="button" value="GeoLoc Panel"
				onclick="window.location.href='user/geoloc'; return false;"
				class="button-button" />	
			
		</div>
	</div>
</body>
</html>