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
                System.out.println(" . ");
                try {
                    Thread.sleep(400);
                    System.out.println("A. state = " + Thread.currentThread().getState());
                } catch (InterruptedException e) {
                    System.out.println("whoops! " + tname + " got interrupted");
                    System.out.println("A1. state = " + Thread.currentThread().getState());
                    return;
                }
            }
            System.out.println(tname + " completed");
        });

        System.out.println(thread.getName() + " starting");
        thread.start();

        long now = System.currentTimeMillis();
        while(thread.isAlive()){
            System.out.println("Waiting for thread to complete");
            try {
                Thread.sleep(1000);
                System.out.println("B. state = " + thread.getState());
                if(System.currentTimeMillis() - now > 2000)
                    thread.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("C. state = " + thread.getState());

        // System.out.println("Main thread would continue here");
        // try {
        //     Thread.sleep(2000);
        // }catch (InterruptedException e){
        //     e.printStackTrace();
        // }
        // thread.interrupt();

    }
}
