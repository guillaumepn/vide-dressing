package servlets;

import ENTITIES.ArticleEntity;
import ENTITIES.VendeurEntity;
import db.ArticleDAO;
import db.CommentaireDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/add-comment")
public class CommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        VendeurEntity vendeur = (VendeurEntity) session.getAttribute("vendeur");
        CommentaireDAO commentaireDAO = new CommentaireDAO();
        commentaireDAO.create(vendeur.getCodeVendeur(), id, request.getParameter("content"));
        response.sendRedirect("/article?id="+id);
    }
}
