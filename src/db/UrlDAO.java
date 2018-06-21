package db;

import models.Url;

import java.util.ArrayList;

public class UrlDAO {
    private Url url;

    public UrlDAO(Url url) {
        this.url = url;
    }

    public void create() {
        System.out.println("test1");
        ArrayList<String> params = new ArrayList<String>();

        params.add(Integer.toString(this.url.getUserId()));
        params.add(this.url.getUrlOriginal());
        params.add(this.url.getUrlShort());
        params.add(this.url.getPassword());
        params.add(Integer.toString(this.url.getCaptcha()));
        params.add(this.url.getEmail());
        params.add(this.url.getDateStart());
        params.add(this.url.getDateEnd());

        String baseQuery = "INSERT INTO url(user_id, url_original, url_short, password, captcha, email, date_start, date_end) VALUE(?, ?, ?, ?, ?, ?, ?, ?);";

        Db db = new Db();
        db.execute(baseQuery, params);
    }
}


