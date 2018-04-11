import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "IndexServlet", urlPatterns = {"/"})
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Context env = (Context)new InitialContext().lookup("java:comp/env");
            String dbhost = (String)env.lookup("db-host");
            String dbport = (String)env.lookup("db-port");
            String dbname = (String)env.lookup("db-name");
            String dblogin = (String)env.lookup("db-login");
            String dbpwd = (String)env.lookup("db-pwd");


            String strClassName = "com.mysql.cj.jdbc.Driver";
            String strUrl = "jdbc:mysql://"+dbhost+":"+dbport+"/"+dbname+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName(strClassName);
            Connection conn = DriverManager.getConnection(strUrl, dblogin, dbpwd);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM users;";
            ResultSet results = stmt.executeQuery(query);

            while (results.next()) {
                int id = results.getInt("id");
                String login = results.getString("login");
                String password = results.getString("mdp");

                System.out.println(login);
            }

            request.setAttribute("users", results);

            this.getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);

            conn.close();
        }
        catch(ClassNotFoundException e) {
            System.err.println("Driver non chargé !");
            System.out.println("Driver non chargé !");
            e.printStackTrace();
        } catch(SQLException e) {
            System.out.print(e);
        } catch (NamingException e) {
            System.out.print(e);
        }
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
