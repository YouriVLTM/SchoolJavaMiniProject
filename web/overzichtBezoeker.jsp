<%-- 
    Document   : overzichtBezoeker
    Created on : Apr 25, 2019, 9:03:44 AM
    Author     : yourivanlaer
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="fact.it.www.beans.*;"%>


<%ArrayList<Bezoeker> bezoekers = (ArrayList<Bezoeker>) session.getAttribute("bezoekers");
ArrayList<Pretpark> pretparken = (ArrayList<Pretpark>) session.getAttribute("pretparken");

session.setAttribute("bezoekers", bezoekers);
session.setAttribute("pretparken", pretparken);

%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<template:template title="Overzicht bezoeker">
    <jsp:attribute name="content">
        
                <!-- banner -->
<section class="banner_inner" id="home">
	<div class="banner_inner_overlay">
	</div>
</section>
                

<!-- tour packages -->
<section class="packages pt-5">
	<div class="container py-lg-4 py-sm-3">
		<h2 class="heading text-capitalize text-center">Overzicht bezoekers</h2>
		
                <c:choose>
    <c:when test="${bezoekers == null}">
        <p>Er bestaan geen bezoekers</p>
        
    </c:when>    
    <c:otherwise>  
        <div class="row">
        <c:forEach items="${bezoekers}" var="bezoeker">         
			
			<div class="col-lg-6 col-sm-6 mb-5">
				<div class="package-info">
                                    <i class="fas fa-user fa-5x"></i>
					<h5 class="my-2"><span>${bezoeker.getVoornaam()} ${bezoeker.getFamilienaam()}</span></h5>
					<ul class="listing mt-3">
                                            <li><i class="fas fa-microchip mr-2"></i>Pretparkcode : <span>${bezoeker.getPretparkcode()}</span></li>
					</ul>
                                        <p>Dit zijn u pretpark matchen:</p>
                                        <ul class="listing mt-3">
                                            <c:forEach items="${pretparken}" var="pretpark">
                                                <li>
                                                    <div class="row">
                                                        <div class="col-5">
                                                            <span>${pretpark.getNaam()}</span></span>
                                                        </div>
                                                        <div class="col-5">
                                                            <div class="progress">
                                                                <div class="progress-bar bg-success" role="progressbar" style="width: ${pretpark.pretparkMatch(bezoeker)}%" aria-valuenow="${pretpark.pretparkMatch(bezoeker)}" aria-valuemin="0" aria-valuemax="100">${pretpark.pretparkMatch(bezoeker)}%</div>
                                                             </div>
                                                        </div>
                                                    </div>
                                                
                                                </li>
                                                
                                             </c:forEach>                                            
					</ul>
                                            
				</div>
			</div>
			
        </c:forEach>
        </div>
    </c:otherwise>
</c:choose>
        <br>
        <a class="btn btn-outline-primary" href="nieuwBezoeker.jsp">Maak nieuwe Bezoeker aan</a>
	</div>
</section>
<!-- tour packages -->

        

    </jsp:attribute>
</template:template>
