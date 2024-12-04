package clientserver.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            while (true) {
                try (Socket socket = serverSocket.accept();) {
                    System.out.println("Server accepts client connection");
                    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                    while (true) {
                        String echoString = input.readLine();
                        System.out.println("server got request data: " + echoString);
                        if (echoString.equals("exit")) break;
                        output.println("echo from server: " + echoString);
                    }
                }catch (IOException e){
                    System.out.println("Client socket resources closed here");
                }
            }
        } catch (IOException e) {
            System.out.println("server exception " + e.getMessage());
        }
    }
}
