package servlets;

import models.Url;

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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "IndexServlet", urlPatterns = {"/"})
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("tetetet");
        String urlOriginal = request.getParameter("originUrl");
        String urlShort = "";
        String password = request.getParameter("password");

        if (urlOriginal.equals("")) {
            request.setAttribute("alert", "danger");
            request.setAttribute("message", "Erreur");
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            urlShort = request.getRequestURL().toString() + Long.toHexString(Double.doubleToLongBits(Math.random()));
        }

        Url url = new Url(0, urlOriginal, urlShort, "", 0, "", "", "");
        url.create();

        response.sendRedirect("/subscribe");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
