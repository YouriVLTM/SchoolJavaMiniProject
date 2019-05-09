<%-- 
    Document   : template
    Created on : May 2, 2019, 9:34:41 AM
    Author     : yourivanlaer
--%>

<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@ attribute name="title" required="true" rtexprvalue="true"%>
<%@ attribute name="content" fragment="true"%>


<!DOCTYPE html>
<html lang="en">

<head>
  <title>${title}</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta charset="utf-8">
  <meta name="keywords" content="Pretpark" />



  <!-- css files -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <!--<link href="assets/css/bootstrap.css" rel='stylesheet' type='text/css' />-->
  <!-- bootstrap css -->
  <link href="assets/css/style.css" rel='stylesheet' type='text/css' />
  <!-- custom css -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
  <!-- fontawesome css -->
  <!-- //css files -->

  <link href="assets/css/css_slider.css" type="text/css" rel="stylesheet" media="all">

  <!-- google fonts -->
  <link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
  <link href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
  <!-- //google fonts -->

</head>

<body>

  <!-- header -->
  <header>
    <div class="container">
      <!-- nav -->
      <nav class="py-md-4 py-3 d-lg-flex">
        <div id="logo">
          <h1 class="mt-md-0 mt-2"> <a href="index.jsp"><span class="fa fa-map-signs"></span> Pretpark </a></h1>
        </div>
        <label for="drop" class="toggle"><span class="fa fa-bars"></span></label>
        <input type="checkbox" id="drop" />
        <ul class="menu ml-auto mt-1">
          <li class="active"><a href="index.jsp">Home</a></li>
          <li class=""><a href="nieuwBezoeker.jsp">New bezoeker</a></li>
          <li class=""><a href="overzichtPretpark.jsp">Overzicht pretpark</a></li>
          <li class=""><a href="Pretparkdate.jsp">Date</a></li>
          <li class="booking"><a href="OpvulServlet?actie=opvullen">Opvullen</a></li>
        </ul>
      </nav>
      <!-- //nav -->
    </div>
  </header>
  <!-- //header -->

<jsp:invoke fragment="content"></jsp:invoke>



  <!-- copyright -->
  <div class="copyright py-3 text-center">
    <p>© 2019 Pretpark | Design by <a href="https://school.yourivanlaer.be/" target="=_blank"> Youri Van Laer </a></p>
  </div>
  <!-- //copyright -->

  <!-- move top -->
  <div class="move-top text-right">
    <a href="#home" class="move-top">
		<span class="fa fa-angle-up  mb-3" aria-hidden="true"></span>
	</a>
  </div>
  <!-- move top -->


</body>

</html>
