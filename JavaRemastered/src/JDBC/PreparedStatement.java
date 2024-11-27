package JDBC;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class PreparedStatement {
    public static void main(String[] args) {
        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("music");
        try {
            dataSource.setContinueBatchOnError(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try(Connection connection = dataSource.getConnection("devuser", System.getenv("MYSQL_PASS"))){

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
