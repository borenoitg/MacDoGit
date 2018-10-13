<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <fmt:setLocale value="fr_FR"/>

<!-- Affichage nouveaux produits -->
<c:if test="${produitTest != null}">
    <c:forEach var="p" items="${produitTest}">
        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top" src="${p.imageUrl}" alt="${p.nom}">
                <div class="card-body">
                    <h5 class="card-title">
                        <a href="">${p.nom}</a>
                    </h5>
                    <h6>${p.prix}</h6>
                </div>
                <div class="card-footer">
                    <a href="#" class="btn btn-primary">Commander</a>
                </div>
            </div>
        </div>
    </c:forEach>
</c:if>
