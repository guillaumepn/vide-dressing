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

@WebServlet(name = "CreateArticleServlet", urlPatterns = {"/create-article"})
public class CreateArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArticleDAO articleDAO = new ArticleDAO();
        ArticleEntity article = null;

        if (session.getAttribute("vendeur") != null && request.getParameter("submit-article") != null) {
            VendeurEntity vendeur = (VendeurEntity) session.getAttribute("vendeur");
            String codeVendeur = vendeur.getCodeVendeur();
            String taille = request.getParameter("taille");
            int prix = Integer.parseInt(request.getParameter("prix"));
            String description = request.getParameter("description");

            article = articleDAO.create(codeVendeur, prix, taille, description);
        }

        if (article != null) {
            request.setAttribute("success", "Votre article a bien été ajouté.");
            response.sendRedirect("/index");
//            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            request.setAttribute("danger", "Une erreur est survenue lors de l'ajout de l'article.");
            this.getServletContext().getRequestDispatcher("/create-article.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/create-article.jsp").forward(request, response);
    }
}
