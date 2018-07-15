package servlets;

import db.ClicDAO;
import db.UrlDAO;
import entities.ClicEntity;
import entities.UrlEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "StatsServlet", urlPatterns = {"/stats"})
public class StatsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/stats.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UrlDAO urlDAO = new UrlDAO();
        ClicDAO clicDAO = new ClicDAO();
        UrlEntity url = null;
        String urlId = request.getParameter("id");

        if (urlId != null || !urlId.equals("")) {
            url = urlDAO.findById(Integer.parseInt(urlId));
            if (url != null) {
                request.setAttribute("url", url);

                List<ClicEntity> clics = clicDAO.findByUrl(url.getId());

                request.setAttribute("clics", clics);

                Map<String, Integer> stats = clicDAO.getStatsById(url.getId());

                request.setAttribute("stats", stats);


                System.out.println(clics);


            } else {
                request.setAttribute("danger", "Aucune url n'a été trouvée. <a href='/mes-urls'>Retour</a>");
            }
        } else {
            request.setAttribute("danger", "L'id de l'url est incorrect. <a href='/mes-urls'>Retour</a>");
        }

        this.getServletContext().getRequestDispatcher("/stats.jsp").forward(request, response);
    }
}
