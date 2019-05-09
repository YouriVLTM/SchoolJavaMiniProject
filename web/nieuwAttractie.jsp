<%-- 
    Document   : nieuwAttractie
    Created on : Apr 4, 2019, 8:52:43 AM
    Author     : yourivanlaer
--%>

<%@page import="fact.it.www.beans.*"%>
<%@page import="java.util.ArrayList"%>
<%ArrayList<Personeelslid> personeelsleden = (ArrayList<Personeelslid>) request.getAttribute("personeelsleden");
request.setAttribute("personeelsleden", personeelsleden);

String errorMessage = (String)request.getAttribute("errorMessage");
request.setAttribute("errorMessage", errorMessage);
%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<template:template title="Nieuw Attractie">
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
                        <h2 class="heading text-center mb-5">Maak een nieuwe <strong>attractie</strong> aan.</h2>
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
                                        <label for="pretparknaam">Pretpark Naam</label>
                                      <input type="text" class="form-control" id="pretparknaam" name="pretparknaam" placeholder="pretparknaam" value="${pretpark.getNaam()}"> 
                                    </div>
                                
                                    <div class="form-group contact-forms">
                                        <label for="attractienaam">Attractie naam</label>
                                      <input type="text" class="form-control" id="attractienaam" name="attractienaam" placeholder="attractienaam" > 
                                    </div>
                                
                                    <div class="form-group contact-forms">
                                        <label for="duur">Duur</label>
                                      <input type="number" class="form-control" id="duur" name="duur" placeholder="duur" > 
                                    </div>
                                    
                                    <div class="form-group contact-forms">
                                        <label for="fotobestand">Naam van fotobestand</label>
                                      <input type="text" class="form-control" id="fotobestand" name="fotobestand" placeholder="fotobestand" > 
                                    </div>
                                
                                    
                                    <div class="form-group contact-forms">
                                       <label>Personeelslid verandwoordelijke</label>
                                       <br>
                                       <select name="personeelslidverandwoordelijke">
                                           <c:forEach items="${personeelsleden}" var="personeelslid">
                                                <option value= "${personeelslid.getVoornaam()}-${personeelslid.getFamilienaam()}">${personeelslid.getVoornaam()} ${personeelslid.getFamilienaam()}</option>
                                           </c:forEach>
                                        </select> 
                                      
                                    </div>
                                    
                                    <input type="submit" class="btn btn-block sent-butnn btn-primary btn-lg " name="nieuwattractie" value="Maak attractie aan" />

                                
                                 
                            </form>
                                    
                                    <br>
                        <br>
                        <a href="index.jsp">Ga terug naar Home</a>
                        
                    </div>
			
                
			
		</div>
	</div>
</section>
<!-- tour packages -->


        

    </jsp:attribute>
</template:template>
