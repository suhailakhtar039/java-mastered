public class SecondClass {
    public static void main(String[] args) {
        Account account = new Account();
        account.setAccountBalance(10);
        account.setAccountNumber(123);
        account.setEmail("abc");
        account.setCustomerName("suhail");
        account.setPhoneNumber(1234567890);
        System.out.println(account);

        account.depositFund(100);
        System.out.println(account);

        account.withdrawBalance(500);
        System.out.println(account);
    }
}
