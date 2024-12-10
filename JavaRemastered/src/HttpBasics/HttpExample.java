package HttpBasics;

import java.io.IOException;
import java.net.URL;

public class HttpExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com");
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
