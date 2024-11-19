package Thread;

import java.util.Random;

class MessageRepository {
    private String message;
    private boolean hasMessage = false;

    public synchronized String read() {
        while (!hasMessage) {

        }
        hasMessage = false;
        return message;
    }

    public synchronized void write(String message) {
        while (hasMessage) {

        }
        hasMessage = true;
        this.message = message;
    }

}

class MessageWriter implements Runnable {

    private MessageRepository outgoingMessage;
    private final String text = """
            Humpty Dumpty sat on the wall,
            Humpty Dumpty had a great fall,
            All the king's horses and all the king's men,
            Couldn't put humpty together again
            """;

    public MessageWriter(MessageRepository outgoingMessage) {
        this.outgoingMessage = outgoingMessage;
    }

    @Override
    public void run() {
        Random random = new Random();
        String []lines = text.split("\n");
        for(int i = 0;i<lines.length; i++){
            outgoingMessage.write(lines[i]);
            try{
                Thread.sleep(random.nextInt(500, 2000));
            }catch (InterruptedException e){
                System.out.println("got interrupted");
            }
        }
        outgoingMessage.write("Finished!");
    }
}

public class CustomerProducer {
    public static void main(String[] args) {

    }
}
