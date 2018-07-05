package db;

import entities.ClicEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ClicDAO {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    private EntityManager em = factory.createEntityManager();

    public ClicEntity create(int urlId, String date) {

        ClicEntity clic = new ClicEntity();
        clic.setUrlId(urlId);
        clic.setDate(date);

        this.em.getTransaction().begin();
        this.em.persist(clic);
        this.em.getTransaction().commit();
        return clic;

    }

    public List<ClicEntity > find(String urlId) {
        List<ClicEntity > clics = new ArrayList<ClicEntity >();
        this.em.getTransaction().begin();
        Query q = this.em.createQuery("SELECT v FROM ClicEntity v WHERE v.urlId = :urlId", ClicEntity .class).setParameter("urlId", urlId);
        try {
            clics = q.getResultList();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        this.em.getTransaction().commit();
        return clics;
    }

}