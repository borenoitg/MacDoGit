
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <c:url value="FrontControleur" var="urlHome" />
    <a class="navbar-brand" href="${urlHome}"><img src="./Images/logos/logo56x50.png"/></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <c:url value="FrontControleur?section=CreationDeDonneesCtrl" var="urlCreationDonnee" />
                <a class="nav-link" href="${urlCreationDonnee}" id="createdata">Creation Donnees <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <c:url value="FrontControleur" var="urlHome" />
                <a class="nav-link" href="${urlHome}" id="features">Features</a>
            </li>
            <li class="nav-item">
                <c:url value="FrontControleur" var="urlHome" />
                <a class="nav-link" href="#" id="pricing">Pricing</a>
            </li>
            <li class="nav-item">
                <c:url value="FrontControleur" var="urlHome" />
                <a class="nav-link" href="${urlHome}" id="other">Disabled</a>
            </li>
        </ul>
    </div>
</nav>
    
