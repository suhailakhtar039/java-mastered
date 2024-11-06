package Thread;

public class Challenge1 {
    public static void main(String[] args) {
        Thread even = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println("EvenThread - " + i);
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    System.out.println("Even thread interrupted");
                    break;
                }
            }
        });

        OddThread oddThread = new OddThread();

        even.start();
        oddThread.start();

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        oddThread.interrupt();
    }
}

class OddThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i += 2) {
            System.out.println("Odd Thread: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Odd thread interrupted!");
                break;
            }
        }
    }
}
