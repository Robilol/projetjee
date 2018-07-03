package servlets;


import db.UserDAO;
import entities.UserEntity;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "SubscribeServlet", urlPatterns = {"/subscribe"})
public class SubscribeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();

        System.out.println("cl,sndv");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String type = request.getParameter("type");

        if (email.equals("") || password.equals("") || type.equals("")) {
            request.setAttribute("alert", "danger");
            request.setAttribute("message", "Erreur");
            this.getServletContext().getRequestDispatcher("/subscribe.jsp").forward(request, response);
        }

        UserEntity user = new UserEntity();
        user = userDAO.create(email, password, type);

        request.setAttribute("token", user.getToken());

//        response.sendRedirect("/");
        this.getServletContext().getRequestDispatcher("/subscribe.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/subscribe.jsp").forward(request, response);

    }
}
