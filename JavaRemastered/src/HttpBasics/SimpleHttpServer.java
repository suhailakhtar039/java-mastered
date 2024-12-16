package HttpBasics;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class SimpleHttpServer {
    public static void main(String[] args) {
        try {

            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

            server.createContext("/", exchange -> {
                String requestMethod = exchange.getRequestMethod();
                System.out.println("Request Method: " + requestMethod);
            });

            server.start();
            System.out.println("Server is listening on port 8080...");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
