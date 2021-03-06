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
<jsp:include page="header.jsp"/>
<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form method="post" modelAttribute="registrationData">
        <div class="form-group">
            <form:input path="email" name="email" placeholder="Email"/>
        </div>
        <div class="form-group">
            <form:password path="password" name="password" placeholder="Hasło"/>
        </div>
        <div class="form-group">
            <form:password path="rePassword" name="password2" placeholder="Powtórz hasło"/>
        </div>

        <div class="form-group form-group--buttons">
            <a href="/login" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>
