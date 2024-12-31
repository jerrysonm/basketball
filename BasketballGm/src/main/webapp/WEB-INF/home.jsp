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
<title>Home</title>
</head>
<body>
	 <div class="taskbar">
        <div class="firstHalf">
            <a href="/home"><button class="btnn">Home</button></a>
            <a href="/new/team"><button class="btnn">Add Team</button></a>
            <a href="/new/player"><button class="btnn">Add Player</button></a><!--appears only when user is logged in-->
        </div>
       
        <div class="secondHalf">
            <a href="/logout"><button class="btnn">Logout</button></a><!--appears only when user is logged in-->
        </div>
      </div>
      <h1>Welcome, <c:out value="${manager.name }"></c:out></h1>
      <hr>
      <h2>Teams</h2>
      <hr>
		<c:forEach var="team" items="${teams}">
			<div>
				<h4><a href="team/${team.id}"><c:out value="${team.location}"/> <c:out value=" ${team.nickName }"/></a></h4>
				<p>General Manager: <em><c:out value="${team.manager.name}"/></em></p>
			</div>
		<hr>
		</c:forEach>
</body>
</html>