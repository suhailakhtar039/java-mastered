package clientserver.client;

import java.io.IOException;
import java.net.DatagramSocket;

public class UDPAudioClient {

    private static final int SERVER_PORT = 5000;
    private static final int PACKET_SIZE = 1024;

    public static void main(String[] args) {
        try (DatagramSocket clientSocket = new DatagramSocket()) {

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
