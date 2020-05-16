<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Home</title>
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
  </style>
</head>

<body>
<%
//out.print(session.getAttribute("uNm"));
if(session.getAttribute("uNm")==null){
	response.sendRedirect("/");
}
%>
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
          <li class="active"><a href="#mycontribution">My Contribution</a></li>
          <li class="active"><a href="/contribute">Contribute</a></li>
          <li class="active"><a href="/mylogout">Logout</a></li>

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
    <section id="services" class="services">
      <div class="container">
      <div class="section-title" data-aos="zoom-out">
          <h2>Welcome <c:out value="${sessionScope.usrFullName}" /></h2>
          <p>Registered Users</p>
        </div>

<table class="table table-bordered table-stripped" data-aos="fade-left">
    <thead style="background-color:#F5F5F5;">
      <tr>
        <th>Name</th>
        <th>Location</th>
        <th>Email</th>
        <th>Status</th>
      </tr>
    </thead>
    <tbody>
   <c:forEach items="${usrRegDetails}" var="userDetails"> 
   <fmt:formatDate var="regDt" pattern = "dd-MM-yyyy" value = "${userDetails.getRegDate() }" />
      <tr style="height: 30px;">
      <c:set var="phn" value="${ userDetails.getUserPhnNum() }"></c:set>
        <td><a href="/userContri/${ userDetails.getUserEmail() }/${userDetails.getUserName()}"><b>${ userDetails.getUserName() }</b></a></br></br>${fn:substring(phn, 0, 5)}-${fn:substring(phn, 5, fn:length(phn))} </td>
        <td></br>${ userDetails.getUserAdrs() }</td>
        <td style="word-break: break-all;"></br>${ userDetails.getUserEmail() }</td>
        <c:if test="${userDetails.getUserStatus() }">
        <td><b style="color: green;">Active ${ userDetails.getUserRole() }</b></br></br><a href="" data-toggle="dropdown">Remove User</a></td>
        </c:if>
        <c:if test="${!userDetails.getUserStatus() }">
        <td><b style="color: red;">Not Active</b></br></br><div class="dropdown">
    					<a href="" data-toggle="dropdown">Approve User</a>
    					<ul class="dropdown-menu">
      					<li><a href="/approveAdmin/${ userDetails.getUserEmail() }">Admin</a></li>
      					<li><a href="/approveUser/${ userDetails.getUserEmail() }">User</a></li>
    					</ul>
  				</div></td>
        </c:if>
      </tr>
    </c:forEach>
    </tbody>
  </table>
      </div>
    </section><!-- End Services Section -->
    
    <!-- ======= Services Section ======= -->
    <section id="services" class="services">
      <div class="container">
      <div class="section-title" data-aos="zoom-out">
          <h2>Status</h2>
          <p>Flash Users</p>
        </div>

<table class="table table-bordered table-stripped" data-aos="fade-left">
    <thead style="background-color:#F5F5F5;">
      <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Unique Name</th>
      </tr>
    </thead>
    <tbody>
   <c:forEach items="${flashUserList}" var="flashUserDetails"> 
      <tr style="height: 30px;">
        <td><a href="/userContri/${ flashUserDetails.getEmailId() }/${flashUserDetails.getUserName()}"><b>${ flashUserDetails.getUserName() }</b></a></td>
        <td>${ flashUserDetails.getEmailId()}</td>
        <td>${ flashUserDetails.getUserUniqueName()}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
      </div>
    </section><!-- End Services Section -->

  <!-- ======= Services Section ======= -->
    <section id="mycontribution" class="faq">
      <div class="container">
      <div class="section-title" data-aos="zoom-out">
          <h2>Status</h2>
          <p>My Contributions</p>
        </div>
  
<div data-aos="fade-up">    
<ul class="faq-list">
<c:forEach items="${contriList}" var="contri"> 
          
            <c:choose>
            <c:when test="${contri.getId()==1 }">
            <li>
            <a data-toggle="collapse" class="" href="#f${contri.getId() }">${contri.getId() }. ${contri.getContriQuestion() }<i class="icofont-simple-up"></i></a>
            <div id="f${contri.getId() }" class="collapse show" data-parent=".faq-list" style="white-space: pre-line;">
                ${contri.getContriAnswer() }
            </div>
            </c:when>
            <c:otherwise>
            <li>
            <a data-toggle="collapse" class="collapsed" href="#f${contri.getId() }">${contri.getId() }. ${contri.getContriQuestion() } <i class="icofont-simple-up"></i></a>
            <div id="f${contri.getId() }" class="collapse" data-parent=".faq-list" style="white-space: pre-line;">
                ${contri.getContriAnswer() }
            </div>
            </c:otherwise>
            </c:choose>
          </li>
</c:forEach>
</ul>
</div>

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
        Designed by <a href="#">Sayantan M <%-- <c:out value="${sessionScope.pWd}" /> --%></a>
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
  <script src="assets/js/main.js">
  //disable back button
  $(document).ready(function() {
      window.history.pushState(null, "", window.location.href);        
      window.onpopstate = function() {
      window.history.pushState(null, "", window.location.href);
      };
  });
  </script>

</body>

</html>