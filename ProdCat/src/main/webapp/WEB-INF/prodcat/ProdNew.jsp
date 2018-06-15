<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Product</title>
</head>
<body>
	<div class="wrapper">
		<h1>New Product</h1>
	</div>
	<div class="form">
		<form:form action="/products/new" method="POST" modelAttribute="product">
			<h4>
				<form:label path="name">Name</form:label>
				<form:input path="name"/>
			</h4>
			<h5><form:errors path="name"/></h5>
			
			<h4>
				<form:label path="description">Description</form:label>
				<form:input path="description"/>
			</h4>
			<h5><form:errors path="description"/></h5>
			
			
			<h4>
				<form:label path="price">Price</form:label>
				<form:input type="number" step="0.01" min="1.00" path="price"/>
			</h4>
			<h5><form:errors path="price"/></h5>
			<input type="submit" value="Create"/>
		</form:form>
	</div>
</body>
</html>