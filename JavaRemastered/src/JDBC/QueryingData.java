package JDBC;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.*;
import java.util.Properties;

public class QueryingData {
    public static void main(String[] args) {

        Properties props = new Properties();
        try {
            props.load(Files.newInputStream(Path.of("C:\\Users\\Suhail Akhtar\\OneDrive\\Desktop\\project\\Java remastered\\JavaRemastered\\src\\music.properties"), StandardOpenOption.READ));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName(props.getProperty("serverName"));
        dataSource.setPort(Integer.parseInt(props.getProperty("port")));
        dataSource.setDatabaseName(props.getProperty("databaseName"));

        String albumName = "Tapestry";
        String query = "SELECT * FROM music.albumview WHERE album_name='%s'".formatted(albumName);

        try (Connection connection = dataSource.getConnection(props.getProperty("user"), (System.getenv("MYSQL_PASS")));
             Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.printf("%d %s %s %n", i, metaData.getColumnName(i), metaData.getColumnTypeName(i));
            }
            System.out.println("=========================");

            while (resultSet.next()) {
                System.out.printf("%d %s %s %n", resultSet.getInt("track_number"), resultSet.getString("artist_name"), resultSet.getString("song_title"));
            }

            System.out.println("SUCCESS!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
