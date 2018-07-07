package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "clic", schema = "jee", catalog = "")
public class ClicEntity {
    private int id;
    private Integer urlId;
    private String date;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "url_id")
    public Integer getUrlId() {
        return urlId;
    }

    public void setUrlId(Integer urlId) {
        this.urlId = urlId;
    }

    @Basic
    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClicEntity that = (ClicEntity) o;
        return id == that.id &&
                Objects.equals(urlId, that.urlId) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, urlId, date);
    }
}
