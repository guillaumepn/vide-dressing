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

    <%-- Vendeurs --%>
    <div class="row">
        <div class="card mt-5 w-100">
            <div class="card-header">
            <h3 data-toggle="collapse" data-target="#users" aria-expanded="false" aria-controls="users">Utilisateurs</h3>
            </div>
            <div id="users" class="collapse card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Prénom</th>
                        <th scope="col">Nom</th>
                        <th scope="col">Bloquer</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${vendeurs}" var="vendeur">
                        <tr>
                            <td class="first-col">
                                <div class="pastille <c:out default="None" escapeXml="true" value="${vendeur.password != null ? 'bg-success' : 'bg-warning'}" />"></div><a href="/user?id=${vendeur.id}">${vendeur.prenom}</a>
                            </td>
                            <td>${vendeur.nom}</td>
                            <form action="/admin" method="post" >
                                <td>
                                    <c:if test="${vendeur.blocked == '0'}">
                                        <button type="submit" name="block" value="${vendeur.codeVendeur}" class="btn btn-warning">Bloquer</button>
                                    </c:if>
                                    <c:if test="${vendeur.blocked == '1'}">
                                        <button type="submit" name="unblock" value="${vendeur.codeVendeur}" class="btn btn-success">Débloquer</button>
                                    </c:if>
                                </td>
                            </form>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <%-- Articles --%>
    <div class="row">
        <div class="card mt-5 w-100">
            <div class="card-header">
                <h3 data-toggle="collapse" data-target="#articles" aria-expanded="false" aria-controls="articles">Tous les articles</h3>
            </div>
            <div id="articles" class="collapse card-body">
                <c:choose>
                    <c:when test="${!empty vendeur}">
                        <div class="card-text">
                            <div class="col">
                                <c:if test="${!empty articles}">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th scope="col">Code Article</th>
                                            <th scope="col">Prix</th>
                                            <th scope="col">Taille</th>
                                            <th scope="col">Description</th>
                                            <th scope="col">Voir</th>
                                            <th scope="col">Editer</th>
                                            <th scope="col">Statut</th>
                                            <th scope="col">Retirer</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${articles}" var="article">
                                            <tr>
                                                <td class="code-article">${article.codeArticle}</td>
                                                <td class="prix-article">${article.prix} €</td>
                                                <td class="taille-article">${article.taille}</td>
                                                <td class="description-article">${article.description}</td>
                                                <td>
                                                    <a href="article?id=${article.codeArticle}" class="btn btn-primary">Voir la fiche</a>
                                                </td>

                                                <td>
                                                        <a href="edit-article?id=${article.codeArticle}" class="btn btn-outline-primary">Editer</a>
                                                </td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${article.vendu == 1}">
                                                            <button class="btn btn-danger" disabled>Vendu</button>
                                                        </c:when>

                                                        <c:otherwise>
                                                                <a href="buy-article?id=${article.codeArticle}" class="btn btn-outline-success">Acheter</a>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
                                                <td>
                                                        <a class="btn btn-danger" href="delete-article?id=${article.codeArticle}">Retirer</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </c:if>
                                <c:if test="${empty articles}">
                                    Aucun article
                                </c:if>

                            </div>
                        </div>
                    </c:when>

                    <c:otherwise>
                        Connectez-vous pour voir les articles.
                    </c:otherwise>

                </c:choose>
            </div>
        </div>
    </div>

</div>

<%@include file="footer.jsp"%>
</body>
</html>
