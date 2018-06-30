package models;

import db.UrlDAO;

public class Url {
    private int userId;
    private String urlOriginal;
    private String urlShort;
    private String password;
    private int captcha;
    private String email;
    private String dateStart;
    private String dateEnd;

    public Url(int userId, String urlOriginal, String urlShort, String password, int captcha, String email, String dateStart, String dateEnd) {
        this.userId = userId;
        this.urlOriginal = urlOriginal;
        this.urlShort = urlShort;
        this.password = password;
        this.captcha = captcha;
        this.email = email;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public void create() {
        UrlDAO urlDAO = new UrlDAO(this);
        urlDAO.create();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUrlOriginal() {
        return urlOriginal;
    }

    public void setUrlOriginal(String urlOriginal) {
        this.urlOriginal = urlOriginal;
    }

    public String getUrlShort() {
        return urlShort;
    }

    public void setUrlShort(String urlShort) {
        this.urlShort = urlShort;
    }

    public int getCaptcha() {
        return captcha;
    }

    public void setCaptcha(int captcha) {
        this.captcha = captcha;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

}
