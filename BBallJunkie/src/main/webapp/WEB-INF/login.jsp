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
<title>Login</title>
</head>
<body class="i">
	<h1 class="f">Welcome Back</h1>
	<div class="login">
	<div>
	<h2>Login</h2>
		<form:form action="/login" method="post" modelAttribute="loginUser">
			<div>
				<form:errors path="username" class="err" />
			</div>
			<form:label path="username">Username:</form:label>
			<form:input path="username"/>
			<div>
			<form:label path="password">Password:</form:label>
			<form:password path="password"/>
			</div>
			
			<div>
				<input class="btnn" type="submit" value="Login"/>
			</div>
		</form:form>
		<a href="/register">Create new</a>
	</div>
	</div>
</body>
</html>