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
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Lien raccourci</th>
                    <th scope="col">Lien original</th>
                    <th scope="col">Date de création</th>
                    <th scope="col">Statistiques</th>
                </tr>
                </thead>
                <tbody>
            <c:forEach var="url" items="${urls}">
                <tr>
                    <td><a href="${url.urlShort}" target="_blank">${url.urlShort}</a></td>
                    <td><a href="${url.urlOriginal}" target="_blank">${url.urlOriginal}</a></td>
                    <td>${url.dateCreation}</td>
                    <td><a href="stats?id=${url.id}">Voir</a></td>
                </tr>
            </c:forEach>
                </tbody>
            </table>
        </c:when>

        <c:otherwise>
            Vous n'avez pas encore créé d'URLs.
        </c:otherwise>
    </c:choose>

</div>
<%@include file="footer.jsp"%>
</body>
</html>