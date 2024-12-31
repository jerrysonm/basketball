<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/main.css"/>
<meta charset="ISO-8859-1">
<title>welcome</title>
</head>
<body class="i">
<div class="taskbar">
	<a href="/login"><button class="btnn">Login</button></a> <h1 class="welcomeMess">Welcome To Basketball GM</h1> <a href="/register"><button class="btnn">Register</button></a>
</div>
<div>
	<img src="<c:url value='/images/background.png' />" alt="background image" class="background-image">
</div>
</body>
</html>