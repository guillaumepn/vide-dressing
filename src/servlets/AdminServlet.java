package servlets;

import ENTITIES.ArticleEntity;
import ENTITIES.VendeurEntity;
import db.ArticleDAO;
import db.VendeurDAO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminServlet", urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        VendeurDAO vendeurDAO = new VendeurDAO();
        VendeurEntity vendeur = null;
        List<VendeurEntity> vendeurs = new ArrayList<VendeurEntity>();
        List<ArticleEntity> articles = new ArrayList<ArticleEntity>();

        if (session.getAttribute("vendeur") != null) {
            vendeur = (VendeurEntity) session.getAttribute("vendeur");
            if(!vendeur.isOrga()){
                request.setAttribute("danger", "Vous n'avez pas le droit d'accéder ici !");
                response.sendRedirect("/");
                return;
            }
        } else {
            request.setAttribute("danger", "Vous devez être connecté !");
            response.sendRedirect("/");
            return;
        }
        request.setAttribute("vendeur", vendeur);

        vendeurs = vendeurDAO.all();
        request.setAttribute("vendeurs", vendeurs);

        articles = allArticles();
        request.setAttribute("articles", articles);

        this.getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        VendeurDAO vendeurDAO = new VendeurDAO();
        VendeurEntity vendeur = null;

        if (request.getParameter("block") != null) {
            vendeurDAO.block(request.getParameter("block"));
        } else if (request.getParameter("unblock") != null) {
            vendeurDAO.unblock(request.getParameter("unblock"));
        }

        response.sendRedirect("/admin");
    }

    private List<ArticleEntity> allArticles() {
        ArticleDAO articleDAO = new ArticleDAO();

        List<ArticleEntity> articles = articleDAO.find("");

        return articles;
    }
}
