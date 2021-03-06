package sousControleurs;

import entites.Commande;
import entites.LigneDeCommande;
import entites.Menu;
import entites.Produit;
import entites.SousType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import metiers.CatalogueLocal;
import metiers.GererItemLocal;

public class CatalogueCtrl implements SousControleurInterface, Serializable {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        CatalogueLocal catalogue = lookupCatalogueLocal();

//        List<Produit> produits = catalogue.listeProduit();
//        request.setAttribute("catalogue", produits);
        List<Produit> produitCarroussel = catalogue.listeProduitNouveaute("Nouveaute");
        request.setAttribute("produitCarroussel", produitCarroussel);
        Long id;
        if (request.getParameter("proId") != null) {
            id = Long.valueOf(request.getParameter("proId"));
            session.setAttribute("proId", id);
        }
        
        if(request.getParameter("produitId") != null){
            Long produitid = Long.valueOf(request.getParameter("produitId"));
            Produit produit = catalogue.descriptionProduit(produitid);
            request.setAttribute("produitDescription", produit);
            
            return"/WEB-INF/jspDescription.jsp";
        }

        String nom = request.getParameter("nom");
        String detail = request.getParameter("detail");
        
        System.out.println(">>>>>>>>> NOM : " + nom);
        System.out.println(">>>>>>>>> DETAIL : " + detail);

        List<SousType> sousTypeTest = null;
        List<Produit> produitTest = null;
        List<Menu> menusTest = null;

        //Récupération et envoie des menus
        if (nom.equalsIgnoreCase("Menu")) {

            menusTest = catalogue.gestionSideBarMenu();
            request.setAttribute("menusTest", menusTest);
            System.out.println(menusTest.isEmpty());
        } //Récupération et envoie des sousTypes par rapport à un type
        else if (((nom.equalsIgnoreCase("Boisson"))
                || (nom.equalsIgnoreCase("Dessert"))) && (detail == null)) {

            sousTypeTest = catalogue.gestionSideBarSousType(nom);
            request.setAttribute("sousTypeTest", sousTypeTest);
        }//Recupération de produits par SousType
        else {
            produitTest = catalogue.gestionSideBar(nom, detail);
            request.setAttribute("produitTest", produitTest);
        }
        return "/WEB-INF/home.jsp";
        
    }

    private CatalogueLocal lookupCatalogueLocal() {
        try {
            Context c = new InitialContext();
            return (CatalogueLocal) c.lookup("java:global/MacDo/MacDo-ejb/Catalogue!metiers.CatalogueLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
