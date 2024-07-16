<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="org.example.consultation.entity.Patient" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 15/07/2024
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="patients" type="java.util.ArrayList<org.example.consultation.entity.Patient>" scope="request"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="import.html" %>
</head>
<body>
<%@include file="header.jsp" %>
<section id="content" class="container">
    <table class="table table-striped table-dark">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">id</th>
            <th scope="col">Prenom</th>
            <th scope="col">Nom</th>
            <th scope="col">Date de naissance</th>
            <th scope="col">Medecin</th>
            <th scope="col">Option</th>
            <th scope="col"><a class="btn btn-light" href="add">Creer Patient</a></th>
        </tr>
        </thead>
        <tbody>
        <% if (patients.isEmpty()) { %>
        <tr>
            <td colspan="5">Aucun patient trouvé</td>
            <td>
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton"
                            data-bs-toggle="dropdown" aria-expanded="false">
                        Option
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <li><a class="dropdown-item" href="add">Creer Patient</a></li>
                    </ul>
                </div>
            </td>
        </tr>
        <% } else { %>
        <% for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i); %>
        <tr>
            <th scope="row"><%= i + 1 %>
            </th>
            <td><%= patient.getPatientId()%>
            </td>
            <td><%= patient.getFirstName()%>
            </td><td><%= patient.getLastName()%>
            </td>
            <td><%= patient.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) %>
            </td>
            <td><%= patient.getDoctor().getLastName()%></td>
            <td colspan="2">
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton"
                            data-bs-toggle="dropdown" aria-expanded="false">
                        Option
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <li><a class="dropdown-item" href="detail?id=<%= patient.getPatientId()%>">Fiche</a></li>
                        <li><a class="dropdown-item" href="edit?id=<%= patient.getPatientId()%>">Modifier</a></li>
                        <li><a class="dropdown-item" href="delete?id=<%= patient.getPatientId()%>">Supprimer</a></li>
                    </ul>
                </div>
            </td>
        </tr>
        <% }
        } %>
        </tbody>
    </table>
</section>
<%@include file="footer.jsp" %>
</body>
</html>
