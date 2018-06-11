<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dojo Survey Index</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="wrapper">
		<div class="form">
			<form method="POST" action="/submit">
				<label>Your Name:<input type="text" name="name"></label>
				<label>Dojo Location<select name="location">
									<option value="Burbank">Burbank</option>
									<option value="San Jose">San Jose</option>
									<option value="Other">Other</option>
									</select></label>
				<label>Favorite Language<select name="favLang">
									<option value="Python">Pyhton</option>
									<option value="Java">Java</option>
									<option value="Mean">Mean</option>
									</select></label>
				<label>Comment (optional)</label>
				<textarea name="comment"></textarea>
				<input class="button" type="submit" name="Enter">
			</form>
		</div>
		
	</div>
</body>
</html>