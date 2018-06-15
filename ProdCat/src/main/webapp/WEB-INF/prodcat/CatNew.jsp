<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Category</title>
</head>
<body>
	<div class="wrapper">
		<h1>New Category</h1>
	</div>
	<div class="form">
		<form:form action="/categories/new" method="POST" modelAttribute="category">
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