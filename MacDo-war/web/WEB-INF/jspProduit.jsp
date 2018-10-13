<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <fmt:setLocale value="fr_FR"/>

<!-- Affichage des  produits -->

<c:if test="${produitTest != null}">
    <c:forEach var="p" items="${produitTest}">
        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
              <a href="FrontControleur?section=PersonnaliserCtrl&prodId=${p.id}&produit=${p.nom}&soustype=${p.soustype.nom}"><img class="card-img-top" src="${p.imageUrl}" width="200px"></a>
                <div class="card-body">
                    <h5 class="card-title">
                        <br>${p.nom} ${p.taille}<br><fmt:formatNumber value="${p.prix}" type = "currency"/>
                    </h5>
                </div>
                <div class="card-footer">
                    <a href="FrontControleur?section=PersonnaliserCtrl&prodId=${p.id}&produit=${p.nom}&soustype=${p.soustype.nom}" class="btn btn-primary">Commander</a>
                </div>
            </div>
        </div>
    </c:forEach>
</c:if>
