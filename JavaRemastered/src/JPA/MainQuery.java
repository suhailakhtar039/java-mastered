package JPA;

import JPA.music.Artist;
import jakarta.persistence.*;

import java.util.List;

public class MainQuery {
    public static void main(String[] args) {
        List<Artist> artists = null;
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA.music");
             EntityManager em = emf.createEntityManager();
        ) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            artists = getArtistsJPQL(em, "%Stev%");
            artists.forEach(System.out::println);
            getArtistsName(em, "%Stev%").forEach(System.out::println);
            getArtistsNameUsingTuple(em, "%Stev%").forEach(System.out::println);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<Artist> getArtistsJPQL(EntityManager em, String matchedValue) {
        String jpql = "SELECT a FROM Artist a WHERE a.artistName LIKE :partialName";
        TypedQuery<Artist> query = em.createQuery(jpql, Artist.class);
        query.setParameter("partialName", matchedValue);
        return query.getResultList();
    }

    private static List<String> getArtistsName(EntityManager em, String matchedValue) {
        String jpql = "SELECT a.artistName FROM Artist a WHERE a.artistName LIKE ?1";
        TypedQuery<String> query = em.createQuery(jpql, String.class);
        query.setParameter(1, matchedValue);
        return query.getResultList();
    }

    private static List<Tuple> getArtistsNameUsingTuple(EntityManager em, String matchedValue) {
        String jpql = "SELECT a.artistId, a.artistName FROM Artist a WHERE a.artistName LIKE ?1";
        TypedQuery<Tuple> query = em.createQuery(jpql, Tuple.class);
        query.setParameter(1, matchedValue);
        return query.getResultList();
    }

}
