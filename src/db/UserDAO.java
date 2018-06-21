package db;

import models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {

    private User user;

    public UserDAO(User user) {
        this.user = user;
    }
    public UserDAO() { }

    public void create() {
        System.out.println("testa");
        ArrayList<String> params = new ArrayList<String>();

        params.add(this.user.getEmail());
        params.add(this.user.getPassword());
        params.add(this.user.getType());

        String baseQuery = "INSERT INTO user(email, password, type) VALUE(?, ?, ?);";

        Db db = new Db();
        db.execute(baseQuery, params);
    }

    public User find(String email, String password) {
        ArrayList<String> params = new ArrayList<String>();

        params.add(email);
        params.add(password);

        String baseQuery = "SELECT * FROM user WHERE email = ? AND password = ? LIMIT 1;";

        Db db = new Db();
        ArrayList results = db.query(baseQuery, params);

        if (results != null) {
            User user = new User(Integer.parseInt(results.get(0).toString()), results.get(1).toString(), results.get(2).toString(), results.get(3).toString());
            return user;
        } else {
            return null;
        }



    }

}