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
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
    <h1>Mes urls :</h1>

    <c:choose>
        <c:when test="${!empty urls}">
            <c:forEach var="url" items="${urls}">
                <div><a href="${url.urlShort}" target="_blank">${url.urlShort}</a></div>
            </c:forEach>
        </c:when>

        <c:otherwise>
            Vous n'avez pas encore créé d'URLs.
        </c:otherwise>
    </c:choose>

</div>
<%@include file="footer.jsp"%>
</body>
</html>