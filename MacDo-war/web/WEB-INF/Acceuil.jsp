
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>        <link rel="stylesheet" href="./css/style.css" />
        <title>Accueil</title>
    </head>
    <body>
        <h1>Create DATA</h1>
        <c:url value="FrontControleur?section=CreationDeDonneesCtrl" var="url02" />
        <a class="nav-link" href="${url02}">créer les données</a>
        <h1>Produits</h1>

        <c:forEach items = "${catalogue}" var = "c">
            <h3 class="produits"><center>${c.nom}</center></h3>

        <center class="image"><img class="img-thumbnail" src ="${c.imageUrl}"  width = 200px ></center>


        <center>${c.description}</center>
        </c:forEach>

    <h4>YEAH MAN</h4>
</body>
</html>
