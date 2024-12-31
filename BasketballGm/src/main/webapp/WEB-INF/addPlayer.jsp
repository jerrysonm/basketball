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
<title>Add Player</title>
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
    <h1>Add New Player</h1>
	<div class="addPlayer">
		<form:form action="/add/player" modelAttribute="player" method="post">
			<div>
				<form:errors class="err" path="name"/>
				<form:label path="name">Name:</form:label>
				<form:input path="name"/>
			</div>
			<div>
				<form:errors class="err" path="position"/>
				<form:label path="position">Position:</form:label>
				<form:select path="position">
					<option value="null">Select Position</option>
					<option value="PG">Point Guard</option>
					<option value="SG">Shooting Guard</option>
					<option value="SF">Small Forward</option>
					<option value="PF">Power Forward</option>
					<option value="C">Center</option>
				</form:select>
			</div>
			<div>
				<form:errors class="err" path="height"/>
				<form:label path="height">Height:</form:label>
				<form:input path="height"/>
			</div>
			<div>
				<form:errors class="err" path="weight"/>
				<form:label path="weight">Weight:</form:label>
				<form:input path="weight"/>
			</div>
			<div>
				<form:errors class="err" path="team"/>
				<form:label path="team">Team:</form:label>
				<form:select path="team">
					<option value="">Select Team</option>
					<c:forEach var="team" items="${teams}">
						<c:if test="${managerId==team.manager.id }">
							<option value="${team.id }"><c:out value="${team.location}"></c:out> <c:out value="${team.nickName}"></c:out></option>
						</c:if>
					</c:forEach>
				</form:select>
			</div>
			<div>
				<input class="btnn" type="submit" value="submit"/>
			</div>
		</form:form>
	</div>
</body>
</html>