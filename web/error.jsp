<%-- 
    Document   : error
    Created on : Apr 25, 2019, 7:39:08 PM
    Author     : yourivanlaer
--%>

<% String errorMessage = (String)request.getAttribute("errorMessage");

request.setAttribute("errorMessage", errorMessage);

%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<template:template title="Error Page">
    <jsp:attribute name="content">
        
                <!-- banner -->
<section class="banner_inner" id="home">
	<div class="banner_inner_overlay">
	</div>
</section>
                

<!-- tour packages -->
<section class="packages pt-5">
	<div class="container py-lg-4 py-sm-3">
		<h2 class="heading text-capitalize text-center">ERROR page!</h2>
		<p class="text mt-2 mb-5 text-center">${errorMessage}</p>
                
            
           <br>
           <br>
        <a class="btn btn-outline-primary" href="index.jsp">Ga terug naar home pagina</a>
	</div>
</section>
<!-- tour packages -->

        

    </jsp:attribute>
</template:template>