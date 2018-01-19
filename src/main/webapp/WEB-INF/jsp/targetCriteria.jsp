<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ taglib prefix="dandelion" uri="http://github.com/dandelion" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="datatable" uri="http://github.com/dandelion/datatables" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="button" uri="http://www.springframework.org/tags/form" %>


<fmt:setLocale value="ru"/>
<fmt:setBundle basename="messages.app"/>

<html>
<dandelion:bundle includes="topjavaDatatable"/>
<jsp:include page="fragments/headTag.jsp"/>

<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <h3>Целевые значения показателей результативности процессов:</h3>
            <div><label></label></div>
            <div><label></label></div>
            <div><label></label></div>
            <div><label></label></div>
            <c:set var="ajaxUrl" value="ajax/profile/responsibles/"/>
            <h4> P2.1-3 "Оценка персонала"</h4>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addProcess">Добавить
                критерий
            </button>
            <table id="example" class="table table-striped" border="0" datapagesize="1" cellspacing="0" width="80%">
                <thead>
                <tr>
                    <th width="150px">Название критерия</th>
                    <th width="100px">Целевое значение</th>
                    <th width="100px">Весовой коэффициент</th>
                    <th width="100px"></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Количество сотрудников, успешно прошедших аттестацию</td>
                    <td>0,8</td>
                    <td>0,6</td>
                    <td>
                        <button type="submit" class="btn btn-primary">Изменить</button>
                    </td>
                </tr>
                <tr>
                    <td>Количество сотрудников, отправленных на повышение квалификации по результатам аттестации</td>
                    <td>0,2</td>
                    <td>0,15</td>
                    <td>
                        <button type="submit" class="btn btn-primary">Изменить</button>
                    </td>
                </tr>
                <tr>
                    <td>Количество сотрудников, рекомендованных к повышению по результатам аттестации</td>
                    <td>0,35</td>
                    <td>0,25</td>
                    <td>
                        <button type="submit" class="btn btn-primary">Изменить</button>
                    </td>
                </tr>

                </tbody>
            </table>

        </div>
    </div>

</div>

<div class="modal fade" id="addProcess">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title">Добавить критерий:</h2>
            </div>
            <div class="modal-body">


                <input type="text" hidden="hidden" id="id" name="id">
                <input type="Название критерия" id="name" name="name">
                <input type="Целевое значение" id="value" name="name">
                <input type="Весовой коэффициент" id="weigth" name="name">


            </div>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>


</html>