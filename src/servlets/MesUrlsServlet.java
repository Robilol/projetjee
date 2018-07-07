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
import java.util.List;

@WebServlet(name = "MesUrlsServlet", urlPatterns = {"/mes-urls"})
public class MesUrlsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserEntity user = (UserEntity) session.getAttribute("user");
        if (user != null) {
            UrlDAO urlDAO = new UrlDAO();
            List<UrlEntity> urls = urlDAO.findByUser(String.valueOf(user.getId()));

            if (urls != null) {
                request.setAttribute("urls", urls);
            }

            this.getServletContext().getRequestDispatcher("/mes-urls.jsp").forward(request, response);
        } else {
            response.sendRedirect("/login");
        }

    }
}
