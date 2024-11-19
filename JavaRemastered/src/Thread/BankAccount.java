package Thread;

public class BankAccount {

    private double balance;
    private String name;
    private final Object lockName = new Object();
    private final Object lockBalance = new Object();

    public BankAccount(double balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        synchronized (lockName){
            this.name = name;
            System.out.println("Updated name = " + this.name);
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        try {
            System.out.println("Talking to the teller at the bank...");
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lockBalance) {
            double origBalance = balance;
            this.balance += amount;
            System.out.printf("STARTING BALANCE: %.0f, DEPOSIT (%.0f): NEW BALANCE = %.0f%n", origBalance, amount, balance);
            addPromoDollars(amount);
        }
    }

    private void addPromoDollars(double amount){
        if(amount >= 5000){
            synchronized (lockBalance){
                System.out.println("Congratulations! You earned a promotional deposit");
                balance += 25;
            }
        }
    }

    public synchronized void withdraw(double amount) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double origBalance = balance;
        if (balance >= amount) {
            this.balance -= amount;
            System.out.printf("STARTING BALANCE: %.0f, WITHDRAWAL (%.0f): NEW BALANCE = %.0f%n", origBalance, amount, balance);
        } else {
            System.out.printf("STARTING BALANCE: %.0f, WITHDRAWAL (%.0f): INSUFFICIENT FUND", origBalance, amount);
        }

    }

}
