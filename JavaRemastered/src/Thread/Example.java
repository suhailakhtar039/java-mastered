package Thread;

import java.util.concurrent.TimeUnit;

public class Example {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        System.out.println(thread);
        printThreadState(thread);

        thread.setName("MainGuy");
        thread.setPriority(Thread.MAX_PRIORITY);
        printThreadState(thread);

        CustomThread customThread = new CustomThread();
        customThread.start();

        Runnable runnable = () -> {
            for (int i = 1; i <= 8; i++) {
                System.out.println(" 2 ");
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread myThread = new Thread(runnable);
        // Thread myThread = new Thread(
        //         () -> {
        //             for (int i = 1; i <= 8; i++) {
        //                 System.out.println(" 2 ");
        //                 try {
        //                     TimeUnit.MILLISECONDS.sleep(500);
        //                 } catch (InterruptedException e) {
        //                     e.printStackTrace();
        //                 }
        //             }
        //         }
        // );
        myThread.start();

        for (int i = 1; i <= 3; i++) {
            System.out.println(" 0 ");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("I am here");

    }

    public static void printThreadState(Thread thread) {
        System.out.println("_".repeat(10));

        System.out.println("Thread ID: " + thread.getId());
        System.out.println("Thread name: " + thread.getName());
        System.out.println("Thread priority: " + thread.getPriority());
        System.out.println("Thread state: " + thread.getState());
        System.out.println("Thread group: " + thread.getThreadGroup());
        System.out.println("Thread is alive: " + thread.isAlive());

        System.out.println("_".repeat(10));
    }

}
