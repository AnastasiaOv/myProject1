<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="footer">
    <fmt:setLocale value="ru"/>
    <fmt:setBundle basename="messages.app"/>
    <div class="container">
        <fmt:message key="app.footer"/>
    </div>
</div>
