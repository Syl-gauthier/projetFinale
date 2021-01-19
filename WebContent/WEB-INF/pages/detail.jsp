<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>detail</title>
</head>
<body>
	<a href="/finalProject/?page=gestion">retour</a>

	<p>${cas}
		<a href="/finalProject/?page=detail&id=${cas.id}">details</a>
	</p>
	<c:forEach var="test" items="${cas.listTest}">
		<p style="padding-left: 12px;">${test}</p>
	</c:forEach>

</body>
</html>