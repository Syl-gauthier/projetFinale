<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>auth</title>
</head>
<body>
	<h4>${err}</h4>
	<form action="/finalProject/" method="post">
		<input type="hidden" name="form" value="auth"/>
		<label for="login">login</label><input name="login" id="login" type="text" />
		<label for="password">password</label><input name="pwd" id="password" type="text" />
		<input type="submit"/>	
	</form>
</body>
</html>