<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>SAYinfos</title>
  <meta content="" name="descriptison">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.jpg" rel="icon">
  <link href="assets/img/apple-touch-icon1.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
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
  .tooltip .tooltiptext {
    width: 100px;
    bottom: 100%;    
    left: 50%;
    margin-left: -50px; /* This makes the margin half of the width to the center */
}
  .sent-message1 {
  display: none;
  color: #fff;
  background: #18d26e;
  text-align: center;
  padding: 15px;
  font-weight: 600;
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

.loading1 {
  display: none;
  color: #fff;
  background: #18d26e;
  text-align: center;
  padding: 15px;
  font-weight: 600;
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

<body onload="myFunction3()">
<%session.invalidate(); %>

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
          <li class="active"><a href="#header">Home</a></li>
          <li><a href="#about">About</a></li>
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
              	<li><a href="/worldCovid">Whole World</a></li>
              	</ul>
              </li>
              <li><a href="/weather">Weather Updates</a></li>
              <li><a href="/news">Latest News</a></li>
              <li><a href="/cooking">Cooking Recipes</a></li>
          </ul>
          </li>
          <li><a href="#contact">Contact</a></li>
          <li><a href="#header" data-toggle="modal" data-target="#signup">Sign Up</a></li>
          <li><a href="#header" data-toggle="modal" data-target="#login">Login</a></li>

        </ul>
      </nav><!-- .nav-menu -->

    </div>
  </header><!-- End Header -->

  <!-- ======= Hero Section ======= -->
  <section id="hero" class="d-flex flex-column justify-content-end align-items-center">
    <div id="heroCarousel" class="container carousel carousel-fade" data-ride="carousel">

      <!-- Slide 1 -->
      <div class="carousel-item active">
        <div class="carousel-container">
          <h2 class="animated fadeInDown">Welcome to <span>SAYinfos</span></h2>
          <p class="animated fadeInUp">Do something that matters</p>
          <a href="#about" class="btn-get-started animated fadeInUp scrollto">Read More</a>
        </div>
      </div>

       <!-- Slide 2 -->
      <!--<div class="carousel-item">
        <div class="carousel-container">
          <h2 class="animated fadeInDown">Start something that matters</h2>
          <p class="animated fadeInUp">Stop wasting valuable time with projects that just isn't you.</p>
          <a href="#about" class="btn-get-started animated fadeInUp scrollto">Read More</a>
        </div>
      </div> -->

      <!-- <a class="carousel-control-prev" href="#heroCarousel" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon bx bx-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>

      <a class="carousel-control-next" href="#heroCarousel" role="button" data-slide="next">
        <span class="carousel-control-next-icon bx bx-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a> -->

    </div>
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
  </section><!-- End Hero -->

  

  <main id="main">
  
    <div class="modal fade" id="loginfail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    <div class="modal-body" align="center">
          <p>Wrong credentials!</p>
        </div>
    </div>
    </div>
    </div>
    
     <div class="modal fade" id="servicefail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    <div class="modal-body" align="center">
          <p>The service you are trying to access is temporarily closed!</p>
        </div>
    </div>
    </div>
    </div>
    
    <div class="modal fade" id="accessfail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    <div class="modal-body" align="center">
          <p>Unauthorized Access!</p>
        </div>
    </div>
    </div>
    </div>
    
    <main id="main">
     <div class="modal fade" id="emailRegSuccess" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    <div class="modal-body" align="center">
          <p>Your registration is successful! You will receive a mail with login name on approval.</p>
        </div>
    </div>
    </div>
    </div>
    
    <div class="modal fade" id="emailfail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    <div class="modal-body" align="center">
          <p>Please use different email id. This one is already registered.</p>
        </div>
    </div>
    </div>
    </div>
    
    <main id="main">
    <div class="modal fade" id="namefail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    <div class="modal-body" align="center">
          <p>Please enter your name correctly.</p>
        </div>
    </div>
    </div>
    </div>
  
  <div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    <form action="/mylogin" method="post" role="form" class="php-email-form" id="loginForm">
      <div class="modal-header text-center">
        <h4 class="modal-title w-100 font-weight-bold">Login</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <div class="form-row">
           <div class="col-md-2 form-group"">
           <i class="la la-user" style="font-size: 40px;"></i>
           </div>
           <div class="col-md-10 form-group">
           <input type="text" class="form-control" name="uniqueName" id="uniqueName" placeholder="Your Login Name" onkeyup="myFunctionValidateLogin()"/>
           <div class="validate"></div>
           </div>
      </div></br>
        
        <div class="form-row">
           <div class="col-md-2 form-group">
                <i class="la la-lock" style="font-size: 40px;"></i>
           </div>
           <div class="col-md-10 form-group">
           <input type="password" class="form-control" name="userPwd" id="userPwd" placeholder="Your Password" onkeyup="myFunctionValidateLogin()"/>
           <div class="validate"></div>
           </div>
      </div>

      </div>
      <div class="modal-footer d-flex justify-content-center">
      <div class="sent-message1" id = "myDIVLogin">Please wait. You will be redirected to your home page. </div></br>
        <input type="button" class="btn-primary1" onclick="myFunctionLogin()" id="submitLogin" value="Login">
      </div>
      <p align="center">Want to contribute Q&A?</p>
      
      <div class="form-row">
      <div class="col-md-6 form-group">
      <div class="modal-footer d-flex justify-content-center">
      <a href="/ssoLogin">Login With Google</a>
      </div>
      </div>
      <div class="col-md-6 form-group">
      <div class="modal-footer d-flex justify-content-center">
      <a href="#header" data-toggle="modal" data-target="#otpLoginModal" data-dismiss="modal">Login With OTP</a>
      </div>
      </div>
      </div>
      </form>
    </div>
  </div>
</div>
<div class="modal fade" id="otpLoginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    
      <div class="modal-header text-center">
        <h4 class="modal-title w-100 font-weight-bold">OTP Login</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" align="center" style="margin-bottom: 15px;">
      <form action="/generateOTP" method="post" role="form" class="php-email-form" id="OTPGenerationForm">
           <input type="text" class="form-control" name="otpEmailId" id="otpEmailId" placeholder="Enter Email Id" onkeyup="myFunctionValidateOTPGen()"/><br>
           <input type="submit" class="btn-primary1" onclick="myFunctionLoginOTPShowTextBox()" id="submitOTPGen" value="Get OTP">
      </form>
      <form action="/myOTPLogin" method="post" role="form" class="php-email-form" id="OTPLoginForm">
      	   <div id="OTPBox" style="display: none; margin-top: 0;"><br><input type="text" class="form-control" name="OTPBoxVal" id="OTPBoxVal" placeholder="Enter OTP"/><br>
      	   <div align="center"><p id="mins"></p><p id="end"></p></div>
      	   <div class="sent-message1" id = "myDIVLoginOTP" style="margin-bottom: 22px">Please wait. You will be redirected to your home page. </div>
      	   <input type="button" class="btn-primary1" onclick="myFunctionLoginOTP()" id="submitOTPLogin" value="Login"></div>
      </form>
      </div>
      
     <!-- <div class="modal-footer d-flex justify-content-center">
      <div class="sent-message1" id = "myDIVLoginOTP">Please wait. You will be redirected to your home page. </div></br>
        <input type="button" class="btn-primary1" onclick="myFunctionLoginOTP()" id="submitLogin" value="Login">
      </div> -->
    </div>
    </div>
</div>
  
<div class="modal fade" id="signup" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    <form action="/registration" method="post" role="form" class="php-email-form" id="signupForm">
    <!-- <fieldset disabled="disabled"> -->
      <div class="modal-header text-center">
        <h4 class="modal-title w-100 font-weight-bold">Sign up</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <div class="form-row">
           <div class="col-md-2 form-group"">
           <i class="la la-user" style="font-size: 40px;"></i>
           </div>
           <div class="col-md-10 form-group">
           <input type="text" class="form-control" name="name" id="names" placeholder="Your Name*" onkeyup="myFunctionValidate()" minlength=4 data-toggle="tooltip" title="Please enter name with more than 5 characters"/>
           <div class="validate"></div>
           </div>
      </div></br>
        
        <div class="form-row">
           <div class="col-md-2 form-group">
                <i class="la la-map-marker" style="font-size: 40px;"></i>
           </div>
           <div class="col-md-10 form-group">
           <input type="text" class="form-control" name="location" id="location" placeholder="Your Location" />
           <div class="validate"></div>
           </div>
      </div></br>
      
        <div class="form-row">
           <div class="col-md-2 form-group">
           <i class="la la-envelope" style="font-size: 40px;"></i>
           </div>
           <div class="col-md-10 form-group">
           <input type="email" class="form-control" name="email" id="emails" placeholder="Your Email*" onkeyup="myFunctionValidate()" minlength=4 data-toggle="tooltip" title="Please enter valid email"/>
           <div class="validate"></div>
           </div>
      </div></br>

        <div class="form-row">
           <div class="col-md-2 form-group">
           <i class="la la-mobile-phone" style="font-size: 40px;"></i>
           </div>
           <div class="col-md-10 form-group">
           <input type="number" class="form-control" name="phone" id="phone" placeholder="Your Phone Number"/>
           <div class="validate"></div>
           </div>
      </div></br>
      
        <div class="form-row">
           <div class="col-md-2 form-group">
           <i class="la la-lock" style="font-size: 40px;"></i>
           </div>
           <div class="col-md-10 form-group">
           <input type="password" class="form-control" name="password" id="passwords" placeholder="Your Password*" onkeyup="myFunctionValidate()" minlength=4 data-toggle="tooltip" title="Please enter password with more than 5 characters"/>
           <div class="validate"></div>
           </div>
      </div>

      </div>
      <div class="modal-footer d-flex justify-content-center">
      <div class="sent-message1" id = "myDIV">Please wait while we validate your data.</div></br>
        <!-- <button class="btn-primary1" onclick="myFunction()" id="submitSignup" >Sign up</button> -->
        <input type="button" class="btn-primary1" onclick="myFunction()" id="submitSignup" value="Sign Up">
      </div>
      <p align="center">Want to contribute Q&A?</p>
      <div class="form-row">
      <div class="col-md-6 form-group">
      <div class="modal-footer d-flex justify-content-center">
      <a href="/ssoLogin">Login With Google</a>
      </div>
      </div>
      <div class="col-md-6 form-group">
      <div class="modal-footer d-flex justify-content-center">
      <a href="#header" data-toggle="modal" data-target="#otpLoginModal" data-dismiss="modal">Login With OTP</a>
      </div>
      </div>
      </div>
      <!-- </fieldset> -->
      </form>
    </div>
  </div>
</div>

    <!-- ======= About Section ======= -->
    <section id="about" class="about">
      <div class="container">

        <div class="section-title" data-aos="zoom-out">
          <h2>About</h2>
          <p>Who we are</p>
        </div>

        <div class="row content" data-aos="fade-up">
          <div class="col-lg-6">
            <p>
              Welcome to SAYinfos - a non-profit/non-commercial and open/crowd source website.
            </p>
            
            <ul>
              <li><i class="ri-check-double-line"></i> Interview Oriented Q&A</li>
              <li><i class="ri-check-double-line"></i> Cooking Recipes</li>
              <li><i class="ri-check-double-line"></i> Check COVID19 updates</li>
              <li><i class="ri-check-double-line"></i> Read Daily News</li>
              <li><i class="ri-check-double-line"></i> Get Weather Forecasts</li>
              <li><i class="ri-check-double-line"></i> Contribute Q&A Upon Login</li>
              <li><i class="ri-check-double-line"></i> Contribute Recipes Upon Login</li>
            </ul>
          </div>
          <div class="col-lg-6 pt-4 pt-lg-0">
            <p>
              This website is made out of sheer interest towards learning something new. This website does not promote anything and does not contain any advertise. It is also a personal website where all the services are implemented to make a point of proof for new learnings. The source code is available on GIT. <a href="https://github.com/sayangit03" target="_blank">Click here</a> to access it. We would love to have your contributions here.</br> Reach me for more details.
            </p>
            <p style="font: italic; color: #ef6603;">**Cookies used only to track the user session while logged in. Cookies expire when the browsing session ends**</p>
            <!-- <a href="#" class="btn-learn-more">Learn More</a> -->
          </div>
        </div>

      </div>
    </section><!-- End About Section -->

<!--     ======= Features Section =======
    <section id="features" class="features">
      <div class="container">

        <ul class="nav nav-tabs row d-flex">
          <li class="nav-item col-6" data-aos="zoom-in">
            <a class="nav-link active show" data-toggle="tab" href="#tab-1">
              <i class="las la la-puzzle-piece"></i>
              <h4 class="d-none d-lg-block">Solution to your innovation</h4>
            </a>
          </li>
          
          <li class="nav-item col-6" data-aos="zoom-in" data-aos-delay="100">
            <a class="nav-link" data-toggle="tab" href="#tab-2">
              <i class="las la la-mortar-board"></i>
              <h4 class="d-none d-lg-block">Enhance your knowledge</h4>
            </a>
          </li>
         
        </ul>

        <div class="tab-content" data-aos="fade-up">
          <div class="tab-pane active show" id="tab-1">
            <div class="row">
              <div class="col-lg-6 order-2 order-lg-1 mt-3 mt-lg-0">
                <h3>One stop solution for your innovative ideas</h3></br>
                <p>
                  As we say with SAYinfos, just say, we will be there and weave your innovation together.
                </p>
                <p>Just tell us about your innovative ideas. We will work on it together and the implementation will be added here in this website. </p>
                <ul>
                  <li><i class="ri-check-double-line"></i> Your passion, our implementation for free</li>
                  <li><i class="ri-check-double-line"></i> Solution to all your issues and queries for free</li>
                  <li><i class="ri-check-double-line"></i> Consume our expertise to grow your technical skills for free</li>
                  <li><i class="ri-check-double-line"></i> Solution to your unimplemented tasks for free</li>
                  <li><i class="ri-check-double-line"></i> Exchange of knowledge and innovative ideas</li>
                </ul></br>
                <p>
                  **Coming Soon**
                </p>
              </div>
              <div class="col-lg-6 order-1 order-lg-2 text-center">
                <img src="assets/img/features-1.png" alt="" class="img-fluid">
              </div>
            </div>
          </div>
        
          <div class="tab-pane" id="tab-2">
            <div class="row">
              <div class="col-lg-6 order-2 order-lg-1 mt-3 mt-lg-0">
                <h3>Enhance your knowledge with our wide range of study materials</h3></br>
                <p>
                 We have created a study-base where you can go through a wide range of book and articles, which you can share among everyone. You can also submit your articles and contribute in our study-base.
                </p>
                <ul>
                  <li><i class="ri-check-double-line"></i> Read any book or article for free.</li>
                  <li><i class="ri-check-double-line"></i> Download any book or article for free</li>
                  <li><i class="ri-check-double-line"></i> Submit your own article.</li>
                  <li><i class="ri-check-double-line"></i> Edit your article anytime.</li>
                </ul></br>
                <p>
                  **Coming Soon**
                </p>
              </div>
              <div class="col-lg-6 order-1 order-lg-2 text-center">
                <img src="assets/img/features-3.png" alt="" class="img-fluid">
              </div>
            </div>
          </div>
        
        </div>

      </div>
    </section>End Features Section
 -->


    <!-- ======= Services Section ======= -->
    <section id="services" class="services">
      <div class="container">

        <div class="section-title" data-aos="zoom-out">
          <h2>Services</h2>
          <p>What we do offer</p>
        </div>

        <div class="row">
          <div class="col-lg-4 col-md-6">
            <div class="icon-box" data-aos="zoom-in-left">
              <div class="icon"><i class="las la la-puzzle-piece" style="color: #41cf2e;"></i></div>
              <h4 class="title"><a href="">Idea Management</a></h4>
              <p class="description">Contribute your idea on <a href="https://github.com/sayangit03" target="_blank">GIT</a>. We will integrate your contribution here, with SAYinfos.com</p>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 mt-5 mt-md-0">
            <div class="icon-box" data-aos="zoom-in-left" data-aos-delay="100">
              <div class="icon"><i class="las la la-mortar-board" style="color: #e9bf06;"></i></div>
              <h4 class="title"><a href="enKnow/java/Java_Basics">Enhance Knowledge</a></h4>
              <p class="description"> To know what you know and what you do not know, that is true knowledge. Join us.</p>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 mt-5 mt-lg-0 ">
            <div class="icon-box" data-aos="zoom-in-left" data-aos-delay="200">
              <div class="icon"><i class="las la la-cutlery" style="color: #3fcdc7;"></i></div>
              <h4 class="title"><a href="/cooking">Cooking Recipe</a></h4>
              <p class="description">People who love to eat are always the best people.To eat is a necessity, but to eat intelligently is an art.	</p>
            </div>
          </div>
          
          
          <div class="col-lg-4 col-md-6 mt-5">
            <div class="icon-box" data-aos="zoom-in-left" data-aos-delay="300">
              <div class="icon"><i class="las la la-empire" style="color:#ff689b;"></i></div>
              <h4 class="title"><a href="/worldCovid">COVID 19 Updates</a> </h4>
              <p class="description">Coronavirus disease (COVID-19) is an infectious disease caused by a new virus. Get latest updates.</p>
            </div>
          </div>

          <div class="col-lg-4 col-md-6 mt-5">
            <div class="icon-box" data-aos="zoom-in-left" data-aos-delay="400">
              <div class="icon"><i class="las la la-newspaper-o" style="color: #d6ff22;"></i></div>
              <h4 class="title"><a href="/news">Latest News</a></h4>
              <p class="description">News is something somebody doesn't want printed; all else is advertising. Stay updated with us!</p>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 mt-5">
            <div class="icon-box" data-aos="zoom-in-left" data-aos-delay="500">
              <div class="icon"><i class="las l	a la-globe" style="color: #4680ff;"></i></div>
              <h4 class="title"><a href="/weather">Weather Updates</a></h4>
              <p class="description">Sunshine is delicious, rain is refreshing, wind braces us up, snow is exhilarating. Get weather updates.</p>
            </div>
          </div>
        </div>

      </div>
    </section><!-- End Services Section -->


    <!-- ======= Contact Section ======= -->
    <section id="contact" class="contact">
      <div class="container">

        <div class="section-title" data-aos="zoom-out">
          <h2>Contact</h2>
          <p>Contact Us</p>
        </div>

        <div class="row mt-5">
          <div class="col-lg-4" data-aos="fade-right">
            <div class="info">
              <div class="address">
                <i class="icofont-google-map"></i>
                <h4>Location:</h4>
                <p>Kolkata, India</p>
              </div>

              <div class="email">
                <i class="icofont-envelope"></i>
                <h4>Email:</h4>
                <p>sayinfos.com@gmail.com</p>
              </div>

              <div class="phone">
                <i class="icofont-phone"></i>
                <h4>Call:</h4>
                <p>+91 9834696318</p>
              </div>

            </div>

          </div>

          <div class="col-lg-8 mt-5 mt-lg-0" data-aos="fade-left">

            <form action="/mail" method="post" role="form" class="php-email-form">
              <div class="form-row">
                <div class="col-md-6 form-group">
                  <input type="text" name="name" class="form-control" id="name" placeholder="Your Name" />
                  <div class="validate"></div>
                </div>
                <div class="col-md-6 form-group">
                  <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" />
                  <div class="validate"></div>
                </div>
              </div>
              <div class="form-group">
                <input type="text" class="form-control" name="subject" id="subject" placeholder="Subject" />
                <div class="validate"></div>
              </div>
              <div class="form-group">
                <textarea class="form-control" name="message" id="message" rows="5" placeholder="Message"></textarea>
                <div class="validate"></div>
              </div>
              <div class="mb-3">
                <!-- <div class="loading">Sending message..</div>
                <div class="error-message"></div> -->
                <div class="sent-message1" id = "myDIV1">Your message has been sent. Thank you!</div>
              </div>
              <div class="text-center"><button type="submit" onclick="myFunction1()">Send Message</button></div>
            </form>

          </div>

        </div>

      </div>
    </section><!-- End Contact Section -->

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
      <div class="credits">
        <a href="/privacyPolicy">Privacy Policy</a>
      </div>
      <div class="copyright">
        &copy; Copyright <strong><span>SAYinfos</span></strong>. All Rights Reserved
      </div>
      <div class="credits">
        Designed by <a href="#">Sayantan M</a>
      </div>
    </div>
  </footer><!-- End Footer -->
<fmt:parseNumber var = "loginFlag" type = "number" value = "${isOk}" />
<fmt:parseNumber var = "isOkEmail" type = "number" value = "${emailfFlag1}" />
<fmt:parseNumber var = "isOkService" type = "number" value = "${serviceFlag1}" />
<fmt:parseNumber var = "isOkAccess" type = "number" value = "${accessFlag1}" />
<%//request.getSession().invalidate();%>
  <a href="#" class="back-to-top"><i class="ri-arrow-up-line"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/jquery/jquery.min.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/venobox/venobox.min.js"></script>
  <script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
  <!-- <script src="assets/vendor/TweenMax/TweenMax.min.js"></script>
  <script src="assets/vendor/wavify/wavify.js"></script> -->
  <script src="assets/vendor/aos/aos.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>
  <script type="text/javascript">
  //disable back button
  $(document).ready(function() {
      window.history.pushState(null, "", window.location.href);        
      window.onpopstate = function() {
      window.history.pushState(null, "", window.location.href);
      };
  });
  
  function myFunction() {
	  var x = document.getElementById("myDIV");
	  if (x.style.display === "none") {
		  x.style.display = "none";
	  } else {
		  x.style.display = "block";
	  }
	  //document.getElementById("signupForm").action="/registration";
	  document.getElementById("signupForm").submit();
	  //location.replace("/validateEmailReg/"+email)
	  //setTimeout(function(){ history.go(0); }, 1200);
	}
  function myFunctionLogin() {
	  var x = document.getElementById("myDIVLogin");
	  if (x.style.display === "none") {
		  x.style.display = "none";
	  } else {
		  x.style.display = "block";
	  }
	  document.getElementById("loginForm").submit();
	}
  
  function myFunctionLoginOTPShowTextBox() {
	//The data/time we want to countdown to
	
	  var countDownDate = new Date().getTime()+90000;

	  // Run myfunc every second
	  var myfunc = setInterval(function() {
	  var now = new Date().getTime();
	  var timeleft = countDownDate - now;
	      
	  // Calculating the days, hours, minutes and seconds left
	  var days = Math.floor(timeleft / (1000 * 60 * 60 * 24));
	  var hours = Math.floor((timeleft % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
	  var minutes = Math.floor((timeleft % (1000 * 60 * 60)) / (1000 * 60));
	  var seconds = Math.floor((timeleft % (1000 * 60)) / 1000);
	  if (seconds < 10 && seconds >= 0) {seconds = "0" + seconds};
	      
	  // Result is output to the specific element
	  document.getElementById("mins").innerHTML = "0"+minutes + " : "+seconds  
	      
	  // Display the message when countdown is over
	  if (minutes==0 && seconds==0) {
		  document.getElementById("mins").innerHTML = "Time up! Please try again."
	  }
	  if (timeleft < 0) {
	      clearInterval(myfunc);
	      document.getElementById("mins").innerHTML = ""
	      location.reload();
	  }
	  }, 100);
	  
	  var x = document.getElementById("OTPBox");
	  if (x.style.display === "none") {
		  x.style.display = "block";
		  
	  }
	  
	  var x1 = document.getElementById("submitOTPGen");
	  x1.style.display = "none";
	  
	  //document.getElementById("submitOTPGen").disabled = true;
	}
  
  function myFunctionLoginOTP() {
	  var x = document.getElementById("myDIVLoginOTP");
	  if (x.style.display === "none") {
		  x.style.display = "none";
	  } else {
		  x.style.display = "block";
	  }
	  document.getElementById("OTPLoginForm").submit();
	}
  
  function myFunction2() {
	  var x = document.getElementById("myDIV2");
	  if (x.style.display === "none") {
		  x.style.display = "none";
	  } else {
		  x.style.display = "block";
	  }
	  
	 
	}
  function myFunction1() {
	  var x = document.getElementById("myDIV1");
	  if (x.style.display === "none") {
		  x.style.display = "none";
	  } else {
		  x.style.display = "block";
	  }
	  
	  setTimeout(function(){ history.go(0); }, 1200);
	}
  
  function myFunction3() {
	  $('[data-toggle="tooltip"]').tooltip();
	  var loginFlag = ${loginFlag};
	  var okEmail = ${isOkEmail};
	  var okService = ${isOkService};
	  var okAccess = ${isOkAccess};
	  //var okName = ${isOkName};
	  //alert(">>>>> "+loginFlag);
	  if(loginFlag==0)
	  	$("#loginfail").modal({backdrop: true});
	  
	  if(okService==0)
		  	$("#servicefail").modal({backdrop: true});
	  
	  if(okAccess==0)
		  	$("#accessfail").modal({backdrop: true});
	  
	 if(okEmail==0)
	 	$("#emailfail").modal({backdrop: true});
	 if(okEmail==1)
		 	$("#emailRegSuccess").modal({backdrop: true});
	 
	}

  document.addEventListener("DOMContentLoaded", function(event) {
      document.getElementById('submitSignup').disabled = "true";
  });
  function myFunctionValidate() {
      var nameInput = document.getElementById('names').value;
      var passwordInput = document.getElementById('passwords').value;
      var emailInput = document.getElementById('emails').value;
      var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
      
      if (nameInput.length < 4 || passwordInput.length < 4 || !emailInput.match(mailformat)) {
          document.getElementById('submitSignup').disabled = true;
      } else {
      		document.getElementById('submitSignup').disabled = false;
      }
  }
  
  document.addEventListener("DOMContentLoaded", function(event) {
      document.getElementById('submitLogin').disabled = "true";
  });
  function myFunctionValidateLogin() {
      var nameInput = document.getElementById('uniqueName').value;
      var passwordInput = document.getElementById('userPwd').value;
      
      if (nameInput.length < 4 || passwordInput.length < 4) {
          document.getElementById('submitLogin').disabled = true;
      } else {
      		document.getElementById('submitLogin').disabled = false;
      }
  }
  
  document.addEventListener("DOMContentLoaded", function(event) {
      document.getElementById('submitOTPGen').disabled = "true";
  });
  function myFunctionValidateOTPGen() {
      var emailInput = document.getElementById('otpEmailId').value;
      var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
      
      if (!emailInput.match(mailformat)) {
          document.getElementById('submitOTPGen').disabled = true;
      } else {
      		document.getElementById('submitOTPGen').disabled = false;
      }
  }
</script>

</body>

</html>