package servlets;

import db.ClicDAO;
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
        UrlDAO urlDAO = new UrlDAO();
        String urlShort = request.getParameter("url");
        String password = request.getParameter("password");
        UrlEntity url = urlDAO.find(urlShort);
        if (url != null && password.equals(url.getPassword())) {

            /* Si le lien n'a pas atteint son max de clics autorisés */
            if ((url.getMaxClics() != 0 && url.getClicsCounter() < url.getMaxClics()) || (url.getMaxClics() == 0)) {
                urlDAO.addClic(url.getId());
                response.sendRedirect(url.getUrlOriginal());
            } else {
                request.setAttribute("maxclics", "Le nombre maximum de clics autorisés sur ce lien a été atteint.");
                this.getServletContext().getRequestDispatcher("/link.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("url", url);
            request.setAttribute("danger", "Le mot de passe est incorrect");
            this.getServletContext().getRequestDispatcher("/link.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UrlDAO urlDAO = new UrlDAO();
        ClicDAO clicDAO = new ClicDAO();
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

            /* Si le lien n'a pas besoin de password */
            if (urlObject.getPassword() == null || urlObject.getPassword().equals("")) {

                /* Si le lien n'a pas atteint son max de clics autorisés */
                if ((urlObject.getMaxClics() != 0 && urlObject.getClicsCounter() < urlObject.getMaxClics()) || (urlObject.getMaxClics() == 0)) {
                    urlDAO.addClic(urlObject.getId());
                    response.sendRedirect(urlOriginal);
                } else {
                    request.setAttribute("maxclics", "Le nombre maximum de clics autorisés sur ce lien a été atteint.");
                    this.getServletContext().getRequestDispatcher("/link.jsp").forward(request, response);
                }
            }

            /* Si le lien nécessite un password */
            else {
                request.setAttribute("url", urlObject);
                this.getServletContext().getRequestDispatcher("/link.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("danger", "Ce lien n'a pas été reconnu");
            this.getServletContext().getRequestDispatcher("/link.jsp").forward(request, response);
        }

    }
}
