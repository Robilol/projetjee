package db;

import entities.UserEntity;

import javax.persistence.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    private EntityManager em = factory.createEntityManager();

    public UserEntity create(String email, String password, String type) {

        String token = randomString(16);

        UserEntity user = new UserEntity();
        user.setEmail(email);
        user.setPassword(password);
        user.setType(password);
        user.setToken(token);
        user.setValidated(0);

        this.em.getTransaction().begin();
        this.em.persist(user);
        this.em.getTransaction().commit();
        return user;

    }

    public UserEntity find(String email, String password) {
        UserEntity user = new UserEntity();
        this.em.getTransaction().begin();
        Query q = this.em.createQuery("SELECT v FROM UserEntity v WHERE v.email = :email AND v.password = :pass", UserEntity.class).setParameter("email", email).setParameter("pass", password);
        try {
            user = (UserEntity) q.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        this.em.getTransaction().commit();
        return user;
    }

    public List<UserEntity> all(){
        List<UserEntity> users = new ArrayList<UserEntity>();
        this.em.getTransaction().begin();
        try {
            users = em.createQuery("SELECT e FROM UserEntity e").getResultList();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        this.em.getTransaction().commit();

        return users;
    }

    public boolean validateUser(String token) {
        List<UserEntity> users = all();
        System.out.println(users);
        for (UserEntity user : users) {
            if (user.getToken() != null && user.getToken().equals(token)) {
                user.setValidated(1);
                this.em.getTransaction().begin();
                this.em.persist(user);
                this.em.getTransaction().commit();
                return true;
            }
        }
        return false;
    }

    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static SecureRandom rnd = new SecureRandom();

    String randomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

}