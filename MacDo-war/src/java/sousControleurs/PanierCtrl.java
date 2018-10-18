package sousControleurs;

import entites.Commande;
import entites.ItemARajouter;
import entites.ItemARetirer;
import entites.LigneDeCommande;
import entites.Produit;
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
import metiers.GererItemLocal;
import metiers.PanierLocal;

public class PanierCtrl implements SousControleurInterface {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        GererItemLocal gererItem = lookupGererItemLocal();
        PanierLocal panier = lookupPanierLocal();

        if (request.getParameter("proId") != null) {
            Commande c = (Commande) session.getAttribute("commande");
            ArrayList<LigneDeCommande> lignesDeCommande = (ArrayList<LigneDeCommande>) session.getAttribute("lignesdecommande");
            Long id = (Long) session.getAttribute("proId");
            Produit p = gererItem.ProduitSelection(id);
            request.setAttribute("produit", p);

            if (c == null) {
                c = new Commande(new Date(), true);
                lignesDeCommande = new ArrayList<>();
            }
            //récupérer liste itemARetirer
//            ArrayList<String> listR = new ArrayList<>();
//            List<ItemARetirer> listeARetirer = (List<ItemARetirer>) session.getAttribute("listepro");
//            
//            for(ItemARetirer l : listeARetirer){
//                if(request.getParameter(l.getNom())!= null){
//                    listR.add(l.getNom());
//                    SousLigneDeCommandeCtrl n = new SousLigneDeCommandeCtrl();
//                    
//                }
//            }
            
             
                
                
                
                
            int qty = 1;
            LigneDeCommande lc = new LigneDeCommande(p.getTva().getTaux(), qty, p.getPrix(), null, p, c);

            lignesDeCommande.add(lc);
            c.setLigneDeCommandes(lignesDeCommande);
            session.setAttribute("lignesdecommande", lignesDeCommande);
            session.setAttribute("commande", c);

            }
        return "WEB-INF/home.jsp";
    }

    private PanierLocal lookupPanierLocal() {
        try {
            Context c = new InitialContext();
            return (PanierLocal) c.lookup("java:global/MacDo/MacDo-ejb/Panier!metiers.PanierLocal");
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
