<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter un test</title>
</head>
<body>
	<a href="/finalProject">retour</a>
	<h4>${err}</h4>
	<form action="/finalProject/" method="post">
		<input type="hidden" name="form" value="addtest"/>
		<label for="id_teste">Id teste</label><input name="id_teste" id="id_teste" type="text" />
		<label for="resultat">resultat</label><input name="resultat" id="resultat" type="text" />
		<label for="jour">jour</label><input name="jour" id="jour" type="text" />
		<label for="mois">mois</label><input name="mois" id="mois" type="text" />
		<label for="annee">annee</label><input name="annee" id="annee" type="text" />
		<input type="submit"/>	
	</form>
</body>
</html>