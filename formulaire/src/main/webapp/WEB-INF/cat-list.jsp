<%@ page import="org.example.formulaire.model.Cat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="catList" type="java.util.ArrayList<org.example.formulaire.model.Cat>" scope="request"/>
<html>
<head>
    <title>Liste des chats</title>
    <%@include file="import.html" %>
</head>
<body>
<h1>Liste des chats</h1>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Nom</th>
        <th scope="col">Date de naissance</th>
        <th scope="col">Race</th>
        <th scope="col">Nourriture favorite</th>
    </tr>
    </thead>
    <tbody>
    <% for (int i = 0; i < catList.size(); i++) {
        Cat cat = catList.get(i); %>
    <tr>
        <th scope="row"><%= i + 1 %></th>
        <td><%= cat.getName() %></td>
        <td><%= cat.getBirthDate() %></td>
        <td><%= cat.getCatRace().name() %></td>
        <td><%= cat.getFoodType().name() %></td>
    </tr>
    <% } %>
    </tbody>
</table>
  <a href="form-servlet" class="btn btn-primary"> Retourner au formulaire </a>
</body>
</html>