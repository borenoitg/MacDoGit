package sousControleurs;

import entites.ItemARajouter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metiers.GererItemLocal;

public class ItemARajouterCtrl implements SousControleurInterface {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        GererItemLocal gererItem = lookupGererItemLocal();
        List<ItemARajouter> liste =  gererItem.LesItemsARajouter();
//        request.setAttribute("premier", liste.get(0));
//        liste.remove(0);
        request.setAttribute("liste", liste);
        request.getParameter("itemarajouterId");
        
        return "/WEB-INF/jspNappage.jsp";
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
