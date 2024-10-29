package immutableClasses;

public class BankAccountMain {
    public static void main(String[] args) {
        // BankAccount bankAccount = new BankAccount(BankAccount.AccountType.CHECKING, 500);
        // System.out.println(bankAccount);

        BankCustomer bankCustomer = new BankCustomer("Suhail", 234.98, 1000);
        System.out.println(bankCustomer);
    }
}
