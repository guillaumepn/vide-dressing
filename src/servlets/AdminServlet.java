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

@WebServlet(name = "AdminServlet", urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        VendeurDAO vendeurDAO = new VendeurDAO();
        VendeurEntity vendeur = null;
        List<VendeurEntity> vendeurs = new ArrayList<VendeurEntity>();

        if (session.getAttribute("vendeur") != null) {
            vendeur = (VendeurEntity) session.getAttribute("vendeur");
        }
        request.setAttribute("vendeur", vendeur);

        vendeurs = vendeurDAO.all();
        request.setAttribute("vendeurs", vendeurs);

        this.getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
    }
}
