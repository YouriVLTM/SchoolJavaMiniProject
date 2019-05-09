<%-- 
    Document   : Pretparkdate
    Created on : Apr 26, 2019, 5:23:16 PM
    Author     : yourivanlaer
--%>

<%@page import="fact.it.www.beans.*"%>
<%@page import="java.util.ArrayList"%>
<%ArrayList<Bezoeker> bezoekers = (ArrayList<Bezoeker>) session.getAttribute("bezoekers");
request.setAttribute("bezoekers", bezoekers);
%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<template:template title="Pretpark date">
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
                        <h2 class="heading text-center mb-5">Pretpark date</h2>
                        
                              <c:choose>
         
                                <c:when test = "${bezoekers.size() > 1}">
                                    
                                    <form action="MaakServlet" method="post">
                                
                                    <div class="form-group contact-forms">
                                        <label for="pretparknaam">Bezoeker 1</label>
                                          <select name="bezoeker1">
                                            <c:forEach items="${bezoekers}" var="bezoeker">
                                                <option value= "${bezoekers.indexOf(bezoeker)}">${bezoeker.getVoornaam()} ${bezoeker.getFamilienaam()}</option>
                                           </c:forEach>
                                          </select>
                                    </div>
                                
                                 <div class="form-group contact-forms">
                                        <label for="pretparknaam">Bezoeker 2</label>
                                          <select name="bezoeker2">
                                            <c:forEach items="${bezoekers}" var="bezoeker">
                                                <option value= "${bezoekers.indexOf(bezoeker)}">${bezoeker.getVoornaam()} ${bezoeker.getFamilienaam()}</option>
                                           </c:forEach>
                                          </select>
                                    </div>
                                
                                   
                                    
                                    <input type="submit" class="btn btn-block sent-butnn btn-primary btn-lg " name="dateNaamdateLeeftijd" value="Berekenen op bijde" />

                                
                                 
                            </form>
                                </c:when>

                                <c:otherwise>
                                    <p> Error  moeten minsten 2 bezoekers zijn!</p>
                                    <br>
                                    <a class="btn btn-outline-primary" href="index.jsp">Terug naar home pagina</a>
                                </c:otherwise>
                             </c:choose>
                           
                    </div>
			
                
			
		</div>
	</div>
</section>
<!-- tour packages -->


        

    </jsp:attribute>
</template:template>

