<%@ page import="org.example.ex01.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="users" type="java.util.List" scope="request"/>


<html>
<head>
    <title>Tableau des utilisateurs</title>
    <%@include file="../bootstrap/import.html"%>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Lastname</th>
        <th scope="col">Age</th>
    </tr>
    </thead>
    <tbody>
    <% for (int i = 0; i < users.size(); i++) {
        User user = (User) users.get(i);
    %>
    <tr>
        <th scope="row"><%= i + 1 %></th>
        <td><%= user.getName() %></td>
        <td><%= user.getLastname() %></td>
        <td><%= user.getAge()%></td>
    </tr>
    <% } %>
    </tbody>
</table>

<a class="btn btn-danger" href="/ex01_war_exploded/"> retour </a>
</body>
</html>
