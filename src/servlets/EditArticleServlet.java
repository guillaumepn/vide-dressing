package servlets;

import ENTITIES.ArticleEntity;
import ENTITIES.VendeurEntity;
import db.ArticleDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "EditArticleServlet", urlPatterns = {"/edit-article"})
public class EditArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArticleDAO articleDAO = new ArticleDAO();
        ArticleEntity article = null;

        String codeArticle = request.getParameter("id");

        if (session.getAttribute("vendeur") != null && request.getParameter("edit-article") != null) {
            String taille = request.getParameter("taille");
            int prix = Integer.parseInt(request.getParameter("prix"));
            String description = request.getParameter("description");

            article = articleDAO.edit(codeArticle, prix, taille, description);
        }

        if (article != null) {
            request.setAttribute("success", "Votre article a bien été modifié.");
            response.sendRedirect("/index");
//            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            request.setAttribute("danger", "Une erreur est survenue lors de la modification de l'article.");
            this.getServletContext().getRequestDispatcher("/edit-article.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        ArticleDAO articleDAO = new ArticleDAO();
        ArticleEntity article = null;

        if (id != null) {
            article = articleDAO.findOne(id);

            if (article != null) {
                request.setAttribute("article", article);
            }
        }

        this.getServletContext().getRequestDispatcher("/edit-article.jsp").forward(request, response);

    }
}
