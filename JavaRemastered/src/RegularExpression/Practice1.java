package RegularExpression;

public class Practice1 {
    public static void main(String[] args) {
        String s = "Hello world";
        String ans = Practice1.format("%s %s", "Hello", "World!");
        // System.out.println(ans);

        String testString = "Anyone can Learn abc's, 123's and any regular expression";
        String replacement = "(-)";
        String[] patterns = {
                "[a-zA-Z]*$",
                "^[a-zA-Z]{3}",
                "[aA]ny\\b"
        };

        // for (String pattern : patterns) {
        //     String output = testString.replaceFirst(pattern, replacement);
        //     System.out.println("Pattern: " + pattern + " => " + output);
        // }

        // challenge 1
        // String ch1 = "Hello World.";
        // boolean t1 = ch1.matches("Hello World!");
        // System.out.println(t1);

        // challenge 2
        // String ch1 = "Hello world.";
        // boolean t1 = ch1.matches("[A-Z].*\\.");
        // System.out.println(t1);

        //challenge 3
        String ch1 = "The bike is red.";
        // ch1 = "Hello, friends and family: Welcome!";
        boolean t1 = ch1.matches("[A-Z].+[.?!]");
        System.out.println(t1);

    }

    private static String format(String regexp, String... args) {
        int index = 0;
        while (regexp.matches(".*%s.*")) {
            regexp = regexp.replaceFirst("%s", args[index++]);
        }
        return regexp;
    }
}
