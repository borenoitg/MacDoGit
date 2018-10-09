package sousControleurs;

import entites.Produit;
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

public class BurgerCtrl implements SousControleurInterface {

    private CatalogueLocal lookupCatalogueLocal() {
        try {
            Context c = new InitialContext();
            return (CatalogueLocal) c.lookup("java:global/MacDo/MacDo-ejb/Catalogue!metiers.CatalogueLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        CatalogueLocal catalogue = lookupCatalogueLocal();

        List<Produit> produits = catalogue.listeBurger();
        request.setAttribute("liste", produits);
        return "/WEB-INF/jspBurgertiti.jsp";
    }

}
