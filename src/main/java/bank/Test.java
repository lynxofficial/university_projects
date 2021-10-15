package bank;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        AccountNumberGenerator accountNumberGenerator = new AccountNumberGenerator();
        Account account = new Account(accountNumberGenerator.getNext());
        System.out.println(account.getId());
        Account account1 = new Account(accountNumberGenerator.getNext(), 10000);
        Account account2 = new Account(accountNumberGenerator.getNext(), 12, 1);
        Account account3 = new Account(accountNumberGenerator.getNext(), 123, 12, Currency.AED);
        CreditAccount creditAccount = new CreditAccount(accountNumberGenerator.getNext());
        CreditAccount creditAccount1 = new CreditAccount(accountNumberGenerator.getNext(), 1);
        CreditAccount creditAccount2 = new CreditAccount(accountNumberGenerator.getNext(), 12, 1);
        CreditAccount creditAccount3 = new CreditAccount(accountNumberGenerator.getNext(), 123, 12, Currency.RUB);
        CreditAccount creditAccount4 = new CreditAccount(accountNumberGenerator.getNext(), 1234, 123, Currency.EUR, 1, 10000);
        DebitAccount debitAccount = new DebitAccount(accountNumberGenerator.getNext());
        DebitAccount debitAccount1 = new DebitAccount(accountNumberGenerator.getNext(), 1);
        DebitAccount debitAccount2 = new DebitAccount(accountNumberGenerator.getNext(), 12, 1);
        DebitAccount debitAccount3 = new DebitAccount(accountNumberGenerator.getNext(), 123, 12, Currency.USD);
        NaturalClient naturalClient = new NaturalClient("firstName1", "lastName1", "1234");
        NaturalClient naturalClient1 = new NaturalClient("firstName2", "lastName2", "4321", new ArrayList<Account>());
        System.out.println(account1.getId());
        account.setId(345);
        System.out.println(account3.getBalance());
        System.out.println(account3.getCommission());
        account.setCommission(12345);
        System.out.println(account3.getCurrency());
        account.setCurrency(Currency.EUR);
        account1.subtractCommissionFromBalance();
        account1.writeOffSum(1000);
        account1.refillAccount(12345);
        System.out.println(accountNumberGenerator.getCurrent());
        System.out.println(accountNumberGenerator.getNext());
        accountNumberGenerator.reset();
        System.out.println(creditAccount4.getPercent());
        creditAccount.setPercent(10);
        System.out.println(creditAccount4.getCardLimit());
        System.out.println(creditAccount4.getPlusPercents());
        System.out.println(creditAccount4.getPlusCommissions());
        creditAccount4.increasePercent(2015);
        creditAccount4.subtractCommissionFromBalance();
        creditAccount4.refillAccount(1000);
        System.out.println(creditAccount4.equals(creditAccount3));
        System.out.println(creditAccount4.hashCode());
        System.out.println(debitAccount.equals(debitAccount1));
        System.out.println(debitAccount.hashCode());
        naturalClient.addAccount(account);
        naturalClient.addAccount(account1);
        System.out.println(naturalClient.getAccount(1));
        System.out.println(naturalClient.getAccounts());
        System.out.println(naturalClient.totalBalance());
        System.out.println(naturalClient.getPlusBalancesAccounts());
        naturalClient.deleteAccount(1);
        naturalClient.addAccount(account1);
        naturalClient.addCreditAccount(creditAccount);
        naturalClient.addDebitAccount(debitAccount2);
        naturalClient.subtractBalance(1, 100);
        naturalClient.refillBalance(1, 1000);
        System.out.println(naturalClient.getDefiniteAccounts(true));
        System.out.println(naturalClient.getDefiniteAccounts(false));
        System.out.println(naturalClient.sumOfDebitAccounts());
        System.out.println(naturalClient.sumOfDebt());
        Account account4 = new Account(10, 1, 0, Currency.EUR);
        account4.setCurrency(Currency.RUB);
        System.out.println(account4.getBalance());
        double sum = 100;
        try {
            creditAccount4.writeOffSum(sum);
            if (sum > creditAccount4.getBalance()) {
                throw new InsufficientFundsException("Exception: The entered number is greater than the allowed");
            }
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        account.setBalance(10490);
        account.subtractBalance(1000);
        creditAccount.setCardLimit(100000);
        System.out.println(naturalClient.getFirstName());
        naturalClient.setFirstName("Hello");
        System.out.println(naturalClient.getLastName());
        naturalClient.setLastName("World");
        System.out.println(naturalClient.getPassport());
        naturalClient.setPassport("3716 75636");
    }
}
