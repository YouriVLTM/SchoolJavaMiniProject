<%-- 
    Document   : overzichtPersoneelslid
    Created on : Apr 25, 2019, 9:09:04 PM
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

<template:template title="Overzicht Personeelsleden">
    <jsp:attribute name="content">
        
                <!-- banner -->
<section class="banner_inner" id="home">
	<div class="banner_inner_overlay">
	</div>
</section>
                

<!-- tour packages -->
<section class="packages pt-5">
	<div class="container py-lg-4 py-sm-3">
		<h2 class="heading text-capitalize text-center">Overzicht Personeelsleden</h2>
		
                <c:choose>
    <c:when test="${personeelsleden == null}">
        <p>Er bestaan geen Personeelslid</p>
    </c:when>    
    <c:otherwise>  
        <br>
        <div class="row">
        <c:forEach items="${personeelsleden}" var="personeelslid">         
			
			<div class="col-lg-6 col-sm-6 mb-5">
				<div class="package-info text-center">
                                    <i class="fas fa-user fa-5x"></i>
					<h5 class="my-2"><span>${personeelslid.toString()}</span></h5>
                                        
                                            
				</div>
			</div>
			
        </c:forEach>
        </div>
    </c:otherwise>
</c:choose>
        <br>
        <a class="btn btn-outline-primary" href="nieuwPersoneelslid.jsp">Maak nieuwe Personeelsid aan</a>
	</div>
</section>
<!-- tour packages -->

        

    </jsp:attribute>
</template:template>

