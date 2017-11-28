<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ taglib prefix="dandelion" uri="http://github.com/dandelion" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<dandelion:bundle includes="topjavaDatatable"/>
<jsp:include page="fragments/headTag.jsp"/>
<fmt:setLocale value="ru"/>
<fmt:setBundle basename="messages.app"/>
<body>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <h3><fmt:message key="users.title"/></h3>

            <c:set var="ajaxUrl" value="ajax/admin/users/"/>
            <div class="view-box">
                <a class="btn btn-sm btn-info" id="add">Add User</a>

                <datatables:table id="datatable" url="${ajaxUrl}" row="user" theme="bootstrap3"
                                  cssClass="table table-striped" pageable="false" info="false">

                    <datatables:column title="Имя" sortInitDirection="asc" property="name"/>
                    <datatables:column title="Email" property="email" renderFunction="renderEmail"/>
                    <datatables:column title="Роль" property="roles"/>
                    <datatables:column title="Фамилия" property="surname"/>
                    <datatables:column title="Имя" property="firstName"/>
                    <datatables:column title="Отчество" property="secondName"/>
                    <datatables:column title="Active" filterable="false" property="enabled"
                                       renderFunction="renderCheckbox"/>
                    <datatables:column title="Дата регистрации" filterable="false" property="registered"
                                       renderFunction="renderDate"/>
                    <datatables:column title="Должность" filterable="false" property="rates"
                                       renderFunction="renderList"/>
                    <datatables:column sortable="false" renderFunction="renderUpdateBtn"/>
                    <datatables:column sortable="false" renderFunction="renderDeleteBtn"/>

                    <datatables:callback type="init" function="makeEditable"/>
                </datatables:table>
            </div>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title">Сведения о пользователе:</h2>
            </div>
            <div class="modal-body">
                <form:form class="form-horizontal" method="post" id="detailsForm">
                    <input type="text" hidden="hidden" id="id" name="id">

                    <div class="form-group">
                        <label for="name" class="control-label col-xs-3">Логин</label>
                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="name" name="name" placeholder="Name">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="control-label col-xs-3">Email</label>

                        <div class="col-xs-9">
                            <input type="email" class="form-control" id="email" name="email" placeholder="email">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="password" class="control-label col-xs-3">Пароль</label>

                        <div class="col-xs-9">
                            <input type="password" class="form-control" id="password" name="password" placeholder="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="surname" class="control-label col-xs-3">Фамилия</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="surname" name="surname" placeholder="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="firstName" class="control-label col-xs-3">Имя</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="secondName" class="control-label col-xs-3">Отчество</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="secondName" name="secondName"
                                   placeholder="">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="positionDicts" class="control-label col-xs-3">Должность</label>

                        <div class="col-xs-9">
                            <select id="positionDicts" >
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="roles" class="control-label col-xs-3">Роль</label>
                        <div class="col-xs-9">
                               <select id="roles">
                                   <c:forEach var="role" items="<%= ru.javawebinar.topjava.web.converter.ReadableRoles.getReadableRoles() %>">
                                       <option selected="selected">${role}</option>
                                   </c:forEach>
                               </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    var ajaxUrl = '${ajaxUrl}';

    function init() {
        checkedUsers();
    }

    function updateTable() {
        $.get(ajaxUrl, function (data) {
            updateByData(data);
            checkedUsers();
        });
    }

    function checkedUsers() {
        $(':checkbox').each(function () {
            if (!$(this).is(":checked")) {
                $(this).parent().parent().css("text-decoration", "line-through");
            }
        });
    }
</script>
</html>