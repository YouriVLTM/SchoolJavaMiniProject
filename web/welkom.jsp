<%-- 
    Document   : welkom
    Created on : Mar 28, 2019, 9:32:23 AM
    Author     : yourivanlaer
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="fact.it.www.beans.*;"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%ArrayList<Bezoeker> bezoekers = (ArrayList<Bezoeker>) session.getAttribute("bezoekers");
ArrayList<Pretpark> pretparken = (ArrayList<Pretpark>) session.getAttribute("pretparken");
Bezoeker bezoeker = bezoekers.get(bezoekers.size() - 1);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welkom! </h1>
        <p><%=bezoeker.toString() %></p>
        <p>U gekozen attractie :
           <% if(bezoeker.getAantalOpWishlist() != 0){%>
            <%for(String attractieNaam : bezoeker.getWishlist()){%>
               <label><%=attractieNaam %> </label>
           <% } 
            }else{%>
            <label> Er is geen favoriete attracties gekozen</label>
            <%}
           %>
         </p>
           <br>
           <br>
                
                
               
        
        <a href="nieuwBezoeker.jsp">Maak nieuwe gebruiker aan</a>
    </body>
</html>
