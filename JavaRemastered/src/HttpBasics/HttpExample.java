package HttpBasics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent","Chrome");
            connection.setRequestProperty("Accept","application/json,text/html");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
