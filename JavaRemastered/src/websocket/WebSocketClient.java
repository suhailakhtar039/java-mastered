package websocket;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class WebSocketClient {
    public static void main(String[] args) throws URISyntaxException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name to enter: ");
        String name = scanner.nextLine();

        HttpClient client = HttpClient.newHttpClient();
        WebSocket webSocket = client.newWebSocketBuilder()
                .buildAsync(new URI("ws://localhost:8080?name=%s".formatted(name)),
                        new WebSocket.Listener() {

                        }).join();

        while(true){
            String input = scanner.nextLine();
            if("bye".equalsIgnoreCase(input)){
                try {
                    webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "User left normally!").get();
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
                break;
            }else {
                webSocket.sendText(input, true);
            }
        }

    }
}
