<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Affichage nouveaux produits -->
<c:if test="${nouveauxProduits != null}">
    <c:forEach var="p" items="${nouveauxProduits}">
        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top" src="${p.imageUrl}" alt="${p.nom}">
                <div class="card-body">
                    <h5 class="card-title">
                        <a href="#">${p.nom}</a>
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

<!-- Affichage des produits par sousType -->
<c:if test="${produitsBySousTypes != null}">
    <c:forEach var="p" items="${produitsBySousTypes}">
        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top" src="${p.imageUrl}" alt="${p.nom}">
                <div class="card-body">
                    <h5 class="card-title">
                        <a href="#">${p.nom}</a>
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

<!-- Affichage des frites et sauces -->
<c:if test="${friteSauce != null}">
    <c:forEach var="p" items="${friteSauce}">
        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top" src="${p.imageUrl}" alt="${p.nom}">
                <div class="card-body">
                    <h5 class="card-title">
                        <a href="#">${p.nom}</a>
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