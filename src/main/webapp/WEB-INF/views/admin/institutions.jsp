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
        <h1>Zarządzanie instytucjami</h1>
        <h2>
            <tr>
                <td> Id:  <br/>
                <td> Nawa </td>
                <td> Opis:</td>
                <td> Akcje:</td>

            </tr>
            <for:forEach items="${institutions}" var="institution">
                <tr>
                    <td>${institution.id}</td>
                    <td>${institution.name}</td>
                    <td> ${institution.description} <br/>
                        <c:url value="/admin/deleteInst" var="deleteURL">
                            <c:param name="id" value="${institution.id}"/>
                        </c:url>
                    <td> <a href="${deleteURL}">Usuń</a></td>

                    <c:url value="/admin/updateInst" var="updateURL">
                        <c:param name="id" value="${institution.id}"/>
                    </c:url>
                    <td> <a href="${updateURL}">Edytuj</a></td>
                </tr>
            </for:forEach>
        </h2>
    </table>
</div>
</body>
</html>
