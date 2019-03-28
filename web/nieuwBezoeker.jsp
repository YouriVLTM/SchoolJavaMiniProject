<%-- 
    Document   : nieuwBezoekers
    Created on : Mar 28, 2019, 9:18:04 AM
    Author     : yourivanlaer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Maak een nieuwe bezoeker aan</h1>
        <form action="MaakServlet" method="post" >
            <p><label for="voornaam">Voornaam:</label>
                <input type="text" id="voornaam" name="voornaam" size="10" /></p>
            <p><label for="achternaam">Achternaam:</label>
                <input type="text" id="achternaam" name="achternaam" size="10" /></p>
            
            
            <input type="checkbox" id="bezocht" name="bezocht" value="true">
                <label for="bezocht">Al bezocht</label>
            <br>
            <br>
            
            <% String[] attractieLijst = new String[]{ "geen", "wingo","Joepiewoepie","attractie1" };  %>
            <% for (String attractie : attractieLijst){ %>
                <input type="radio" name="attractie" value="<%=attractie%>" id="<%=attractie%>">
                <label for="<%=attractie%>"><%=attractie%></label>
             <%}%>
              
             <br>
             <br>
        
            
            <input type="submit" name="bereken" value="Maak gebruiker aan" />
            
        </form>
        
        <a href="index.jsp">Terug</a>
        
    </body>
</html>
