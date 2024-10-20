package LambdaInterfaces;

import java.util.ArrayList;
import java.util.List;

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

        int result = Calculator((a,b) -> a - b, 5, 2);


    }
    public static <T> T Calculator(Operation<T> function, T value1, T value2){
        T result = function.operate(value1, value2);
        System.out.println("Result of operation = " + result);
        return result;
    }
}
