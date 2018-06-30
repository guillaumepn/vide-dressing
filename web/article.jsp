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
    </div>

    <div class="row">
        <div class="col">
            <div>
                <a href="index" class="back badge badge-secondary">Retour à l'accueil</a>
            </div>

            <c:choose>
                <c:when test="${!empty article}">
                    <div class="card">
                        <div class="card-header">
                            Produit #${article.codeArticle}
                        </div>
                        <div class="card-body">
                            <h5 class="card-title">Prix : ${article.prix} €</h5>
                            <p class="card-text"><strong>Description :</strong> ${article.description}</p>

                            <c:choose>
                                <c:when test="${article.vendu == 1}">
                                    <button class="btn btn-danger" disabled>Vendu</button>
                                </c:when>

                                <c:otherwise>
                                    <a href="buy-article?id=${article.codeArticle}" class="btn btn-primary">Acheter</a>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                 </c:when>

                <c:otherwise>
                    <div class="alert alert-danger">
                        L'article n'a pas été trouvé.
                    </div>
                </c:otherwise>
            </c:choose>

        </div>
    </div>
</div>

<%@include file="footer.jsp"%>
</body>
</html>
