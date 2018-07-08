<%--
  Created by IntelliJ IDEA.
  User: robin
  Date: 22/05/18
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="head.jsp"%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.js"></script>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
    <h1>Statistiques du lien</h1>

    <canvas id="chart" width="400" height="400"></canvas>

    <c:choose>
        <c:when test="${!empty url}">
            <c:if test="${!empty clics}">
                <h2>Clics</h2>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Date du clic</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="clic" items="${clics}">
                        <tr>
                            <td>${clic.date}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </c:when>

        <c:otherwise>
            Ce lien est introuvable.
        </c:otherwise>
    </c:choose>

</div>
<%@include file="footer.jsp"%>
</body>

<script type="text/javascript">
    var ctx = document.getElementById("chart");

    var labels = [];
    var data = [];

    <c:forEach items="${stats}" var="stat">
        labels.push(${stat.key});
        data.push(${stat.value});
    </c:forEach>

    var myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: labels,
            datasets: [{
                label: 'Nombre de clics',
                data: data,
            }]
        },
    });
</script>
</html>