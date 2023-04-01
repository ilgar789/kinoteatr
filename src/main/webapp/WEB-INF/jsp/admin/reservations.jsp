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
        <th>Hall</th>
        <th>Row</th>
        <th>Place</th>
        <th>Session</th>
        <th>Date</th>
        <th>Movie</th>
        <th>User Id</th>
        <th>User Login</th>
        <th>User Role</th>


        </thead>
        <c:forEach items="${getReservations}" var="reservation">
            <tr>
                <td>${reservation.id}</td>
                <td>${reservation.hall}</td>
                <td>${reservation.row}</td>
                <td>${reservation.place}</td>
                <td>${reservation.session.id}</td>
                <td>${reservation.session.date}</td>
                <td>${reservation.session.cinema.movie}</td>
                <td>${reservation.user.id}</td>
                <td>${reservation.user.username}</td>
                <td>${reservation.user.roles}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/admin" method="post">
                        <input type="hidden" name="id" value="${reservation.id}"/>
                        <input type="hidden" name="action" value="delete"/>
                        <button type="submit">Delete</button>
                    </form>

                </td>

            </tr>
        </c:forEach>
    </table>
    <a href="/">Главная</a>
    <a href="/admin/sessions">Sessions</a>
</div>

</body>
</html>