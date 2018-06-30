package servlets;

import ENTITIES.VendeurEntity;
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

        if (request.getParameter("signup") != null) {
            String prenom = request.getParameter("prenom");
            String nom = request.getParameter("nom");
            vendeur = vendeurDAO.create(prenom, nom);
        }

        if (request.getParameter("login") != null) {
            String codeVendeur = request.getParameter("code_vendeur");
            String password = request.getParameter("password");
            vendeur = vendeurDAO.find(codeVendeur, password);
        }

        if (vendeur.getCodeVendeur() != null) {
            session.setAttribute("vendeur", vendeur);
            System.out.println(vendeur.isOrga());
        } else {
            request.setAttribute("danger", "Cet utilisateur est introuvable");
            System.out.println(request.getAttribute("danger"));
        }

        response.sendRedirect("/admin");
        //this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        VendeurEntity vendeur = null;
        if (session.getAttribute("vendeur") != null) {
            vendeur = (VendeurEntity) session.getAttribute("vendeur");
        }

        request.setAttribute("vendeur", vendeur);

        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
