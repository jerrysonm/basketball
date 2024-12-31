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
<title>Team</title>
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
    
    <h1><c:out value="${team.location }"/> <c:out value="${team.nickName }"/></h1>
    <div class="teamBox">
    	<h2>General Manager:<c:out value="${team.manager.name }"/></h2>
    	<c:if test="${managerId==team.manager.id }">
    	<a href="/team/${team.id }/resign">Resign as General Manager</a>
    	<a href="/team/${team.id }/edit">Edit Team</a>
    	</c:if>
    		<h3>Players</h3>
    		<hr>
    		<div class="teamBoxII">
    			<c:forEach var="player" items="${players }">
    			<c:if test="${player.team.id==team.id }">
    				<h4> <c:out value="${player.name }"></c:out></h4>
    				<p>Position: <c:out value="${player.position }"></c:out></p>
    				<p>Height: <c:out value="${player.height }"></c:out> ft</p>
    				<p>weight: <c:out value="${player.weight }"></c:out> lbs</p>
    			<c:if test="${managerId==team.manager.id }">
    				<a href="/player/${player.id}/cut">Cut Player</a>
    			</c:if>	
    				<hr>
    			</c:if>
    			</c:forEach>
    		</div>
    </div>
</body>
</html>