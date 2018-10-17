<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Affichage des sousType par rapport à un type-->

<c:if test="${sousTypeTest != null}">
    <c:forEach var="s" items="${sousTypeTest}">
        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card">
                <img class="card-img-top" src="${s.imageUrl}" alt="${s.nom}">
                <div class="card-body">
                    <h4 class="card-title">${s.nom}</h4>
                </div>
                <div class="card-footer">
                    <a href="FrontControleur?section=CatalogueCtrl&nom=${s.type.nom}&detail=${s.nom}" class="btn btn-primary">AFFICHER</a>
                </div>
            </div>
        </div>
    </c:forEach>
</c:if>