<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>
<head>
  <title>Главная</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
<div>
  <h3>${pageContext.request.userPrincipal.name}</h3>
  <sec:authorize access="!isAuthenticated()">
    <h4><a href="/login">Sign in</a></h4>
    <h4><a href="/registration">Register</a></h4>
  </sec:authorize>
  <sec:authorize access="isAuthenticated()">
    <h4><a href="/logout">Go out</a></h4>
  </sec:authorize>
  <h4><a href="/cinemas">Movies </a></h4>
  <h4><a href="/sessions">Sessions </a></h4>
  <h4><a href="/reservations">Reservations </a></h4>
  <h4><a href="/admin">Admin</a></h4>
</div>
</body>
</html>