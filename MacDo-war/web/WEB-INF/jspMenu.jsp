<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Affichage de nos Menus -->
<c:if test="${menus != null}">
    <c:forEach var="m" items="${menus}">
        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
                <img class="card-img-top" src="${m.imageUrl}" alt="${m.nom}">
                <div class="card-body">
                    <h5 class="card-title">
                        <a href="#">${m.nom}</a>
                    </h5>
                    <h6>${m.prix}</h6>
                </div>
                <div class="card-footer">
                    <a href="#" class="btn btn-primary">Commander</a>
                </div>
            </div>
        </div>
    </c:forEach>
</c:if>