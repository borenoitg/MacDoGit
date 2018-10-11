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
        <title>Nappages</title>
    </head>
    <body>
        <%-- Barre de Navigation --%>
        
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" style="height: 40px">
            <div class="container">
                <a class="navbar-brand" href="FrontControleur">MacDo</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="FrontControleur">Accueil</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="marge">
            <h1>Choix Nappage</h1>
            <br>
                <%-- On affiche les nappages --%>
                
            <form action="FrontControleur?section=ItemARajouterCtrl" method="GET">
                <center>    <div class="col-form-label">
                    <c:forEach var="n" items="${liste}">
                        
                                <%-- Image et checkbox --%>

                        <label class="container">
                            <img src="${n.imageUrl}" width="110px"><br>${n.nom} &nbsp<fmt:formatNumber value="${n.prix}" type = "currency"/>
                            <input type="radio" name="nappageId" value="${n.id}">
                            <span class="checkmark"></span>
                        </label>
                        <br>
                    </c:forEach>
                                        <%-- On affiche le bouton "nature" --%>

                    <label class="container">
                        <input type="radio" name="nappageId" value="nature">Nature
                        <span class="checkmark"></span>
                    </label>                     
                    </div> </center> <br>
                <center><input type="submit" value="Validez" name="validez"/>&nbsp&nbsp&nbsp<input type="submit" value="Annuler" name="annulez"/></center>
            </form>
        </div>
    </body>
</html>
