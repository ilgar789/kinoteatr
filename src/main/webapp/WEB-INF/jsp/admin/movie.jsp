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
        <th>Movie</th>

        </thead>
        <c:forEach items="${getCinemas}" var="cinema">
            <tr>
                <td>${cinema.id}</td>
                <td>${cinema.movie}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/admin" method="post">
                        <input type="hidden" name="id" value="${cinema.id}"/>
                        <input type="hidden" name="action" value="delete"/>
                        <button type="submit">Delete</button>
                    </form>

                </td>
            </tr>

        </c:forEach>
    </table>
    <a href="/">Главная</a>
    <a href="/admin/sessions">Sessions</a>
    <a href="/admin/reservations">Reservations</a>
</div>

</body>
</html>