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
        <title>Personnaliser</title>
    </head>
    <body>
        <%-- nav bar--%>

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" style="height: 30px">
            <div class="container">
                <a class="navbar-brand" href="#">MacDo</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation" >
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
        <%-- Titre--%>
        <div class="marge">
            <h1>Personnaliser</h1>
            <center><h2>${produit} <c:if test="${produit == 'Chicken McNuggets'}">${objetProduit.taille}</c:if></h2></center>

            <%-- Si ce sont des salades --%>

            <form action="FrontControleur" method="GET">
                <c:if test="${soustype == 'Salade'}">
                    <c:forEach var="n" items="${listeSaucesSalade}">
                        <center><img src="${n.imageUrl}" width="200px"><br>
                            <%-- Rounded switch --%>
                            <label class="switch">
                                <input type="checkbox" name="saucesaladeId" value="${n.id}" >
                                <span class="slider round"></span><br><br>${n.nom}
                            </label></center>
                        <br>
                    </c:forEach>     
                    <%-- On affiche les boutons de validation --%>
                    <br><br><br><br><br>
                    <center> <input type="submit" value="Validez" name="validez"/>&nbsp&nbsp&nbsp<input type="submit" value="Annuler" name="annulez"/></center>
                    </c:if>
            </form>
            <%-- Si ce sont des nuggets alors on affiche les sauces --%>

            <form action="FrontControleur" method="GET">
                <c:if test="${produit == 'Chicken McNuggets'}">
                    <c:forEach var="n" items="${listeSauces}">
                        <center><img src="${n.imageUrl}" width="100px">
                            <%-- Rounded switch --%>
                            <label class="switch">
                                <input type="checkbox" name="sauceId" value="${n.id}" >
                                <span class="slider round"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp${n.nom}
                            </label></center>
                        <br>
                    </c:forEach>     
                    <%-- On affiche les boutons de validation --%>
                    <br><br>
                    <center> <input type="submit" value="Validez" name="validez"/>&nbsp&nbsp&nbsp<input type="submit" value="Annuler" name="annulez"/></center>
                    </c:if>
            </form>
            <%-- Si ce pas des nuggets alors on affiche les ingredients --%>

            <c:if test="${produit != 'Chicken McNuggets'}">

                <%-- On affiche le pain du haut correspondant au sandwich --%>

                <c:if test="${(produit != 'Mc Wrap™ Chèvre') && (produit != 'Croque McDo™')&& (produit != 'Chicken McNuggets') && (soustype !='Salade')}">
                    <center><img src="./Images/Painburgerhaut.jpg" width="180px"</center>
                    </c:if>
                    <c:if test="${produit == 'Mc Wrap™ Chèvre'}">
                    <center><img src="./Images/wrap.jpg" width="180px"</center>
                    </c:if>
                    <c:if test="${produit == 'Croque McDo™'}">
                    <center><img src="./Images/croq.png" width="180px"</center>
                    </c:if>
                    <%-- On affiche les ingredients du sandwich --%>

                <form action="FrontControleur" method="GET">
                    <c:forEach var="n" items="${listepro}">
                        <img src="${n.imageUrl}" width="100px">

                        <%-- Rounded switch --%>

                        <label class="switch">
                            <input type="checkbox" name="${n.nom}" value="${n.id}" checked>
                            <span class="slider round"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp${n.nom}
                        </label>
                        <br>
                    </c:forEach> 
                    <%-- On affiche le pain du bas correspondant au sandwich --%>

                    <center>     
                        <c:if test="${produit == 'Croque McDo™'}">
                            <img src="./Images/croq.png" width="180px"
                            </c:if>

                            <c:if test="${(produit ne 'Mc Wrap™ Chèvre') && (produit ne 'Chicken McNuggets') && (nom ne 'Croque McDo™') && (soustype !='Salade')}">
                                <img src="./Images/Painburgerbas.jpeg" width="180px">
                        </c:if>
                    </center>

                    <%-- On affiche les boutons de validation --%>

                    <c:if test="${(produit != 'Chicken McNuggets') && (soustype !='Salade')}">
                        <br>
                        <center> <input type="submit" value="Validez" name="validez"/>&nbsp&nbsp&nbsp<input type="submit" value="Annuler" name="annulez"/></center>
                        </c:if>
                    </c:if>
            </form>
        </div>
    </body>
</html>
