<%@page pageEncoding="UTF-8" %>
<%@page contentType="text/html; UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<fmt:setLocale value="ru"/>
<fmt:setBundle basename="messages.app"/>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header navbar-brand"><fmt:message key="app.title"/></div>
        <div class="navbar-collapse collapse">
            <form:form class="navbar-form navbar-right" role="form" action="spring_security_check" method="post">
                <div class="form-group">
                    <input type="text" placeholder="Email" class="form-control" name='username'>
                </div>
                <div class="form-group">
                    <input type="password" placeholder="Пароль" class="form-control" name='password'>
                </div>
                <button type="submit" class="btn btn-success">Sign in</button>
            </form:form>
        </div>
    </div>
</div>

<div class="jumbotron">
    <div class="container">
        <c:if test="${error}">
            <div class="error">
                    ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
            </div>
        </c:if>
        <c:if test="${not empty message}">
            <div class="message">
                <fmt:message key="${message}"/>
            </div>
        </c:if>
        <p>

        <p>User login: <b>user@yandex.ru / password</b></p>

        <p>Admin login: <b>admin@gmail.com / admin</b></p>

    </div>
</div>
<div class="container">
    <div class="lead">
        <fmt:message key="app.mainDescription"/>
    </div>

</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>

