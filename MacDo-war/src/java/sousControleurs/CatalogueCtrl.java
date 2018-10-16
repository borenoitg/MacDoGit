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
        GererItemLocal gererItem = lookupGererItemLocal();
        CatalogueLocal catalogue = lookupCatalogueLocal();

//        List<Produit> produits = catalogue.listeProduit();
//        request.setAttribute("catalogue", produits);
        List<Produit> produitCarroussel = catalogue.listeProduitNouveaute("Nouveaute");
        request.setAttribute("produitCarroussel", produitCarroussel);

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
        } //Recupération de produits par SousType
        else {
            produitTest = catalogue.gestionSideBar(nom, detail);
            request.setAttribute("produitTest", produitTest);
        }

        //panier
        if (request.getParameter("prodId") != null) {
            Long id;
            Commande c = (Commande) session.getAttribute("panier");
            id = Long.valueOf(request.getParameter("prodId"));
            Produit p = gererItem.ProduitSelection(id);
            
            if (session.getAttribute("commande") == null) {
                 c = new Commande(new Date(), true);
                session.setAttribute("commande",c);
            }
            int qty = 1;
            LigneDeCommande lc = new LigneDeCommande(p.getTva().getTaux(), qty, p.getPrix(), null, p, c);
            ArrayList<LigneDeCommande> lignesDeCommande = new ArrayList<>();
            lignesDeCommande.add(lc);
            c.setLigneDeCommandes(lignesDeCommande);
            request.setAttribute("Commande", c);
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

    private GererItemLocal lookupGererItemLocal() {
        try {
            Context c = new InitialContext();
            return (GererItemLocal) c.lookup("java:global/MacDo/MacDo-ejb/GererItem!metiers.GererItemLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
