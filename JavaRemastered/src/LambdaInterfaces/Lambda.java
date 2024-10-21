package LambdaInterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.BinaryOperator;

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

    }

    public static <T> T Calculator(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        System.out.println("Result of operation = " + result);
        return result;
    }
}
