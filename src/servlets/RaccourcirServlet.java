package servlets;

import db.UrlDAO;
import entities.UrlEntity;
import entities.UserEntity;

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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "RaccourcirServlet", urlPatterns = {"/raccourcir"})
public class RaccourcirServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        UrlDAO urlDAO = new UrlDAO();

        UserEntity user = (UserEntity) session.getAttribute("user");

        String urlOriginal = request.getParameter("originUrl");
        String password = request.getParameter("password");
        String captcha = request.getParameter("captcha") != null ? request.getParameter("captcha") : "";
        int maxClics = request.getParameter("maxClicsCheckbox") != null ? Integer.parseInt(request.getParameter("maxClics")) : 0;
        String timestampFrom = null;
        String timestampTo = null;

        if (request.getParameter("date") != null) {
            if (request.getParameter("date").equals("fromto")) {
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date parsedDate = dateFormat.parse(request.getParameter("from"));
                    timestampFrom = String.valueOf(new Timestamp(parsedDate.getTime()));
                } catch(Exception e) {}

                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date parsedDate = dateFormat.parse(request.getParameter("to"));
                    timestampTo = String.valueOf(new Timestamp(parsedDate.getTime()));
                } catch(Exception e) {}
            } else if (request.getParameter("date").equals("onlyto")) {
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date parsedDate = dateFormat.parse(request.getParameter("only-to"));
                    timestampTo = String.valueOf(new Timestamp(parsedDate.getTime()));
                } catch(Exception e) {}
            }
        }
        LocalDate localDate = LocalDate.now();
        String dateCreation = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDate);

        String urlShort = "";
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
                request.setAttribute("message", "Erreur : URL vide");
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            } else {
                urlShort = uri + "/l/" + UUID.randomUUID().toString().substring(0, 4);
            }

            UrlEntity url = null;
            if (user != null) {
                request.setAttribute("user", user);
                url = urlDAO.create(user.getId(), urlOriginal, urlShort, password, captcha, timestampFrom, timestampTo, "", maxClics, 0, dateCreation);
                if (url != null) {
                    request.setAttribute("url", url);
                }
            }

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }



        this.getServletContext().getRequestDispatcher("/raccourcir.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/raccourcir.jsp").forward(request, response);
    }
}
