<%-- 
    Document   : welkomPersoonslid
    Created on : Apr 4, 2019, 9:59:21 AM
    Author     : yourivanlaer
--%>

<%@page import="fact.it.www.beans.*;"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% //Personeelslid personeelslid = (Personeelslid)(request.getAttribute("personeelslid"));
%>


<%ArrayList<Personeelslid> personeelsleden = 
(ArrayList<Personeelslid>) session.getAttribute("personeelsleden");%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Persoonslid</title>
    </head>
    <body>
        <h1>Hallo</h1>
        <p><%=personeelsleden.get(personeelsleden.size() - 1).toString() %></p>
        
        
        <a href="index.jsp">Terug</a>
    </body>
</html>
