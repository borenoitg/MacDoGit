
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/style.css" />
        <title>Accueil</title>
    </head>
    <body>
        <h1>Create DATA</h1>
        <c:url value="FrontControleur?section=CreationDeDonneesCtrl" var="url02" />
        <a class="nav-link" href="${url02}">creer les données</a>
        <h1>Produits</h1>
        <c:forEach items = "${catalogue}" var = "c">
            <<h3 class="produits"><center>${c.nom}</center></h3>
            <center class="image"><img src ="${c.imageUrl}"></center>
        </c:forEach>
        <h4>YEAH MAN</h4>
    </body>
</html>
