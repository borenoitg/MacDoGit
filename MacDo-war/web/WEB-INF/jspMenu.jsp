<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<fmt:setLocale value="fr_FR"/>

<!-- Affichage de nos Menus -->
<c:if test="${menusTest != null}">
    <c:forEach var="m" items="${menusTest}">
        <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
              <a href="FrontControleur?section=ChoixMenuCtrl&menuid=${m.id}&menu=${m.nom}"><img class="card-img-top" src="${m.imageUrl}" width="200px"></a>
                <div class="card-body">
                    <h5 class="card-title">
                        <br>${m.nom} ${m.taille}<br><fmt:formatNumber value="${m.prix}" type = "currency"/>
                    </h5>
                </div>
                <div class="card-footer">
                    <a href="FrontControleur?section=ChoixMenuCtrl&menuid=${m.id}&menu=${m.nom}&taille=${m.taille}" class="btn btn-primary">Commander</a>
                </div>
            </div>
        </div>
   
</c:forEach>
</c:if>
