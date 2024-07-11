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
<a href="form-servlet">Formulaire</a>
<%--<a href="list-servlet">Liste</a>--%>
</body>
</html>