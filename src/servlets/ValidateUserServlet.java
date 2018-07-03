package servlets;

import db.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ValidateUserServlet", urlPatterns = {"/validate-user"})
public class ValidateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getParameter("token");
        UserDAO userDAO = new UserDAO();

        if (token != null) {
            boolean result = userDAO.validateUser(token);
            if (result) {
                request.setAttribute("success", "Votre compte a été validé");
            } else {
                request.setAttribute("danger", "Le token n'est pas valide");
            }
        } else {
            request.setAttribute("danger", "Le token n'est pas valide");
        }

        this.getServletContext().getRequestDispatcher("/validate-user.jsp").forward(request, response);
    }
}
