package servlets;

import db.UrlDAO;
import entities.UrlEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@WebServlet(name = "LinkServlet", urlPatterns = {"/l/*"})
public class LinkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UrlDAO urlDAO = new UrlDAO();
        URL url = new URL(request.getRequestURL().toString());
        String urlShort = null;
        URI uri = null;

        String host  = url.getHost();
        String userInfo = url.getUserInfo();
        String scheme = url.getProtocol();
        int port = url.getPort();
        String path = (String) request.getAttribute("javax.servlet.forward.request_uri");
        String query = (String) request.getAttribute("javax.servlet.forward.query_string");
        try {
            uri = new URI(scheme,userInfo,host,port,path,query,null);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        if (uri != null) {
            urlShort = uri.toString() + "/l" + request.getPathInfo();
            UrlEntity urlObject = urlDAO.find(urlShort);
            String urlOriginal = urlObject.getUrlOriginal();
            if (urlObject.getPassword() == null || urlObject.getPassword().equals("")) {
                response.sendRedirect(urlOriginal);
            } else {
                // Gérer avec le mdp
            }
        } else {
            this.getServletContext().getRequestDispatcher("/link.jsp").forward(request, response);
        }

    }
}
