package HttpBasics;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

import static java.net.HttpURLConnection.HTTP_OK;

public class SimpleHttpServer {
    public static void main(String[] args) {
        try {

            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

            server.createContext("/", exchange -> {
                String requestMethod = exchange.getRequestMethod();
                System.out.println("Request Method: " + requestMethod);

                String response =
                        """
                                <html>
                                    <body>
                                        <h1>Hello World from my HTTP Server</h1>
                                    </body>
                                </html>
                                """;

                byte[] bytes = response.getBytes();
                exchange.sendResponseHeaders(HTTP_OK, bytes.length);
                exchange.getResponseBody().write(bytes);
                exchange.close();
            });


            server.start();
            System.out.println("Server is listening on port 8080...");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
