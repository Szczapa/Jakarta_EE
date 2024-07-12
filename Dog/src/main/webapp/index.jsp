<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Systeme de gestion de Chien</title>
    <%@include file="/WEB-INF/import.html" %>
</head>
<body>
<div class="container">
    <h1><%= "Bienvenue" %>
    </h1>
    <br/>
    <div class="mb-1">
        <a class="btn btn-primary" href="dog">Formulaire d'ajout</a>
    </div>
    <div class="mb-1">
        <a class="btn btn-primary" href="dog-list">Liste des Chiens</a>
    </div>
</div>
</body>
</html>