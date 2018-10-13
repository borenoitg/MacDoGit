package sousControleurs;

import entites.ItemARajouter;
import entites.ItemARetirer;
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
import metiers.GererItemLocal;

public class PersonnaliserCtrl implements SousControleurInterface {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        GererItemLocal gererItem = lookupGererItemLocal();
        Long id;
        id = Long.valueOf(request.getParameter("prodId"));

        List<ItemARetirer> liste = gererItem.ItemARetirerAAfficher(id);
        List<Produit> sauces = gererItem.SaucesNugget();
        List<Produit> saucesSalade = gererItem.SaucesSalade();
        session.setAttribute("prodId", id);
        Produit p = gererItem.ProduitSelection(id);
        request.setAttribute("objetProduit", p);

        request.setAttribute("soustype", request.getParameter("soustype"));
        request.setAttribute("produit", request.getParameter("produit"));
        request.setAttribute("listepro", liste);
        request.setAttribute("listeSauces", sauces);
        request.setAttribute("listeSaucesSalade", saucesSalade);

        
        if ((p.getItemsARetirer().isEmpty()) && (p.getItemARajoutes().isEmpty()) && !((request.getParameter("soustype").equals("Burger")) ||(request.getParameter("soustype").equals("Salade"))) ) {
            return "/WEB-INF/home.jsp";
        }
        if ((p.getItemsARetirer().isEmpty()) && !(p.getItemARajoutes().isEmpty())) {
            request.setAttribute("liste", gererItem.LesItemsARajouter());
            request.getParameter("itemarajouterId");
            return "/WEB-INF/jspNappage.jsp";
        }

        return "/WEB-INF/jspPersonnaliser.jsp";
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
