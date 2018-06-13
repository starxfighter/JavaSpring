<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Search</title>
</head>
<body>
	<div class="wrapper">
		<div class="nav">
			<h2>Songs by artist: <c:out value="${search}"/></h2>
			<div class="form">
				<form action="/search" method="GET">
					<input name="search"/>
					<input type="submit" value="Search Artists"/>
				</form>
			</div>
			<a href="/dashboard">Dashboard</a>
		</div>
		<div class="resuklts">
			<table>
				<thead>
					<tr>
						<th>Title</th>
						<th>Rating</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${music}" var="m">
						<tr>
							<td><c:out value="${m.title}"/></td>
							<td><c:out value="${m.rating}"/></td>
							<td>
								<form action="/song/${m.id}" method="post">
							    <input type="hidden" name="_method" value="delete">
							    <input type="submit" value="Delete">
							</form>
					</c:forEach>
				</tbody>
			</table>	
		</div>
	</div>
</body>
</html>