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

            <c:set var="responsibles" value="/responsibles"/>

            <div><a class="btn btn-info" role="button" href="${cancelled}">Показать завершенные процессы</a></div>
            <div><label></label></div>
            <div><label></label></div>
            <div><label></label></div>
            <div><a class="btn btn-info" role="button" href="${cancelled}">Показать незавершенные процессы</a></div>
            <div><label></label></div>
            <div><label></label></div>
            <div><label></label></div>
            <div><a class="btn btn-info" role="button" href="${responsibles}">Показать список ответственных</a></div>
            <div><label></label></div>
            <div><label></label></div>
            <div><label></label></div>
            <div id="piechart"></div>
            <div><label></label></div>
            <div><label></label></div>
            <div><label></label></div>
            <div id="piechart1"></div>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>


</body>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    google.charts.load('current', {'packages': ['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

        var data = google.visualization.arrayToDataTable([
            ['Task', 'Hours per Day'],
            ['Завершенные процессы', 9],
            ['Незавершенные процессы', 3],

        ]);

        var options = {
            title: 'Соотношение завершенных/незавершенных процессов',
            slices: {
                0: {color: 'green'},
                1: {color: 'orange'}
            },
            backgroundColor: 'ghostwhite',
            height:300,
            width:600,
            legend:'label',


        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
    }
</script>

<script type="text/javascript">
    google.charts.load('current', {'packages': ['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

        var data = google.visualization.arrayToDataTable([
            ['Task', 'Hours per Day'],
            ['результативен (>0,75)', 4],
            ['не результативен (<0,25)', 1],
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

