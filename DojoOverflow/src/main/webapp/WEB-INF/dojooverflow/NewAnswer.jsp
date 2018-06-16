<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Question Profile</title>
</head>
<body>
	<div class="wrapper">
		<h1><c:out value="${quest.questiondt}"/></h1>
	</div>
	<div class="list">
		<table>
			<thead>
				<tr>
					<th>Answers</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${quest.answers}" var="qa">
				<tr>
					<td><c:out value="${qa.answerdt}"/></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="tags">
		<c:forEach items="${tags}" var="t">
			<h5><c:out value="${t.tag.subject}"/></h5>
		</c:forEach>
	</div>
	<div class="form">
		<form:form action="/questions/${quest.id}" method="POST" modelAttribute="answer">
			<h4>
				<form:label path="answerdt">Question</form:label>
				<form:textarea path="answerdt"/>
			</h4>
			<h5><form:errors path="answerdt"/></h5>
			<input type="submit" value="Answer It"/>
		</form:form>
	</div>
</body>
</html>