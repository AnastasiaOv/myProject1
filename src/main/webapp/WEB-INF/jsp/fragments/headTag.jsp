<%@page pageEncoding="UTF-8" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<head>
    <fmt:setLocale value="ru"/>
    <fmt:setBundle basename="messages.app"/>
    <meta http-equiv="Content-Type" content="text/html;encoding=utf-8;charset=UTF-8">
    <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <title><fmt:message key="app.title"/></title>


    <%--<link rel="stylesheet" href="resources/css/style.css">--%>
    <link rel="shortcut icon" href="resources/images/emblem.png">
</head>
