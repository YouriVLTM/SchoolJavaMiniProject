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
import fact.it.www.*;
import fact.it.www.beans.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yourivanlaer
 */
@WebServlet(name = "MaakServlet", urlPatterns = {"/MaakServlet"})
public class MaakServlet extends HttpServlet {

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
            //sessions
            HttpSession session = request.getSession();
            
            //global settings
            //TODO error page
            RequestDispatcher rd = null;
            
            String test = request.getParameter("nieuwbezoeker");
            
            if(request.getParameter("nieuwbezoeker") !=null || request.getParameter("nieuwbezoekermetpretpark") !=null){
                
                //get parameters
                String voornaam = request.getParameter("voornaam");
                String achternaam = request.getParameter("achternaam");
                String attractie = request.getParameter("attractienaam");
                
                // Bezoeker aanmaken
                Bezoeker bezoeker = new Bezoeker(voornaam, achternaam);
                /*if(bezocht){
                    bezoeker.setPretparkcode(1000);
                }*/

                if (!attractie.equals("geen")){
                    // kijken binnen het bereik
                    bezoeker.voegToeAanWishlist(attractie);
                }
                
                // Haal de array op
                ArrayList<Bezoeker> bezoekers = (ArrayList<Bezoeker>) session.getAttribute("bezoekers");
                // kijken of de array bestaat 
                if (bezoekers == null) {                    
                    bezoekers = new ArrayList<>();
                    bezoekers.add(bezoeker);
                }else{
                    // als de sessie al reeds bestaat 
                    bezoekers.add(bezoeker);                    
                }                
                //request.setAttribute("Bezoeker", bezoeker)               
                session.setAttribute("bezoekers", bezoekers);
                
                //Met pretpark
                if(request.getParameter("nieuwbezoekermetpretpark") !=null){
                    // Haal de array op
                    ArrayList<Pretpark> pretparken = (ArrayList<Pretpark>) session.getAttribute("pretparken");                    
                    int pretparkindex = Integer.parseInt(request.getParameter("pretparkindex"));
                    // Het registreren van een bezoeker
                    pretparken.get(pretparkindex).registreerBezoeker(bezoeker);
                }
                
                rd = request.getRequestDispatcher("welkomBezoeker.jsp");
                
                
            }else if(request.getParameter("nieuwpretpark") !=null){
                //get parameters
                String pretparkNaam = request.getParameter("naam");                
                // Hoeft eignelijk niet
                Pretpark pretpark = new Pretpark(pretparkNaam);
                
                // persooneelsleden bestaat niet!!
                ArrayList<Personeelslid> personeelsleden = (ArrayList<Personeelslid>) session.getAttribute("personeelsleden");
                if (personeelsleden == null) {
                    request.setAttribute("errorMessage", "Voeg eerst personeelsleden toe!");
                    rd = request.getRequestDispatcher("error.jsp");
                    rd.forward(request, response);
                    
                }        
                
                
                // haal de array op
                ArrayList<Pretpark> pretparken = (ArrayList<Pretpark>) session.getAttribute("pretparken");
                // kijken of de array bestaat 
                if (pretparken == null) {                    
                    pretparken = new ArrayList<>();
                    pretparken.add(pretpark);
                }else{
                    // als de sessie al reeds bestaat 
                    pretparken.add(pretpark);                    
                }
                
                
                    
                
                // pretpark opslaan
                session.setAttribute("pretparken", pretparken);
                
                
                request.setAttribute("pretpark", pretparken.get(pretparken.size() - 1));
                request.setAttribute("personeelsleden", personeelsleden);
                
                rd = request.getRequestDispatcher("nieuwAttractie.jsp");
                
            }else if(request.getParameter("nieuwattractie") !=null){
                //get parameters
                String pretparkNaam = request.getParameter("pretparknaam"); 
                String attractieNaam = request.getParameter("attractienaam");
                long duur = Long.parseLong(request.getParameter("duur"));
                String fotoBestand = request.getParameter("fotobestand");
                String personeelslidVerantwoordlijke = request.getParameter("personeelslidverandwoordelijke");

                /*moet lijst aangemaatk worden?*/
                /*ArrayList<Personeelslid> personeelslidLijst = new ArrayList();
                String[] splitpersoneelslidVerantwoordlijke = personeelslidVerantwoordlijke.split("-");
                personeelslidLijst.add(new Personeelslid(splitpersoneelslidVerantwoordlijke[0],splitpersoneelslidVerantwoordlijke[1]));
                personeelslidLijst.add(new Personeelslid("Mamie", "Van Laer"));
                personeelslidLijst.add(new Personeelslid("Lorenzo", "Van Laer"));
                personeelslidLijst.add(new Personeelslid("Claudia", "Van Laer"));
                
                Pretpark pretpark = new Pretpark(pretparkNaam);
                Attractie attractie = new Attractie(attractieNaam,duur);
                attractie.setFoto(fotoBestand);*/
                
                /*extra attractie toevoegen*/
               /* ArrayList<Attractie> attractieLijst = new ArrayList<>();
                attractieLijst.add(new Attractie("Att2",10));
                attractieLijst.add(new Attractie("Att3",20));
                attractieLijst.add(new Attractie("Att4",30));
                attractieLijst.add(new Attractie("Att5",5));
                attractieLijst.add(new Attractie("Att6",12));
                for(Attractie attracti : attractieLijst){
                    pretpark.voegAttractieToe(attracti);
                }
                /* voer verantwoordelijke toe*/
               /* attractieLijst.get(0).setVerantwoordelijke(personeelslidLijst.get(1));
                attractieLijst.get(1).setVerantwoordelijke(personeelslidLijst.get(2));
                attractieLijst.get(2).setVerantwoordelijke(personeelslidLijst.get(3));

                                
                /*Form ingegeven attractie*/
                /*attractie.setVerantwoordelijke(personeelslidLijst.get(0));                
                pretpark.voegAttractieToe(attractie);
                
*/              
                //NEW VERSION
                // kijken of het pretpark al bestaat 
                ArrayList<Pretpark> pretparken = (ArrayList<Pretpark>) session.getAttribute("pretparken");
                //kijken of pretparken niet leeg is 
                if(pretparken == null){
                    request.setAttribute("errorMessage", "Pretpark is leeg!");
                    rd = request.getRequestDispatcher("error.jsp");
                    rd.forward(request, response);
                }
                //search for pretpark   
                Pretpark pretpark = null;
                for(Pretpark pretpa : pretparken){
                    if(pretpa.getNaam().equals(pretparkNaam)){
                        pretpark = pretpa;
                    }
                }
                                
                // Als pretpark niet bestaat dan -> al nog toevoegen
                if (pretpark == null) {                    
                    pretparken = new ArrayList<>();
                    pretparken.add(pretpark);
                }
                               
                //attractie
                Attractie attractie = new Attractie(attractieNaam);
                attractie.setDuur(duur);
                attractie.setFoto(fotoBestand);
                
                ArrayList<Personeelslid> personeelsleden = (ArrayList<Personeelslid>) session.getAttribute("personeelsleden");
                // zoek juist personeelslid
                for (Personeelslid personeel : personeelsleden){
                    if((personeel.getVoornaam() + "-" +personeel.getFamilienaam()).equals(personeelslidVerantwoordlijke)){
                        attractie.setVerantwoordelijke(personeel);
                    }
                }
                
                
                // attractie toevoegen aan pretpark
                pretpark.voegAttractieToe(attractie);
                
                
                request.setAttribute("pretpark", pretpark);
                rd = request.getRequestDispatcher("welkomPretpark.jsp");
                
                
            }else if(request.getParameter("nieuwpersoneelslid") !=null){
               //get parameters
                String voornaam = request.getParameter("voornaam"); 
                String achternaam = request.getParameter("achternaam");
                Personeelslid personeelslid = new Personeelslid(voornaam, achternaam);
                
                // haal de array op
                ArrayList<Personeelslid> personeelsleden = (ArrayList<Personeelslid>) session.getAttribute("personeelsleden");
                // kijken of de array bestaat 
                if (personeelsleden == null) {                    
                    personeelsleden = new ArrayList<>();
                    personeelsleden.add(personeelslid);
                }else{
                    // als de sessie al reeds bestaat 
                    personeelsleden.add(personeelslid);                    
                }
                
                // request.setAttribute("personeelslid", personeelslid);
               
                session.setAttribute("personeelsleden", personeelsleden);

                rd = request.getRequestDispatcher("welkomPersoneelslid.jsp");
                
            }else if(request.getParameter("pretpark") !=null){
                int pretpakId = Integer.parseInt(request.getParameter("pretpark"));
                ArrayList<Pretpark> pretparken = (ArrayList<Pretpark>) session.getAttribute("pretparken");
                
                Pretpark pretpark = pretparken.get(pretpakId);
                request.setAttribute("pretpark", pretpark);
                rd = request.getRequestDispatcher("welkomPretpark.jsp");
                
                
            }
            
            
            
            rd.forward(request, response);
            
            
            
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
