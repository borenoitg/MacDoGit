
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="http://localhost:8080/MacDo-war/css/style.css" />

        <title>Accueil Borne</title>
    </head>
    <body>

        <c:url value="FrontControleur?section=MainMenuCtrl" var="urlHome" />
        <c:import url="${urlHome}" />

        <h1>Produits</h1>




        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>

<script>
    $(document).ready(function () {

        console.log("Document ready!");
        var vMenu2 = $.get('menu');
        
        console.log("vMenu2 = "+vMenu2);
        
        $("#features").click(function () {
            $("#features").attr('class', 'nav-link disabled');
            $("#createdata").attr('class', 'nav-link');
            $("#pricing").attr('class', 'nav-link');
            $("#other").attr('class', 'nav-link');
        });

        $("#createdata").click(function () {
            $("#features").attr('class', 'nav-link');
            $("#createdata").attr('class', 'nav-link disabled');
            $("#pricing").attr('class', 'nav-link');
            $("#other").attr('class', 'nav-link');
        });

        $("#pricing").click(function () {
            $("#features").attr('class', 'nav-link');
            $("#createdata").attr('class', 'nav-link');
            $("#pricing").attr('class', 'nav-link pricing');
            $("#other").attr('class', 'nav-link');
        });

        $("#other").click(function () {
            $("#features").attr('class', 'nav-link');
            $("#createdata").attr('class', 'nav-link');
            $("#pricing").attr('class', 'nav-link');
            $("#other").attr('class', 'nav-link disabled');
        });
    });
</script>
