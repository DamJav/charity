<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Damian
  Date: 2019-12-17
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="header--main-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <sec:authorize access="isAnonymous()">
                <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
                <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
            </sec:authorize>
            <sec:authorize access="hasRole('ADMIN')">
                <li><a href="/admin/administrators" class="btn btn--small btn--without-border">Administratorzy</a></li>
                <li><a href="/admin/manage" class="btn btn--small btn--without-border">Użytkownicy</a></li>
                <li><a href="/admin/institutions" class="btn btn--small btn--without-border">Instytucje</a></li>
            </sec:authorize>

            <sec:authorize access="hasRole('ADMIN')">
                <li><a href="/user/manage" class="btn btn--small btn--without-border">Moje konto</a></li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">

           <li>
                <form method="post" action="/logout">
                    <button class="btn btn--small btn--without-border" type="submit">Wyloguj</button>
                    <sec:csrfInput/>
                </form>
               </li>
            </sec:authorize>
        </ul>

        <ul>
            <li><a href="/" class="btn btn--without-border active">Start</a></li>
            <li><a href="#steps" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="#about-us" class="btn btn--without-border">O nas</a></li>
            <li><a href="#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <sec:authorize access="isAuthenticated()">
            <li><a href="/donation/form" class="btn btn--without-border">Przekaż dary</a></li>
            </sec:authorize>
            <li><a href="#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>
</header>
