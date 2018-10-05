<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap core CSS -->
        <link href="http://localhost:8080/MacDo-war/bootstrapv4/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="http://localhost:8080/MacDo-war/bootstrapv4/css/shop-homepage.css" rel="stylesheet">
        <link rel="stylesheet" href="http://localhost:8080/MacDo-war/css/style.css" />
        <title>Nappages</title>
        <fmt:setLocale value="fr_FR"/>

    </head>
    <body>
        <h1>Choix Nappage</h1>

        <c:forEach var="n" items="${liste}">
        <center>
            <a href="FrontControleur"><img src="${n.imageUrl}"><br>${n.nom}<br><fmt:formatNumber value="${n.prix}" type = "currency"/><br></a>
        </center>
    </c:forEach>

</body>
</html>
