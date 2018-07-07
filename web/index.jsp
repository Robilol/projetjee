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
    <div class="col mt-3">
      <c:if test="${!empty success}">
        <div class="alert alert-success">
            ${success}
        </div>
      </c:if>

      <c:if test="${!empty alert}">
          <div class="alert alert-${alert}" role="alert">
              ${message}
          </div>
      </c:if>
      <form method="post" action="/index" class="url-form">
        <div class="form-group">
          <label for="originUrl">URL à raccourcir</label>
          <input type="text" class="form-control" id="originUrl" name="originUrl" placeholder="Votre URL" required>
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

      <c:if test="${!empty url}">
        <div class="alert alert-success">
          Voilà votre URL raccourcie : <a href="${url.urlShort}" target="_blank">${url.urlShort}</a>
        </div>
      </c:if>

      <c:if test="${empty user}">
        <a href="subscribe">Créer un compte pour voir nos autres options possibles</a>
      </c:if>
    </div>
  </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>