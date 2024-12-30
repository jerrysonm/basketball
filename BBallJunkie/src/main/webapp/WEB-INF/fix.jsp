<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${session.id==user.id }">
		<p><a href="#">Logout</a></p>
	</c:if>
	<c:if test="${session.id=!user.id }">
		<p><a href="#">Login</a> <a href="#">/Register</a></p>
	</c:if>
</body>
</html>