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
    <div class="row">
        <div class="col">
            <h1>Accéder au lien</h1>

            <c:if test="${!empty danger}">
                <div class="alert alert-danger">
                    ${danger}
                </div>
            </c:if>

            <c:if test="${!empty maxclics}">
                <div class="alert alert-danger">
                        ${maxclics}
                </div>
            </c:if>

            <c:if test="${!empty url.password}">
                <form action="" method="post">
                    <div class="form-group">
                        <label for="password">Mot de passe :</label>
                        <input type="text" id="password" name="password" class="form-control">
                    </div>
                    <input type="hidden" value="${url.urlShort}" name="url">
                    <input type="submit" class="btn btn-primary">
                </form>
            </c:if>
        </div>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>