package db;

import entities.UrlEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class UrlDAO {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    private EntityManager em = factory.createEntityManager();

    public UrlEntity create(int userId, String urlOriginal, String urlShort, String captcha, String dateStart, String dateEnd, String email) {

        UrlEntity url = new UrlEntity();
        url.setUserId(String.valueOf(userId));
        url.setUrlOriginal(urlOriginal);
        url.setUrlShort(urlShort);
        url.setCaptcha(captcha);
        url.setEmail(email);
        url.setDateStart(dateStart);
        url.setDateEnd(dateEnd);

        this.em.getTransaction().begin();
        this.em.persist(url);
        this.em.getTransaction().commit();
        return url;

    }

    public UrlEntity createWithPassword(int userId, String urlOriginal, String urlShort, String password, String captcha, String dateStart, String dateEnd, String email) {

        UrlEntity url = new UrlEntity();
        url.setUserId(String.valueOf(userId));
        url.setUrlOriginal(urlOriginal);
        url.setUrlShort(urlShort);
        url.setPassword(password);
        url.setCaptcha(captcha);
        url.setEmail(email);
        url.setDateStart(dateStart);
        url.setDateEnd(dateEnd);

        this.em.getTransaction().begin();
        this.em.persist(url);
        this.em.getTransaction().commit();
        return url;

    }

    public UrlEntity find(String email, String password) {
        UrlEntity url = new UrlEntity();
        this.em.getTransaction().begin();
        Query q = this.em.createQuery("SELECT v FROM UrlEntity v WHERE v.email = :email AND v.password = :pass", UrlEntity .class).setParameter("email", email).setParameter("pass", password);
        try {
            url = (UrlEntity ) q.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        this.em.getTransaction().commit();
        return url;
    }

    public List<UrlEntity > all(){
        List<UrlEntity > urls = new ArrayList<UrlEntity >();
        this.em.getTransaction().begin();
        try {
            urls = em.createQuery("SELECT e FROM UrlEntity e").getResultList();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        return urls;
    }

}