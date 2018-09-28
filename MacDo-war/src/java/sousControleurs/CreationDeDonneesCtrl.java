package sousControleurs;

import entites.Produit;
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
import metiers.CreationDeDonneesLocal;

public class CreationDeDonneesCtrl implements SousControleurInterface, Serializable {


    @Override
    public String execute(HttpServletRequest request,
             HttpServletResponse response) {

        CreationDeDonneesLocal creationDeDonnees = lookupCreationDeDonneesLocal();

        creationDeDonnees.creationDonnees();

        CatalogueLocal catalogue = lookupCatalogueLocal();       
        List<Produit> produits = catalogue.listeProduit();
        request.setAttribute("catalogue", produits);

        return "/WEB-INF/Acceuil.jsp";
    }

    private CreationDeDonneesLocal lookupCreationDeDonneesLocal() {
        try {
            Context c = new InitialContext();
            return (CreationDeDonneesLocal) c.lookup("java:global/MacDo/MacDo-ejb/CreationDeDonnees!metiers.CreationDeDonneesLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
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
