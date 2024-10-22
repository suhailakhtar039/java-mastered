package Stream;


import java.util.stream.Stream;

public class BingoBallChallenge {
    public static void main(String[] args) {
        int seed = 1;
        Stream<String> streamB = Stream.iterate(seed, i -> i <= 15, i -> i + 1)
                .map(i -> "B" + i);
        // streamB.forEach(System.out::println);
        seed += 15;
        Stream<String> streamI = Stream.iterate(seed, i -> i + 1)
                .limit(15)
                .map(i -> "I" + i);

        seed += 15;
        Stream<String> streamN = Stream.iterate(seed, i -> i + 1)
                .limit(15)
                .map(i -> "N" + i);

        seed += 15;
        Stream<String> streamG = Stream.iterate(seed, i -> i + 1)
                .limit(15)
                .map(i -> "G" + i);

        seed += 15;
        Stream<String> streamO = Stream.iterate(seed, i -> i + 1)
                .limit(15)
                .map(i -> "O" + i);

        Stream<String> concat = Stream.concat(streamB, Stream.concat(streamI, Stream.concat(streamN, Stream.concat(streamG, streamO))));
        concat.forEach(System.out::println);
    }
}
