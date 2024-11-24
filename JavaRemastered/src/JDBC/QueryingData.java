package JDBC;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

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

        Scanner sc = new Scanner(System.in);
        String artistId = sc.nextLine();
        int artistid = Integer.parseInt(artistId);
        String query = "SELECT * FROM music.artists limit 10".formatted(artistid);

        try (Connection connection = dataSource.getConnection(props.getProperty("user"), (System.getenv("MYSQL_PASS")));
             Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            System.out.println("=========================");

            for(int i = 1; i<=metaData.getColumnCount(); i++){
                System.out.printf("%-15s", metaData.getColumnName(i).toUpperCase());
            }
            System.out.println();
            while (resultSet.next()) {
                for(int i = 1; i<=metaData.getColumnCount(); i++){
                    System.out.printf("%-15s", resultSet.getString(i));
                }
                System.out.println();
            }

            System.out.println("SUCCESS!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
