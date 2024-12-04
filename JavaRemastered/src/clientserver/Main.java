package clientserver;

import java.nio.ByteBuffer;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

    }

    private static void doOperation(String op, ByteBuffer buffer, Consumer<ByteBuffer> c) {
        System.out.printf("%-30s", op);
        c.accept(buffer);
        System.out.printf("Capacity = %d, Limit = %d, Position = %d, Remaining = %d%d",
                buffer.capacity(),
                buffer.limit(),
                buffer.position(),
                buffer.remaining());
    }
}
