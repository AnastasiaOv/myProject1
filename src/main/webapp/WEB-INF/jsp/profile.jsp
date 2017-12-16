<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="topjava" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setLocale value="ru"/>
<fmt:setBundle basename="messages.app"/>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <h2>
                ${register ? 'Register new' : 'Изменить данные'}
            </h2>

            <div class="view-box">
                <form:form modelAttribute="userTo" class="form-horizontal" method="post"
                           action="${register ? 'register' : 'profile'}" charset="utf-8"
                           accept-charset="UTF-8">

                    <topjava:inputField label="Name" name="name"/>
                    <topjava:inputField label="Email" name="email"/>
                    <topjava:inputField label="Password" name="password" inputType="password"/>
                    <topjava:inputField label="Фамилия" name="surname"/>
                    <topjava:inputField label="Имя" name="firstName"/>
                    <topjava:inputField label="Отчество" name="secondName"/>

                    <div class="form-group">
                        <div class="col-xs-offset-2 col-xs-10">
                            <button type="submit" class="btn btn-primary">${register ? 'Добавить' : 'Обновить'}</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
