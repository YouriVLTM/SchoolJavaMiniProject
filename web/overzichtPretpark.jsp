<%-- 
    Document   : overzichtPretpark
    Created on : Apr 25, 2019, 9:37:17 AM
    Author     : yourivanlaer
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="fact.it.www.beans.*;"%>
<%ArrayList<Pretpark> pretparken = 
(ArrayList<Pretpark>) session.getAttribute("pretparken");%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Overzicht Pretparken</h1>
        <% if (session.getAttribute("pretparken") == null){ %>
            <h1> De pretparken zijn leeg </h1>
        <% }else{ %>
         <% for (Pretpark pretpark : pretparken){ %>
         <p>Naam: <span><%=pretpark.getNaam()%> </span></p>

         <%} }%>
    </body>
</html>
