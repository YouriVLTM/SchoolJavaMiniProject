<%-- 
    Document   : overzichtBezoeker
    Created on : Apr 25, 2019, 9:03:44 AM
    Author     : yourivanlaer
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="fact.it.www.beans.*;"%>
<%ArrayList<Bezoeker> bezoekers = 
(ArrayList<Bezoeker>) session.getAttribute("bezoekers");%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Overzicht bezoekers</h1>
        <% if (session.getAttribute("pretparken") == null){ %>
            <h1> De Bezoekers zijn leeg </h1>
        <% }else{ %>
         <% for (Bezoeker bezoeker : bezoekers){ %>
         <p>Naam: <span><%=bezoeker.getVoornaam()%> <%=bezoeker.getFamilienaam()%></span></p>
         <p>Pretparkcode :  <span><%=bezoeker.getPretparkcode()%></span></p>

         <%} }%>
    </body>
</html>
