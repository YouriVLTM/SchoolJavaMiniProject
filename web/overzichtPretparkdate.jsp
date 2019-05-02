<%-- 
    Document   : overzichtPretparkdate
    Created on : Apr 26, 2019, 5:44:01 PM
    Author     : yourivanlaer
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="fact.it.www.beans.*;"%>


<%String leeftijd = (String)(request.getAttribute("leeftijd"));
String score = (String)(request.getAttribute("score"));

request.setAttribute("leeftijd", leeftijd);
request.setAttribute("score", score);
%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<template:template title="Overzicht date">
    <jsp:attribute name="content">
        
                <!-- banner -->
<section class="banner_inner" id="home">
	<div class="banner_inner_overlay">
	</div>
</section>
                

<!-- tour packages -->
<section class="packages pt-5">
	<div class="container py-lg-4 py-sm-3">
		<h2 class="heading text-capitalize text-center">Overzicht Date</h2>
                <p>Op basis van de naam passen jullie voor ${score}% bij elkaar</p>
                <i class="fas fa-heartbeat fa-4x"></i>
                 <div class="progress">
                    <div class="progress-bar bg-danger" role="progressbar" style="width: ${score}%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">${score}</div>
                  </div>
                  
                  <br>
                <p>${leeftijd}</p>
                <br>
        <a class="btn btn-outline-primary" href="Pretparkdate.jsp">Overzicht van Pretparkdate</a>
	</div>
</section>
<!-- tour packages -->

        

    </jsp:attribute>
</template:template>
