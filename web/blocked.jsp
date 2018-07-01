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
     <div class="row mt-3">
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
        <img src="data:image/png;base64,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">
    </div>
</div>
    <%@include file="footer.jsp"%>
</body>
</html>