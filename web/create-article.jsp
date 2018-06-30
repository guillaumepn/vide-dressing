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
            <form action="/create-article" method="post">
                <div class="form-group">
                    <label for="prix">Prix</label>
                    <input type="text" name="prix" id="prix" class="form-control" required>
                </div>

                <div class="form-group">
                    <label for="taille">Taille</label>
                    <select name="taille" id="taille" class="form-control" required>
                        <option value="S">S</option>
                        <option value="M">M</option>
                        <option value="L">L</option>
                        <option value="XL">XL</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="description">Description</label>
                    <textarea name="description" id="description" class="form-control" cols="30" rows="10" required></textarea>
                </div>

                <input type="submit" class="form-control" name="submit-article">
            </form>

        </div>
    </div>
</div>

<%@include file="footer.jsp"%>
</body>
</html>
