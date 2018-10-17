
package sousControleurs;

import entites.SousLigneDeCommande;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metiers.GererSousLigneDeCommandeLocal;

public class SousLigneDeCommandeCtrl implements SousControleurInterface,Serializable{

    

    

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        GererSousLigneDeCommandeLocal gererSousLigneDeCommande = lookupGererSousLigneDeCommandeLocal();
        List<SousLigneDeCommande> SsLigne = gererSousLigneDeCommande.listSsLigne();
        
        request.setAttribute("listCuisine",SsLigne);
        return "/WEB-INF/jspCuisine1.jsp";
    }

    private GererSousLigneDeCommandeLocal lookupGererSousLigneDeCommandeLocal() {
        try {
            Context c = new InitialContext();
            return (GererSousLigneDeCommandeLocal) c.lookup("java:global/MacDo/MacDo-ejb/GererSousLigneDeCommande!metiers.GererSousLigneDeCommandeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    
    
}
