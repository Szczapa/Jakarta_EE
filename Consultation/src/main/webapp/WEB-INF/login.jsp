<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 16/07/2024
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@include file="import.html" %>
</head>
<body>
<%@include file="header.jsp" %>
<section id="login">
    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <div class="card">
                    <div class="card-header bg-dark text-light">
                        <h4>Authentification</h4>
                    </div>
                    <div class="card-body">
                        <form action="login" method="post">
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary">Se connecter</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<%@include file="footer.jsp" %>
</body>
</html>
