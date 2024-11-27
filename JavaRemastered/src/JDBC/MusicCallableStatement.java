package JDBC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MusicCallableStatement {
    private static final int ARTIST_COLUMN = 0;
    private static final int ALBUM_COLUMN = 1;
    private static final int SONG_COLUMN = 3;

    public static void main(String[] args) {
        Map<String, Map<String, String>> albums = null;

        try (Stream<String> lines = Files.lines(Path.of("NewAlbums.csv"))) {

            albums = lines.map(s -> s.split(","))
                    .collect(Collectors.groupingBy(s -> s[ARTIST_COLUMN],
                            Collectors.groupingBy(s -> s[ALBUM_COLUMN],
                                    Collectors.mapping(s -> s[SONG_COLUMN],
                                            Collectors.joining("\",\"", "[\"", "\"]")))));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
