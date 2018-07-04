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

            <c:choose>
                <c:when test="${empty user}">
                    <a href="login">Vous devez être connecté pour accéder à ces options</a><br><br>
                    <a href="subscribe">Pas de compte ? Créez-en un !</a>
                </c:when>

                <c:otherwise>
                    <form method="post" action="raccourcir" class="url-form">
                        <div class="form-group">
                            <label for="originUrl">URL à raccourcir</label>
                            <input type="text" class="form-control" id="originUrl" name="originUrl" placeholder="Votre URL" required>
                        </div>

                        <div class="form-check">
                            <input type="checkbox" name="captcha" class="form-check-input" id="captchaProtected">
                            <label class="form-check-label" for="captchaProtected">Utiliser un captcha</label>
                        </div>

                        <div class="form-check">
                            <input type="checkbox" class="form-check-input" id="passwordProtected">
                            <label class="form-check-label" for="passwordProtected">Sécurisée avec mot de passe</label>
                        </div>

                        <div class="form-group">
                            <input type="text" class="form-control" id="password" name="password" placeholder="Mot de passe">
                        </div>

                        <div class="form-check form-check-inline">
                            <input type="checkbox" class="form-check-input" id="maxClics">
                            <label class="form-check-label" for="maxClics" style="    width: 60%;">Max de clics :</label> <input type="text" name="maxClics" class="form-control form-control-inline">
                        </div>

                        <div class="form-group">
                            <label for="fromto" class="form-check-label">
                                <input type="radio" class="form-check-input" name="date" id="fromto" name="fromto" value="fromto"> De
                                <input type="date" name="from" class="form-control"> à <input type="date" name="to" class="form-control">
                            </label><br>
                        </div>

                        <div class="form-group">
                            <label for="onlyto" class="form-check-label">
                                <input type="radio" class="form-check-input" name="date" id="onlyto" name="onlyto" value="onlyto"> Jusqu'à
                                <input type="date" name="only-to" class="form-control">
                            </label>
                        </div>
                        <button type="submit" class="btn btn-primary">Raccourcir</button>
                    </form>

                    <c:if test="${!empty url}">
                        <div class="alert alert-success">
                            Voilà votre URL raccourcie : <a href="${url.urlShort}" target="_blank">${url.urlShort}</a>
                        </div>
                    </c:if>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>