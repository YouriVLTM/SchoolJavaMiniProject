<%-- 
    Document   : overzichtPretpark
    Created on : Apr 25, 2019, 9:37:17 AM
    Author     : yourivanlaer
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="fact.it.www.beans.*;"%>


<%ArrayList<Pretpark> pretparken = (ArrayList<Pretpark>) session.getAttribute("pretparken");

session.setAttribute("pretparken", pretparken);
%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<template:template title="Overzicht pretparken">
    <jsp:attribute name="content">
        
                <!-- banner -->
<section class="banner_inner" id="home">
	<div class="banner_inner_overlay">
	</div>
</section>
                

<!-- tour packages -->
<section class="packages pt-5">
	<div class="container py-lg-4 py-sm-3">
		<h2 class="heading text-capitalize text-center">Overzicht pretparken</h2>
		
                <c:choose>
    <c:when test="${pretparken == null}">
        <p>Er bestaan geen pretparken</p>
    </c:when>    
    <c:otherwise>  
        <br>
        <div class="row">
        <c:forEach items="${pretparken}" var="pretpark">        
			
            <div class="col-lg-6 col-sm-6 mb-5">
                    <div class="package-info text-center">
                            <h2 class="my-2"><span>${pretpark.getNaam()}</span></h2>
                            <a href="MaakServlet?pretpark=${pretparken.indexOf(pretpark)}">Klik hier</a>


                    </div>
            </div>
			
        </c:forEach>
        </div>
    </c:otherwise>
</c:choose>

        <a class="btn btn-outline-primary" href="nieuwPersoneelslid.jsp">Maak nieuwe Personeelsid aan</a>
	</div>
</section>
<!-- tour packages -->

        

    </jsp:attribute>
</template:template>
