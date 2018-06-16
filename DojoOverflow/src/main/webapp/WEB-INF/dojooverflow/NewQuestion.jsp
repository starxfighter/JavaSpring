<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Question</title>
</head>
<body>
	<div class="wrapper">
		<h1>What is your question?</h1>	
	</div>
	<div class="form">
		<form:form action="/questions/new" method="POST" modelAttribute="question">
			<h4>
				<form:label path="questiondt">Question</form:label>
				<form:textarea path="questiondt"/>
			</h4>
			<h5><form:errors path="questiondt"/></h5>
			<label>Tags</label>
			<h4>Enter tags sepearted by a comma</h4>
			<c:out value="${error}"/>
			<input type="text" name="qtags"/>
			<input type="submit" value="Add"/>
		</form:form>
	</div>
</body>
</html>