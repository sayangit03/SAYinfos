<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
<link href="assets/img/favicon.jpg" rel="icon">
</head>
<body></br>
<h1 align="center">Oops! Error Occurred!</h1></br>
<h3 align="center" style="color: red">${errorStatusCode} while trying to access "${reqURI }"</h3></br>
<h5 align="center">Please <a href="/">click here</a> to go to the home page and contact with the above details.</h5>
</body>
</html>