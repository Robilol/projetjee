import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "MesInformationsServlet", urlPatterns = {"/mes-informations"})
public class MesInformationsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Object user = session.getAttribute("user");

        if (user == "" || user == null) {
            response.sendRedirect("/login");
        } else {
            request.setAttribute("user", user);
            this.getServletContext().getRequestDispatcher("/mes-informations.jsp").forward(request, response);
        }
    }
}
