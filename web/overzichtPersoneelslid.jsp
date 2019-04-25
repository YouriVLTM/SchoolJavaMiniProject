<%-- 
    Document   : overzichtPersoneelslid
    Created on : Apr 25, 2019, 9:09:04 PM
    Author     : yourivanlaer
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="fact.it.www.beans.*;"%>
<%ArrayList<Personeelslid> personeelsleden = (ArrayList<Personeelslid>) session.getAttribute("personeelsleden");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Overzicht Personeelslid</h1>
        <% if (session.getAttribute("personeelsleden") == null){ %>
            <h1> De Personeelslid zijn leeg </h1>
        <% }else{ %>
         <% for (Personeelslid personeelslid : personeelsleden){ %>
         <p>Naam: <span><%=personeelslid.toString() %> </span></p>

         <%} }%>
    </body>
</html>
