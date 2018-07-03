<%--
  Created by IntelliJ IDEA.
  User: robin
  Date: 22/05/18
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="container">
    <div class="row">
        <div class="col-3">
            logo
        </div>
        <div class="col-9">
            Pub
        </div>
    </div>
    <div class="row">
        <div class="col">
            <a href="/" class="btn btn-primary">Accueil</a>
        </div>
        <div class="col">
            <a href="" class="btn btn-primary">Présentation</a>
        </div>
        <div class="col">
            <a href="/subscribe" class="btn btn-primary">Création d'un compte</a>
        </div>
        <div class="col">
            <a href="" class="btn btn-primary">Raccourcir</a>
        </div>
        <div class="col">
            <a href="/account" class="btn btn-primary">Mon compte</a>
        </div>

        <c:if test="${!empty session}">
            <div class="col">
                <a href="" class="btn btn-primary">Déconnexion</a>
            </div>
        </c:if>
    </div>
    <c:if test="${alert != null}">
        <div class="container">
            <div class="alert alert-${alert}" role="alert">
                ${message}
            </div>
        </div>
    </c:if>
</div>