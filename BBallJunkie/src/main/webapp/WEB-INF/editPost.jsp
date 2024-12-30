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
	<meta charset="UTF-8">
    <title>Edit Post</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<h1>BBall Junkie</h1>
	<div class="taskBar">
		<a href="/logout"><button class="homeBt">Sign out</button></a>
		<a href="/home"><button class="homeBt">Home</button></a>
		<a href="/add/post"><button class="homeBt">+</button></a>
	</div>
<hr>
<h1>Edit Post</h1>
     <div class="editPost" style="background:orange;">
     	<form:form action="/post/edit/${post.id }" modelAttribute="post" method="post">
     	<input type="hidden" name="_method" value="put">
     	<div>
			<div>
				<form:label path="text" style="font-size:30px; font-weight:bold;">Edit Content:</form:label>
			</div>
			<form:textarea id="post" style="border:5px solid orange" path="text"/>
			<form:errors class="err" path="text"/>
		</div>
			<div>
				<form:input type="hidden" path="user" value="${user.id}"/>
			</div>
			
     		<div>
     			<input class="homeBt" type="submit" style="font-size:15px;" value="Update Post"/>
     		</div>
     		
     		
     		
     	</form:form>
     </div>  
</body>
</html>