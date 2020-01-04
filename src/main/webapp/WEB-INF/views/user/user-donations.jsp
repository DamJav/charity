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
<a href="/admin/create" class="btn btn--large" style="text-align: center;">Utwórz nowego administratora</a>
<div class="container container--85">
    <table id="tabAdmins">
        <h1>Moje dary</h1>
        <h2>
            <tr>
                <td> Id:  <br/>
                <td> Email: </td>
                <td> Akcje:</td>
            </tr>
            <for:forEach items="${admins}" var="admin" varStatus="i">
                <tr>
                    <td>${i}</td>
                    <td><b>${admin.email}</b></td>
                    <c:url value="/admin/delete" var="deleteURL">
                        <c:param name="id" value="${admin.id}"/>
                    </c:url>
                    <td> <a href="${deleteURL}">Usuń</a></td>
                    <c:url value="/admin/update" var="updateURL">
                        <c:param name="id" value="${admin.id}"/>
                    </c:url>
                    <td> <a href="${updateURL}">Edytuj</a></td>
                </tr>
            </for:forEach>
        </h2>
    </table>
</div>
</body>
</html>
