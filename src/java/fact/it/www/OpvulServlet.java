/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fact.it.www;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fact.it.www.beans.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yourivanlaer
 */
@WebServlet(name = "OpvulServlet", urlPatterns = {"/OpvulServlet"})
public class OpvulServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           HttpSession session = request.getSession();
           
           
           String actie = request.getParameter("actie");
            if (actie != null) {
                // error page
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                   if (actie.equals("opvullen")) {
                       
                        ArrayList<Personeelslid> personeelsleden = new ArrayList<>();
                        personeelsleden.add(new Personeelslid("Jitse", "Verhaegen"));
                        personeelsleden.add(new Personeelslid("Bert", "De Meulenaere"));
                        personeelsleden.add(new Personeelslid("Sanne", "Beckers"));
                        ArrayList<Bezoeker> bezoekers = new ArrayList<>();
                        bezoekers.add(new Bezoeker("Daan", "Mertens"));
                        bezoekers.add(new Bezoeker("Wim", "Wijns"));
                        bezoekers.add(new Bezoeker("Gert", "Pauwels"));
                        bezoekers.get(0).voegToeAanWishlist("Weerwolf");
                        bezoekers.get(0).voegToeAanWishlist("Vampire");
                        bezoekers.get(1).voegToeAanWishlist("Glijbaan");
                        bezoekers.get(1).voegToeAanWishlist("Vampire");
                        bezoekers.get(1).voegToeAanWishlist("Jump");
                        bezoekers.get(1).voegToeAanWishlist("Aquaglide");
                        bezoekers.get(2).voegToeAanWishlist("Weerwolf");
                       //pretparken
                        ArrayList<Pretpark> pretparken = new ArrayList<>();
                        Pretpark pretpark1 = new Pretpark("Park 2020");
                        Pretpark pretpark2 = new Pretpark("Jong en oud");
                        Pretpark pretpark3 = new Pretpark("ThomasMoveMore");
                        Attractie attractie1 = new Attractie("Vampire", 20);
                        Attractie attractie2 = new Attractie("Weerwolf", 15);
                        Attractie attractie3 = new Attractie("Cobra", 10);
                        Attractie attractie4 = new Attractie("Glijbaan", 10);
                        Attractie attractie5 = new Attractie("Jump", 20);
                        Attractie attractie6 = new Attractie("Aquaglide", 10);
                        attractie1.setFoto("vampire.jpg");
                        attractie2.setFoto("weerwolf.jpg");
                        attractie3.setFoto("cobra.jpg");
                        attractie1.setVerantwoordelijke(personeelsleden.get(0));
                        attractie2.setVerantwoordelijke(personeelsleden.get(1));
                        attractie3.setVerantwoordelijke(personeelsleden.get(2));
                        pretpark1.voegAttractieToe(attractie1);
                        pretpark1.voegAttractieToe(attractie2);
                        pretpark2.voegAttractieToe(attractie3);
                        pretpark2.voegAttractieToe(attractie4);
                        pretpark3.voegAttractieToe(attractie5);
                        pretpark3.voegAttractieToe(attractie6);
                        pretparken.add(pretpark1);
                        pretparken.add(pretpark2);
                        pretparken.add(pretpark3);

                        // sessie maken

                        session.setAttribute("personeelsleden", personeelsleden);
                        session.setAttribute("bezoekers", bezoekers);
                        session.setAttribute("pretparken", pretparken);


                        // terug naar index page 
                        rd = request.getRequestDispatcher("index.jsp");           
                   }               
                   rd.forward(request, response);
            }
  

           
        }
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
