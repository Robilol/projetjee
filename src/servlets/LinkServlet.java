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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
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

            if (url.getPassword() != null && !url.getPassword().equals("")) {
                if (!password.equals(url.getPassword())) {
                    alerts.put("danger", "Le mot de passe est incorrect.");
                    checks.put("password", false);
                }
            }

            if (url.getCaptcha() == 1) {
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
        Map<String, Boolean> checks = new HashMap<>();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date today = Calendar.getInstance().getTime();

        if (uri != null) {
            urlShort = uri.toString() + "/l" + request.getPathInfo();
            UrlEntity urlObject = urlDAO.find(urlShort);
            String urlOriginal = urlObject.getUrlOriginal();

            if (urlObject.getMaxClics() != 0 && urlObject.getClicsCounter() > urlObject.getMaxClics()) {
                alerts.put("danger", "Le nombre maximum de clics autorisés sur ce lien a été atteint.");
                checks.put("clic", false);
                request.setAttribute("alerts", alerts);
            }

            Date dateStart = null;
            Date dateEnd = null;

            if (urlObject.getDateStart() != null) {
                try {
                    dateStart = format.parse(urlObject.getDateStart());
                } catch (ParseException e) {

                }
            }

            if (urlObject.getDateEnd() != null) {
                try {
                    dateEnd = format.parse(urlObject.getDateEnd());
                } catch (ParseException e) {

                }
            }

            if (urlObject.getPassword() != "") {
                checks.put("password", false);
            }

            if (urlObject.getCaptcha() == 1) {
                checks.put("captcha", false);
            }


            if (urlObject.getDateStart() == null && urlObject.getDateEnd() != null && dateEnd.compareTo(today) < 0) {
                alerts.put("danger", "La date de validité est dépassé");
                checks.put("date to", false);
                request.setAttribute("alerts", alerts);
            }

            if (urlObject.getDateStart() != null && urlObject.getDateEnd() != null && (dateStart.compareTo(today) > 0 || dateEnd.compareTo(today) < 0)) {
                alerts.put("danger", "La date de validité est dépassé ou le lien n'est pas encore disponible");
                checks.put("date interval", false);
                request.setAttribute("alerts", alerts);
            }

            if (checks.containsValue(false)) {
                request.setAttribute("url", urlObject);
                request.setAttribute("alerts", alerts);
                this.getServletContext().getRequestDispatcher("/link.jsp").forward(request, response);
            } else {
                urlDAO.addClic(urlObject.getId());
                response.sendRedirect(urlObject.getUrlOriginal());
            }

        } else {
            alerts.put("danger", "L'url n'existe pas");
            request.setAttribute("alerts", alerts);

            this.getServletContext().getRequestDispatcher("/link.jsp").forward(request, response);
        }

    }

}
