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
	<h1 class="f">Welcome</h1>
	<h3 class="f">Welcome back GM</h3>
	<div class="login">
	<div>
	<h2>Login</h2>
		<form:form action="/login" method="post" modelAttribute="loginManager">
		<form:errors class="err" path="*"/>
			<form:label path="email">Email:</form:label>
			<form:input path="email"/>
			<div>
			<form:label path="password">Password:</form:label>
			<form:input path="password"/>
			</div>
			
			<div>
				<input class="btnn" type="submit" value="Log In"/>
			</div>
		</form:form>
		<a href="/register">Create new</a>
	</div>
	</div>
</body>
</html>