<%--
  Created by IntelliJ IDEA.
  User: robin
  Date: 22/05/18
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <h1>Créer votre compte</h1>
    <form method="post" action="/subscribe">
        <div class="form-group">
            <label for="email">Email :</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Votre email" required="required">
        </div>
        <div class="form-group">
            <label for="password">Mot de passe :</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Mot de passe" required="required">
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="type" id="particulier" value="particulier">
            <label class="form-check-label" for="particulier">
                Particulier
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="type" id="entreprise" value="entreprise">
            <label class="form-check-label" for="entreprise">
                Entreprise
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="type" id="association" value="association">
            <label class="form-check-label" for="association">
                Association
            </label>
        </div>
        <button type="submit" class="btn btn-primary float-right">Créer votre compte</button>
    </form>
</div>