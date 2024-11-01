package RegularExpression;

public class Practice1 {
    public static void main(String[] args) {
        String s = "Hello world";
        String ans = Practice1.format("%s %s", "Hello", "World!");
        // System.out.println(ans);

        String testString = "Anyone can Learn abc's, 123's and any regular expression";
        String replacement = "(-)";
        String[] patterns = {
                "abc",
                "123",
                "A"
        };
        for (String pattern : patterns) {
            String output = testString.replaceFirst(pattern, replacement);
            System.out.println("Pattern: " + pattern + " => " + output);
        }
    }

    private static String format(String regexp, String... args) {
        int index = 0;
        while (regexp.matches(".*%s.*")) {
            regexp = regexp.replaceFirst("%s", args[index++]);
        }
        return regexp;
    }
}
