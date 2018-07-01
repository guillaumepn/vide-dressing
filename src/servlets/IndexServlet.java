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

@WebServlet(name = "IndexServlet", urlPatterns = {"/index"})
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        VendeurDAO vendeurDAO = new VendeurDAO();
        VendeurEntity vendeur = null;
        ArticleDAO articleDAO = new ArticleDAO();
        List<ArticleEntity> articles = null;
        List<ArticleEntity> allArticles = allArticles();

        if (request.getParameter("signup") != null) {
            String prenom = request.getParameter("prenom");
            String nom = request.getParameter("nom");
            vendeur = vendeurDAO.create(prenom, nom);
        }

        if (request.getParameter("login") != null) {
            String codeVendeur = request.getParameter("code_vendeur");
            String password = request.getParameter("password");
            vendeur = vendeurDAO.find(codeVendeur, password);
            articles = articleDAO.find(vendeur.getCodeVendeur());
        }

        if (vendeur != null) {
            if (vendeur.getCodeVendeur() != null) {
                session.setAttribute("vendeur", vendeur);
                String totalVentes = totalVentes(vendeur.getCodeVendeur());
                request.setAttribute("total", totalVentes);
            } else {
                request.setAttribute("danger", "Cet utilisateur est introuvable");
            }
        }

        if (articles != null && !articles.isEmpty()) {
            request.setAttribute("articles", articles);
        }

        if (!allArticles.isEmpty()) {
            request.setAttribute("allArticles", allArticles);
        }
        response.sendRedirect("/index");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        VendeurEntity vendeur = null;
        ArticleDAO articleDAO = new ArticleDAO();
        List<ArticleEntity> articles = null;
        List<ArticleEntity> allArticles = allArticles();
        if (session.getAttribute("vendeur") != null) {
            vendeur = (VendeurEntity) session.getAttribute("vendeur");
            if(vendeur.isBlocked() == true){
                request.setAttribute("danger", "Votre compte a été bloqué, veuillez contacter un organisateur.");
                this.getServletContext().getRequestDispatcher("/blocked.jsp").forward(request, response);
                this.getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
                return;
            }
            request.setAttribute("vendeur", vendeur);


            articles = articleDAO.find(vendeur.getCodeVendeur());
            String totalVentes = totalVentes(vendeur.getCodeVendeur());
            request.setAttribute("total", totalVentes);
            if (!articles.isEmpty()) {
                request.setAttribute("articles", articles);
            }

            if (!allArticles.isEmpty()) {
                request.setAttribute("allArticles", allArticles);
            }
        }
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private String totalVentes(String codeVendeur) {
        int total = 0;

        ArticleDAO articleDAO = new ArticleDAO();

        List<ArticleEntity> articles = articleDAO.find(codeVendeur);

        if (articles != null) {
            for (ArticleEntity article : articles) {
                if (article.getVendu() == 1) {
                    total += article.getPrix();
                }
            }
        }

        return String.valueOf(total);
    }

    private List<ArticleEntity> allArticles() {
        ArticleDAO articleDAO = new ArticleDAO();

        List<ArticleEntity> articles = articleDAO.find("");

        return articles;
    }
}
