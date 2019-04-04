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
            
            if(request.getParameter("nieuwbezoeker") !=null){
                
                String voornaam = request.getParameter("voornaam");
                String achternaam = request.getParameter("achternaam");

                //boolean bezocht = Boolean.parseBoolean(request.getParameter("bezocht"));
                String attractie = request.getParameter("attractienaam");


                Bezoeker bezoeker = new Bezoeker(voornaam, achternaam);
                /*if(bezocht){
                    bezoeker.setPretparkcode(1000);
                }*/

                if (!attractie.equals("geen")){
                    bezoeker.voegToeAanWishlist(attractie);
                }


                request.setAttribute("Bezoeker", bezoeker);
                RequestDispatcher rd = request.getRequestDispatcher("welkom.jsp");
                rd.forward(request, response);
                
            }else if (request.getParameter("nieuwbezoekermetpretpark") !=null  ){
                String voornaam = request.getParameter("voornaam");
                String achternaam = request.getParameter("achternaam");
                String attractienaam = request.getParameter("attractienaam");
                String pretparknaam = request.getParameter("pretparknaam");
                
                
                Pretpark pretpark = new Pretpark(pretparknaam);
                Bezoeker bezoeker = new Bezoeker(voornaam, achternaam);
                Attractie attractie = new Attractie(attractienaam);
                pretpark.voegAttractieToe(attractie);
                pretpark.registreerBezoeker(bezoeker);
                
                 if (!attractie.equals("geen")){
                    bezoeker.voegToeAanWishlist(attractienaam);
                }
                
                request.setAttribute("Bezoeker", bezoeker);
                RequestDispatcher rd = request.getRequestDispatcher("welkom.jsp");
                rd.forward(request, response);
            
            
            
            }else if(request.getParameter("nieuwpretpark") !=null){
                String pretparkNaam = request.getParameter("naam"); 
                
                
                // Hoeft eignelijk niet
                Pretpark pretpark = new Pretpark(pretparkNaam);
                
                request.setAttribute("pretpark", pretpark);
                RequestDispatcher rd = request.getRequestDispatcher("nieuwAttractie.jsp");
                rd.forward(request, response);
                
            }else if(request.getParameter("nieuwattractie") !=null){
                String pretparkNaam = request.getParameter("pretparknaam"); 
                String attractieNaam = request.getParameter("attractienaam");
                long duur = Long.parseLong(request.getParameter("duur"));
                String fotoBestand = request.getParameter("fotobestand");
                String personeelslidVerantwoordlijke = request.getParameter("personeelslidverandwoordelijke");

                /*moet lijst aangemaatk worden?*/
                ArrayList<Personeelslid> personeelslidLijst = new ArrayList();
                String[] splitpersoneelslidVerantwoordlijke = personeelslidVerantwoordlijke.split("-");
                personeelslidLijst.add(new Personeelslid(splitpersoneelslidVerantwoordlijke[0],splitpersoneelslidVerantwoordlijke[1]));
                personeelslidLijst.add(new Personeelslid("Mamie", "Van Laer"));
                personeelslidLijst.add(new Personeelslid("Lorenzo", "Van Laer"));
                personeelslidLijst.add(new Personeelslid("Claudia", "Van Laer"));
                
                Pretpark pretpark = new Pretpark(pretparkNaam);
                Attractie attractie = new Attractie(attractieNaam,duur);
                attractie.setFoto(fotoBestand);
                
                /*extra attractie toevoegen*/
                ArrayList<Attractie> attractieLijst = new ArrayList<>();
                attractieLijst.add(new Attractie("Att2",10));
                attractieLijst.add(new Attractie("Att3",20));
                attractieLijst.add(new Attractie("Att4",30));
                attractieLijst.add(new Attractie("Att5",5));
                attractieLijst.add(new Attractie("Att6",12));
                for(Attractie attracti : attractieLijst){
                    pretpark.voegAttractieToe(attracti);
                }
                /* voer verantwoordelijke toe*/
                attractieLijst.get(0).setVerantwoordelijke(personeelslidLijst.get(1));
                attractieLijst.get(1).setVerantwoordelijke(personeelslidLijst.get(2));
                attractieLijst.get(2).setVerantwoordelijke(personeelslidLijst.get(3));

                                
                /*Form ingegeven attractie*/
                attractie.setVerantwoordelijke(personeelslidLijst.get(0));
                pretpark.voegAttractieToe(attractie);
                

                
                request.setAttribute("pretpark", pretpark);
                RequestDispatcher rd = request.getRequestDispatcher("welkomPretpark.jsp");
                rd.forward(request, response);
                
            }else if(request.getParameter("nieuwpersoneelslid") !=null){
                String voornaam = request.getParameter("voornaam"); 
                String achternaam = request.getParameter("achternaam");
                Personeelslid personeelslid = new Personeelslid(voornaam, achternaam);
                
                request.setAttribute("personeelslid", personeelslid);
                RequestDispatcher rd = request.getRequestDispatcher("welkomPersoneelslid.jsp");
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
