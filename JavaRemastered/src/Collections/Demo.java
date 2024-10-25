package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        String[] names = {"Anna", "Bob", "Carol", "David", "Edna"};

        list.addAll(Arrays.asList(names));
        System.out.println(list);
    }
}
