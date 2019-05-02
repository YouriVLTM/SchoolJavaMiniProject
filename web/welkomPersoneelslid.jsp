<%-- 
    Document   : welkomPersoonslid
    Created on : Apr 4, 2019, 9:59:21 AM
    Author     : yourivanlaer
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="fact.it.www.beans.*;"%>


<%ArrayList<Personeelslid> personeelsleden = (ArrayList<Personeelslid>) session.getAttribute("personeelsleden");
session.setAttribute("personeelsleden", personeelsleden);
%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<template:template title="Nieuw bezoeker">
    <jsp:attribute name="content">
        
                <!-- banner -->
<section class="banner_inner" id="home">
	<div class="banner_inner_overlay">
	</div>
</section>
                

<!-- tour packages -->
<section class="packages pt-5">
	<div class="container py-lg-4 py-sm-3">
		<h2 class="heading text-capitalize text-center">Welkome ${personeelsleden.get(personeelsleden.size() - 1).getVoornaam()}!</h2>
		<p class="text mt-2 mb-5 text-center">${personeelsleden.get(personeelsleden.size() - 1).toString()}</p>

        <a class="btn btn-outline-primary" href="nieuwPersoneelslid.jsp">Maak nieuwe personeelslid aan</a>
	</div>
</section>
<!-- tour packages -->

        

    </jsp:attribute>
</template:template>
