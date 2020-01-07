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
<div class="container container--85" style="text-align: center;">
    <table id="tabAdmins" style="text-align: center;">
        <h1>Moje dary</h1>
        <h2>
            <tr>
                <td> Id  <br/>
                <td> Ilośc worków  <br/>
                <td> Miasto </td>
                <td> Komentarz</td>
                <td> Status</td>
                <td> Akcje</td>
            </tr>
            <for:forEach items="${donations}" var="donation" varStatus="i">
                    <td>${i.count}</td>
                    <td>${donation.quantity}</td>
                    <td>${donation.city}</td>
                    <td>${donation.pickUpComment}</td>
                    <td>${donation.status}</td>
                    <td><b> <a href="${detailsURL}">Szczegóły</a></b></td>
                    <c:url value="/donation/details" var="detailsURL">
                        <c:param name="id" value="${donation.id}"/>
                    </c:url>



                </tr>
            </for:forEach>
        </h2>
    </table>
</div>
</body>
</html>
