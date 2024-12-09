package clientserver.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

public class ChannelSelectorService {
    public static void main(String[] args) {
        try(ServerSocketChannel serverChannel = ServerSocketChannel.open()){
            serverChannel.bind(new InetSocketAddress(5000));
            serverChannel.configureBlocking(false);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
