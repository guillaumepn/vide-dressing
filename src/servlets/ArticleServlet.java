package servlets;

import ENTITIES.ArticleEntity;
import ENTITIES.CommentaireEntity;
import db.ArticleDAO;
import db.CommentaireDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ArticleServlet", urlPatterns = {"/article"})
public class ArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        ArticleDAO articleDAO = new ArticleDAO();
        CommentaireDAO commentaireDAO = new CommentaireDAO();
        ArticleEntity article = null;
        List<CommentaireEntity> commentaires = new ArrayList<CommentaireEntity>();

        if (id != null) {
            article = articleDAO.findOne(id);
            if (article != null) {
                request.setAttribute("article", article);
                commentaires = commentaireDAO.allOfArticle(article.getCodeArticle());
                if( commentaires != null) {
                    System.out.println(commentaires);
                    request.setAttribute("commentaires", commentaires);
                }
            }
        }
        this.getServletContext().getRequestDispatcher("/article.jsp").forward(request, response);
    }
}
