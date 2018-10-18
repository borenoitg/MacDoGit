<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
    <fmt:setLocale value="fr_FR"/>

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>MacDo</title>

        <!-- Bootstrap core CSS -->
        <link href="http://localhost:8080/MacDo-war/bootstrapv4/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="http://localhost:8080/MacDo-war/bootstrapv4/css/shop-homepage.css" rel="stylesheet">
        <link rel="stylesheet" href="http://localhost:8080/MacDo-war/css/style.css" />

    </head>

    <body>
        <!-- Navigation -->
        <%@ include file="jspNavBar.jsp" %>

        <!-- Page Content -->
        <div class="container">
            <div class="row align-items-center justify-content-between">
                <div class="col-lg-6 col-md-12 col-sm-12 about-left">
                    <img class="img-fluid" src="${produitDescription.imageUrl}" alt="${produitDescription.nom}">
                </div>
                <div class="col-lg-6 col-md-12 col-sm-12 about-right">
                    <span class="lnr lnr-sun"></span>
                    <h1 class="text-uppercase">

                        <span>${produitDescription.nom}${p.taille}</span> <br>
                        <fmt:formatNumber value="${p.prix}" type = "currency"/>
                    </h1>
                    <p>
                    ${produitDescription.description}
                    </p>
                    <img style="width: 40%; height: auto;" src="./Images/allergeine.png"
                </div>
            </div>

    </body>
</html>
