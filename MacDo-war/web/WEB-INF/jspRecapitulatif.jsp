<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">    
        <title>resulatDesCoures</title>
    </head>
    <body>
       
        <div class="container">
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th>Article</th>
                        <th>Nom</th>
                        <th>Prix unitaire TCC</th>
                        <th>Quantité</th>
                        <th>Prix TCC</th>
                        <th>TVA</th>
                        <th>Date</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${lignesdecommande}" var="lc">
                        <c:set  var="total" value="${(total + (lc.produit.prix*lc.quantite))}" />
                    <tr>
                        <td><img class="card-img-top mx-auto d-block" style=" width: 60px;" src = "${lc.produit.imageUrl}" alt ="illustration" ></td>
                        <td>${lc.produit.nom}</td>
                        <td><fmt:formatNumber value="${lc.produit.prix}" type="currency"/></td>
                        <td>${lc.quantite}</td>
                        <td><fmt:formatNumber value="${lc.produit.prix*lc.quantite}" type="currency"/></td>
                        <td>${lc.tva} % </td>
                        <td>
                            <fmt:formatDate value="${commande.dateCommande}" pattern="EEEE dd MMMM yyyy HH:mm:ss" />
                        </td>
                          
                    </tr>
                    </c:forEach>
                    
                </tbody>
            </table>
             <div>  <h2>Total de la commande TTC : <strong><fmt:formatNumber value="${total}" type="currency"/></strong></h2>
        
        
          <form action="FrontControleur?section=SousLigneDeCommandeCtrl" method="POST">

               <center><input type="submit" value="Validez" name="validez2"/>&nbsp&nbsp&nbsp<input type="submit" value="Annuler" name="annulez2"/></center></form>  
        </div>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>    
    
        </body>
</html>
