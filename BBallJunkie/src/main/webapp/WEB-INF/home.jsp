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
	<meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<div>
<hr>
<div class="huhh">
	<h1 class="homeWel">BBall Junkie</h1>
	<div class="taskBar">
		<a href="/logout"><button class="homeBt">Sign out</button></a>
		<a href="/home"><button class="homeBt">Home</button></a>
		<a href="/add/post"><button class="homeBt">+</button></a>
		<a href="/profile/${user.id}"><button class="homeBt">Profile</button></a>
		<!--  <a href="/edit/profile/${user.id}"><button class="homeBt" style="font-size:15px;">Edit Profile</button></a>-->
	</div>
</div>
</div>
<hr>
<h2 class="homeWel">Welcome <c:out value="${user.username }"/> !!</h2>
<hr>
<c:forEach var="post" items="${posts }">
	<div class="huhh">
		<h4><a href="user/${post.user.id }" class="undl"><c:out value="${post.user.username }"/></a></h4>
		<p><c:out value="${post.text }"/></p>
		<div>
			<form action="likePost" method="post">
              <input type="hidden" name="postId" value="1" />
              <hr>
              <button type="submit" class="likeBtn" >Like</button>
			<!-- add a post counter*counts the amount of post the user has a displays them -->
        	</form>
		</div>
	</div>
<hr>
</c:forEach>


</body>
</html>