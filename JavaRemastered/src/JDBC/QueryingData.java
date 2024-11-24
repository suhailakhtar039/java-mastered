package JDBC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

public class QueryingData {
    public static void main(String[] args) {

        Properties props = new Properties();
        try{
            props.load(Files.newInputStream(Path.of("C:\\Users\\Suhail Akhtar\\OneDrive\\Desktop\\project\\Java remastered\\JavaRemastered\\src\\music.properties")));

        }catch (IOException e){
            throw new RuntimeException(e);
        }


    }
}
