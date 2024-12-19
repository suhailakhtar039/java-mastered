package websocket;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

public class SimpleWebSocketServer extends WebSocketServer {

    public static final int SERVER_PORT = 8080;

    public SimpleWebSocketServer() {
        super(new InetSocketAddress(SERVER_PORT));
    }

    public static void main(String[] args) {
        SimpleWebSocketServer server = new SimpleWebSocketServer();
        server.start();
    }

    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        System.out.println("Server opened " + webSocket.getRemoteSocketAddress());
    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        System.out.println("Server closed " + webSocket.getRemoteSocketAddress());
    }

    @Override
    public void onMessage(WebSocket webSocket, String s) {
        System.out.println("Message received " + webSocket.getRemoteSocketAddress());
    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {
        System.out.println("Error for " + webSocket.getRemoteSocketAddress());
    }

    @Override
    public void onStart() {
        System.out.println("Server listening on port " + getPort());
    }
}