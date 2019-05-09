<%-- 
    Document   : nieuwPretpark
    Created on : Apr 4, 2019, 8:44:18 AM
    Author     : yourivanlaer
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<% String errorMessage = (String)request.getAttribute("errorMessage");

request.setAttribute("errorMessage", errorMessage);

%>
<template:template title="Nieuw bezoeker">
    <jsp:attribute name="content">
        
        <!-- banner -->
<section class="banner_inner" id="home">
	<div class="banner_inner_overlay">
	</div>
</section>
<!-- //banner -->
<!-- tour packages -->
<section class="packages pt-5">
	<div class="container py-lg-4 py-sm-3">
		
		<div class="row">               
				
                    <div class="col-lg-12 contact-left-form">
                        <h2 class="heading text-capitalize text-center mb-5">Maak een nieuwe <strong>Pretpark</strong> aan.</h2>
                        <c:if test="${errorMessage != null}">
                        <div class="alert alert-danger">
                            <strong>Alert!</strong> 
                            <ul>
                                ${errorMessage}
                            </ul>
                          </div>
                        </c:if>
                        
                            <form action="MaakServlet" method="post">
                                    <div class="form-group contact-forms">
                                        <label for="naam">Naam van het pretpark:</label>
                                      <input type="text" class="form-control" id="naam" name="naam" placeholder="Pretpark naam" > 
                                    </div>
                    
                                    <input type="submit" class="btn btn-block sent-butnn btn-primary btn-lg " name="nieuwpretpark" value="Maak pretpark aan" />
                                   
                                 </div>
                            </form>
                    </div>
		</div>
	</div>
</section>
<!-- tour packages -->


        

    </jsp:attribute>
</template:template>