<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Choix Menu</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="jspNavBar.jsp" flush="true"/>
    <center><h1>Votre menu :</h1></center>
    <br>
    <div class="container">
        <div class="card">
            <div class="card-title">${taille} ${menu}</div>
            </div>
        <br>
        <div class="card">
            <div class="card-body">
                <c:forEach var="a" items="${accompagnements}">

                    <label class="container">
                        <img src="${a.imageUrl}" width="100px">${a.nom}
                        <input type="radio" name="nappageId" value="${a.id}">
                        <span class="checkmark"></span>
                    </label>
                    <br>
                </c:forEach>
            </div>
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
    <br>
    <div class="panel-group" id="accordion">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
                        Collapsible Group 1</a>
                </h4>
            </div>
            <div id="collapse1" class="panel-collapse collapse in">
                <div class="panel-body">Lorem ipsum dolor sit amet, consectetur adipisicing elit,
                    sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
                    minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
                    commodo consequat.</div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">
                        Collapsible Group 2</a>
                </h4>
            </div>
            <div id="collapse2" class="panel-collapse collapse">
                <div class="panel-body">Lorem ipsum dolor sit amet, consectetur adipisicing elit,
                    sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
                    minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
                    commodo consequat.</div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">
                        Collapsible Group 3</a>
                </h4>
            </div>
            <div id="collapse3" class="panel-collapse collapse">
                <div class="panel-body">Lorem ipsum dolor sit amet, consectetur adipisicing elit,
                    sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
                    minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
                    commodo consequat.</div>
            </div>
        </div>
    </div>
    <center><a href="FrontControleur?section=AccueilCtrl">VALIDER</a></center>
</body>
</html>
