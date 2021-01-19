<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter un cas</title>
</head>
<body>
	<a href="/finalProject">retour</a>
	<h4>${err}</h4>
	<form action="/finalProject/" method="post">
		<input type="hidden" name="form" value="addcas"/>
		<label for="nom">Nom complet</label><input name="nom" id="nom" type="text" />
		<label for="tel">Tel</label><input name="tel" id="tel" type="text" />
		<label for="adresse">Adresse</label><input name="adresse" id="adresse" type="text" />
		<label for="codepostal">Code postal</label><input name="codepostal" id="codepostal" type="text" />
		<input type="submit"/>	
	</form>
</body>
</html>