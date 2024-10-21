package LambdaInterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

class PlainOld{
    private static int last_id = 1;
    private int id;
    PlainOld(){
        id = PlainOld.last_id++;
        System.out.println("Object created having id = " + id);
    }
}

public class MethodReference {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("ana", "bob", "mikey", "john"));
        // System.out.println(list);

        // list.forEach(System.out::println);

        Supplier<PlainOld> reference = PlainOld::new;

        PlainOld pojo = reference.get();

        System.out.println("Getting array: ");
        PlainOld[] plainOlds = seedArray(PlainOld::new, 10);

        calculator((a, b)->a+b, "suhail", "akhtar");
        calculator(String::concat, "Hello ", "World!");

        BinaryOperator<String> b1 = String::concat;
        BiFunction<String, String, String> b2 = String::concat;
        UnaryOperator<String> u1 = String::toUpperCase;

        // applying those functions
        System.out.println(b1.apply("Hello"," method reference b1"));
        System.out.println(b2.apply("Hello", "b2"));
        System.out.println(u1.apply("unary"));

        String result = "Hello".transform(u1);
        System.out.println("Result = " + result);

        result = result.transform(String::toLowerCase);
        System.out.println("Result = " + result);

        Function<String, Boolean> f0 = String::isEmpty;
        boolean resultBoolean = result.transform(f0);
        System.out.println("Result = " + resultBoolean);


    }

    private static <T> void calculator(BinaryOperator<T> function, T first, T second){
        T result = function.apply(first, second);
        System.out.println("After applying operation result = " + result);
    }

    private static PlainOld[] seedArray(Supplier<PlainOld> reference, int count){
        PlainOld[] array = new PlainOld[count];
        Arrays.setAll(array, i -> reference.get());
        return array;
    }

}
