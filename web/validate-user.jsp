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
            <h1>Validation de votre compte</h1>
            <c:if test="${!empty success}">
                <div class="alert alert-success" role="alert">
                    ${success}
                </div>
            </c:if>

            <c:if test="${!empty danger}">
                <div class="alert alert-danger" role="alert">
                        ${danger}
                </div>
            </c:if>
        </div>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>