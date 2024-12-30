<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
 	<script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<body>
<div>
	<h1>BBall Junkie</h1>
	<div class="taskBar">
		<a href="/logout"><button class="homeBt">Sign out</button></a>
		<a href="/home"><button class="homeBt">Home</button></a>
		<a href="/add/post"><button class="homeBt">+</button></a>
	</div>
<hr>
<h1>Edit Profile</h1>
     <div class="editProfile">
     	<form:form action="/profile/edit/${user.id }" modelAttribute="user" method="post">
     	<input type="hidden" name="_method" value="put">
     		<div>
     			<form:errors class="err" path="username"/>
				<form:label path="username">Update Username:</form:label>
				<form:input path="username"/>
     		</div>
     		
     		<div>
     			<form:errors class="err" path="email"/>
				<form:label path="email">Update Email:</form:label>
				<form:input path="email"/>
     		</div>
     		
     		<div>
     			<form:errors class="err" path="password"/>
				<form:label path="password">Update Password:</form:label>
				<form:password path="password"/>
     		</div>
     		
     		<div>
     			<input class="homeBt" type="submit" value="Update"/>
     		</div>
     	</form:form>
     </div>	

</body>
</html>