package control;

import model.MastermindModel;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Das ist der Controller des Webspiels Mastermind es handelt sich dabei 
 * um ein Servlet der mittels eines Request Dispatcher mit dem JSP komm
 * uniziert
 * @author tobi
 * @Datum 1.11.2013
 */
//@WebServlet(name = "MastermindController", urlPatterns = {"/SelectNumber.do"})
public class MastermindControler extends HttpServlet {

    MastermindModel master;
    
    @Override
    public void init() throws ServletException {
        master = new MastermindModel();
    }
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String bool = request.getParameter("restart");
        if(bool != null) {
            master.restart();
        }
        //Speichern der Eingabe
        String n1 = request.getParameter("number1");
        String n2 = request.getParameter("number2");
        String n3 = request.getParameter("number3");
        String n4 = request.getParameter("number4");
        //Ueberpruefen ob sie null ist und ob sie im erlaubten Wertebereich liegt
        if(n1 != null && n2 != null && n3 != null && n4 != null ) {
            if(n1.matches("[1-9]") && n2.matches("[1-9]") && n3.matches("[1-9]") && n4.matches("[1-9]")){
                int[] vers = {Integer.parseInt(n1), Integer.parseInt(n2), Integer.parseInt(n3), Integer.parseInt(n4)};
                master.check(vers);
            } 
        }
        //Abfragen der zu setzenden Attribute
        boolean gewonnen = master.sieg();
        boolean verloren = master.niederlage();
        String text = master.stringHTML();
        //Setzen der Attribute
        request.setAttribute("gewonnen", gewonnen);
        request.setAttribute("verloren", verloren);
        request.setAttribute("text", text);
        
        //Weiterleitung der Aenderungen an das JSP
        RequestDispatcher view = request.getRequestDispatcher("mastermindView.jsp");
        view.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
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
        return "Mastermind";
    }// </editor-fold>
}
