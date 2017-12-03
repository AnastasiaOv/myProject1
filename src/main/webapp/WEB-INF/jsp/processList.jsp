<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ taglib prefix="dandelion" uri="http://github.com/dandelion" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="datatable" uri="http://github.com/dandelion/datatables" %>


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
                            <label class="col-sm-2">Дата с</label>
                            <div class="col-sm-2"><form:input path="startDate" class="form-control date-picker"
                                                              placeholder="Дата начала"/></div>
                        </spring:bind>
                        <spring:bind path="startTime">
                            <label class="col-sm-2">Время с</label>
                            <div class="col-sm-2"><form:input path="startTime" class="form-control time-picker"
                                                              placeholder="Время начала"/></div>
                        </spring:bind>
                    </div>
                    <div class="form-group">
                        <spring:bind path="endDate">
                            <label class="col-sm-2">Дата по</label>
                            <div class="col-sm-2"><form:input path="endDate" class="form-control date-picker"
                                                              placeholder="Дата конца"/></div>
                        </spring:bind>
                        <spring:bind path="endTime">
                            <label class="col-sm-2">Время по</label>
                            <div class="col-sm-2"><form:input path="endTime" class="form-control time-picker"
                                                              placeholder="Время конца"/></div>
                        </spring:bind>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-8">
                            <button type="submit" class="btn btn-primary pull-right">Поиск</button>
                        </div>
                    </div>
                </form:form>

                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addProcess" >Добавить процесс</button>


                <datatables:table id="datatable" url="${ajaxUrl}" row="process" theme="bootstrap3"
                                  cssClass="table table-striped" pageable="false" info="false">

                    <datatables:column title="время начала" filterable="false" sortInitDirection="desc"
                                       property="start_time"/>
                    <datatables:column title="время окончания" filterable="false" sortInitDirection="desc"
                                       property="end_time"/>
                    <datatables:column title="имя процесса" filterable="false" property="processName"/>
                    <datatables:column title="описание процесса" filterable="false" property="definition"/>

                    <datatables:column sortable="false" renderFunction="renderUpdateBtn"/>
                    <datatables:column sortable="false" renderFunction="renderDeleteBtn"/>
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
                <form:form class="form-horizontal" method="post" id="detailsForm">

                    <input type="text" hidden="hidden" id="id" name="id">
                    <input type="datetime" hidden="hidden" id="start_time" name="start_time">

                    <input type="text" hidden="hidden" id="processName" name="processName">

                    <div class="form-group">
                        <label for="definition" class="control-label col-xs-3">Описание</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="definition" name="definition"
                                   placeholder="Description">
                        </div>
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
    <div class="modal-dialog" >
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title">Добавить процесс:</h2>
            </div>
            <div class="modal-body">
                <form:form class="form-horizontal" method="post" id="detailsForm">

                    <input type="text" hidden="hidden" id="id" name="id">
                    <input type="datetime" hidden="hidden" id="start_time" name="start_time">
                    <input type="text" hidden="hidden" id="processName" name="processName">

                    <div class="form-group">
                        <label for="name" class="control-label col-xs-3">Название процесса</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="name" name="name"
                                   placeholder="Description">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="try" class="control-label col-xs-3">Уровень процесса</label>

                        <div class="col-xs-9">
                            <form>
                                <input list="try" type="number" id ="level" name="level">
                                <datalist id="try">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                </datalist>
                            </form>
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
            span.parent().css("color", span.html() == 'true' ? 'red' : 'green');
        });
    }
</script>
</html>