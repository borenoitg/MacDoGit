package sousControleurs;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metiers.GererMenuLocal;

public class ChoixMenuCtrl implements SousControleurInterface {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
            GererMenuLocal gererMenu = lookupGererMenuLocal();
            request.setAttribute("menu", request.getParameter("menu"));
            request.setAttribute("boissons", gererMenu.LesBoissons());
            String taille="Moyenne";
            if (request.getParameter("taille").equals("Menu Maxi Best Of")) {
                taille="Grande";
            
        }
            request.setAttribute("accompagnements", gererMenu.LesAccompagnements(taille));

            return "WEB-INF/home.jsp";
    }

    private GererMenuLocal lookupGererMenuLocal() {
        try {
            Context c = new InitialContext();
            return (GererMenuLocal) c.lookup("java:global/MacDo/MacDo-ejb/GererMenu!metiers.GererMenuLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
    
}
