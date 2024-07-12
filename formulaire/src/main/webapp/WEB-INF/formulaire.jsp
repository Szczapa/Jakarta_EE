<%@ page import="org.example.formulaire.model.CatRace" %>
<%@ page import="org.example.formulaire.model.FoodType" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 11/07/2024
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulaire</title>
    <%@include file="import.html" %>
</head>
<body>
<h1>Formulaire</h1>
<form method="post" action="form-servlet" class="container">
    <div class="form-group mb-3">
        <label for="name">Nom</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="Nom">
    </div>


    <div class="form-group mb-3">
        <label for="birthdate">Date de naissance</label>
        <input type="date" class="form-control" id="birthdate" name="birthdate" placeholder="Date de naissance">
    </div>

    <div class="form-group mb-3">
        <label for="race">Race de chat</label>
        <select id="race" name="race" class="form-select">
            <% for (CatRace race : CatRace.values()) { %>
            <option value="<%= race.name() %>"><%= race.name().toLowerCase().replace("_", " ") %>
            </option>
            <% } %>
        </select>
    </div>

    <div class="form-group mb-3">
        <label for="foodtype">Nourriture favorite</label>
        <select id="foodtype" name="foodtype" class="form-select">
            <% for (FoodType foodType : FoodType.values()) { %>
            <option value="<%= foodType.name() %>"><%= foodType.name().toLowerCase().replace("_", " ")%>
            </option>
            <% }%>
        </select>
    </div>

    <div class="form-group mb-3">
    <button type="submit" class="btn btn-primary">Envoyer</button>
    </div>
</form>
</body>
</html>
