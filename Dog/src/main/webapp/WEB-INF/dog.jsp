<%@ page import="org.example.dog.entity.DogRace" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 12/07/2024
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chien</title>
    <%@include file="import.html" %>
</head>
<body>
<h1>Formulaire</h1>
<form method="post" action="dog" class="container">
    <div class="form-group mb-3">
        <label for="name">Nom</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="Nom">
    </div>


    <div class="form-group mb-3">
        <label for="birthdate">Date de naissance</label>
        <input type="date" class="form-control" id="birthdate" name="birthdate" placeholder="Date de naissance">
    </div>

    <div class="form-group mb-3">
        <label for="race">Race du chien</label>
        <select id="race" name="race" class="form-select">
            <% for (DogRace race : DogRace.values()) { %>
            <option value="<%= race.name() %>"><%= race.name().toLowerCase().replace("_", " ") %>
            </option>
            <% } %>
        </select>
    </div>

    <div class="form-group mb-3">
        <button type="submit" class="btn btn-primary">Envoyer</button>
    </div>
</form>
</body>
</html>
