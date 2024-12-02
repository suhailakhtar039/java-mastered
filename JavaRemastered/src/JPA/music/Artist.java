package JPA.music;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @Column(name = "artist_id")
    private int artistId;

    @Column(name = "artist_name")
    private String artistName;

    @OneToMany
    @JoinColumn(name = "artist_id")
    private List<Album> albums = new ArrayList<>();

    public Artist() {
    }

    public Artist(String artistName) {
        this.artistName = artistName;
    }

    public Artist(int artistId, String artistName) {
        this.artistId = artistId;
        this.artistName = artistName;
    }

    public String getArtistName() {
        return artistName;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistId=" + artistId +
                ", artistName='" + artistName + '\'' +
                ", albums=" + albums +
                '}';
    }
}
