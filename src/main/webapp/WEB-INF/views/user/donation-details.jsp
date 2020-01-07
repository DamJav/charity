<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Damian
  Date: 2020-01-07
  Time: 12:17
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
    <table style="text-align: center;">
        <h1>Szczegóły daru</h1>
        <h2>
            <tr>
                <td> Organizacja odbierająca <br/>

            </tr>

                <td>${donation.institution.name}</td>



            </tr>

        </h2>
    </table>
</div>
</body>
</html>
