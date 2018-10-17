<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">    
        <title>Cuisine</title>
    </head>
    <body>
       
        <div class="container">
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th>Number</th>
                        <th>Burger</th>
                        <th>Date</th>
                        <th>Quantité</th>
                        <th>Ingrédients à Retirer</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listCuisine}" var="c">
                    <tr>
                        <td>${c.id}</td>
                        <td>${c.produit.nom}</td>
                        <td>
                            <fmt:formatDate value="${c.ligneCommande.commande.dateCommande}" pattern="EEEE dd MMMM yyyy HH:mm:ss" />
                        </td>
                        <td>${c.ligneCommande.quantite}</td>
                        <td><c:forEach items="${c.getItemsARetirer()}" var="var">
                                <c:out value="${var.nom}"/>
                                <c:out value=" "/>
                                
                            </c:forEach>
                         
                            </td>
                           <td>
                            <input id="champ" type="button" value="En cours de préparation" onClick="doModifie()"/>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <!-- Optional JavaScript -->
        <script>
             function doModifie() {
      document.getElementById('champ').value= "Ok";
    }
            </script>
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>    
    </body>
</html>
