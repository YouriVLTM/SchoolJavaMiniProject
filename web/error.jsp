<%-- 
    Document   : error
    Created on : Apr 25, 2019, 7:39:08 PM
    Author     : yourivanlaer
--%>

<% String errorMessage = (String)request.getAttribute("errorMessage");%>
<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>Error page</h1>
        <p><%=errorMessage %></p>
        
        <a href="index.jsp">Ga terug naar Home page</a>
    </body>
</html>
