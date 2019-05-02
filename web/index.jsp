<%-- 
    Document   : index
    Created on : Mar 28, 2019, 9:17:26 AM
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
        <h1>Welkom op onze pretpark</h1>
        <p>In de volgende link kan u een nieuwe gebruiker aanmaken</p>
        <a href="nieuwBezoeker.jsp">Nieuw bezoeker aanmaken</a>
        <a href="nieuwPretpark.jsp">Nieuw pretpark aanmaken</a>
        <a href="nieuwPersoneelslid.jsp">Nieuw Persoonslid aanmaken</a>
        <a href="OpvulServlet?actie=opvullen">Opvullen</a>
        <a href="overzichtBezoeker.jsp">Overzicht van bezoekers</a>
        <a href="overzichtPretpark.jsp">Overzicht van pretparken</a>
        <a href="overzichtPersoneelslid.jsp">Overzicht van personeelslid</a>
        <a href="Pretparkdate.jsp">Overzicht van Pretparkdate</a>

        
        <form action="MaakServlet" method="POST">
            <p><label for="attractieNaam">Zoek attractie</label>
                <input type="text" id="attractieNaam" name="attractieNaam" value="" size="10" /></p>
            <input type="submit" name="zoekAttractie" value="Zoek de attractie op" />
        </form>
        
        
        <form action="MaakServlet" method="POST">
            
            <input type="submit" name="test" value="TEST" />
        </form>

    </body>
</html>
