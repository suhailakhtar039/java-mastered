package LambdaInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CompleteChallenge {

    private static Random random = new Random();

    public static void main(String[] args) {
        String[] names = {"Anna", "Carol", "Baggage", "John", "Undertaker", "Ben", "Mihawk", "Ed", "Gary"};

        //1st
        System.out.println("Transform to UpperCase");
        Arrays.setAll(names, i -> names[i].toUpperCase());
        System.out.println(Arrays.toString(names));

        //2nd
        List<String> backedByArray = Arrays.asList(names);

        backedByArray.replaceAll(s -> s += " " + getRandomChar('A', 'D') + ".");
        System.out.println("---Add random initial---");
        System.out.println(backedByArray);

        backedByArray.replaceAll(s -> s += " " + getReversedName(s.split(" ")[0]));
        System.out.println("Front plus Last");
        System.out.println(backedByArray);
        // printing on names array
        Arrays.asList(names).forEach(s -> System.out.println(s));

        //final
        backedByArray.removeIf(s -> s.substring(0, s.indexOf(" ")).equals(s.substring(s.lastIndexOf(" ")+1))
        );
        System.out.println(backedByArray);
    }

    public static char getRandomChar(char startChar, char endChar){
        return (char) random.nextInt((int) startChar, (int) endChar+1);
    }
    private static String getReversedName(String firstName){
        return new StringBuilder(firstName).reverse().toString();
    }
}
