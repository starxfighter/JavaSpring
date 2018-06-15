<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Category Page</title>
</head>
<body>
	<div class="wrapper">
		<h1><c:out value="${cat.name}"/></h1>
		<c:forEach items="${cp}" var="list">
			<c:out value="${list.product.name}"/>
		</c:forEach>
	</div>
	<div class="form">
		<form:form action="/categories/${cat.id}" method="POST" modelAttribute="categoryProduct">
			<h4>
				<form:label path="product">Add Product</form:label>
				<form:select path="product">
					<c:forEach items="${prod}" var="p">
						<form:option value="${p}" label="${p.name}"/>
					</c:forEach>
				</form:select>
			</h4>	
			<h5><form:errors path="product"/></h5>
			<input type="submit" value="Add"/>
		</form:form>
	</div>	
</body>
</html>