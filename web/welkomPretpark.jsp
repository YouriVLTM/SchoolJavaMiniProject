<%-- 
    Document   : welkomPretpark
    Created on : Apr 4, 2019, 9:17:42 AM
    Author     : yourivanlaer
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="fact.it.www.beans.*;"%>


<% Pretpark pretpark = (Pretpark)(request.getAttribute("pretpark")); 
request.setAttribute("pretpark", pretpark);
%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<template:template title="Welkome Pretpark">
    <jsp:attribute name="content">
        
                <!-- banner -->
<section class="banner_inner" id="home">
	<div class="banner_inner_overlay">
	</div>
</section>
                

<!-- places -->
<section class="trav-grids py-5" id="desti">
	<div class="container py-xl-5 py-lg-3">
		<h3 class="heading text-center mb-lg-5 mb-4">Welkome in het pretpark ${pretpark.getNaam()}!</h3>
                <h4>De attractie's : </h4>
		<div class="row">
                    <c:forEach items="${pretpark.getAttracties()}" var="attractie">
                                                                        
			<div class="col-lg-6 mt-4">
				<div class="grids-tem-one">
					<div class="row">
                                            
						<div class="col-sm-5 grids-img-left">
							<img src="images/${attractie.getFoto()}" alt="" class="img-fluid">
						</div>
						<div class="col-sm-7 right-cont">
							<h4 class="mb-2 let mt-sm-0 mt-2 tm-clr">${attractie.getNaam()}</h4>
							<p class="duration mt-2"><span class="far fa-clock mr-2"></span><strong>Tijd</strong> ${attractie.getDuur()}</p>
                                                        <p class="duration mt-2"><span class="fas fa-user-tie mr-2"></span><strong>Verantwoordelijke</strong> ${attractie.getVerantwoordelijke().getFamilienaam()} ${attractie.getVerantwoordelijke().getVoornaam()}</p>

						</div>
					</div>
				</div>
			</div>
                                       
                  </c:forEach>
			
                   
	</div>
        
                <br>
        <a class="btn btn-outline-primary" href="nieuwPretpark.jsp">Maak nieuwe pretpark aan</a>
</section>
<!-- //places -->
        

    </jsp:attribute>
</template:template>
