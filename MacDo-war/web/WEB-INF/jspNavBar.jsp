<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="http://localhost:8080/MacDo-war/bootstrapv4/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="http://localhost:8080/MacDo-war/bootstrapv4/css/shop-homepage.css" rel="stylesheet">
        <link rel="stylesheet" href="http://localhost:8080/MacDo-war/css/style.css" />
    </head>
    <body>
        <br><br>
        <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top" style="height: 50px;" style="background-color:#004413;">
            <div class="container">
                <a class="nav-link" href="FrontControleur"><img src="./Images/logos/logo56x50.png"></a>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="FrontControleur?section=CreationDeDonneesCtrl">Création des données</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="FrontControleur?section=SousLigneDeCommandeCtrl">Cuisine</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </body>
</html>
