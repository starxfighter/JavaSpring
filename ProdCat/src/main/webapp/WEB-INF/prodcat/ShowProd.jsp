<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Product Page</title>
</head>
<body>
	<div class="wrapper">
		<h1><c:out value="${prod.name}"/></h1>
		<c:forEach items="${cp}" var="list">
			<c:out value="${list.category.name}"/>
		</c:forEach>
	</div>
	<div class="form">
		<form:form action="/products/${prod.id}" method="POST" modelAttribute="categoryProduct">
			<h4>
				<form:label path="category">Add Category</form:label>
				<form:select path="category">
					<c:forEach items="${cat}" var="c">
						<form:option value="${c}" label="${c.name}"/>
					</c:forEach>
				</form:select>
			</h4>
			<h5><form:errors path="category"/></h5>
			<input type="submit" value="Add"/>
		</form:form>	
	</div>
</body>
</html>