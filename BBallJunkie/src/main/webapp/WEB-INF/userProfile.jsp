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
<title>User Profile</title>
</head>
<body>
<div>
	<h1>BBall Junkie</h1>
	<div class="taskBar">
		<a href="/logout"><button class="homeBt">Sign out</button></a>
		<a href="/add/post"><button class="homeBt">+</button></a>
		<a href="/home"><button class="homeBt">Home</button></a>
		<!--<c:set var="sessionId" value="${session.user.id}"/>-->
		<!--<a href="/profile/${user.id }"><button class="homeBt">Profile</button></a> -->
	</div>
</div>
<hr>
	<h2><c:out value="${user.username }"/></h2>
	<!-- add a bio -->
	
<hr/>
<h3>Posts</h3>
	<div class="userPost">    
		<c:forEach var="post" items="${userPosts}">
		<hr>
		<c:if test="${post.user.id==post.user.id }">
			<h4><c:out value="${post.user.username }"></c:out></h4>
			<p><c:out value="${post.text }"></c:out></p>
		</c:if>
		<c:if test="${userId==post.user.id }">
		<a href="/delete/post/${post.id}"><button class="deletebttn">Trash</button></a>
		<a href="/edit/post/${post.id}"><button class="editbttn">Edit</button></a>
		</c:if>
		<hr>
		<!-- add a like button and comment -->
		</c:forEach>
	</div>
</body>
</html>