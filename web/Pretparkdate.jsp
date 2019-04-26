<%-- 
    Document   : Pretparkdate
    Created on : Apr 26, 2019, 5:23:16 PM
    Author     : yourivanlaer
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="fact.it.www.beans.Bezoeker"%>
<%ArrayList<Bezoeker> bezoekers = (ArrayList<Bezoeker>) session.getAttribute("bezoekers");%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pretpark date</h1>
        <form action="MaakServlet" method="POST">
            <p>Bezoeker 1 :</p>
            <select name="bezoeker1">
                <% for (Bezoeker bezoeker : bezoekers){ %>
                    <option value= "<%=bezoekers.indexOf(bezoeker)%>"><%=bezoeker.getVoornaam() + " " + bezoeker.getFamilienaam()%></option>
               <%}%>
             </select> 
             <p>Bezoeker 2 :</p>
             <select name="bezoeker2">
                <% for (Bezoeker bezoeker : bezoekers){ %>
                    <option value= "<%=bezoekers.indexOf(bezoeker)%>"><%=bezoeker.getVoornaam() + " " + bezoeker.getFamilienaam()%></option>
               <%}%>
             </select> 
             <br>
             <br>
            
            <!--<input type="submit" name="dateNaam" value="Berekenen op naam" />-->
            <!--<input type="submit" name="dateLeeftijd" value="Berekenen op leeftijd" />-->
            <input type="submit" name="dateNaamdateLeeftijd" value="Berekenen op bijde" />
        </form>
             
             <a href="index.jsp">Terug</a>

    </body>
</html>
