<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Results</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="wrapper">
		<h1 class="title">Submitted Info</h1>
		<div class="results">
			<h3>Name:</h3>
			<h4><c:out value="${name}"/></h4>
			
			<h3>Dojo Location:</h3>
			<h4><c:out value="${location}"/></h4>
			
			<h3>Favorite Language:</h3>
			<h4><c:out value="${favlang}"/></h4>
			
			<h3>Comment:</h3>
			<h4><c:out value="${comment}"/></h4>
			
			<a href="/"><button>Go Back</button></a>
		</div>
	</div>
	
</body>
</html>