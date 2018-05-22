import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

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
        ArrayList<String> params = new ArrayList<String>();

        params.add(this.email);
        params.add(this.password);
        params.add(this.type);

        String baseQuery = "INSERT INTO user(email, password, type) VALUE(?, ?, ?);";

        Db db = new Db();
        db.execute(baseQuery, params);
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