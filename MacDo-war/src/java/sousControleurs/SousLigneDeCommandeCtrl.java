
package sousControleurs;

import entites.Commande;
import entites.Commande_;
import entites.LigneDeCommande;
import entites.SousLigneDeCommande;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import metiers.GererSousLigneDeCommandeLocal;

public class SousLigneDeCommandeCtrl implements SousControleurInterface,Serializable{

    

    

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        
        String url = "/WEB-INF/jspCuisine1.jsp";
        GererSousLigneDeCommandeLocal gererSousLigneDeCommande = lookupGererSousLigneDeCommandeLocal();
        List<SousLigneDeCommande> SsLigne = gererSousLigneDeCommande.listSsLigne();
        request.setAttribute("listCuisine",SsLigne); 
        
        if(request.getParameter("validez")!= null ){
            url = "/WEB-INF/jspRecapitulatif.jsp";
        }
        if(request.getParameter("annuler")!= null){
            url = "/WEB-INF/jspFooter.jsp";
        }
         if(request.getParameter("validez2")!= null){
             ArrayList<LigneDeCommande> listL = (ArrayList<LigneDeCommande>) session.getAttribute("lignesdecommande");
             Commande c  = (Commande) session.getAttribute("commande");
             gererSousLigneDeCommande.creationSsLigne(listL,c);
            url = "/WEB-INF/jspFinCommande.jsp";
        }
        if(request.getParameter("ligneId")!= null){
            long d = Long.valueOf(request.getParameter("ligneId"));
            gererSousLigneDeCommande.listSsLigne(d);
            SsLigne = gererSousLigneDeCommande.listSsLigne();
            request.setAttribute("listCuisine",SsLigne);
            
        }
         
         
        
        request.setAttribute("listCuisine",SsLigne);
        return url;
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
