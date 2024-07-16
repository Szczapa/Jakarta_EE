<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"
          name="viewport">
    <meta content="ie=edge" http-equiv="X-UA-Compatible">
</head>
<body>
<section id="header">
    <div class="bg-success d-flex justify-content-center">
        <h1 class="text-light">Bienvenue dans le systeme de gestion Hospitaliere</h1>
    </div>
    <div class="bg-dark">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 justify-content-center">
                <li class="nav-item">
                    <a aria-current="page" class="nav-link  text-light" href="<%= request.getContextPath() %>">Accueil</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-light" href="<%= request.getContextPath() %>/patient/list">Liste des patients</a>
                </li>
            </ul>
        </nav>
    </div>
</section>
</body>
</html>