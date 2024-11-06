package Thread;

public class Example {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        System.out.println(thread);
        printThreadState(thread);

        thread.setName("MainGuy");
        thread.setPriority(Thread.MAX_PRIORITY);

    }

    public static void printThreadState(Thread thread){
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
