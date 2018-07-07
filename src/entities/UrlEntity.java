package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "url", schema = "jee", catalog = "")
public class UrlEntity {
    private int id;
    private String userId;
    private String urlOriginal;
    private String urlShort;
    private String password;
    private boolean captcha;
    private String email;
    private String dateStart;
    private String dateEnd;
    private Integer maxClics;
    private Integer clicsCounter;
    private String dateCreation;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "url_original")
    public String getUrlOriginal() {
        return urlOriginal;
    }

    public void setUrlOriginal(String urlOriginal) {
        this.urlOriginal = urlOriginal;
    }

    @Basic
    @Column(name = "url_short")
    public String getUrlShort() {
        return urlShort;
    }

    public void setUrlShort(String urlShort) {
        this.urlShort = urlShort;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "captcha")
    public boolean getCaptcha() {
        return captcha;
    }

    public void setCaptcha(boolean captcha) {
        this.captcha = captcha;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "date_start")
    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    @Basic
    @Column(name = "date_end")
    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrlEntity urlEntity = (UrlEntity) o;
        return id == urlEntity.id &&
                Objects.equals(userId, urlEntity.userId) &&
                Objects.equals(urlOriginal, urlEntity.urlOriginal) &&
                Objects.equals(urlShort, urlEntity.urlShort) &&
                Objects.equals(password, urlEntity.password) &&
                Objects.equals(captcha, urlEntity.captcha) &&
                Objects.equals(email, urlEntity.email) &&
                Objects.equals(dateStart, urlEntity.dateStart) &&
                Objects.equals(dateEnd, urlEntity.dateEnd);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, urlOriginal, urlShort, password, captcha, email, dateStart, dateEnd);
    }

    @Basic
    @Column(name = "max_clics")
    public Integer getMaxClics() {
        return maxClics;
    }

    public void setMaxClics(Integer maxClics) {
        this.maxClics = maxClics;
    }

    @Basic
    @Column(name = "clics_counter")
    public Integer getClicsCounter() {
        return clicsCounter;
    }

    public void setClicsCounter(Integer clicsCounter) {
        this.clicsCounter = clicsCounter;
    }

    @Basic
    @Column(name = "date_creation")
    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }
}
