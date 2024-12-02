package JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @Column(name = "artist_id")
    private int artistId;

    @Column(name = "artist_name")
    private String artistName;
}
