<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 12/07/2024
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Erreur 404</title>
    <%@include file="import.html" %>
    <style>
        body,
        html {
            height: 100%;
        }
    </style>
</head>
<body class="d-flex justify-content-center
                 align-items-center">
<div class="col-md-12 text-center">
    <h1>404</h1>
    <h2>Page Not Found</h2>
    <p>
        Sorry, the page you are looking
        for does not exist.
    </p>
    <a href="<%= request.getContextPath() %>/"
       class="btn btn-primary">Retour à l'accueil</a>

</div>
</body>
</html>
