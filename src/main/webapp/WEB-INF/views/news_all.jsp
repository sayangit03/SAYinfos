<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>News</title>
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
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

  .sent-message1 {
  display: none;
  color: #fff;
  background: #18d26e;
  text-align: center;
  padding: 15px;
  font-weight: 600;
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
          <li class="drop-down"><a href="">Services</a>
          <ul>
              <li class="drop-down"><a href="">Covid-19 Updates</a>
              	<ul>
              	<li><a href="/indiaCovid"">India & States</a></li>
              	<li><a href="/countryCovid">All Countries</a></li>
              	<li><a href="/worldCovid"">Whole World</a></li>
              	</ul>
              </li>
              <li><a href="#">Idea Management</a></li>
              <li><a href="#">Enhance Knowledge</a></li>
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
   
    <!-- ======= Services Section ======= -->
    <section id="faq" class="faq">
      <div class="container">
      <div class="section-title" data-aos="zoom-out">
          <h2>Service</h2>
          <p>Latest News</p>
        </div>
        
        <div class="containerForm">
        <div class="col-lg-12 mt-6 mt-lg-1" data-aos="fade-left">
        <form action="/news" method="get" role="form" class="php-email-form" id="searchForm">
        <div class="form-row">
                <div class="col-md-12 form-group">
                  <input type="text" name="name" class="form-control" id="name" placeholder="Powered by http://newsapi.org"/>
                </div>
         </div>
         <div class="mb-3">
                <!-- <div class="loading">Sending message..</div>
                <div class="error-message"></div> -->
                <div class="sent-message1" id = "myDIV1">Searching..</div>
              </div>
         <div class="text-center"><input type="button" class="btn-primary1" onclick="search()" value="Search"></div>
        </form>
        </div>
        </div></br>

<%--   <div class="panel-group" id="accordion">
  <c:forEach items="${articleList}" var="article"> 
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href='#item${article.getId() }'><i class="ri-check-double-line"></i>${article.getId() } . ${article.getTitle() }</a>
        </h4>
      </div>
      <div id='item${article.getId() }' class="panel-collapse collapse in">
      <c:choose>
      <c:when test="${fn:containsIgnoreCase(article.getSource().getName(), 'Maharashtratimes.com')}">  
        <div class="panel-body" style="padding-left: 27px"><p> ${article.getDescription() }</p></div></br>
      </c:when>
      <c:otherwise>
      	<div class="panel-body" style="padding-left: 27px"><p> ${article.getContent() }</p></div></br>
      </c:otherwise>
      </c:choose>
        <div class="panel-body" style="padding-left: 27px"><p> To read full article <a href="${article.getUrl() }" target="_blank">click here</a> </p></div></br>
    </div>
    </div>
    </c:forEach>
    </div> --%>
    
          <ul class="faq-list">
<c:forEach items="${articleList}" var="article"> 
          
            <c:choose>
            <c:when test="${article.getId()==1 }">
            <li data-aos="fade-up" data-aos-delay="${article.getId() }00">
            <a data-toggle="collapse" class="" href="#f${article.getId() }">${article.getId() }. ${article.getTitle() } <i class="icofont-simple-up"></i></a>
            <div id="f${article.getId() }" class="collapse show" data-parent=".faq-list" style="white-space: pre-line;">
                ${article.getDescription() }</br>
                <a href="${article.getUrl() }" target="_blank">Full article is here.</a>
            </div>
            </c:when>
            <c:otherwise>
            <li data-aos="fade-up" data-aos-delay="${article.getId() }00">
            <a data-toggle="collapse" class="collapsed" href="#f${article.getId() }">${article.getId() }. ${article.getTitle() } <i class="icofont-simple-up"></i></a>
            <div id="f${article.getId() }" class="collapse" data-parent=".faq-list" style="white-space: pre-line;">
                ${article.getDescription() }</br>
                <a href="${article.getUrl() }" target="_blank">Full article is here.</a>
            </div>
            </c:otherwise>
            </c:choose>
          </li>
</c:forEach>
          </ul>
    


      </div>
    </section><!-- End Services Section -->





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
  <script src="assets/vendor/wavify/wavify.js"></script>
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
  
  function search(){
	  //alert("ok");
	  var x = document.getElementById("myDIV1");
	  if (x.style.display === "none") {
		  x.style.display = "none";
	  } else {
		  x.style.display = "block";
	  }
	  document.getElementById("searchForm").submit();
  }
  </script>

</body>

</html>