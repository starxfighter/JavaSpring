<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Dojo</title>
</head>
<body>
	<div class="wrapper">
		<h1>New Dojo</h1>
	</div>
	<div class="form">
		<form:form action="/dojos/new" method="POST" modelAttribute="dojo">
			<h4>
				<form:label path="name">Name</form:label>
				<form:input path="name"/>
			</h4>
			<h5><form:errors path="name"/></h5>
			<input type="submit" value="Create"/>
		</form:form>
	</div>		
</body>
</html>