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

        Thread thread = new Thread(()->{
            String tname = Thread.currentThread().getName();
            System.out.println(tname + " should take 10 dots to run");
            for(int i = 0; i<10; i++){
                System.out.println(".");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("whoops! " + tname + " got interrupted");
                    return;
                }
            }
            System.out.println(tname + " completed");
        });

        System.out.println(thread.getName() + " starting");
        thread.start();
        System.out.println("Main thread would continue here");

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        thread.interrupt();

    }
}
