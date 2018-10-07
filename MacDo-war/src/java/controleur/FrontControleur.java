package controleur;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sousControleurs.SousControleurInterface;

public class FrontControleur extends HttpServlet {

    HashMap<String, SousControleurInterface> map;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        map = new HashMap();

        for (Enumeration<String> e = this.getInitParameterNames(); e.hasMoreElements();) {
            String name = e.nextElement();
            String value = this.getInitParameter(name);

            SousControleurInterface s;
            try {
                s = (SousControleurInterface) Class.forName(value).newInstance();
                map.put(name, s);
            } catch (ClassNotFoundException ex) {
                System.out.println("ClassNotFound : " + ex.getMessage());
                ex.getStackTrace();
            } catch (InstantiationException ex) {
                System.out.println("Instantiation : " + ex.getMessage());
                ex.getStackTrace();
            } catch (IllegalAccessException ex) {
                System.out.println("IllegalAccess : " + ex.getMessage());
                ex.getStackTrace();
            }

        }

    }

    protected void processRequest(HttpServletRequest request,
             HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = "/WEB-INF/home.jsp";
  
        if (request.getParameter("section") != null) {
            String name = request.getParameter("section");
            if (map.containsKey(name)) {
                SousControleurInterface s = map.get(name);
                url = s.execute(request, response);
            }
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>> url : >>" + url);
        request.getRequestDispatcher(url).include(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
