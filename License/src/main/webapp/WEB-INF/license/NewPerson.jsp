<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Person</title>
</head>
<body>
	<div class="wrapper">
		<h1>New Person</h1>
		<div class="form">
			<form:form action="/person/new" method="POST" modelAttribute="person">
				<h4>
					<form:label path="fname">First Name</form:label>
					<form:input path="fname"/>
				</h4>	
				<h5><form:errors path="fname"/></h5>
				<h4>
					<form:label path="lname">Last Name</form:label>
					<form:input path="lname"/>
				</h4>
				<h5><form:errors path="lname"/></h5>
				<input type="submit" value="Create"/>
			</form:form>
		</div>
	</div>
</body>
</html>