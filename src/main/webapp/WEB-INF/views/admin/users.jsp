<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Damian
  Date: 2019-12-28
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="../resources/css/style.css"/>" />
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container container--85">
    <table id="tabAdmins">
        <h1>Zarządzanie użytkownikami</h1>
        <h2>
            <tr>
                <td> Id:  <br/>
                <td> Email: </td>
                <td> Aktywny:</td>
                <td> Akcje:</td>

            </tr>
            <for:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.email}</td>
                    <td> ${user.active} <br/>
                        <c:url value="/admin/deleteUser" var="deleteURL">
                            <c:param name="id" value="${user.id}"/>
                        </c:url>
                    <td> <a href="${deleteURL}">Usuń</a></td>
                    <c:url value="/admin/manage/lock" var="lockURL">
                        <c:param name="id" value="${user.id}"/>
                    </c:url>
                    <td> <a href="${lockURL}">Zablokuj</a></td>

                    <c:url value="/admin/manage/unlock" var="unlockURL">
                        <c:param name="id" value="${user.id}"/>
                    </c:url>
                    <td> <a href="${unlockURL}">Odblokuj</a></td>
                    <c:url value="/admin/manage/update" var="updateURL">
                        <c:param name="id" value="${user.id}"/>
                    </c:url>
                    <td> <a href="${updateURL}">Edytuj</a></td>
                </tr>
            </for:forEach>
        </h2>
    </table>
</div>
</body>
</html>
