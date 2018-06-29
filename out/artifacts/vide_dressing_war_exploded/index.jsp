<%--
  Created by IntelliJ IDEA.
  User: guillaume
  Date: 28/06/18
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Vide-Dressing</title>
    <%@include file="head.jsp"%>
  </head>
  <body>

  <div class="container">

      <div class="row">
          <div class="col">
          <h1>Vide-Dressing</h1>
          </div>
      </div>

      <div class="row">
          <c:if test="${danger != null}">
              <div class="alert alert-danger" role="alert">
                  ${danger}
              </div>
          </c:if>
      </div>

      <div class="row">
              <c:choose>
                  <c:when test="${vendeur == null}">
                  <div class="col">
                      <h2>S'inscrire en tant que vendeur</h2>

                      <form action="/index" method="post">

                          <div class="form-group">
                              <label for="prenom">Prénom</label>
                              <input type="text" id="prenom" name="prenom" class="form-control" required>
                          </div>

                          <div class="form-group">
                              <label for="nom">Nom</label>
                              <input type="text" id="nom" name="nom" class="form-control" required>
                          </div>

                          <input type="submit" name="signup" class="btn btn-primary" value="S'inscrire">
                      </form>
                  </div>

                      <div class="col">
                          <h2>Se connecter</h2>

                          <form action="/index" method="post">

                              <div class="form-group">
                                  <label for="code_vendeur">Code Vendeur</label>
                                  <input type="text" id="code_vendeur" name="code_vendeur" class="form-control" required>
                              </div>

                              <div class="form-group">
                                  <label for="password">Password</label>
                                  <input type="text" id="password" name="password" class="form-control" required>
                              </div>

                              <input type="submit" name="login" class="btn btn-primary" value="Se connecter">
                          </form>
                      </div>

                  </c:when>

                  <c:when test="${vendeur != null}">
                      <div class="col">
                          Bienvenue ${vendeur.prenom}
                      </div>
                  </c:when>

              </c:choose>
      </div>
  </div>

  <%@include file="footer.jsp"%>
  </body>
</html>
