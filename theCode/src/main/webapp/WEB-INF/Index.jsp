<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Secret Code</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="wrapper">
		<div class="errors">
			<h3><c:out value="${error}"/></h3>
		</div>
		<div class="form">
			<h1>What is the secret code word?</h1>
			<form method="POST" action="/try">
				<input type="text" name="guess">
				<input type="Submit" value="Try Code">
			</form>
		</div>
	</div>
</body>
</html>