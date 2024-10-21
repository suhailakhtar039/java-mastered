package LambdaInterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class Lambda {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta"));

        for (String s : list)
            System.out.println(s);

        System.out.println("-".repeat(10));
        list.forEach(myString -> System.out.println(myString));

        System.out.println("-".repeat(10));
        list.forEach(myString -> {
            char first = myString.charAt(0);
            System.out.println(myString + " means " + first);
        });

        int result1 = Calculator((a, b) -> a - b, 5, 2);
        String result2 = Calculator((a, b) -> a.toUpperCase(Locale.ROOT) + " " + b.toUpperCase(), "Suhail", "Akhtar");

        List<double[]> coordinates = Arrays.asList(
                new double[]{2, 4.08},
                new double[]{23.1, 53.9},
                new double[]{-34.1, -4.230});

        coordinates.forEach(s -> System.out.println(Arrays.toString(s)));

        System.out.println("_".repeat(10));
        BiConsumer<Double, Double> p1 = (latitude, longitude) -> System.out.println("Latitude = " + latitude + " Longitude = " + longitude);

        double[] firstPoint = coordinates.get(0);
        processPoint(firstPoint[0], firstPoint[1], p1);
        System.out.println("-".repeat(10) + " starting predicate");


        Consumer<String> consumer = (String s) -> {
            String[] parts = s.split(",");
            System.out.println(Arrays.toString(parts));
        };

        String s = "123456789";

        UnaryOperator<String> function = (String source) -> {
            StringBuilder sb = new StringBuilder("");
            int n = source.length();
            for(int i = 0; i<n; i++){
                if(i%2 == 1)
                    sb.append(source.charAt(i));
            }
            return sb.toString();
        };
        String ans = function.apply(s);
        System.out.println(ans);
    }

    public static <T> T Calculator(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        System.out.println("Result of operation = " + result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {
        consumer.accept(t1, t2);
    }


}
