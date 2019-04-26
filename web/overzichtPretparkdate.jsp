<%-- 
    Document   : overzichtPretparkdate
    Created on : Apr 26, 2019, 5:44:01 PM
    Author     : yourivanlaer
--%>
<% String leeftijd = (String)(request.getAttribute("leeftijd")); %>
<% String score = (String)(request.getAttribute("score")); %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Overzicht</h1>
        
        <p>Op basis van de naam passen jullie voor <%=score %>% bij elkaar</p>
        
        <p><%=leeftijd %></p>
        
        
        
        
        <a href="Pretparkdate.jsp">Overzicht van Pretparkdate</a>
    </body>
</html>
