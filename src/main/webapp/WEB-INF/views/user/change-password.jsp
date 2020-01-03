<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Damian
  Date: 2019-12-09
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Zmiana hasła</title>
    <%-- Elementy dotyczące treści strony --%>
    <%-- Elementy dotyczące wyświetlania --%>
    <meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>

    <%-- Linki do szablonów css trafią tutaj --%>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">


    <%-- Linki do skryptów js trafią tutaj --%>
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body class="has-navbar-fixed-top">
<jsp:include page="../header.jsp"/>
<section>
    <h1 class="title">
        Zmiana hasła
    </h1>
    <form method="post">
        <div class="field">
            <label class="label" for="password">Nowe hasło</label>
            <div class="control has-icons-left">
                <input type="password" id="password" name="password" required class="input"/>
                <span class="icon is-small is-left">
                        <i class="fas fa-lock"></i>
                    </span>
                <p class="help">Wpisz nowe hasło</p>
            </div>
        </div>
        <div class="field">
            <div class="control" style="text-align: center;">
                <button class="button is-success is-link" type="submit">Zmień</button>
            </div>
        </div>
        <sec:csrfInput/>
    </form>
</section>

</body>
</html>