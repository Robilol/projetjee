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
    <h1>Mon compte</h1>
    
    <div class="row">
        <div class="col">
            <a href="/mes-informations" class="btn btn-primary">
                Mes informations
            </a>
        </div>
        <div class="col">
            <a href="/mes-urls" class="btn btn-primary">
                Mes Urls
            </a>
        </div>
    </div>

</div>
<%@include file="footer.jsp"%>
</body>
</html>