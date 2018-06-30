package servlets;

import ENTITIES.VendeurEntity;
import db.VendeurDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VendeurDAO vendeurDAO = new VendeurDAO();
        VendeurEntity vendeur = new VendeurEntity();
        HttpSession session = request.getSession();

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

        vendeur = vendeurDAO.findById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("vendeur", vendeur);
        this.getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VendeurDAO vendeurDAO = new VendeurDAO();
        VendeurEntity vendeur = new VendeurEntity();
        HttpSession session = request.getSession();

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

        vendeur = vendeurDAO.findById(Integer.parseInt(request.getParameter("id")));
        vendeurDAO.changePassword(vendeur,request.getParameter("password"));
        response.sendRedirect("/user?id="+vendeur.getId());
    }
}