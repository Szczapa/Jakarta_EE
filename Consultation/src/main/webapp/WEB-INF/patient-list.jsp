<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 15/07/2024
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="import.html" %>
</head>
<body>
<%@include file="header.html" %>
<section id="content" class="container">
    <table class="table table-striped table-dark">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">id</th>
            <th scope="col">Nom</th>
            <th scope="col">Date de naissance</th>
            <th scope="col">Race</th>
            <th scope="col">Option</th>
        </tr>
        </thead>
        <tbody>
        <% if (patients.isEmpty()) { %>
        <tr>
            <td colspan="6">Aucun chien trouvé</td>
        </tr>
        <% } else { %>
        <% for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i); %>
        <tr>
            <th scope="row"><%= i + 1 %>
            </th>
            <td><%= patient.getId()%>
            </td>
            <td><%= patient.getName()%>
            </td>
            <td><%= patient.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) %>
            </td>
            <td>
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton"
                            data-bs-toggle="dropdown" aria-expanded="false">
                        Option
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <li><a class="dropdown-item" href="patient/detail?id=<%= patient.getId()%>">Fiche</a></li>
                        <li><a class="dropdown-item" href="patient/edit?id=<%= patient.getId()%>">Modifier</a></li>
                        <li><a class="dropdown-item" href="patient/delete?id=<%= patient.getId()%>">Supprimer</a></li>
                    </ul>
                </div>
            </td>
        </tr>
        <% }
        } %>
        </tbody>
    </table>
</section>
<%@include file="footer.html" %>
</body>
</html>
