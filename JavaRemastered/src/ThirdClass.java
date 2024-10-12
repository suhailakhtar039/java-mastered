public class ThirdClass {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            LPAStudent s = new LPAStudent("abc" + i,
                    switch (i) {
                        case 1 -> "Mary";
                        case 2 -> "Carol";
                        case 3 -> "Tim";
                        case 4 -> "Harry";
                        default -> "anonymous";
                    }, "12/02/2000", "randomList"
            );
            System.out.println(s);
        }
    }
}
