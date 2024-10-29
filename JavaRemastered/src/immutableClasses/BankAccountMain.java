package immutableClasses;

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(BankAccount.AccountType.CHECKING, 500);
        System.out.println(bankAccount);
    }
}
