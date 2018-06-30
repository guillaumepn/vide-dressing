package servlets;

import ENTITIES.ArticleEntity;
import db.ArticleDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BuyArticleServlet", urlPatterns = {"/buy-article"})
public class BuyArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ArticleDAO articleDAO = new ArticleDAO();
        ArticleEntity article = null;



        if (id != null) {
            article = articleDAO.buy(id);

            if (article != null) {
                request.setAttribute("article", article);
            }
        }

        this.getServletContext().getRequestDispatcher("/article.jsp").forward(request, response);
    }
}
