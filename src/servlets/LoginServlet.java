package servlets;

import db.UserDAO;
import entities.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDAO userDAO = new UserDAO();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email == "" || password == "") {
            request.setAttribute("alert", "danger");
            request.setAttribute("message", "Erreur");
            this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }

        UserEntity user = new UserEntity();
        user = userDAO.find(email, password);
        System.out.println(user);

        if (user != null) {
            session.setAttribute( "user", user );
            request.setAttribute("success", "Vous êtes connecté");
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            request.setAttribute("danger", "Les identifiants sont incorrects");
            this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
