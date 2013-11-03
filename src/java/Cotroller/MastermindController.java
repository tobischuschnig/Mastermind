/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cotroller;

import Model.MastermindModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tobi
 */
public class MastermindController extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Eingaben speichern
        String n1 = request.getParameter("number1");
        String n2 = request.getParameter("number2");
        String n3 = request.getParameter("number3");
        String n4 = request.getParameter("number4");
        
        //mittels regex Eingaben pruefen
        if(n1.matches("[1-9]") && n2.matches("[1-9]") && n3.matches("[1-9]") && n4.matches("[1-9]")){
            int[] vers = {Integer.parseInt(n1), Integer.parseInt(n2), Integer.parseInt(n3), Integer.parseInt(n4)};
            master.check(vers);
        }
        boolean gewonnen = master.sieg();
        boolean verloren = master.niederlage();
        String text = master.ausString();
        
        request.setAttribute("gewonnen", gewonnen);
        request.setAttribute("verloren", verloren);
        request.setAttribute("text", text);
        
        //weiterleiten an game jsp
        RequestDispatcher view = request.getRequestDispatcher("MastermindView.jsp");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
