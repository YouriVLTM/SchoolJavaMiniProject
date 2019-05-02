<%-- 
    Document   : nieuwPersoon
    Created on : Apr 4, 2019, 9:50:02 AM
    Author     : yourivanlaer
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<template:template title="Nieuw Persoonlid">
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
                        <h2 class="heading text-center mb-5">Maak een nieuwe <strong>Persoonlid</strong> aan.</h2>
                            <form action="MaakServlet" method="post">
                                <div class="form-row">
                                    <div class="form-group col-md-6 contact-forms">
                                        <label for="voornaam">Voornaam</label>
                                      <input type="text" class="form-control" id="voornaam" name="voornaam" placeholder="Voornaam" required="">
                                    </div>
                                    <div class="form-group col-md-6 contact-forms">
                                        <label for="achternaam">Achternaam</label>
                                      <input type="text" class="form-control" id="achternaam" name="achternaam" placeholder="Achternaam" required="">
                                    </div>
                                </div>
                                  
                                <input type="submit" class="btn btn-block sent-butnn btn-primary btn-lg " name="nieuwpersoneelslid" value="Maak persoonlid aan" />
                                   
                            </form>
                    </div>
			
                
			
		</div>
	</div>
</section>
<!-- tour packages -->


        

    </jsp:attribute>
</template:template>




