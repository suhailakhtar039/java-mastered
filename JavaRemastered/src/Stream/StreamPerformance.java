package Stream;

import java.util.*;
import java.util.stream.Stream;

public class StreamPerformance {
    public static void main(String[] args) {
        List<String> bingoPool = new ArrayList<>(75);
        int start = 1;
        for (char c : "BINGO".toCharArray()) {
            for (int i = start; i < start + 15; i++) {
                bingoPool.add("" + c + i);
                // System.out.println("" + c + i);
            }
            start += 15;
        }

        Collections.shuffle(bingoPool);
        for (int i = 0; i < 15; i++)
            System.out.println(bingoPool.get(i));

        System.out.println("-".repeat(20));

        // List<String> firstOnes = bingoPool.subList(0, 15);
        List<String> firstOnes = new ArrayList<>(bingoPool.subList(0, 15));
        firstOnes.sort(Comparator.naturalOrder());

        firstOnes.replaceAll(s -> {
            if (s.indexOf('G') == 0 || s.indexOf('O') == 0) {
                String updated = s.charAt(0) + "-" + s.substring(1);
                System.out.print(updated + " ");
                return updated;
            }
            return s;
        });

        System.out.println();
        System.out.println("-".repeat(20));

        Stream<String> sorted = bingoPool.stream()
                .limit(15)
                .filter(s -> s.indexOf("G") == 0 || s.indexOf("O") == 0)
                .map(s -> s.charAt(0) + "-" + s.substring(1))
                .sorted();

        sorted.forEach(s -> System.out.print(s + " "));
        System.out.println();
        String[] strings = {"One", "Two", "Three"};
        Arrays.stream(strings)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        Stream.of("six", "five", "four")
                .map(String::toUpperCase)
                .forEach(System.out::println);

    }
}
