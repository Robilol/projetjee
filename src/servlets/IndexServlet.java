package servlets;


import db.UrlDAO;
import entities.UrlEntity;
import entities.UserEntity;

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
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "IndexServlet", urlPatterns = {"/index"})
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UrlDAO urlDAO = new UrlDAO();

        UserEntity user = (UserEntity) session.getAttribute("user");

        String urlOriginal = request.getParameter("originUrl");
        String urlShort = "";
        String password = request.getParameter("password");
        URL urlObject = new URL(request.getRequestURL().toString());
        String host  = urlObject.getHost();
        String userInfo = urlObject.getUserInfo();
        String scheme = urlObject.getProtocol();
        int port = urlObject.getPort();
        String path = (String) request.getAttribute("javax.servlet.forward.request_uri");
        String query = (String) request.getAttribute("javax.servlet.forward" +
                "soutquery.query_string");
        try {
            URI uri = new URI(scheme,userInfo,host,port,path,query,null);
            System.out.println(uri);
            if (urlOriginal.equals("")) {
                request.setAttribute("alert", "danger");
                request.setAttribute("message", "Erreur");
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            } else {
                urlShort = uri + "/l/" + UUID.randomUUID().toString().substring(0, 4);
            }

            if (user != null) {
                UrlEntity url = urlDAO.create(user.getId(), urlOriginal, urlShort, password, "", "", "");

            } else {
                UrlEntity url = urlDAO.create(-1, urlOriginal, urlShort, password, "", "", "");
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/index");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
