<%--
  Created by IntelliJ IDEA.
  User: mael
  Date: 30/06/2018
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
        </ul>
        <c:choose>
            <c:when test="${empty vendeur}">
                <form action="/index" method="post" class="form-inline my-2 my-lg-0">
                    <input type="text" class="form-control mr-sm-2" name="code_vendeur"  placeholder="Code Vendeur" required>
                    <input type="text" class="form-control mr-sm-2" name="password"  placeholder="Password" required>
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="login" value="Se connecter">Connection</button>
                </form>
            </c:when>
            <c:otherwise>
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="/logout">Logout <span class="sr-only">(current)</span></a>
                    </li>
                </ul>
            </c:otherwise>
        </c:choose>

    </div>
</nav>