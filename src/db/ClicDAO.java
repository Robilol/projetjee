package db;

import entities.ClicEntity;
import entities.UrlEntity;

import javax.persistence.*;
import java.util.*;

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

    public List<ClicEntity> findByUrl(Integer urlId) {
        List<ClicEntity > clics = new ArrayList<ClicEntity>();

        this.em.getTransaction().begin();
        Query q = this.em.createQuery("SELECT v FROM ClicEntity v WHERE v.urlId = :urlId", ClicEntity.class).setParameter("urlId", urlId);

        try {
            clics = q.getResultList();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        this.em.getTransaction().commit();
        return clics;
    }

    public Map<String, Integer> getStatsById(Integer urlId) {
        HashMap<String, Integer> stats = new HashMap<String, Integer>();
        this.em.getTransaction().begin();
        Query q = this.em.createQuery("SELECT COUNT(v.id), v.date as bla  FROM ClicEntity v WHERE v.urlId = :urlId GROUP BY bla", ClicEntity.class).setParameter("urlId", urlId);
        try {
            List<Object[]> results = q.getResultList();

            for (Object[] obj : results) {
                stats.put(obj[1].toString(), Integer.parseInt(obj[0].toString()));
            }

        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        this.em.getTransaction().commit();

        Map<String, Integer> sortedMap = new TreeMap<String, Integer>(stats);

        return sortedMap;
    }
}