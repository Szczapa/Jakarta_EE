<%@ page import="org.example.dog.entity.Dog" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 12/07/2024
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="dogs" type="java.util.ArrayList<org.example.dog.entity.Dog>" scope="request"/>
<html>
<head>
    <title>Liste des Chiens</title>
    <%@include file="import.html" %>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">id</th>
        <th scope="col">Nom</th>
        <th scope="col">Date de naissance</th>
        <th scope="col">Race</th>
        <th scope="col">Fiche Perso</th>
    </tr>
    </thead>
    <tbody>
    <% if (dogs.isEmpty()) { %>
    <tr>
        <td colspan="6">Aucun chien trouvé</td>
    </tr>
    <% } else { %>
    <% for (int i = 0; i < dogs.size(); i++) {
        Dog dog = dogs.get(i); %>
    <tr>
        <th scope="row"><%= i + 1 %>
        </th>
        <td><%= dog.getId()%>
        </td>
        <td><%= dog.getName()%>
        </td>
        <td><%= dog.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) %>
        </td>
        <td><%= dog.getDogRace().name().toLowerCase() %>
        </td>
        <td><a class="btn btn-success m-1" href="dog/detail?id=<%= dog.getId()%>">Fiche</a></td>
    </tr>
    <% }} %>
    </tbody>
</table>
<a class="btn btn-primary" href="dog">Ajouter Chien</a>
</body>
</html>
