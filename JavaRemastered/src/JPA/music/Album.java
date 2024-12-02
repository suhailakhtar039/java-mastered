package JPA.music;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "albums")
public class Album {
    @Id
    @Column(name = "album_id")
    private int albumId;

    @Column(name = "album_name")
    private String albumName;

    public Album() {
    }

    public Album(String albumName) {
        this.albumName = albumName;
    }

    public Album(int albumId, String albumName) {
        this.albumId = albumId;
        this.albumName = albumName;
    }

    public String getalbumName() {
        return albumName;
    }

    public void setalbumName(String albumName) {
        this.albumName = albumName;
    }

    @Override
    public String toString() {
        return "album{" +
                "albumId=" + albumId +
                ", albumName='" + albumName + '\'' +
                '}';
    }
}
