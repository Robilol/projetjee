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
    <h1>Mes informations :</h1>

    <p>Email : ${user.email}</p>
    <p>Type : ${user.type}</p>

</div>
<%@include file="footer.jsp"%>
</body>
</html>