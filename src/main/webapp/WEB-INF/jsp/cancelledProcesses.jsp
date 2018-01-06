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


                        <div class="col-sm-3">
                            <button type="submit" class="btn btn-primary pull-right">Поиск</button>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="processName1" class="control-label col-sm-2">Выбрать имя процесса</label>

                        <div class="col-sm-2">
                            <input list="names" type="text" class="form-control" id="processName1" name="level">
                            <datalist id="names">
                                <option>P1.1-1</option>
                                <option>P2.1-3</option>
                                <option>P3.1-2</option>
                                <option>P4.1-1</option>
                            </datalist>
                        </div>
                        <div class="col-sm-1">
                            <button type="submit" class="btn btn-primary">Выбрать</button>
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
            <div id="piechart1"></div>
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
                            <input type="text" class="form-control" id="owner" value="Иванов И.И." disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="executor" class="control-label col-xs-3">Исполнители:</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="executor" value="Петров П.П., Иванов И.И. "
                                   disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="responsible" class="control-label col-xs-3">Ответственный:</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="responsible" value="Петров П.П." disabled>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="result" class="control-label col-xs-3">Результативность процесса</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="result" name="result"
                                   style="color: darkblue; font-size: 14pt" disabled>
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
                            <c:forEach var="criteria" items="${criterias}">

                                <c:set var="procID" value="${criteria.process.id}"/>
                                <c:if test="${criteria.process.id == '100019'}">
                                    <tr>
                                        <td>${criteria.name}</td>
                                        <td>${criteria.value}</td>
                                        <td>${criteria.targetValue}</td>
                                        <td>${criteria.reduceFactor}</td>
                                        <td>${criteria.weight}</td>
                                    </tr>
                                </c:if>
                            </c:forEach>
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

<script type="text/javascript">
    google.charts.load('current', {'packages': ['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
        var data = google.visualization.arrayToDataTable([
            ['Task', 'Hours per Day'],
            ['результативен (>0,75)', 11],
            ['не результативен (<0,25)', 2],
            ['средний уровень результативности(0,5-0,75)', 2],
            ['низкий уровень результативности(0,25-0,5)', 2]

        ]);
        var options = {
            title: 'Сводная диаграмма показателей результативности процессов',
            slices: {
                0: {color: 'green'},
                1: {color: 'red'},
                2: {color: 'yellow'},
                3: {color: 'orange'}
            },
            backgroundColor: 'ghostwhite',
            height:300,
            width:600

        };
        var chart = new google.visualization.PieChart(document.getElementById('piechart1'));
        chart.draw(data, options);
    }
</script>
</html>