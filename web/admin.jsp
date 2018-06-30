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
            <h1>Panel Admin</h1>
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
        <div class="col">
            <h3>Listing User</h3>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Prénom</th>
                    <th scope="col">Nom</th>
                    <th scope="col">Bannir</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${vendeurs}" var="vendeur">
                    <tr>
                        <td>${vendeur.prenom}</td>
                        <td>${vendeur.nom}</td>
                        <form action="/admin" method="post" >
                            <td>
                            <c:if test="${vendeur.blocked == '0'}">
                                <button type="submit" name="block" value="${vendeur.codeVendeur}" class="btn btn-danger">Bannir</button>
                            </c:if>
                            <c:if test="${vendeur.blocked == '1'}">
                                <button type="submit" name="unblock" value="${vendeur.codeVendeur}" class="btn btn-success">Amnisiter</button>
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

<%@include file="footer.jsp"%>
</body>
</html>
