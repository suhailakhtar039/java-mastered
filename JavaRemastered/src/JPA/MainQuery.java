package JPA;

import JPA.music.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class MainQuery {
    public static void main(String[] args) {

    }

    private static List<Artist> getArtistsJPQL(EntityManager em, String matchedValue){
        String jpql = "SELECT a FROM Artists a";
        TypedQuery<Artist> query = em.createQuery(jpql, Artist.class);
        return query.getResultList();
    }


}
