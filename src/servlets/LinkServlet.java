package servlets;

import db.ClicDAO;
import db.UrlDAO;
import entities.UrlEntity;
import nl.captcha.Captcha;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import nl.captcha.servlet.CaptchaServletUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LinkServlet", urlPatterns = {"/l/*"})
public class LinkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UrlDAO urlDAO = new UrlDAO();
        String urlShort = request.getParameter("url");
        String password = request.getParameter("password");
        UrlEntity url = urlDAO.find(urlShort);

        Captcha captcha = (Captcha) session.getAttribute("simpleCaptcha");

        request.setCharacterEncoding("UTF-8");

        String captchaAnswer = request.getParameter("captchaAnswer");

        Map<String, String> alerts = new HashMap<>();
        Map<String, Boolean> checks = new HashMap<>();

        if (url != null) {

            if (url.getPassword() != null && url.getPassword() != "") {
                if (!password.equals(url.getPassword())) {
                    alerts.put("danger", "Le mot de passe est incorrect.");
                    checks.put("password", false);
                }
            }

            if (url.getCaptcha()) {
                if (!captcha.isCorrect(captchaAnswer)) {
                    alerts.put("danger", "Le captcha est incorrect");
                    checks.put("captcha", false);
                }
            }
        } else {
            request.setAttribute("url", url);
            alerts.put("danger", "L'url n'existe pas");
            request.setAttribute("alerts", alerts);
            this.getServletContext().getRequestDispatcher("/link.jsp").forward(request, response);
        }

        if (checks.containsValue(false)) {
            request.setAttribute("url", url);
            request.setAttribute("alerts", alerts);
            this.getServletContext().getRequestDispatcher("/link.jsp").forward(request, response);
        } else {
            urlDAO.addClic(url.getId());
            response.sendRedirect(url.getUrlOriginal());
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UrlDAO urlDAO = new UrlDAO();
        ClicDAO clicDAO = new ClicDAO();
        URL url = new URL(request.getRequestURL().toString());
        String urlShort = null;
        URI uri = null;

        String host = url.getHost();
        String userInfo = url.getUserInfo();
        String scheme = url.getProtocol();
        int port = url.getPort();
        String path = (String) request.getAttribute("javax.servlet.forward.request_uri");
        String query = (String) request.getAttribute("javax.servlet.forward.query_string");
        try {
            uri = new URI(scheme, userInfo, host, port, path, query, null);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        Map<String, String> alerts = new HashMap<>();


        if (uri != null) {
            urlShort = uri.toString() + "/l" + request.getPathInfo();
            UrlEntity urlObject = urlDAO.find(urlShort);
            String urlOriginal = urlObject.getUrlOriginal();


            /* Si le lien n'a pas atteint son max de clics autorisés */
            if ((urlObject.getMaxClics() != 0 && urlObject.getClicsCounter() < urlObject.getMaxClics()) || urlObject.getMaxClics() == 0) {

                if ((urlObject.getPassword() != null && urlObject.getPassword() != "") || urlObject.getCaptcha()) {
                    request.setAttribute("url", urlObject);
                    this.getServletContext().getRequestDispatcher("/link.jsp").forward(request, response);
                } else {
                    urlDAO.addClic(urlObject.getId());
                    response.sendRedirect(urlOriginal);
                }

            } else {
                request.setAttribute("url", urlObject);
                request.setAttribute("maxclics", "Le nombre maximum de clics autorisés sur ce lien a été atteint.");
                this.getServletContext().getRequestDispatcher("/link.jsp").forward(request, response);
            }
        } else {
            alerts.put("danger", "L'url n'existe pas");
            this.getServletContext().getRequestDispatcher("/link.jsp").forward(request, response);
        }

    }

}
