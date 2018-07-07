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
            <h1>Se connecter</h1>
            <c:if test="${!empty danger}">
                <div class="alert alert-danger">
                    ${danger}
                </div>
            </c:if>
            <form method="post" action="/login">
                <div class="form-group">
                    <label for="email">Email :</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Votre email" required="required">
                </div>
                <div class="form-group">
                    <label for="password">Mot de passe :</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Mot de passe" required="required">
                </div>
                <button type="submit" class="btn btn-primary float-right">Se connecter</button>
            </form>
        </div>
        <div class="col">
            <h1>S'inscrire</h1>
            <a href="/subscribe" class="btn btn-primary">S'inscrire</a>
        </div>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>