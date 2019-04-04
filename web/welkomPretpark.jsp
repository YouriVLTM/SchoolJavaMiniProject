<%-- 
    Document   : welkomPretpark
    Created on : Apr 4, 2019, 9:17:42 AM
    Author     : yourivanlaer
--%>

<%@page import="fact.it.www.beans.*;"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% Pretpark pretpark = (Pretpark)(request.getAttribute("pretpark"));
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hallo</h1>
        <p><%=pretpark.getNaam()%></p>
        
        
        
        <%for(Attractie attractie : pretpark.getAttracties()){%>
               <label><%=attractie.getNaam() %> </label>
               <label><%=attractie.getFoto()%> </label>
               <label><%=attractie.getDuur()%> </label>
               <label><%=attractie.getVerantwoordelijke()%> </label>
               <br>
           <% } %>
        
        <a href="index.jsp">Terug</a>
    </body>
</html>
