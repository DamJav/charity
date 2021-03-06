<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Damian
  Date: 2019-12-17
  Time: 12:55
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
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
</head>
<body>
<jsp:include page="../header.jsp"/>
<section class="login-page">
    <h2>Stwórz instytucje</h2>
    <form:form method="post" modelAttribute="institution">
            <div class="form-group">
                <form:input path="name" name="name" placeholder="Nazwa"/>
            </div>
            <div class="form-group">
                <form:input path="description" name="description" placeholder="Opis"/>
            </div>
            <div class="form-group form-group--buttons">
                <button class="btn" type="submit">Stwórz</button>
            </div>
    </form:form>
</section>
</body>
</html>
