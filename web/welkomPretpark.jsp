<%-- 
    Document   : welkomPretpark
    Created on : Apr 4, 2019, 9:17:42 AM
    Author     : yourivanlaer
--%>

<%@page import="fact.it.www.beans.*;"%>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<% Pretpark pretpark = (Pretpark)(request.getAttribute("pretpark")); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hallo</h1>
        <p><%=pretpark.getNaam()%></p>
        
        <% for( Attractie attractie : pretpark.getAttracties() ){ %>
            <% if (attractie.getNaam() !=null){ %>
            <label><%=attractie.getNaam() %> </label>
            <% } %>
            
            <% if (attractie.getFoto() !=null){ %>
            <label><%=attractie.getFoto()%> </label>
            <% } %>
            
            <% if (attractie.getDuur() !=0){ %>            
            <label><%=attractie.getDuur()%> </label>
            <% } %>
            
            <% if (attractie.getVerantwoordelijke() !=null){ %>            
            <label><%=attractie.getVerantwoordelijke().getVoornaam()%> </label>
            <% } %>
            
            <br>
        <% } %>
        
        <a href="index.jsp">Terug</a>
    </body>
</html>
