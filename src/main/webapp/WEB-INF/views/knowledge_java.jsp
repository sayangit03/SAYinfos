<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Enhance Knowledge</title>
  <meta content="" name="descriptison">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.jpg" rel="icon">
  <link href="assets/img/apple-touch-icon1.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="assets/vendor/line-awesome/css/line-awesome.min.css" rel="stylesheet">
  <link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
  <link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Selecao - v2.0.0
  * Template URL: https://bootstrapmade.com/selecao-bootstrap-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
  <style type="text/css">
  .borderless td, .borderless th {
    border: none;
}

.btn-primary1
{
  background: #ef6603;
  display: inline-block;
  padding: 8px 35px 10px 35px;
  border-radius: 50px;
  border:thick;
  color: #fff;
  transition: none;
  font-size: 14px;
  font-weight: 400;
  font-family: "Raleway", sans-serif;
  font-weight: 600;
  
}
.btn-primary1:hover {
  background: #fc8129;
}
.containerForm {
  border-radius: 34px;
  background-color: #f2f2f2;
  
  margin: 0px;
  padding-left: 20px;
  padding-right: 20px;
  padding-top: 16px;
  padding-bottom: 0.1px;
  font-style: italic;
}

.line {
  content: "";
  height: 1px;
  display: block;
  background: #fd9042;
  margin: 4px 10px;
}
  </style>
</head>

<body>

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top d-flex align-items-center  header-transparent ">
    <div class="container d-flex align-items-center">

      <div class="logo mr-auto">
        <h1 class="text-light"><a href="#header">SAY infos</a></h1>
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
      </div>

      <nav class="nav-menu d-none d-lg-block">
        <ul>
          <li class="drop-down"><a href="">Java</a>
          <ul>
          	<li><a href="enKnow/java/Java_Basics">Java Basics</a></li>
            <li><a href="enKnow/java/Exception_Handling">Exception Handling</a></li>
            <li><a href="enKnow/java/Java_Concurrency">Java Concurrency</a></li>
            <li><a href="enKnow/java/Java_Collection">Java Collection</a></li>
          </ul>
          </li>
          <li class="drop-down"><a href="">Spring</a>
          <ul>
          	<li><a href="enKnow/spring/Spring_Core">Spring Core</a></li>
            <li><a href="enKnow/spring/Spring_MVC">Spring MVC</a></li>
            <li><a href="enKnow/spring/Spring_AOP">Spring AOP</a></li>
            <li><a href="enKnow/spring/Spring_Data">Spring Data</a></li>
            <li><a href="enKnow/spring/Spring_Security">Spring Security</a></li>
          </ul>
          </li>
          <li class="drop-down"><a href="">Spring Advanced</a>
          <ul>
          	<li><a href="enKnow/springAdv/Spring_Boot">Spring Boot</a></li>
          	<li><a href="enKnow/springAdv/Spring_Cloud">Spring Cloud</a></li>
          	<li><a href="enKnow/springAdv/Spring_Microservices">Microservices</a></li>
          </ul>
          </li>
          <li class="drop-down"><a href="">Hibernate</a>
          <ul>
          	<li><a href="enKnow/hibernate/Hibernate_Basics">Hibernate Basics</a></li>
          	<li><a href="enKnow/hibernate/Hibernate_Advanced">Hibernate Advanced</a></li>
          </ul>
          </li>
          
          <li class="drop-down"><a href="">Services</a>
          <ul>
              
              <li><a href="/ideaMgmt">Idea Management</a></li>
              <li class="drop-down"><a href="">Enhance Knowledge</a>
              	<ul>
              	<li><a href="enKnow/java/Java_Basics">Java</a></li>
              	<li><a href="enKnow/spring/Spring_Core">Spring</a></li>
              	<li><a href="enKnow/springAdv/Spring_Boot">Spring Advanced</a></li>
              	<li><a href="enKnow/hibernate/Hibernate_Basics">Hibernate</a></li>
              	</ul>
              </li>
              <li class="drop-down"><a href="">Covid-19 Updates</a>
              	<ul>
              	<li><a href="/indiaCovid"">India & States</a></li>
              	<li><a href="/countryCovid">All Countries</a></li>
              	<li><a href="/worldCovid"">Whole World</a></li>
              	</ul>
              </li>
              <li><a href="/weather">Weather Updates</a></li>
              <li><a href="/news">Latest News</a></li>
              <li><a href="/cooking">Cooking Recipes</a></li>
          </ul>
          </li>
          <li class="active"><a href="/">Home</a></li>

        </ul>
      </nav><!-- .nav-menu -->

    </div>
  </header><!-- End Header -->

  
<section id="hero" class="d-flex flex-column justify-content-end align-items-center">
     <svg class="hero-waves" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 24 150 28 " preserveAspectRatio="none">
      <defs>
        <path id="wave-path" d="M-160 44c30 0 58-18 88-18s 58 18 88 18 58-18 88-18 58 18 88 18 v44h-352z">
      </defs>
      <g class="wave1">
        <use xlink:href="#wave-path" x="50" y="3" fill="rgba(255,255,255, .1)">
      </g>
      <g class="wave2">
        <use xlink:href="#wave-path" x="50" y="0" fill="rgba(255,255,255, .2)">
      </g>
      <g class="wave3">
        <use xlink:href="#wave-path" x="50" y="9" fill="#fff">
      </g>
    </svg>
</section>

<main id="main">

<section id="faq" class="faq">
<div class="container">
    <div class="section-title" data-aos="zoom-out">
          <h2>Mission ${domain }</h2>
          <p>${topic }</p>
        </div>
       
<div data-aos="fade-left">
<ul class="faq-list">
<c:forEach items="${knowledgeList}" var="contri" varStatus="loop"> 
            <c:choose>
            <c:when test="${cmntFlag && questionNumber == contri.getId() }">
            <li>
            <a data-toggle="collapse" class="" href="#f${contri.getId() }">${loop.count }. ${contri.getContriQuestion() } <i class="icofont-simple-up"></i></a>
            <div id="f${contri.getId() }" class="collapse show" data-parent=".faq-list">
            </br><p style="white-space: pre-line; padding-left: 5px;">${contri.getContriAnswer() }</p>
             <p class="line"></p>
            <a style="color: #ef6603; padding-left: 5px;" data-toggle="collapse" class="" href="#cm${contri.getId() }">Comment</a>
            <p></p>
            <p class="line"></p>
            <div style="padding-left: 30px;" id="cm${contri.getId() }" class="collapse show">
            <ul style=" list-style: none;">
            <c:forEach items="${contri.getCmntList() }" var="cmnt" varStatus="loopC">
            <li>
            <div class="containerForm" id="c${contri.getId() }${loopC.count }">
             <p style="white-space: pre-line; font-size: 13.2px;"><b>${cmnt.getCmntName() }</b>&nbsp;&nbsp;<fmt:formatDate value="${cmnt.getCmntDate() }" pattern="HH:mm dd-MM-yyyy"/></br> ${cmnt.getCmntBody() }</p>
             </div>
             </li>
            </c:forEach>
            <li>
            <form action="/makeComment" method="post" role="form" class="php-email-form" id="commentForm${contri.getId() }">
              <input type="hidden" name="domain" class="form-control" id="domain" value="${contri.getContriDomain() }"/>
              <input type="hidden" name="topic" class="form-control" id="topic" value="${contri.getContriTopic() }"/>
              <input type="hidden" name="questionNum" class="form-control" id="questionNum" value="${contri.getId() }"/>
              </br><input type="text" name="cmntName" class="form-control" id="cmntName" placeholder="Your Name" style=""/></br>
              <textarea class="form-control" name="cmntBody" id="cmntBody" placeholder="Your Comment" style="white-space: pre-wrap;"></textarea></br>
              <input type="button" class="btn-primary1" onclick="comment('${contri.getId() }')" value="Comment" style="line-height: normal;">
           </form>
           </li>
           </ul>
            </div>
            </div>
            </li>
            </c:when>
            <c:otherwise>
            <li>
            <a data-toggle="collapse" class="collapsed" href="#f${contri.getId() }">${loop.count }. ${contri.getContriQuestion() } <i class="icofont-simple-up"></i></a>
            <div id="f${contri.getId() }" class="collapse" data-parent=".faq-list">
            </br><p style="white-space: pre-line; padding-left: 5px;">${contri.getContriAnswer() }</p>
            <p class="line"></p>
            <a style="color: #ef6603; padding-left: 5px;" data-toggle="collapse" class="collapsed" href="#cm${contri.getId() }">Comment</a>
            <p></p>
            <p class="line"></p>
            <div style="padding-left: 30px;" id="cm${contri.getId() }" class="collapse">
            <ul style=" list-style: none;">
            <c:forEach items="${contri.getCmntList() }" var="cmnt">
            <li>
            <div class="containerForm" id="c${contri.getId() }${cmnt.getId() }">
             <p style="white-space: pre-line; font-size: 13.2px;"><b>${cmnt.getCmntName() }</b>&nbsp;&nbsp;<fmt:formatDate value="${cmnt.getCmntDate() }" pattern="HH:mm dd-MM-yyyy"/></br> ${cmnt.getCmntBody() }</p>
             </div>
             </li>
            </c:forEach>
            <li>
            <form action="/makeComment" method="post" role="form" class="php-email-form" id="commentForm${contri.getId() }">
              <input type="hidden" name="domain" class="form-control" id="domain" value="${contri.getContriDomain() }"/>
              <input type="hidden" name="topic" class="form-control" id="topic" value="${contri.getContriTopic() }"/>
              <input type="hidden" name="questionNum" class="form-control" id="questionNum" value="${contri.getId() }"/>
              </br><input type="text" name="cmntName" class="form-control" id="cmntName" placeholder="Your Name" style=""/></br>
              <textarea class="form-control" name="cmntBody" id="cmntBody" placeholder="Your Comment" style="white-space: pre-wrap;"></textarea></br>
              <input type="button" class="btn-primary1" onclick="comment('${contri.getId() }')" value="Comment" style="line-height: normal;">
           </form>
           </li>
           </ul>
            </div>
            </div>        
            </li>
            </c:otherwise>
            </c:choose>
</c:forEach>
</ul>
</div>

</div>
</section>

</br></br>
</main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <footer id="footer">
    <div class="container">
      <h3>SAY infos</h3>
      <div class="social-links">
        <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
        <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
        <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
        <a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
        <a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
      </div>
      <div class="copyright">
        &copy; Copyright <strong><span>SAYinfos</span></strong>. All Rights Reserved
      </div>
      <div class="credits">
        Designed by <a href="#">Sayantan M</a>
      </div>
    </div>
  </footer><!-- End Footer -->

  <a href="#" class="back-to-top"><i class="ri-arrow-up-line"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/jquery/jquery.min.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/venobox/venobox.min.js"></script>
  <script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
  <script src="assets/vendor/TweenMax/TweenMax.min.js"></script>
  <!-- <script src="assets/vendor/wavify/wavify.js"></script> -->
  <script src="assets/vendor/aos/aos.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>
  <script type="text/javascript">
  //disable back button
/*   $(document).ready(function() {
      window.history.pushState(null, "", window.location.href);        
      window.onpopstate = function() {
      window.history.pushState(null, "", window.location.href);
      };
  }); */
  function comment(id){
	  var form = 'commentForm'+id;
	  document.getElementById(form).submit();
  }
  function disableF5(e) { if ((e.which || e.keyCode) == 116) e.preventDefault(); };
  $(document).on("keydown", disableF5);
  </script>

</body>

</html>