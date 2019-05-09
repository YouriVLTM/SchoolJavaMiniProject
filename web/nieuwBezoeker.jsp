<%-- 
    Document   : nieuwBezoekers
    Created on : Mar 28, 2019, 9:18:04 AM
    Author     : yourivanlaer
--%>

<%@page import="fact.it.www.beans.Pretpark"%>
<%@page import="java.util.ArrayList"%>
<%ArrayList<Pretpark> pretparken = (ArrayList<Pretpark>) session.getAttribute("pretparken");
 String[] attractieLijst = new String[]{ "geen", "wingo","Joepiewoepie","attractie1" };  

String errorMessage = (String)request.getAttribute("errorMessage");

request.setAttribute("errorMessage", errorMessage);

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
<!-- //banner -->
<!-- tour packages -->
<section class="packages pt-5">
	<div class="container py-lg-4 py-sm-3">
		
		<div class="row">               
				
                    <div class="col-lg-12 contact-left-form">
                        <h2 class="heading text-center mb-5">Maak een nieuwe <strong>bezoeker</strong> aan.</h2>
                        
                        <c:if test="${errorMessage != null}">
                        <div class="alert alert-danger">
                            <strong>Alert!</strong> 
                            <ul>
                                ${errorMessage}
                            </ul>
                          </div>
                        </c:if>
                        
                        
                            <form action="MaakServlet" method="post">
                                <div class="form-row">
                                    <div class="form-group col-md-6 contact-forms">
                                        <label for="voornaam">Voornaam</label>
                                      <input type="text" class="form-control" id="voornaam" name="voornaam" placeholder="Voornaam" >
                                    </div>
                                    <div class="form-group col-md-6 contact-forms">
                                        <label for="achternaam">Achternaam</label>
                                      <input type="text" class="form-control" id="achternaam" name="achternaam" placeholder="Achternaam" >
                                    </div>
                                </div>
                                    <div class="form-group contact-forms">
                                        <label for="geboortejaar">Geboortejaar</label>
                                        <input type="text" class="form-control" id="geboortejaar" name="geboortejaar" placeholder="Geboortejaar"> 
                                    </div>
                                
                                    
                                    <div class="form-group contact-forms">
                                       <label>Attractie</label>
                                       <br>
                                      <c:forTokens items = "geen,wingo,Joepiewoepie,attractie1" delims = "," var = "attractie">
                                            <input type="radio" name="attractienaam" value="${attractie}" id="${attractie}">
                                               <label for="${attractie}">${attractie}</label>
                                     </c:forTokens>
                                    </div>
                                
                                 <div class="form-group contact-forms">
                                       <label>Pretparken</label>
                                       <br>
                                      <c:forEach items="${pretparken}" var="pretpark">
                                        <input type="radio" name="pretparkindex" value="${pretparken.indexOf(pretpark)}" id="${pretparken.indexOf(pretpark)}">
                                       <label for="${pretparken.indexOf(pretpark)}">${pretpark.getNaam()}</label>
                                    </c:forEach>
                                    </div>
                                
                                   
                                 <div class="row">
                                    <div class="col-6">
                                        <input type="submit" class="btn btn-block sent-butnn btn-primary btn-lg " name="nieuwbezoeker" value="Ga door als bezoeker zonder pretparkregistratie" />
                                    </div>
                                    <div class="col-6">
                                        <input type="submit" class="btn btn-block sent-butnn btn-primary btn-lg " name="nieuwbezoekermetpretpark" value="Ga door als bezoeker" />
                                     </div>
                                 </div>
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


