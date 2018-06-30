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
            <h3>Listing User</h3>
            </div>
            <div class="card-body">
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
                            <td><div class="pastille <c:out default="None" escapeXml="true" value="${vendeur.password != null ? 'bg-success' : 'bg-warning'}" />"></div><a href="/user?id=${vendeur.id}">${vendeur.prenom}</a></td>
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
</div>

<%@include file="footer.jsp"%>
</body>
</html>
