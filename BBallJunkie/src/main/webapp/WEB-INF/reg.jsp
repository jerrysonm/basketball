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
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body class="i">
	<h1 class="f">Join The Community</h1>
	<div class="register">
	<div class="container">
		<div class="contant">
			<form:form action="/register" method="post" modelAttribute="newUser">
			<div>
			<h1>Register</h1>
			</div>
				<div>
					<div>
						<form:errors path="email" class="err"/>	
					</div>
					<form:label path="email">Email:</form:label>
					<form:input path="email"/>
				</div>
				<div>
					<div>
						<form:errors path="username" class="err"/>
					</div>
					<form:label path="username">Username:</form:label>
					<form:input path="username"/>
				</div>
				<div>
					<div>
						<form:errors path="password" class="err"/>
					</div>
					<form:label path="password">Password:</form:label>
					<form:input path="password"/>
				</div>
				<div>
					<div>
						<form:errors path="confirmPassword" class="err"/>
					</div>
					<form:label path="confirmPassword">Confirm Password:</form:label>
					<form:input path="confirmPassword"/>
				</div>
				
				<div>
					<input class="btnn" type="submit" value="Register"/>
				</div>
			</form:form>
			<a href="/login">Already have an account</a>
		</div>
	</div>
	</div>

</body>
</html>