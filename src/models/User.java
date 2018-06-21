package models;

import db.UserDAO;

public class User {
    private int id;
    private String email;
    private String password;
    private String type;

    public User() {

    }

    public User(int id, String email, String password, String type) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public User(String email, String password, String type) {
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void create() {
        UserDAO userDao = new UserDAO(this);
        userDao.create();
    }

    public void find (String email, String password) {
        User user = new UserDAO().find(email,password);
        this.id = user.id;
        this.email = user.email;
        this.password = user.password;
        this.type = user.type;
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