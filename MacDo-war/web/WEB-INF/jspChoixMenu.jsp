<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Choix Menu</title>
    </head>
    <body>
        <h1>Votre menu :</h1>

        <div class="container">
            <h2>Le BURGER</h2>
            <div class="card">
                <div class="card-body">Accompagnement</div>
            </div>
            <br>
            <div class="card">
                <div class="card-body">Boisson</div>
                
            </div>
            <br>
            <div class="card">
                <div class="card-body">Sauce</div>
            </div>
        </div>
        <a href="FrontControleur?section=AccueilCtrl">VALIDER</a>
    </body>
</html>
