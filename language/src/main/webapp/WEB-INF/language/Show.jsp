<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Display Language</title>
</head>
<body>
	<div class="nav">
		<a href="/languages">Dashboard</a>
	</div>
	<div class="results">
		<h1><c:out value="${lang.name}"/></h1>
		<h2><c:out value="${lang.creator}"/></h2>
		<h2><c:out value="${lang.version}"/></h2>
	</div>
	<div class="bnav">
		<a href="/languages/${lang.id}/edit">Edit</a>
		<form action="/languages/${lang.id}" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input type="submit" value="Delete">
		</form>
	</div>
</body>
</html>