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

            <c:set var="cancelled" value="/cancelled_processes"/>

            <a class="btn btn-info" role="button" href="${cancelled}">Показать завершенные процессы</a>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addProcess">Показать
                незавершенные процессы
            </button>

            <div>Соотношение завершенных/незавершенных процессов</div>
            <div id="piechart" style="width: 500px; height: 500px; enable-background: 'false'"></div>
            <div>Общая диаграмма показателей результативности</div>
            <div id="piechart" style="width: 500px; height: 500px; background-color: powderblue"></div>
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
                        <table class="table table-striped" id="positions">
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
                                        <th><c:if test="${positions.owner == 'true'}"><input type="checkbox"
                                                                                             title="owner"
                                                                                             checked/></c:if><c:if
                                                test="${positions.owner == 'false'}"><input type="checkbox"
                                                                                            title="owner"/></c:if></th>
                                        <th><c:if test="${positions.executor == 'true'}"><input type="checkbox"
                                                                                                title="executor"
                                                                                                checked/></c:if><c:if
                                                test="${positions.executor == 'false'}"><input type="checkbox"
                                                                                               title="executor"/></c:if>
                                        </th>
                                        <th><c:if test="${positions.responsible == 'true'}"><input type="checkbox"
                                                                                                   title="responsible"
                                                                                                   checked/></c:if><c:if
                                                test="${positions.responsible == 'false'}"><input type="checkbox"
                                                                                                  title="responsible"/></c:if>
                                        </th>
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
</body>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    google.charts.load('current', {'packages': ['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

        var data = google.visualization.arrayToDataTable([
            ['Task', 'Hours per Day'],
            ['Work', 11],
            ['Eat', 2],

        ]);

        var options = {
            title: 'My Daily Activities',
            slices: {
                0: {color: 'green'},
                1: {color: 'orange'}
            },


        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
    }
</script>
</html>

