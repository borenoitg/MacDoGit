package sousControleurs;

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

        HttpSession session = request.getSession();;
        GererItemLocal gererItem = lookupGererItemLocal();
        Long id;
        id = Long.valueOf(request.getParameter("burgerId"));

        List<ItemARetirer> liste = gererItem.ItemARetirerAAfficher(id);
        liste.remove(0);
        List<Produit> sauces = gererItem.SaucesNugget();
        session.setAttribute("burgerId", id);
        Produit p = gererItem.ProduitSelection(id);
        request.setAttribute("objetBurger", p);
        request.setAttribute("nomBurger", request.getParameter("burger"));
        request.setAttribute("listepro", liste);
        request.setAttribute("listesauces", sauces);
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
