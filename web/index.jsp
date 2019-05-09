<%-- 
    Document   : index
    Created on : Mar 28, 2019, 9:17:26 AM
    Author     : yourivanlaer
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>

<template:template title="Home">
    <jsp:attribute name="content">
        

<!-- banner -->
<section class="banner_w3lspvt" id="home">
	<div class="csslider infinity" id="slider1">
		<input type="radio" name="slides" checked="checked" id="slides_1" />
		<ul>
			<li>
				<div class="banner-top">
					<div class="overlay">
						<div class="container">
							<div class="w3layouts-banner-info">
								<h3 class="text-wh">Pretpark</h3>
                                                                <h4>Van Laer Youri</h4>
								<div class="buttons mt-4">
									<a href="#" class="btn mr-2">Welkom op onze pretparken</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</li>
			
			
		</ul>
		<div class="arrows">
			<label for="slides_1"></label>
			
		</div>
	</div>
</section>
<!-- //banner -->
        <!-- how to book -->
<section class="book py-5">
	<div class="container py-lg-5 py-sm-3">
		<h2 class="heading text-capitalize text-center"> Welkom op onze pretparken</h2>            
    
                    
                     <form action="MaakServlet" method="POST"> 
                         <div class="form-row mt-5">
                             <div class="col-8 contact-forms">
                                  <label for="attractieNaam" class="sr-only">attractie Naam</label>
                                    <input type="text" class="form-control" id="attractieNaam" name="attractieNaam" placeholder="attractie Naam">
                             </div>
                             <div class="col-4">
                                 <input type="submit" class="btn btn-outline-light mb-2 btn-lg" name="zoekAttractie" value="Zoek de attractie op" />
                             </div>
                         </div>
                     </form>
			
	</div>
</section>
<!-- //how to book -->

        <!-- services -->
<section class="services pt-5">
	<div class="container py-lg-5 py-sm-3">
		<h2 class="heading text-capitalize text-center mb-lg-5 mb-4">Dashboard Pretpark</h2> 
                <hr>
        </div>
</section>
<section class="services">
	<div class="container py-lg-5 py-sm-3">
                <h2 class="heading text-capitalize text-center mb-lg-5 mb-4">Nieuw</h2>      
               
                <div class="row">
                        <div class="col-lg-4 col-md-6 col-sm-6 service-grid-wthree text-center mb-5">
                                <div class="ser-fashion-grid">
                                        <div class="about-icon mb-md-4 mb-3">
                                            <span class="fas fa-user-plus fa-3x" aria-hidden="true"></span>
                                        </div>
                                        <div class="ser-sevice-grid mb-3">
                                          <h4 class="pb-3">Nieuw bezoeker</h4>
                                          <p>Hier kan je een nieuw bezoeker aanmaken.</p>
                                        </div>
                                         <a class="btn btn-outline-primary btn-block" href="nieuwBezoeker.jsp">Maak aan</a>

                          </div>
                        </div>
                        <div class="col-lg-4 col-md-6 col-sm-6 service-grid-wthree text-center mb-5">
                                <div class="ser-fashion-grid">
                                        <div class="about-icon mb-md-4 mb-3">
                                            <span class="far fa-building fa-3x" aria-hidden="true"></span>
                                        </div>
                                        <div class="ser-sevice-grid mb-3">
                                          <h4 class="pb-3">Nieuw pretpark</h4>
                                          <p>Hier kan je een nieuw pretpark aanmaken.</p>
                                        </div>
                                         <a class="btn btn-outline-primary btn-block" href="nieuwPretpark.jsp">Maak aan</a>

                          </div>
                        </div>
                        <div class="col-lg-4 col-md-6 col-sm-6 service-grid-wthree text-center mb-5">
                                <div class="ser-fashion-grid">
                                        <div class="about-icon mb-md-4 mb-3">
                                            <span class="fas fa-user-tie fa-3x" aria-hidden="true"></span>
                                        </div>
                                        <div class="ser-sevice-grid mb-3">
                                          <h4 class="pb-3">Nieuw persooneelslid</h4>
                                          <p>Hier kan je een nieuw persooneelslid aanmaken.</p>
                                        </div>
                                         <a class="btn btn-outline-primary btn-block" href="nieuwPersoneelslid.jsp">Maak aan</a>

                          </div>
                        </div>

                </div>
                
	</div>
</section>
<!-- //services -->
<section class="services">
	<div class="container py-lg-5 py-sm-3">
                <h2 class="heading text-capitalize text-center mb-lg-5 mb-4">Overzicht</h2>      
               
                <div class="row">
                        <div class="col-lg-4 col-md-6 col-sm-6 service-grid-wthree text-center mb-5">
                                <div class="ser-fashion-grid">
                                        <div class="about-icon mb-md-4 mb-3">
                                            <span class="fas fa-users fa-3x" aria-hidden="true"></span>
                                        </div>
                                        <div class="ser-sevice-grid mb-3">
                                          <h4 class="pb-3">Overzicht bezoekers</h4>
                                          <p>Hier heb je een overzicht van bezoekers.</p>
                                        </div>
                                         <a class="btn btn-outline-primary btn-block" href="overzichtBezoeker.jsp">Bekijk</a>

                          </div>
                        </div>
                        <div class="col-lg-4 col-md-6 col-sm-6 service-grid-wthree text-center mb-5">
                                <div class="ser-fashion-grid">
                                        <div class="about-icon mb-md-4 mb-3">
                                            <span class="fas fa-university fa-3x" aria-hidden="true"></span>
                                        </div>
                                        <div class="ser-sevice-grid mb-3">
                                          <h4 class="pb-3">Overzicht pretparken</h4>
                                          <p>Hier heb je een overzicht van pretparken.</p>
                                        </div>
                                         <a class="btn btn-outline-primary btn-block" href="overzichtPretpark.jsp">Bekijk</a>

                          </div>
                        </div>
                        <div class="col-lg-4 col-md-6 col-sm-6 service-grid-wthree text-center mb-5">
                                <div class="ser-fashion-grid">
                                        <div class="about-icon mb-md-4 mb-3">
                                            <span class="fas fa-users-cog fa-3x" aria-hidden="true"></span>
                                        </div>
                                        <div class="ser-sevice-grid mb-3">
                                          <h4 class="pb-3">Overzicht persooneelsleden</h4>
                                          <p>Hier heb je een overzicht van persooneelsleden.</p>
                                        </div>
                                         <a class="btn btn-outline-primary btn-block" href="overzichtPersoneelslid.jsp">Bekijk</a>

                          </div>
                        </div>
                        <div class="col-lg-4 col-md-6 col-sm-6 service-grid-wthree text-center mb-5">
                                    <div class="ser-fashion-grid">
                                            <div class="about-icon mb-md-4 mb-3">
                                                <span class="fas fa-heartbeat fa-3x" aria-hidden="true"></span>
                                            </div>
                                            <div class="ser-sevice-grid mb-3">
                                              <h4 class="pb-3">Overzicht pretpark Date</h4>
                                              <p>Hier heb je een overzicht van pretpark date.</p>
                                            </div>
                                             <a class="btn btn-outline-primary btn-block" href="Pretparkdate.jsp">Bekijk</a>

                              </div>
                            </div>

                </div>
                
	</div>
</section>

<section class="services">
	<div class="container py-lg-5 py-sm-3">
                <h2 class="heading text-capitalize text-center mb-lg-5 mb-4">Opvullen</h2>      
               
                <div class="row">
                        <div class="col-lg-4 col-md-6 col-sm-6 service-grid-wthree text-center mb-5">
                                <div class="ser-fashion-grid">
                                        <div class="about-icon mb-md-4 mb-3">
                                            <span class="fas fa-database fa-3x" aria-hidden="true"></span>
                                        </div>
                                        <div class="ser-sevice-grid mb-3">
                                          <h4 class="pb-3">Gegeven Opvullen</h4>
                                          <p>Standaart gegeven opvullen</p>
                                        </div>
                                         <a class="btn btn-outline-primary btn-block" href="OpvulServlet?actie=opvullen">Opvullen</a>

                          </div>
                        </div>
                        
                        

                </div>
                
	</div>
</section>




    </jsp:attribute>
</template:template>
    
