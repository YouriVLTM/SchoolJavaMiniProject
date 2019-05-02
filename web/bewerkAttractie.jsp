<%-- 
    Document   : bewerkAttractie
    Created on : Apr 26, 2019, 3:43:56 PM
    Author     : yourivanlaer
--%>

<%@page import="fact.it.www.beans.*"%>
<%@page import="java.util.ArrayList"%>

<% Attractie attractie = (Attractie)request.getAttribute("attractie");
ArrayList<Personeelslid> personeelsleden = (ArrayList<Personeelslid>) session.getAttribute("personeelsleden");%>

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
                            <form action="MaakServlet" method="post">
                                                               
                                    <div class="form-group contact-forms">
                                        <label for="attractienaam">Attractie naam</label>
                                      <input type="text" class="form-control" id="attractienaam" name="attractienaam" placeholder="attractienaam" value="${attractie.getNaam()}" required=""> 
                                    </div>
                                
                                    <div class="form-group contact-forms">
                                        <label for="duur">Duur</label>
                                      <input type="number" class="form-control" id="duur" name="duur" placeholder="duur" value="${attractie.getDuur()}" required=""> 
                                    </div>
                                    
                                    <div class="form-group contact-forms">
                                        <label for="fotoBestand">Naam van fotobestand</label>
                                      <input type="text" class="form-control" id="fotoBestand" name="fotoBestand" placeholder="fotoBestand" value="${attractie.getFoto()}" required=""> 
                                    </div>
                                
                                    
                                    <div class="form-group contact-forms">
                                       <label>Personeelslid verandwoordelijke</label>
                                       <br>
                                       <select name="personeelslidverandwoordelijke">
                                           <c:forEach items="${personeelsleden}" var="personeelslid">
                                                <option value= "${personeelslid.getVoornaam()}-${personeelslid.getFamilienaam()}"
                                                              <c:choose>
         
                                                            <c:when test = "${attractie.getVerantwoordelijke().equals(personeelslid)}">
                                                               selected
                                                            </c:when>
                                                            <c:otherwise>
                                                               
                                                            </c:otherwise>
                                                         </c:choose>
                                                        
                                                        
                                                        >${personeelslid.getVoornaam()} ${personeelslid.getFamilienaam()}</option>
                                           </c:forEach>
                                        </select> 
                                      
                                    </div>
                                    
                                    <input type="submit" class="btn btn-block sent-butnn btn-primary btn-lg " name="opslaanAttractie" value="Attractie opslaan" />

                                
                                 
                            </form>
                    </div>
			
                
			
		</div>
	</div>
</section>
<!-- tour packages -->


        

    </jsp:attribute>
</template:template>
