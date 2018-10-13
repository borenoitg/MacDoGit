package sousControleurs;

import entites.Menu;
import entites.Produit;
import entites.SousType;
import entites.Statut;
import entites.Type;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metiers.CatalogueLocal;

public class CatalogueCtrl implements SousControleurInterface, Serializable {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        CatalogueLocal catalogue = lookupCatalogueLocal();
        List<Produit> produits = catalogue.listeProduit();
        request.setAttribute("catalogue", produits);

        List<Produit> nouveauxProduits = null;
        List<Menu> menus = null;
        List<Produit> produitsBySousTypes = null;
        List<SousType> sousTypeByTypes = null;
        List<Produit> friteSauce = null;
        request.setAttribute("soustype", request.getParameter("soustype"));
        String nom = request.getParameter("nom");
        String detail = request.getParameter("detail");
        
        System.out.println(">>>>>>>>> NOM : " + nom);
        System.out.println(">>>>>>>>> DETAIL : " + detail);

        //Recupération et envoie des nouveautés
        if (nom.equalsIgnoreCase("Nouveaute")) {
            nouveauxProduits = catalogue.listeProduitNouveaute();
            request.setAttribute("nouveauxProduits", nouveauxProduits);

        }

        //Récupération et envoie des produits par sousType
        if ((nom.equalsIgnoreCase("Burger"))
                || (nom.equalsIgnoreCase("Salade")) || (detail != null)) {
            if (detail != null) {
                nom = detail;
            }
            
            produitsBySousTypes = catalogue.listeProduitBySousType(nom);
            request.setAttribute("produitsBySousTypes", produitsBySousTypes);
        }

        //Récupération et envoie des sousTypes par rapport à un type
        if ((nom.equalsIgnoreCase("Boisson"))
                || (nom.equalsIgnoreCase("Dessert"))) {
            sousTypeByTypes = catalogue.listSousTypeByType(nom);
            request.setAttribute("sousTypeByTypes", sousTypeByTypes);
        }

        //Récupération et envoie des menus
        if (nom.equalsIgnoreCase("Menu")) {
            menus = catalogue.listMenu();
            request.setAttribute("menus", menus);
            
        } //Récupération et envoie des sauces et frites
        else if (nom.equalsIgnoreCase("FriteSauce")) {

            String sousTypeUn = "Pommes de Terre";
            String sousTypeDeux = "Sauce";
            friteSauce = catalogue.listeProduitBySousType(sousTypeUn, sousTypeDeux);

            request.setAttribute("friteSauce", friteSauce);
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
