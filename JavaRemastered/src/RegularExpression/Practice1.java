package RegularExpression;

public class Practice1 {
    public static void main(String[] args) {
        String s = "Hello world";
        String ans = Practice1.format("%s %s", "Hello", "World!");
        System.out.println(ans);
    }
    private static String format(String regexp, String ...args){
        int index = 0;
        while(regexp.matches(".*%s.*")){
            regexp = regexp.replaceFirst("%s", args[index++]);
        }
        return regexp;
    }
}
