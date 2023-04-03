<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div>
    <table>
        <thead>
        <th>ID</th>
        <th>Date</th>
        <th>Movie</th>

        </thead>
        <c:forEach items="${getSessions}" var="session">
            <tr>
                <td>${session.id}</td>
                <td>${session.date}</td>
                <td>${session.cinema.movie}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="/">Главная</a>
    <a href="/reservations">Reservations</a>
</div>

</body>
</html>