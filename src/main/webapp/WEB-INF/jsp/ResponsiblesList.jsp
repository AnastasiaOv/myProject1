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
            <h3>Список ответственных:</h3>
            <div><label></label></div>
            <div><label></label></div>
            <div><label></label></div>
            <div><label></label></div>
            <c:set var="ajaxUrl" value="ajax/profile/responsibles/"/>
            <h4> Иванов Иван Иванович</h4>
            <table id="example" class="table table-striped" border="all" datapagesize="1" cellspacing="0" width="80%">
                <thead>
                <tr>
                    <th width="150px">Название процесса</th>
                    <th width="175px">Описание</th>
                    <th width="100px">Дата начала</th>
                    <th width="100px">Дата завершения</th>
                    <th width="100px">Значение показателя результативности</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>P2.1-3</td>
                    <td>Оценка персонала</td>
                    <td>25.12.2017</td>
                    <td>29.12.2017</td>
                    <td bgcolor="#ffc08f">0,45</td>
                </tr>
                <tr>
                    <td>P2.1-3</td>
                    <td>Оценка персонала</td>
                    <td>26.12.2017</td>
                    <td>29.12.2017</td>
                    <td bgcolor="#81ff8b">0,85</td>
                </tr>

                <tr>
                    <td>P1.1-3</td>
                    <td>Текущая деятельность</td>
                    <td>06.12.2017</td>
                    <td>20.12.2017</td>
                    <td bgcolor="#81ff8b">0,94</td>
                </tr>
                </tbody>
            </table>
            <div><label></label></div>
            <div><label></label></div>
            <div><label></label></div>
            <div><label></label></div>
            <h4> Петров Петр Петрович</h4>
            <table id="example" class="table table-striped" border="all" datapagesize="1" cellspacing="0" width="80%">
                <thead>
                <tr>
                    <th width="150px">Название процесса</th>
                    <th width="175px">Описание</th>
                    <th width="100px">Дата начала</th>
                    <th width="100px">Дата завершения</th>
                    <th width="100px">Значение показателя результативности</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>P2.1-3</td>
                    <td>Оценка персонала</td>
                    <td>25.12.2017</td>
                    <td>29.12.2017</td>
                    <td bgcolor="#81ff8b">0,76</td>
                </tr>
                <tr>
                    <td>P3.1-3</td>
                    <td>Развитие персонала</td>
                    <td>25.12.2017</td>
                    <td>29.12.2017</td>
                    <td bgcolor="#ffc08f">0,49</td>
                </tr>
                <tr>
                    <td>P3.1-3</td>
                    <td>Развитие персонала</td>
                    <td>25.12.2017</td>
                    <td>29.12.2017</td>
                    <td bgcolor="#f7ffaa">0,65</td>
                </tr>
                <tr>
                    <td>P1.1-3</td>
                    <td>Текущая деятельность</td>
                    <td>25.12.2017</td>
                    <td>03.01.2018</td>
                    <td bgcolor="#f08080">0,21</td>
                </tr>
                </tbody>
            </table>
            <div><label></label></div>
            <div><label></label></div>
            <div><label></label></div>
            <div><label></label></div>
            <h4>Сидоров Семен Семенович</h4>
            <table id="example" class="table table-striped" border="all" datapagesize="1" cellspacing="0" width="80%">
                <thead>
                <tr>
                    <th width="150px">Название процесса</th>
                    <th width="175px">Описание</th>
                    <th width="100px">Дата начала</th>
                    <th width="100px">Дата завершения</th>
                    <th width="100px">Значение показателя результативности</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>P1.1-3</td>
                    <td>Текущая деятельность</td>
                    <td>25.12.2017</td>
                    <td>29.12.2017</td>
                    <td bgcolor="#f7ffaa">0,68</td>
                </tr>
                <tr>
                    <td>P1.1-3</td>
                    <td>Текущая деятельность</td>
                    <td>25.12.2017</td>
                    <td>29.12.2017</td>
                    <td bgcolor="#f7ffaa">0,74</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

</div>

<jsp:include page="fragments/footer.jsp"/>


</html>