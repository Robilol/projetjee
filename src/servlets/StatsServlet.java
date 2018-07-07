package servlets;

import db.UrlDAO;
import entities.UrlEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StatsServlet", urlPatterns = {"/stats"})
public class StatsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/stats.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UrlDAO urlDAO = new UrlDAO();
        UrlEntity url = null;
        String urlId = request.getParameter("id");

        if (urlId != null || !urlId.equals("")) {
            url = urlDAO.findById(Integer.parseInt(urlId));
            if (url != null) {
                request.setAttribute("url", url);
            } else {
                request.setAttribute("danger", "Aucune url n'a été trouvée. <a href='/mes-urls'>Retour</a>");
            }
        } else {
            request.setAttribute("danger", "L'id de l'url est incorrect. <a href='/mes-urls'>Retour</a>");
        }

        this.getServletContext().getRequestDispatcher("/stats.jsp").forward(request, response);
    }
}
