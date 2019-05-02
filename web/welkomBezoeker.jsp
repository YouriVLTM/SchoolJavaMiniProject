<%-- 
    Document   : welkom
    Created on : Mar 28, 2019, 9:32:23 AM
    Author     : yourivanlaer
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="fact.it.www.beans.*;"%>


<%ArrayList<Bezoeker> bezoekers = (ArrayList<Bezoeker>) session.getAttribute("bezoekers");
ArrayList<Pretpark> pretparken = (ArrayList<Pretpark>) session.getAttribute("pretparken");
Bezoeker bezoeker = bezoekers.get(bezoekers.size() - 1);

request.setAttribute("bezoeker", bezoeker);
session.setAttribute("pretparken", pretparken);

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
		<h2 class="heading text-capitalize text-center">Welkome ${bezoeker.getVoornaam()}!</h2>
		<p class="text mt-2 mb-5 text-center">${bezoeker.toString()}</p>
                
            <p>U gekozen attractie :
                
            <c:choose>
               <c:when test="${bezoeker.getAantalOpWishlist() != 0}">
                   <c:forEach items="${bezoeker.getWishlist()}" var="attractieNaam">
                        <label>${attractieNaam}</label>
                   </c:forEach>
               </c:when>    
               <c:otherwise>
                   <label> Er is geen favoriete attracties gekozen</label>
               </c:otherwise>
           </c:choose>
           
         </p>
           <br>
           <br>
        <a class="btn btn-outline-primary" href="nieuwBezoeker.jsp">Maak nieuwe gebruiker aan</a>
	</div>
</section>
<!-- tour packages -->

        

    </jsp:attribute>
</template:template>
     
