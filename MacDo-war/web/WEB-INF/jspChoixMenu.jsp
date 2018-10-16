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
        <div class="container">
            <center><h1>${taille} ${menu} <img src="${image}" width="200px"></h1></center>
            <br>
            <form action="FrontControleur" method="GET">
                <div class="card">
                    <div class="card-title">&nbsp${menu}</div>
                </div>
                <br>
                <div class="card">
                    <div class="card-title">&nbspLes accompagnements</div>
                    <div class="card-body">
                        <c:forEach var="a" items="${accompagnements}">
                            <br>
                            <label class="container">
                                <h4><img src="${a.imageUrl}" width="100px">${a.nom}</h4>
                                <input type="radio" name="accomId" value="${a.id}">
                                <span class="checkmark"></span>
                            </label>
                        </c:forEach>
                    </div>
                </div>
                <br>
                <div class="card">
                    <div class="card-title">&nbspLes boissons</div>
                    <div class="card-body">
                        <c:forEach var="b" items="${boissons}">
                            <br>
                            <label class="container">
                                <h4><img src="${b.imageUrl}" width="100px">${b.nom} ${b.volume} cl</h4>
                                <input type="radio" name="boissId" value="${b.id}">
                                <span class="checkmark"></span>
                            </label>
                        </c:forEach>
                    </div>
                </div>
                <br>
                <div class="card">
                    <div class="card-title">&nbspLes sauces</div>
                    <div class="card-body">
                        <c:forEach var="s" items="${sauces}">
                            <br>
                            <label class="container">
                                <h4><img src="${s.imageUrl}" width="100px">${s.nom}</h4>
                                <input type="radio" name="sauceId" value="${s.id}">
                                <span class="checkmark"></span>
                            </label>
                        </c:forEach>
                    </div>
                </div>
                <br>
                <center><button type="submit" value="OK" name="VALIDER"/>VALIDER</center>
            </form>
        </div>
        <%--<div class="panel-group" id="accordion">
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
        </div>--%>
    </body>
</html>
