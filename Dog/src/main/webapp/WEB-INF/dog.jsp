<%@ page import="org.example.dog.entity.DogRace" %>
<%@ page import="org.example.dog.entity.Dog" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 12/07/2024
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String mode = (String) request.getAttribute("mode"); %>
<% Dog dog = (Dog) request.getAttribute("dog"); %>
<html>
<head>
    <title>Chien</title>
    <%@include file="import.html" %>
</head>
<body>
 <section class="container mt-5">
<% if ("form".equals(mode)) { %>
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
        <button type="submit" class="btn btn-dark">Envoyer</button>
    </div>
</form>
<% } else if ("info".equals(mode)) { %>
<div class="d-flex justify-content-between">
    <h1>Info</h1>
    <div class="dropdown">
        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton"
                data-bs-toggle="dropdown" aria-expanded="false">
            Option
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
            <li><a class="dropdown-item" href="<%= request.getContextPath() %>/dog-list">Liste</a></li>
            <li><a class="dropdown-item" href="<%= request.getContextPath() %>/dog/edit?id=<%= dog.getId()%>">Modifier</a></li>
            <li><a class="dropdown-item" href="<%= request.getContextPath() %>/dog/delete?id=<%= dog.getId()%>">Supprimer</a></li>
        </ul>
    </div>
</div>

<form method="post" action="dog" class="container">
    <div class="form-group mb-3">
        <label for="name">Nom</label>
        <input type="text" class="form-control" name="name" placeholder="<%= dog.getName().toString() %>" readonly>
    </div>


    <div class="form-group mb-3">
        <label for="birthdate">Date de naissance</label>
        <input type="date" class="form-control" name="birthdate" value="<%= dog.getBirthDate().toString() %>" readonly>
    </div>

    <div class="form-group mb-3">
        <label for="race">Race du chien</label>
        <select name="race" class="form-select" disabled>
            <option value=""><%= dog.getDogRace().toString().toLowerCase().replace("_"," ") %>
            </option>
        </select>
    </div>
</form>
<% } %>
 </section>
</body>
</html>
