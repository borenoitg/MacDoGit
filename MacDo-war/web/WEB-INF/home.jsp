<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
        <fmt:setLocale value="fr_FR"/>

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>MacDo</title>

        <!-- Bootstrap core CSS -->
        <link href="http://localhost:8080/MacDo-war/bootstrapv4/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="http://localhost:8080/MacDo-war/bootstrapv4/css/shop-homepage.css" rel="stylesheet">
        <link rel="stylesheet" href="http://localhost:8080/MacDo-war/css/style.css" />


    </head>

    <body>

        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" style="height: 30px">
            <div class="container">
                <a class="navbar-brand" href="#">MacDo</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">
                            <c:url value="FrontControleur?section=CreationDeDonneesCtrl" var="urlCreateData" />
                            <a class="nav-link" href="${urlCreateData}">Création De Donnees
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="FrontControleur?section=ItemARajouterCtrl">Pour essai Nappage</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="FrontControleur?section=BurgerCtrl">Pour essai Burgertiti</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="FrontControleur?section=PersonnaliserCtrl">Pour essai Personnaliser</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Page Content -->

        <div class="container">

            <div class="row">

                <div class="col-lg-3">

                    <h3 class="my-4">NOTRE CARTE</h3>
                    <div class="list-group">

                        <a href="FrontControleur?section=CatalogueCtrl&nom=Nouveaute" class="list-group-item"><img src="./Images/enCeMoment.png" alt="En ce Moment"/>  En ce Moment</a>
                        <a href="FrontControleur?section=CatalogueCtrl&nom=Menu" class="list-group-item"><img src="./Images/nosMenus.png" alt="Nos Menus"/>Nos Menus</a>
                        <a href="FrontControleur?section=CatalogueCtrl&nom=Burger" class="list-group-item"><img src="./Images/nosSandwichs.png" alt="Nos Sandwichs"/>Nos Sandwichs</a>
                        <a href="FrontControleur?section=CatalogueCtrl&nom=Boisson" class="list-group-item"><img src="./Images/nosBoissons.png" alt="Nos Boissons"/>Nos Boissons</a>
                        <a href="FrontControleur?section=CatalogueCtrl&nom=Dessert" class="list-group-item"><img src="./Images/nosDessert.png" alt="Nos Desserts"/>Nos Desserts</a>
                        <a href="FrontControleur?section=CatalogueCtrl&nom=Salade" class="list-group-item"><img src="./Images/nosSalades.png" alt="Nos Salades"/>Nos Salades</a>
                        <a href="FrontControleur?section=CatalogueCtrl&nom=HappyMeal" class="list-group-item"><img src="./Images/happyMeal.png" alt="Happy Meal"/>Happy Meal</a>
                        <a href="FrontControleur?section=CatalogueCtrl&nom=FriteSauce" class="list-group-item"><img src="./Images/nosFritesSauces.png" alt="Frites & Sauces"/>Frites & Sauces</a>

                    </div>

                </div>
                <!-- /.col-lg-3 -->

                <div class="col-lg-9">
                    <!-- Begin Caroussel -->
                    <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                        </ol>

                        <div class="carousel-inner" role="listbox">
                            <c:if test="${produitCarroussel == null}">
                                <div class="carousel-item active">
                                    <img class="d-block img-fluid" width="900" src="./Images/boeufRanch.png">
                                </div> 
                                <div class="carousel-item ">
                                    <img class="d-block img-fluid" width="900" src="./Images/DoubleBlueCheeseBacon.png">
                                </div> 
                                <div class="carousel-item ">
                                    <img class="d-block img-fluid" width="900" src="./Images/280SignatureBeef.png">
                                </div> 
                            </c:if>
                            <c:if test="${produitCarroussel != null}">
                                <c:forEach items="${produitCarroussel}" var="c">
                                    <c:if test="${c == produitCarroussel[0]}">
                                        <div class="carousel-item active">
                                            <img class="d-block img-fluid" width="900" src="${c.imageUrl}">
                                        </div> 
                                    </c:if>
                                    <c:if test="${c != produitCarroussel[0]}">
                                        <div class="carousel-item">
                                            <img class="d-block img-fluid" width="900"  src="${c.imageUrl}" alt="${c.nom}">
                                        </div>
                                    </c:if>
                                </c:forEach>
                            </c:if>

                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>

                    <!-- End Caroussel -->

                    <div class="row">

                        <!-- Affichage nouveaux produits -->
                        <c:if test="${produitTest != null}">
                            <jsp:include page="jspProduit.jsp" flush="true" />
                        </c:if>

                        <!-- Affichage de nos Menus -->
                        <c:if test="${menusTest != null}">
                            <jsp:include page="jspMenu.jsp" flush="true" />
                        </c:if>
                        <!-- Affichage des choix du menu -->
                        <c:if test="${boissons != null}">
                            <jsp:include page="jspChoixMenu.jsp" flush="true" />
                        </c:if>

                        <!-- Affichage des sousType par rapport à un type-->
                        <c:if test="${sousTypeTest != null}">
                            <jsp:include page="jspSousType.jsp" flush="true" />
                        </c:if>


                        <!--                        <div class="col-lg-3 col-md-6 mb-4">
                                                    <div class="card">
                                                        <img class="card-img-top" src="http://placehold.it/500x325" alt="">
                                                        <div class="card-body">
                                                            <h4 class="card-title">Card title</h4>
                                                            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
                                                        </div>
                                                        <div class="card-footer">
                                                            <a href="#" class="btn btn-primary">Find Out More!</a>
                                                        </div>
                                                    </div>
                                                </div>
                        
                                                <div class="col-lg-3 col-md-6 mb-4">
                                                    <div class="card">
                                                        <img class="card-img-top" src="http://placehold.it/500x325" alt="">
                                                        <div class="card-body">
                                                            <h4 class="card-title">Card title</h4>
                                                            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo magni sapiente, tempore debitis beatae culpa natus architecto.</p>
                                                        </div>
                                                        <div class="card-footer">
                                                            <a href="#" class="btn btn-primary">Find Out More!</a>
                                                        </div>
                                                    </div>
                                                </div>
                        
                                                <div class="col-lg-3 col-md-6 mb-4">
                                                    <div class="card">
                                                        <img class="card-img-top" src="http://placehold.it/500x325" alt="">
                                                        <div class="card-body">
                                                            <h4 class="card-title">Card title</h4>
                                                            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
                                                        </div>
                                                        <div class="card-footer">
                                                            <a href="#" class="btn btn-primary">Find Out More!</a>
                                                        </div>
                                                    </div>
                                                </div>
                        
                                                <div class="col-lg-3 col-md-6 mb-4">
                                                    <div class="card">
                                                        <img class="card-img-top" src="http://placehold.it/500x325" alt="">
                                                        <div class="card-body">
                                                            <h4 class="card-title">Card title</h4>
                                                            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo magni sapiente, tempore debitis beatae culpa natus architecto.</p>
                                                        </div>
                                                        <div class="card-footer">
                                                            <a href="#" class="btn btn-primary">Find Out More!</a>
                                                        </div>
                                                    </div>
                                                </div>-->

                    </div>
                    <!-- /.row -->

                </div>
                <!-- /.row -->

            </div>
            <!-- /.col-lg-9 -->

        </div>
        <!-- /.row -->
    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
        <div class="container">
            <p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
        </div>
        <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="http://localhost:8080/MacDo-war/bootstrapv4/vendor/jquery/jquery.min.js"></script>
    <script src="http://localhost:8080/MacDo-war/bootstrapv4/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>

