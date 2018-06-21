<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Title</title>
  <%@include file="head.jsp"%>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
  <div class="row">
    <div class="offset-md-3">
      <form method="post" class="url-form">
        <div class="form-group">
          <label for="originUrl">URL à raccourcir</label>
          <input type="text" class="form-control" id="originUrl" name="originUrl" placeholder="Votre URL">
        </div>
        <div class="form-check">
          <input type="checkbox" class="form-check-input" id="passwordProtected">
          <label class="form-check-label" for="passwordProtected">Sécurisée avec mot de passe</label>
        </div>
        <div class="form-group">
          <input type="text" class="form-control" id="password" name="password" placeholder="Mot de passe">
        </div>
        <button type="submit" class="btn btn-primary">Raccourcir</button>
      </form>
    </div>
  </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>