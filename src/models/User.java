package models;

import db.UserDAO;

public class User {
    private String email;
    private String password;
    private String type;

    public User(String email, String password, String type) {
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public void create() {
        UserDAO userDao = new UserDAO(this);
        userDao.create();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}