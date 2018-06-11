<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Counter</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="wrapper">
		<div class="button">
			<a href=""><button type="button">Click Me</button></a>
		</div>
		<div class="info">
			<h2>You have hit the button <c:out value="${count}"/> times!</h2>
		</div>
	</div>
</body>
</html>