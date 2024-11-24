package JDBC;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class QueryingData {
    public static void main(String[] args) {

        Properties props = new Properties();
        try {
            props.load(Files.newInputStream(Path.of("C:\\Users\\Suhail Akhtar\\OneDrive\\Desktop\\project\\Java remastered\\JavaRemastered\\src\\music.properties")));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName(props.getProperty("serverName"));
        dataSource.setPort(Integer.parseInt(props.getProperty("port")));
        dataSource.setDatabaseName(props.getProperty("databaseName"));

        String query = "SELECT * FROM music.artists";

        try (Connection connection = dataSource.getConnection(props.getProperty("user"), (System.getenv("MYSQL_PASS")));
             Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                System.out.printf("%d %s %n", resultSet.getInt(1), resultSet.getString("artist_name"));
            }

            System.out.println("SUCCESS!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
