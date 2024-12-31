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
<title>Add team</title>
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
     <h1>Edit Team</h1>
     <div class="addTeam">
     	<form:form action="/team/edit/${team.id }" modelAttribute="team" method="post">
     	<input type="hidden" name="_method" value="put">
     		<div>
     			<form:errors class="err" path="location"/>
				<form:label path="location">Location:</form:label>
				<form:input path="location"/>
     		</div>
     		
     		<div>
     			<form:errors class="err" path="nickName"/>
				<form:label path="nickName">Nickname:</form:label>
				<form:input path="nickName"/>
     		</div>
     		
     		<div>
				<form:input type="hidden" path="manager" value="${manager.id}"/>
			</div>
			
			<div>
				<input class="btnn" type="submit" value="Submit"/>
			</div>
     	</form:form>
     </div>
	
</body>
</html>