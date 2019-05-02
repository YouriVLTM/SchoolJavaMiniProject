<%-- 
    Document   : test.jsp
    Created on : May 2, 2019, 9:18:23 AM
    Author     : yourivanlaer
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="fact.it.www.beans.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page session="true" %>

<%ArrayList<Bezoeker> bezoekers = (ArrayList<Bezoeker>) session.getAttribute("bezoekers");
ArrayList<Pretpark> pretparken = (ArrayList<Pretpark>) session.getAttribute("pretparken");
Bezoeker bezoeker = bezoekers.get(bezoekers.size() - 1);

request.setAttribute("bezoeker", bezoeker);
session.setAttribute("pretparken", pretparken);
%>

<% String test = "hello world";
request.setAttribute("test", test);
%>
<template:template title="Home">
    <jsp:attribute name="content">
        <p><c:out value="${bezoeker}" /> </p>
    </jsp:attribute>
    
    
</template:template>