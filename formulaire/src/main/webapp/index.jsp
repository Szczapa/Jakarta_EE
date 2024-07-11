<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <%@include file="/WEB-INF/import.html"%>
</head>
<body>
<h1><%= "Bienvenue" %>
</h1>
<br/>
<a class="btn btn-primary" href="form-servlet">Formulaire</a>
<a class="btn btn-primary" href="cat-list"> Liste de chat</a>

</body>
</html>