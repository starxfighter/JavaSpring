<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dojo Page</title>
</head>
<body>
	<div class="wrapper">
		<h1><c:out value="${dojo.name}"/> Location Ninjas</h1>
		<table>
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dojo.ninjas}" var="dn">
				<tr>
					<td><c:out value="${dn.firstName}"/></td>
					<td><c:out value="${dn.lastName}"/></td>
					<td><c:out value="${dn.age}"/></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>	
</body>
</html>