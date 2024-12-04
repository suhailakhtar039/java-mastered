package clientserver.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

public class SimpleServerChannel {
    public static void main(String[] args) {

        try(ServerSocketChannel serverChannel = ServerSocketChannel.open()){
            serverChannel.socket().bind(new InetSocketAddress(5000));

            System.out.println("Server is listening on port " + serverChannel.socket().getLocalPort());
        }catch (IOException e){
            System.out.println("Server Exception " + e.getMessage());
        }

    }
}
