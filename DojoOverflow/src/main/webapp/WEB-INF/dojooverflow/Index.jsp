<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Question Dashboard</title>
</head>
<body>
	<div class="wrapper">
		<h1>Question Dashboard</h1>
		<table>
			<thead>
				<tr>
					<th>Detail</th>
					<th>Question</th>
					<th>Tags</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ed" items="${data}">
				<tr>
					<td><a href="/questions/${ed.key}"><button>Detail</button></a></td>
					<c:forEach var="dt" items="${ed.value}">
						<td><c:out value="${dt}"/></td>
					</c:forEach>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/questions/new">New Question</a>
	</div>	
</body>
</html>