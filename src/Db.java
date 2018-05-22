import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Db {
    private String dbhost;
    private String dbport;
    private String dbname;
    private String dblogin;
    private String dbpwd;
    private Connection conn;

    public Db() {
        try {
            Context env = (Context)new InitialContext().lookup("java:comp/env");
            this.dbhost = (String)env.lookup("db-host");
            this.dbport = (String)env.lookup("db-port");
            this.dbname = (String)env.lookup("db-name");
            this.dblogin = (String)env.lookup("db-login");
            this.dbpwd = (String)env.lookup("db-pwd");

            String strClassName = "com.mysql.cj.jdbc.Driver";
            String strUrl = "jdbc:mysql://"+this.dbhost+":"+this.dbport+"/"+this.dbname+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName(strClassName);
            this.conn = DriverManager.getConnection(strUrl, this.dblogin, this.dbpwd);
        } catch (NamingException e)
        {

        } catch (SQLException e) {

        } catch (ClassNotFoundException e) {

        }
    }

    public void execute(String query, ArrayList params) {
        try {
            PreparedStatement p = this.conn.prepareStatement(query);

            p.setString(1, (String) params.get(0));
            p.setString(2, (String) params.get(1));
            p.setString(3, (String) params.get(2));
            p.execute();
        } catch (SQLException e) {

        }
    }

    public String getDbhost() {
        return dbhost;
    }

    public void setDbhost(String dbhost) {
        this.dbhost = dbhost;
    }

    public String getDbport() {
        return dbport;
    }

    public void setDbport(String dbport) {
        this.dbport = dbport;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getDblogin() {
        return dblogin;
    }

    public void setDblogin(String dblogin) {
        this.dblogin = dblogin;
    }

    public String getDbpwd() {
        return dbpwd;
    }

    public void setDbpwd(String dbpwd) {
        this.dbpwd = dbpwd;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}
