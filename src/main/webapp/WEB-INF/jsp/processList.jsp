<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ taglib prefix="dandelion" uri="http://github.com/dandelion" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="datatable" uri="http://github.com/dandelion/datatables" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<fmt:setLocale value="ru"/>
<fmt:setBundle basename="messages.app"/>

<html>
<dandelion:bundle includes="topjavaDatatable"/>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <h3>"Сведения о процессах"</h3>

            <c:set var="ajaxUrl" value="ajax/profile/processes/"/>
            <div class="view-box">
                <form:form modelAttribute="filter" class="form-horizontal" action="ajax/profile/processes/filter"
                           charset="utf-8"
                           accept-charset="UTF-8" id="filter">
                    <div class="form-group">
                        <spring:bind path="startDate">
                            <label class="col-sm-1">Дата начала</label>
                            <div class="col-sm-2"><form:input path="startDate" class="form-control datetime-picker"
                                                              placeholder="Дата начала"/></div>
                        </spring:bind>

                        <spring:bind path="endDate">
                            <label class="col-sm-1">Дата завершения</label>
                            <div class="col-sm-2"><form:input path="endDate" class="form-control datetime-picker"
                                                              placeholder="Дата завершения"/></div>
                        </spring:bind>


                        <div class="col-sm-1">
                            <button type="submit" class="btn btn-primary pull-right">Поиск</button>
                        </div>
                    </div>
                </form:form>

                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addProcess">Добавить
                    процесс
                </button>

                <datatables:table id="datatable" url="${ajaxUrl}" row="process" theme="bootstrap3"
                                  cssClass="table table-striped" pageable="false" info="false">

                    <datatables:column title="время начала" filterable="false" sortInitDirection="desc"
                                       property="start_time"/>
                    <datatables:column title="время окончания" filterable="false" sortInitDirection="desc"
                                       property="end_time"/>
                    <datatables:column title="имя процесса" filterable="false" property="processName"/>
                    <datatables:column title="уровень процесса" filterable="false" property="level"/>
                    <datatables:column title="описание процесса" filterable="false" property="definition"/>

                    <datatables:column sortable="false" renderFunction="renderUpdateBtn"/>
                    <datatables:column sortable="false" renderFunction="renderCancelBtn"/>
                    <datatables:column property="exceed" sortable="false" cssCellClass="hidden exceed"/>

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
                <h2 class="modal-title">Сведения о процессе</h2>
            </div>
            <div class="modal-body">
                <form:form class="form-horizontal" action="ajax/profile/processes/" method="post" id="detailsForm">
                    <c:set var="ajaxUrl" value="ajax/profile/processes/"/>
                    <input type="text" hidden="hidden" id="id" name="id">
                    <input type="datetime" hidden="hidden" id="start_time" name="start_time">
                    <input type="number" hidden="hidden" id="level" name="level">
                    <input type="text" hidden="hidden" id="processName" name="processName">
                    <div class="form-group">
                        <label for="definition" class="control-label col-xs-3">Описание</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="definition" name="definition"
                                   placeholder="Description">
                        </div>
                    </div>


                    <div>
                        <table class = "table table-striped" id="positions">
                            <thread>
                            <tr>
                                <th></th>
                                <th>Название показателя</th>
                                <th>Значение</th>
                                <th>владелец</th>
                                <th>исполнитель</th>
                                <th>ответственный</th>
                            </tr>
                            </thread>
                            <c:forEach var="positions" items="${positions}">

                                <c:set var="procID" value="${positions.processId}"/>
                                <c:set var="procId" value="${param.id}"/>
                                <c:if test="${positions.processId == id}">
                                <tr>
                                    <th></th>
                                    <th>${positions.positionName}</th>
                                    <th>${ajaxUrl}</th>
                                    <th><c:if test="${positions.owner == 'true'}"><input type="checkbox" title="owner" checked/></c:if><c:if test="${positions.owner == 'false'}"><input type="checkbox" title="owner"/></c:if></th>
                                    <th><c:if test="${positions.executor == 'true'}"><input type="checkbox" title="executor" checked/></c:if><c:if test="${positions.executor == 'false'}"><input type="checkbox" title="executor"/></c:if></th>
                                    <th><c:if test="${positions.responsible == 'true'}"><input type="checkbox" title="responsible" checked/></c:if><c:if test="${positions.responsible == 'false'}"><input type="checkbox" title="responsible"/></c:if></th>
                                </tr>
                                </c:if>
                            </c:forEach>
                        </table>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <button type="submit" class="btn btn-primary">Сохранить</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="addProcess">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title">Добавить процесс:</h2>
            </div>
            <div class="modal-body">
                <form:form class="form-horizontal" action="ajax/profile/processes/" method="post" id="detailsForm">

                    <input type="text" hidden="hidden" id="id" name="id">
                    <input type="datetime" hidden="hidden" id="start_time" name="start_time">


                    <div class="form-group">
                        <label for="processName" class="control-label col-xs-3">Название процесса</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="processName" name="processName"
                                   placeholder="Description">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="level" class="control-label col-xs-3">Уровень процесса</label>

                        <div class="col-xs-9">
                            <input list="level1" type="number" id="level" name="level">
                            <datalist id="level1">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                            </datalist>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="definition" class="control-label col-xs-3">Описание</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" name="definition"
                                   placeholder="Description">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-3">
                            <button type="submit" class="btn btn-primary">Сохранить</button>
                        </div>
                    </div>
                </form:form>

            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="cancel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title">Ввод показателей процесса:</h2>
            </div>
            <div class="modal-body">
                <div>
                    <table id="example" class="display" width="70%"></table>
                </div>
                <form:form class="form-horizontal" action="ajax/profile/processes/" method="post" id="detailsForm">

                    <input type="text" hidden="hidden" id="id" name="id">
                    <input type="datetime" hidden="hidden" id="start_time" name="start_time">
                    <input type="datetime" hidden="hidden" id="start_time" name="start_time">
                    <input type="datetime" hidden="hidden" id="start_time" name="start_time">
                    <input type="datetime" hidden="hidden" id="start_time" name="start_time">
                    <div>
                        <table id="criterias" class = "table table-striped" cellspacing="0" width="100" >
                            <thead>
                            <tr>
                                <th>Название критерия</th>
                                <th>Фактическое<br>значение</th>
                                <th>Целевое<br>значение</th>
                                <th>Понижающий<br>коэффициент</th>
                                <th>Вес критерия</th>
                            </tr>
                            </thead>

                            <tbody>
                            <tr>
                                <td>Критерий1</td>
                                <td><input type="number" style="width: 90px;"  step="any" width="10"></td>
                                <td><input type="number" style="width: 90px;" step="any"></td>
                                <td><input type="number" style="width: 90px;" step="any" value="0.5" disabled></td>
                                <td><input type="number" style="width: 90px;" step="any"></td>
                            </tr>
                            <tr>
                                <td>Критерий2</td>
                                <td><input type="number" style="width: 90px;" step="any" width="10"></td>
                                <td><input type="number" style="width: 90px;" step="any"></td>
                                <td><input type="number" style="width: 90px;" step="any" value="0.5" disabled></td>
                                <td><input type="number" style="width: 90px;" step="any"></td>
                            </tr>
                            <tr>
                                <td>Критерий3</td>
                                <td><input type="number" style="width: 90px;"  step="any" width="10"></td>
                                <td><input type="number"style="width: 90px;"  step="any"></td>
                                <td><input type="number" style="width: 90px;" step="any" value="0.5" disabled></td>
                                <td><input type="number" style="width: 90px;" step="any"></td>
                            </tr>
                            </tbody>
                        </table>
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
        $('#filter').submit(function () {
            updateTable();
            return false;
        });

        $('.date-picker').datetimepicker({
            timepicker: false,
            format: 'Y-m-d',
            lang: 'ru'
        });
        $('.time-picker').datetimepicker({
            datepicker: false,
            format: 'H:i',
            lang: 'ru'
        });
        $('.datetime-picker').datetimepicker({
            format: 'Y-m-d H:i',
            lang: 'ru'
        });
        coloredTable();
    }

    function updateTable() {
        var frm = $('#filter');
        $.ajax({
            type: "POST",
            url: frm.attr('action'),
            data: frm.serialize(),
            success: function (data) {
                updateByData(data);
                coloredTable();
            }
        });
    }

    function coloredTable() {
        $.each($('td.exceed'), function (key, item) {
            var span = $(item);
            span.parent().css("color", span.html() == 'true' ? 'black' : 'black');
        });
    }



</script>
</html>