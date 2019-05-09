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
            ArrayList<String> errorPopUp = new ArrayList<>();
            
            
            try{
            
            if(request.getParameter("nieuwbezoeker") !=null || request.getParameter("nieuwbezoekermetpretpark") !=null){
                //get parameters
                    
                    String voornaam = request.getParameter("voornaam");
                    String achternaam = request.getParameter("achternaam");
                    String attractie = request.getParameter("attractienaam");
                    int geboortejaar = Integer.parseInt(request.getParameter("geboortejaar"));
                    // check if is valid 
                    if(voornaam.isEmpty() || voornaam == null){
                        errorPopUp.add("Voornaam");
                    }
                    if(achternaam.isEmpty() || achternaam == null){
                        errorPopUp.add("Achternaam");
                    }
                    if(attractie == null || attractie.isEmpty() ){
                         errorPopUp.add("Attractie");
                    }
                    if(geboortejaar == 0){
                        errorPopUp.add("geboortejaar");
                    }
                    //kijken 
                    if(request.getParameter("nieuwbezoekermetpretpark") !=null){
                        int pretparkindex = Integer.parseInt(request.getParameter("pretparkindex"));
                        if(pretparkindex == 0){
                            errorPopUp.add("pretparkindex");
                        }
                    }
               
                //kijken of er een foutmelding aanwezig is
                if(!errorPopUp.isEmpty()){
                    // een error message generen 
                    String error="";
                    for (String popup : errorPopUp ){
                        error = error +  "<li>" + popup + " is leeg</li>";
                    }
                    sendErrorRedirect(request,response,"/nieuwBezoeker.jsp",error);
                }else{
                    
                
                
                    // Bezoeker aanmaken
                    Bezoeker bezoeker = new Bezoeker(voornaam, achternaam);
                    // bezoeker geboortedatum toevoegen 
                    bezoeker.setGeboortejaar(geboortejaar);

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
                    
                }                
                
                
            }else if(request.getParameter("nieuwpretpark") !=null){
                //get parameters
                String pretparkNaam = request.getParameter("naam"); 
                
                
                // kijken valid 
                if(pretparkNaam == null || pretparkNaam.isEmpty() ){
                        errorPopUp.add("pretpark");
                   }
                
                //kijken of er een foutmelding aanwezig is
                if(!errorPopUp.isEmpty()){
                    // een error message generen 
                    String error="";
                    for (String popup : errorPopUp ){
                        error = error +  "<li>" + popup + " is leeg</li>";
                    }
                    sendErrorRedirect(request,response,"/nieuwPretpark.jsp",error);
                }else {
                    
                    // Hoeft eignelijk niet
                    Pretpark pretpark = new Pretpark(pretparkNaam);


                    // persooneelsleden bestaat niet!!
                    ArrayList<Personeelslid> personeelsleden = (ArrayList<Personeelslid>) session.getAttribute("personeelsleden");
                    if (personeelsleden == null) {
                        sendErrorRedirect(request,response,"/error.jsp","Voeg eerst personeelsleden toe!");
                    }else{
                        
                        // haal de array op
                        ArrayList<Pretpark> pretparken = (ArrayList<Pretpark>) session.getAttribute("pretparken");
                        // kijken of de array bestaat 
                        if (pretparken == null) {                    
                            pretparken = new ArrayList<>();
                            pretparken.add(pretpark);
                        }else{
                            boolean exist = false;
                            // kijken of al bestaat zo ja de pretpark behouden
                            for (Pretpark pretparke : pretparken){
                                if(pretparke.getNaam().equals(pretpark.getNaam())){
                                    pretpark = pretparke;
                                    exist = true;
                                    break;
                                }
                            }
                            // als de sessie al reeds bestaat 
                            if(!exist){
                                pretparken.add(pretpark);                 
                            }                        
                                   
                        }

                        // pretpark opslaan
                        session.setAttribute("pretparken", pretparken);

                        request.setAttribute("pretpark", pretparken.get(pretparken.size() - 1));
                        request.setAttribute("personeelsleden", personeelsleden);

                        rd = request.getRequestDispatcher("nieuwAttractie.jsp");

                    }

                
                }
                
                
            }else if(request.getParameter("nieuwattractie") !=null){
                //get parameters
                String pretparkNaam = request.getParameter("pretparknaam"); 
                String attractieNaam = request.getParameter("attractienaam");
                long duur = Long.parseLong(request.getParameter("duur"));
                String fotobestand = request.getParameter("fotobestand");
                String personeelslidVerantwoordlijke = request.getParameter("personeelslidverandwoordelijke");
                
                // kijken valid 
                if(pretparkNaam == null || pretparkNaam.isEmpty() ){
                        errorPopUp.add("pretparkNaam");
                   }
                if(attractieNaam == null || attractieNaam.isEmpty() ){
                        errorPopUp.add("attractieNaam");
                   }
                if(duur == 0 ){
                        errorPopUp.add("duur");
                   }
                /*if(fotobestand == null || fotobestand.isEmpty() ){
                        errorPopUp.add("fotoBestand");
                   }*/
                if(personeelslidVerantwoordlijke == null || personeelslidVerantwoordlijke.isEmpty() ){
                        errorPopUp.add("personeelslidVerantwoordlijke");
                   }
                
                //kijken of er een foutmelding aanwezig is
                if(!errorPopUp.isEmpty()){
                    // een error message generen 
                    String error="";
                    for (String popup : errorPopUp ){
                        error = error +  "<li>" + popup + " is leeg</li>";
                    }
                    sendErrorRedirect(request,response,"/nieuwAttractie.jsp",error);
                    
                }else {
                    //NEW VERSION
                    // kijken of het pretpark al bestaat 
                    ArrayList<Pretpark> pretparken = (ArrayList<Pretpark>) session.getAttribute("pretparken");
                    //kijken of pretparken niet leeg is 
                    if(pretparken == null){                         
                        sendErrorRedirect(request,response,"/error.jsp","Pretpark is leeg!");
                    }else{
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
                        attractie.setFoto(fotobestand);

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
                    }
                    
                    
                    
                    
                }

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
                
                
                
            }else if(request.getParameter("nieuwpersoneelslid") !=null){
               //get parameters
                String voornaam = request.getParameter("voornaam"); 
                String achternaam = request.getParameter("achternaam");
                
                
                
                // kijken valid 
                if(voornaam == null || voornaam.isEmpty() ){
                        errorPopUp.add("voornaam");
                   }
                if(achternaam == null || achternaam.isEmpty() ){
                        errorPopUp.add("achternaam");
                   }                
                
                //kijken of er een foutmelding aanwezig is
                if(!errorPopUp.isEmpty()){
                    // een error message generen 
                    String error="";
                    for (String popup : errorPopUp ){
                        error = error +  "<li>" + popup + " is leeg</li>";
                    }
                    sendErrorRedirect(request,response,"/nieuwPersoneelslid.jsp",error);
                    
                }else {
                    
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

                    session.setAttribute("personeelsleden", personeelsleden);

                    rd = request.getRequestDispatcher("welkomPersoneelslid.jsp");
                    
                    
                }
                
                
                
            }else if(request.getParameter("pretpark") !=null){                
                int pretpakId = Integer.parseInt(request.getParameter("pretpark"));
                ArrayList<Pretpark> pretparken = (ArrayList<Pretpark>) session.getAttribute("pretparken");
                
                Pretpark pretpark = pretparken.get(pretpakId);
                request.setAttribute("pretpark", pretpark);
                rd = request.getRequestDispatcher("welkomPretpark.jsp");
                
                
            }else if(request.getParameter("zoekAttractie") !=null){
                String attractieNaam = request.getParameter("attractieNaam");
                
                ArrayList<Pretpark> pretparken = (ArrayList<Pretpark>) session.getAttribute("pretparken");
                
                if(pretparken == null){                    
                    sendErrorRedirect(request,response,"/error.jsp","Pretpark is leeg!");
                }
                                
                                
                Attractie attractie = null;
                for (Pretpark pretpark : pretparken){
                    attractie = pretpark.zoekAttractieOpNaam(attractieNaam);
                    if(attractie != null){
                        break;
                    }
                }
                
                if(attractie == null){
                    sendErrorRedirect(request,response,"/error.jsp","Geen Attractie gevonden!");
                }
                
                session.setAttribute("pretparken", pretparken);                         
                
                request.setAttribute("attractie", attractie);
                rd = request.getRequestDispatcher("bewerkAttractie.jsp");
                
                
            }else if(request.getParameter("opslaanAttractie") !=null){
                //get naam
                String attractieNaam = request.getParameter("attractienaam");
                long duur = Long.parseLong(request.getParameter("duur"));                
                String fotobestand = request.getParameter("fotobestand");
                String personeelslid = request.getParameter("personeelslidverandwoordelijke");

                // kijken valid                
                if(attractieNaam == null || attractieNaam.isEmpty() ){
                        errorPopUp.add("attractieNaam");
                   }
                if(duur == 0 ){
                        errorPopUp.add("duur");
                   }
                /*if(fotobestand == null || fotobestand.isEmpty() ){
                        errorPopUp.add("fotobestand");
                   }*/
                if(personeelslid == null || personeelslid.isEmpty() ){
                        errorPopUp.add("personeelslidVerantwoordlijke");
                   }
                
                //kijken of er een foutmelding aanwezig is
                if(!errorPopUp.isEmpty()){
                    // een error message generen 
                    String error="";
                    for (String popup : errorPopUp ){
                        error = error +  "<li>" + popup + " is leeg</li>";
                    }
                    sendErrorRedirect(request,response,"/error.jsp",error);
                    
                }else {
                    
                     ArrayList<Pretpark> pretparken = (ArrayList<Pretpark>) session.getAttribute("pretparken");
                
                    if(pretparken == null){
                        sendErrorRedirect(request,response,"/error.jsp","Pretpark is leeg session!");
                        
                    }


                    Attractie attractie = null;
                    for (Pretpark pretpark : pretparken){
                        attractie = pretpark.zoekAttractieOpNaam(attractieNaam);
                        if(attractie != null){
                            break;
                        }
                    }
                    if(attractie == null){
                        sendErrorRedirect(request,response,"/error.jsp","Geen Attractie gevonden!");
                    }

                    ArrayList<Personeelslid> personeelsleden = (ArrayList<Personeelslid>) session.getAttribute("personeelsleden");
                    //zoeken 
                    for (Personeelslid personeel : personeelsleden){
                        if((personeel.getVoornaam() + "-" + personeel.getFamilienaam()).equals(personeelslid) ){
                            attractie.setVerantwoordelijke(personeel);
                            break;
                        }
                    }                

                    //gegevens weiziggen
                    attractie.setNaam(attractieNaam);
                    attractie.setDuur(duur);
                    attractie.setFoto(fotobestand);


                    session.setAttribute("pretparken", pretparken); 

                    rd = request.getRequestDispatcher("index.jsp");
                    
                    
                }
                
                
                
                
            }else if(request.getParameter("dateNaamdateLeeftijd") !=null){
                // get parameters
                int bezoeker1Index = Integer.parseInt(request.getParameter("bezoeker1"));
                int bezoeker2Index = Integer.parseInt(request.getParameter("bezoeker2"));
                
                ArrayList<Bezoeker> bezoekers = (ArrayList<Bezoeker>) session.getAttribute("bezoekers");
                
                if(bezoekers == null){
                    sendErrorRedirect(request,response,"/error.jsp","Geen bezoekers aanwezig!");
                }
                
                
                // object calc relatie                
                Relatie relatie = new Relatie(bezoekers.get(bezoeker1Index),bezoekers.get(bezoeker2Index));
                
                String leef = relatie.getScoreLeeftijd();
                String score =  Integer.toString(relatie.getScoreNaam()); 
                        
                
                    
                request.setAttribute("leeftijd", leef);
                request.setAttribute("score", score);

                rd = request.getRequestDispatcher("overzichtPretparkdate.jsp");
                
                
            }        
            
            
            rd.forward(request, response);
            
            }catch(Exception e){
            System.out.print(e);
            sendErrorRedirect(request,response,"/error.jsp",e.getMessage());
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

    

    protected void sendErrorRedirect(HttpServletRequest request,   HttpServletResponse response, String errorPageURL, String errorMessage)
           throws ServletException, IOException {
        
        request.setAttribute ("errorMessage", errorMessage);
        getServletConfig().getServletContext().
        getRequestDispatcher(errorPageURL).forward(request,response);
    }

}

