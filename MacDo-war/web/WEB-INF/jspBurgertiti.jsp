<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap core CSS -->
        <link href="http://localhost:8080/MacDo-war/bootstrapv4/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="http://localhost:8080/MacDo-war/bootstrapv4/css/shop-homepage.css" rel="stylesheet">
        <link rel="stylesheet" href="http://localhost:8080/MacDo-war/css/style.css" />
        <fmt:setLocale value="fr_FR"/>
        <title>Burger</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" style="height: 30px">
            <div class="container">
                <a class="navbar-brand" href="#">MacDo</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="FrontControleur?CreationDeDonneesCtrl">Accueil</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <h1>Burger à la carte</h1>
        <div class="row">
            <c:forEach var="n" items="${liste}">
                <div class="col-md-2">
                    <a href="FrontControleur?section=PersonnaliserCtrl&burgerId=${n.id}&burger=${n.nom}"><img src="${n.imageUrl}" width="200px"><br>${n.nom}<br><fmt:formatNumber value="${n.prix}" type = "currency"/></a>
                </div> 
            </c:forEach>
        </div>
    </body>
</html>
