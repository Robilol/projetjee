package db;

import models.User;

import java.util.ArrayList;

public class UserDAO {

    private User user;

    public UserDAO(User user) {
        this.user = user;
    }

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

}