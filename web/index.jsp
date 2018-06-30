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
      <meta charset="UTF-8">
    <%@include file="head.jsp"%>
  </head>
  <body>
  <%@include file="navbar.jsp"%>
  <div class="container">
      <div class="row">
          <div class="col">
          <h1>Vide-Dressing</h1>
          </div>
      </div>

      <div class="row">
          <c:if test="${!empty danger}">
              <div class="alert alert-danger" role="alert">
                  ${danger}
              </div>
          </c:if>

          <c:if test="${!empty succes}">
              <div class="alert alert-succes" role="alert">
                      ${succes}
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
                  </c:when>

                  <c:when test="${!empty vendeur}">
                      <div class="col">
                          <h3>Bienvenue ${vendeur.prenom}</h3>

                          <h5>Liste de vos articles</h5>

                          <c:if test="${!empty articles}">
                              <table class="table">
                                  <thead>
                                  <tr>
                                      <th scope="col">Code Article</th>
                                      <th scope="col">Prix</th>
                                      <th scope="col">Taille</th>
                                      <th scope="col">Description</th>
                                  </tr>
                                  </thead>
                                  <tbody>
                              <c:forEach items="${articles}" var="article">
                                  <tr>
                                      <td class="code-article">${article.codeArticle}</td>
                                      <td class="prix-article">${article.prix} €</td>
                                      <td class="taille-article">${article.taille}</td>
                                      <td class="description-article">${article.description}</td>
                                  </tr>
                              </c:forEach>
                                  </tbody>
                              </table>
                          </c:if>

                          <c:if test="${empty articles}">
                              Aucun article
                          </c:if>

                          <div>
                              <a href="create-article" class="btn btn-outline-primary">Ajouter un nouvel article</a>
                          </div>
                      </div>
                  </c:when>

              </c:choose>
      </div>
  </div>

  <%@include file="footer.jsp"%>
  </body>
</html>
