package Thread;

public class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        double origBalance = balance;
        this.balance += amount;
        System.out.printf("STARTING BALANCE: %.0f, DEPOSIT (%.0f): NEW BALANCE = %.0f%n", origBalance, amount, balance);

    }

    public void withdraw(double amount){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        double origBalance = balance;
        if(balance >= amount){
            this.balance -= amount;
            System.out.printf("STARTING BALANCE: %.0f, WITHDRAWAL (%.0f): NEW BALANCE = %.0f%n", origBalance, amount, balance);
        }
        else{
            System.out.printf("STARTING BALANCE: %.0f, WITHDRAWAL (%.0f): INSUFFICIENT FUND", origBalance, amount);
        }

    }

}
