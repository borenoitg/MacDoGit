
package sousControleurs;

import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MainMenuCtrl implements SousControleurInterface, Serializable{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
        return "/WEB-INF/menus/mainMenu.jsp";
    }
    
}
