<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ninja Gold Game</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="wrapper">
		<h1>Your gold: <c:out value="${money}"/></h1>
		<div class="segments">
			<h3>Farm</h3>
			<h5>(earns 10-20 gold)</h5>
			<form method="POST" action="/search">
				<input type="hidden" name="location" value="farm">
				<input class="button" type="submit" name="Find Gold!">
			</form>
		</div>
		<div class="segments">
			<h3>Cave</h3>
			<h5>(earns 5-10 gold)</h5>
			<form method="POST" action="/search">
				<input type="hidden" name="location" value="cave">
				<input class="button" type="submit" name="Find Gold!">
			</form>
		</div>
		<div class="segments">
			<h3>House</h3>
			<h5>(earns 2-5 gold)</h5>
			<form method="POST" action="/search">
				<input type="hidden" name="location" value="house">
				<input class="button" type="submit" name="Find Gold!">
			</form>
		</div>
		<div class="segments">
			<h3>Casino</h3>
			<h5>(earns/takes 0-50 gold)</h5>
			<form method="POST" action="/search">
				<input type="hidden" name="location" value="casino">
				<input class="button" type="submit" name="Find Gold!">
			</form>
		</div>
		<div class="routes">
			<h1>Activities:</h1>
			<div class="activities">
				<c:forEach var="x" items="${messages}">
					<h5>${x}</h5>
				</c:forEach>
			</div>
		</div>
		
	</div>
	
</body>
</html>