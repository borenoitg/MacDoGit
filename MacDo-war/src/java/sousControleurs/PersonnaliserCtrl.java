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
        id = Long.valueOf(request.getParameter("proId"));

        List<ItemARetirer> liste = gererItem.ItemARetirerAAfficher(id);
        List<Produit> sauces = gererItem.SaucesNugget();
        List<Produit> saucesSalade = gererItem.SaucesSalade();
        session.setAttribute("proId", id);
        Produit p = gererItem.ProduitSelection(id);
        session.setAttribute("objetProduit", p);

        request.setAttribute("nom", request.getParameter("nom"));
        request.setAttribute("soustype", request.getParameter("soustype"));
        request.setAttribute("produit", request.getParameter("produit"));
        request.setAttribute("listepro", liste);
        request.setAttribute("listeSauces", sauces);
        request.setAttribute("listeSaucesSalade", saucesSalade);

        if (p.getDescription() != null) {
            if ((p.getDescription().equals("nappage"))) {
                request.setAttribute("liste", gererItem.LesItemsARajouter());
                request.setAttribute("proId", request.getParameter("proId"));
                return "/WEB-INF/jspNappage.jsp";
            }
        }
        if (request.getParameter("soustype").equals("Pommes de Terre")) {
            request.setAttribute("proId", request.getParameter("proId"));
            return "FrontControleur?section=PanierCtrl";
        } else if ((p.getItemsARetirer().isEmpty() && (p.getItemARajouter() == null) && !(request.getParameter("soustype").equals("Salade") || (request.getParameter("soustype").equals("Burger"))))) {
            request.setAttribute("proId", request.getParameter("proId"));
            return "FrontControleur?section=PanierCtrl";
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
