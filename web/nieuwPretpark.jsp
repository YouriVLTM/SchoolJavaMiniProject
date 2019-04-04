<%-- 
    Document   : nieuwPretpark
    Created on : Apr 4, 2019, 8:44:18 AM
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
        <h1>Maak een nieuwe pretpark aan</h1>
        <form action="MaakServlet" method="post" >
            <p><label for="naam">Naam van het pretpark:</label>
                <input type="text" id="naam" name="naam" size="10" /></p>
      
            
            <input type="submit" name="nieuwpretpark" value="Maak pretpark aan" />
            
        </form>
        
        <a href="index.jsp">Terug</a>
        
    </body>
</html>
