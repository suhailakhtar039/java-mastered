package LambdaInterfaces;

import java.util.ArrayList;
import java.util.List;

public class MethodReference {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("ana", "bob", "mikey", "john"));
        System.out.println(list);

        list.forEach(System.out::println);
    }
}
