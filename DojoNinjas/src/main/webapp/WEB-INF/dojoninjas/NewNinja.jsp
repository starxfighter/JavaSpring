<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Ninja</title>
</head>
<body>
	<div class="wrapper">
		<h1>New Ninja</h1>
		<form:form action="/ninjas/new" method="Post" modelAttribute="ninja">
			<h4>
				<form:label path="dojo">Dojo</form:label>
				<form:select path="dojo">
					<c:forEach items="${dojo}" var="d">
						<form:option value="${d}" label="${d.name}"/>
					</c:forEach>
				</form:select>
			</h4>		
			<h5><form:errors path="dojo"/></h5>
			<h4>
				<form:label path="firstName">First Name</form:label>
				<form:input path="firstName"/>
			</h4>
			<h5><form:errors path="firstName"/></h5>
			<h4>
				<form:label path="lastName">Last Name</form:label>
				<form:input path="lastName"/>
			</h4>
			<h5><form:errors path="lastName"/></h5>
			<h4>
				<form:label path="age">Age</form:label>
				<form:input type="number" min="1" value="1" path="age"/>
			</h4>
			<h5><form:errors path="age"/></h5>
			<input type="submit" value="Create">
		</form:form>
	</div>
</body>
</html>