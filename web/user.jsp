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
    <div class="row">
        <div class="card mt-5 w-100">
            <div class="card-header">
                <h3>Informations de l'utilisateur</h3>
            </div>
            <div class="card-body">
                <p></p>
                <p>Code : ${vendeur.codeVendeur}</p>
                <p>Nom : ${vendeur.nom}</p>
                <p>Prénom : ${vendeur.prenom}</p>
                <form action="/user?id=${vendeur.id}" method="post">
                    <div class="pastille <c:out default="None" escapeXml="true" value="${vendeur.password != null ? 'bg-success' : 'bg-warning'}" />"></div>
                    <input type="password" placeholder="Password" value="${vendeur.password}" name="password">
                </form>
                <form action="/admin" method="post" >
                    <c:if test="${vendeur.blocked == '0'}">
                        <button type="submit" name="block" value="${vendeur.codeVendeur}" class="btn btn-warning">Bloquer</button>
                    </c:if>
                    <c:if test="${vendeur.blocked == '1'}">
                        <button type="submit" name="unblock" value="${vendeur.codeVendeur}" class="btn btn-success">Débloquer</button>
                    </c:if>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
