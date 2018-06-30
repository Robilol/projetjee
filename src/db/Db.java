package db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.*;
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
        System.out.println("test2");
        try {
            PreparedStatement p = this.conn.prepareStatement(query);
            int i = 0;

            for (Object param : params) {
                p.setString(i+1, (String) params.get(i));
                i++;
            }

            p.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<String> query(String query, ArrayList params) {
        try {
            PreparedStatement p = this.conn.prepareStatement(query);

            int i = 0;

            for (Object param : params) {
                p.setString(i+1, (String) params.get(i));
                i++;
            }

            ResultSet results = p.executeQuery();

            ResultSetMetaData rsmd = results.getMetaData();
            int columnCount = rsmd.getColumnCount();

            ArrayList<String> arrayResult = new ArrayList<>(columnCount);


            while (results.next()) {
                int j = 1;
                while(j <= columnCount) {
                    arrayResult.add(results.getString(j++));
                }
            }

            return arrayResult;
        } catch (SQLException e) {
            System.out.print(e);
            return null;
        }
    }

    public ArrayList<String> query(String query, ArrayList params) {
        try {
            PreparedStatement p = this.conn.prepareStatement(query);

            int i = 0;

            for (Object param : params) {
                p.setString(i+1, (String) params.get(i));
                i++;
            }

            ResultSet results = p.executeQuery();

            ResultSetMetaData rsmd = results.getMetaData();
            int columnCount = rsmd.getColumnCount();

            ArrayList<String> arrayResult = new ArrayList<>(columnCount);


            while (results.next()) {
                int j = 1;
                while(j <= columnCount) {
                    arrayResult.add(results.getString(j++));
                }
            }

            return arrayResult;
        } catch (SQLException e) {
            System.out.print(e);
            return null;
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
