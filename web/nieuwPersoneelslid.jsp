<%-- 
    Document   : nieuwPersoon
    Created on : Apr 4, 2019, 9:50:02 AM
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
        <h1>Maak een nieuwe Persoonlid aan</h1>
        <form action="MaakServlet" method="post" >
            <p><label for="voornaam">Voornaam:</label>
                <input type="text" id="voornaam" name="voornaam" size="10" /></p>
            <p><label for="achternaam">Achternaam:</label>
                <input type="text" id="achternaam" name="achternaam" size="10" /></p>
            
           
            <input type="submit" name="nieuwpersoneelslid" value="Maak persoonlid aan" />
            
        </form>
        
        <a href="index.jsp">Terug</a>
    </body>
</html>
