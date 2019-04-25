<%-- 
    Document   : nieuwAttractie
    Created on : Apr 4, 2019, 8:52:43 AM
    Author     : yourivanlaer
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="fact.it.www.beans.*;"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Pretpark pretpark = (Pretpark)request.getAttribute("pretpark");%>
<%ArrayList<Personeelslid> personeelsleden = (ArrayList<Personeelslid>) request.getAttribute("personeelsleden");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nieuw Attractie</title>
    </head>
    <body>
        <h1>Maak een nieuwe attractie aan</h1>
        <form action="MaakServlet" method="post">
            <p><label for="pretparknaam">Pretpark naam:</label>
                <input type="text" id="pretparknaam" name="pretparknaam" value="<%=pretpark.getNaam() %>" size="10" /></p>
            
            <p><label for="attractienaam">Attractie naam:</label>
                <input type="text" id="attractienaam" name="attractienaam" size="10" /></p>
            <p><label for="duur">Duur</label>
                <input type="text" id="duur" name="duur" size="10" /></p>
            <p><label for="fotoBestand">Naam van fotobestand</label>
                <input type="text" id="fotoBestand" name="fotobestand" size="10" /></p>
            <br>
            <br>
            
            
            
            <select name="personeelslidverandwoordelijke">
                <% for (Personeelslid personeelslid : personeelsleden){ %>
                    <option value= "<%=personeelslid.getVoornaam() + "-"+ personeelslid.getFamilienaam()%>"><%=personeelslid.getVoornaam() + " " + personeelslid.getFamilienaam()%></option>
               <%}%>
             </select> 
             <br>
             <br>
            
            <input type="submit" name="nieuwattractie" value="Maak attractie aan" />
            
        </form>
        
        <a href="index.jsp">Terug</a>
        
    </body>
</html>
