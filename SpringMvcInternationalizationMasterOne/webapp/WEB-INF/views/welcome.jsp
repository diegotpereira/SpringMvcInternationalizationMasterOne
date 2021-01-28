<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<spring:theme code="stylesheet" var="themeChange" />
<link href='<spring:url value="/resources/css/${themeChange}"/>' rel="stylesheet" />
</head>
<body>
  <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
      <a class="navbar-brand" href="#">Spring MVC Internationalization</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
         aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
         <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
         <ul class="navbar-nav mr-auto">
            <li class="nav-item ml-5 active"><a class="nav-link" href="#">Home <span class="sr-only"></span></a></li>
            <li class="nav-item ml-5"><a class="nav-link " href="#">Sobre<span class="sr-only"></span></a></li>
             <li class="nav-item ml-5"><a class="nav-link" href="#">Contato<span class="sr-only"></span></a></li>
         </ul> 
        </div>
   </nav>
 <div class="col-md-12 text-center">
         
         <div class="dropdown">
            <button class="btn btn-danger dropdown-toggle" type="button" id="dropdownMenuButton"
               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Change Theme</button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
              <a class="dropdown-item" href="?themeresources=cerulean">Cerulean</a>
              <a class="dropdown-item" href="?themeresources=flatly">flatly</a>
              <a class="dropdown-item" href="?themeresources=journal">journal</a>
              <a class="dropdown-item" href="?themeresources=pulse">pulse</a>
              </div></div></div>
              <div class="col-md-12 mt-5 text-center">
         <div class="dropdown">
            <button class="btn btn-danger dropdown-toggle" type="button" id="dropdownMenuButton"
               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><spring:message code="spring.app.name"/></button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
               <a class="dropdown-item" href="?language=en"><spring:message code="spring.app.english.lang"/></a> 
               <a class="dropdown-item" href="?language=hi"><spring:message code="spring.app.hindi.lang"/></a>
               <a class="dropdown-item" href="?language=pt"><spring:message code="spring.app.portugues.lang"/></a>
               
            </div>
         </div>
            <!--  -->
         </div>
<div class="main">

<h1 class="ml-5"><spring:message code="spring.app.name"/></h1>
<h2 id="head" class="ml-5"><spring:message code="spring.greeting"/></h2>


 <img alt="logo" class="img-responsive mt-5 ml-5" src="<spring:url value="/images/stop.png"/>" width="400">

</div>
</body>
</html>