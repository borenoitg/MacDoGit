<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

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
                            <a class="nav-link" href="${urlCreateData}">Creation De Donnees
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

                    <h1 class="my-4">Shop Name</h1>
                    <div class="list-group">
                        <a href="#" class="list-group-item">Category 1</a>
                        <a href="#" class="list-group-item">Category 2</a>
                        <a href="#" class="list-group-item">Category 3</a>
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
                        <c:forEach items="${catalogue}" var="c">
                            <c:if test="${c == catalogue[0]}">
                               <div class="carousel-item active">
                                    <img class="d-block img-fluid" width="900" src="${c.imageUrl}">
                                </div> 
                            </c:if>
                            <c:if test="${c != catalogue[0]}">
                                <div class="carousel-item">
                                    <img class="d-block img-fluid" width="900"  src="${c.imageUrl}" alt="${c.nom}">
                                </div>
                            </c:if>
                        </c:forEach>
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
                        </div>

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

