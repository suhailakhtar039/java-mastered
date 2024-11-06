package Thread;

public class Example1 {
    public static void main(String[] args) {
        System.out.println("Main thread are running");
        try {
            System.out.println("Main thread paused for one second");
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Main thread would continue here");
    }
}
