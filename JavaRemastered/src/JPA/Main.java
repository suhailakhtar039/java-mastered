package JPA;

import JPA.music.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        try(EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("JPA.music");
            EntityManager entityManager = sessionFactory.createEntityManager();
        ){

            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(new Artist("Muddy Water"));
            transaction.commit();

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
