<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Song</title>
</head>
<body>
	<div class="wrapper">
		<div class="nav">
			<a href="/dashboard">Dashboard</a>
		</div>
		<div class="form">
			<form:form action="/songs/new" methog="POST" modelAttribute="music">
				<h4>
					<form:label path="title">Title</form:label>
					<form:input path="title"/>
				</h4>	
				<h5>
					<form:errors path="title"/>
				</h5>
				
				<h4>
					<form:label path="artist">Artist</form:label>
					<form:input path="artist"/>
				</h4>
				<h5>
					<form:errors path="artist"/>
				</h5>
				
				<h4>
					<form:label path="rating">Rating</form:label>
					<form:input type="number" min="1" max="10" value="1" path="rating"/>
				</h4>
				<h5>
					<form:errors path="rating"/>
				</h5>
				<input type="submit" value="Add Song"/>
			</form:form>
		</div>
	</div>
</body>
</html>