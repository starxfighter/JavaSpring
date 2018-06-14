<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New License</title>
</head>
<body>
	<div class="wrapper">
		<h1>New License</h1>
		<form:form action="/license/new" method="POST" modelAttribute="license">
			<h4>
				<form:label path="person">Person</form:label>
				<form:select path="person">
					<c:forEach items="${person}" var="p">
						<form:option value="${p}" label="${p.fname} ${p.lname}"/>
					</c:forEach>
				</form:select>
			</h4>
			<h5><form:errors path="person"/></h5>
			<h4>
				<form:label path="state">State</form:label>
				<form:input path="state"/>
			</h4>
			<h5><form:errors path="state"/></h5>
			<h4>
				<label>Expiration Date</label>
				<input type="date" name="expirationDate"/>
			</h4>
			<input type="submit" value="Create">
		</form:form>
	</div>
</body>
</html>