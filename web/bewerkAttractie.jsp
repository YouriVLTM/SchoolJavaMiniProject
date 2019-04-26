<%-- 
    Document   : bewerkAttractie
    Created on : Apr 26, 2019, 3:43:56 PM
    Author     : yourivanlaer
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="fact.it.www.beans.Personeelslid"%>
<%@page import="fact.it.www.beans.Attractie"%>
<% Attractie attractie = (Attractie)request.getAttribute("attractie");%>
<%ArrayList<Personeelslid> personeelsleden = (ArrayList<Personeelslid>) session.getAttribute("personeelsleden");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <form action="MaakServlet" method="post">
  
            <p><label for="attractienaam">Attractie naam:</label>
                <input type="text" id="attractienaam" name="attractienaam" size="10" value="<%=attractie.getNaam() %>" /></p>
            <p><label for="duur">Duur</label>
                <input type="text" id="duur" name="duur" size="10" value="<%=attractie.getDuur() %>" /></p>
            <p><label for="fotoBestand">Naam van fotobestand</label>
                <input type="text" id="fotoBestand" name="fotobestand" size="10" value="<%=attractie.getFoto() %>" /></p>
            <br>
            
            <select name="personeelslidverandwoordelijke">
                <% for (Personeelslid personeelslid : personeelsleden){ %>               
                    <option value= "<%=personeelslid.getVoornaam() + "-"+ personeelslid.getFamilienaam()%>" <%=attractie.getVerantwoordelijke().equals(personeelslid) ? "selected" : "" %> ><%=personeelslid.getVoornaam() + " " + personeelslid.getFamilienaam()%></option>              
               <%}%>
             </select>
             
             <br>
            
            <input type="submit" name="opslaanAttractie" value="Attractie opslaan" />
            
        </form>
        
        <a href="index.jsp">Naat de index pagina</a>
        
        
    </body>
</html>
