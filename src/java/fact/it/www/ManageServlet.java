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

/**
 *
 * @author yourivanlaer
 */
@WebServlet(name = "ManageServlet", urlPatterns = {"/ManageServlet"})
public class ManageServlet extends HttpServlet {
    
    ArrayList<Personeelslid> persooneelLijst = new ArrayList<>();
    ArrayList<Bezoeker> bezoekersLijst = new ArrayList<>();
    ArrayList<Attractie> attractieLijst = new ArrayList<>();
    ArrayList<String> message = new ArrayList<>();
    Persoon persoon1;
    Pretpark pretpark;
            
    public void Set(){
        /*Personeelslid*/
        persooneelLijst.add(new Personeelslid("Jos","Petermans"));
        persooneelLijst.add(new Personeelslid("Jef", "Van Laer"));
        
        /*bezoekerslijst*/
        bezoekersLijst.add(new Bezoeker("Lowie", "Mermans"));
        bezoekersLijst.add(new Bezoeker("Alex", "Barlo"));
        /*pretpark code*/
        bezoekersLijst.get(0).setPretparkcode(5);
        bezoekersLijst.get(1).setPretparkcode(10);
        
        /*wishlist toevoegen*/
        for(Bezoeker bezoeker : bezoekersLijst){
            for(int i = 0; i < 3; i++){
                System.out.println("ok");
                if(!bezoeker.voegToeAanWishlist("Attractie" + i)){
                    message.add("Error : De " + bezoeker.toString() + " kan de attracite" + i + " niet toevoegen!");
                }
            }            
        }
        
        
        /*Persoon*/
        persoon1 = new Persoon("Emma", "Hendri");
        
        /* pretpark*/        
        pretpark = new Pretpark("Hallo");
        
        /*Attractie*/
        for(int i =0; i <= 2; i++){
            attractieLijst.add(new Attractie("Att"+(i+1)));            
        }
        attractieLijst.get(0).setVerantwoordelijke(persooneelLijst.get(0));
        attractieLijst.get(1).setVerantwoordelijke(persooneelLijst.get(1));
        attractieLijst.get(2).setVerantwoordelijke(persooneelLijst.get(1));
        
        /*attracties toevoegen aan pretpark*/
        for(Attractie attractie: attractieLijst){
            pretpark.voegAttractieToe(attractie);
        }
        
        

    }
    
    
     

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
        
        Set();
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ManageServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Personeelsleden</h1>");
            for(Persoon personeel : persooneelLijst){
                out.println("<p>"+ personeel.toString() + "</p>");
            }
            
            out.println("<h1>Bezoekers</h1>");
            for(Bezoeker bezoeker : bezoekersLijst){
                out.println("<p>"+ bezoeker.toString() + "</p>");
                /*wishlist lijst*/
                out.println("<label> Attracties : </label>");
                for(String wishlist : bezoeker.getWishlist()){
                    out.println("<span>"+ wishlist + ",</span>");
                }
            }
            
            out.println("<h1>Persoon</h1>");
            out.println("<p>"+ persoon1.toString() + "</p>");
            
            out.println("<h1>Pretpark</h1>");
            for(Attractie attractie : pretpark.getAttracties()){
                out.println("<p>"+ attractie.getNaam() + "</p>");
                 out.println("<label> Verantwoordelijk : </label>");
                 out.println("<span>"+ attractie.getVerantwoordelijke().toString() + ",</span>");
            }
            
            for(String Error : message){
                out.println("<h2 style='color:red'>"+ Error + "</h2>");
            }
            

            out.println("</body>");
            out.println("</html>");
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
