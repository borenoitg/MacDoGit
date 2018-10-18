
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <c:url value="/WEB-INF/menus/menu2.jsp" var="urlmenu2"/>
        <c:import url="${urlmenu2}" />
    </head>
    <body>
        <br>
        <br>
        <br>
    <center><h2>Merci de Votre Confiance et A bientôt</h2></center><br>
    <center><h3><a href="FrontControleur">Aceuil</a></h3></center>
        
    </body>
</html>
