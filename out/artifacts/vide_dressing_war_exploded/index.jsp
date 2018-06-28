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
          <div class="col">
              <c:choose>
                  <c:when test="${vendeur == null}">
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

                          <input type="submit" class="btn btn-primary" value="S'inscrire">
                      </form>
                  </c:when>

                  <c:when test="${vendeur != null}">
                      Bienvenue ${vendeur.prenom}
                  </c:when>
              </c:choose>

          </div>
      </div>

  </div>

  <%@include file="footer.jsp"%>
  </body>
</html>
