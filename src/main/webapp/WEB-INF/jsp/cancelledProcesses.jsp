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

            <c:set var="ajaxUrl" value="ajax/profile/cancelled_processes/"/>
            <div class="view-box">
                <form:form modelAttribute="filter" class="form-horizontal"
                           action="ajax/profile/cancelled_processes/filter"
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
                <div></div>
                <datatables:table id="datatable" url="${ajaxUrl}" row="process" theme="bootstrap3"
                                  cssClass="table table-striped" pageable="false" info="false">

                    <datatables:column title="время начала" filterable="false" sortInitDirection="desc"
                                       property="start_time"/>
                    <datatables:column title="время окончания" filterable="false" sortInitDirection="desc"
                                       property="end_time"/>
                    <datatables:column title="имя процесса" filterable="false" property="processName"/>
                    <datatables:column title="уровень процесса" filterable="false" property="level"/>
                    <datatables:column title="описание процесса" filterable="false" property="definition"/>

                    <datatables:column sortable="false" renderFunction="renderInfoBtn"/>
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
                <form:form class="form-horizontal" action="ajax/profile/cancelled_processes/" method="post"
                           id="detailsForm">
                    <c:set var="ajaxUrl" value="ajax/profile/cancelled_processes/"/>
                    <div class="form-group">
                        <label for="owner" class="control-label col-xs-3">Владелец:</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="owner" name="processName" value="Иванов"
                                   disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="executor" class="control-label col-xs-3">Исполнители:</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="executor" name="processName" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="responsible" class="control-label col-xs-3">Ответственный:</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="responsible" name="processName" disabled>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="result" class="control-label col-xs-3">Результативность процесса</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="result" name="processResult" value="0,8" style="color: darkblue; font-size: 14pt" disabled>
                        </div>
                    </div>

                    <div>
                        <table id="criterias" class="table table-striped" cellspacing="0" width="100">
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
                                <td>Критерий 1</td>
                                <td><input type="number" style="width: 90px;" step="any" width="10"></td>
                                <td><input type="number" style="width: 90px;" step="any" disabled></td>
                                <td><input type="number" style="width: 90px;" step="any" value="0.5" disabled></td>
                                <td><input type="number" style="width: 90px;" step="any" disabled></td>
                            </tr>
                            <tr>
                                <td>Критерий 2</td>
                                <td><input type="number" style="width: 90px;" step="any" width="10"></td>
                                <td><input type="number" style="width: 90px;" step="any" disabled></td>
                                <td><input type="number" style="width: 90px;" step="any" value="0.5" disabled></td>
                                <td><input type="number" style="width: 90px;" step="any" disabled></td>
                            </tr>
                            <tr>
                                <td>Критерий 3</td>
                                <td><input type="number" style="width: 90px;" step="any" width="10"></td>
                                <td><input type="number" style="width: 90px;" step="any" disabled></td>
                                <td><input type="number" style="width: 90px;" step="any" value="0.5" disabled></td>
                                <td><input type="number" style="width: 90px;" step="any" disabled></td>
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