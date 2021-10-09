package bank;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        AccountNumberGenerator accountNumberGenerator = new AccountNumberGenerator();
        Account account = new Account(accountNumberGenerator.getNext());
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
        System.out.println(account.getUnique_number());
        account.setUnique_number(345);
        System.out.println(account3.getBalance());
        System.out.println(account3.getCommission());
        account.setCommission(12345);
        System.out.println(account3.getCurrency());
        account.setCurrency(Currency.EUR);
        account1.reduceCommissionFromBalance();
        account1.writeOffSum(1000);
        account1.replenishmentAccount(12345);
        System.out.println(accountNumberGenerator.getCurrent());
        System.out.println(accountNumberGenerator.getNext());
        accountNumberGenerator.reset();
        System.out.println(creditAccount4.getPercent());
        creditAccount.setPercent(10);
        System.out.println(creditAccount4.getLimit());
        System.out.println(creditAccount4.getAssessed_percents());
        System.out.println(creditAccount4.getAssessed_commissions());
        creditAccount4.increasePercent(2015);
        creditAccount4.reduceCommissionFromBalance();
        creditAccount4.replenishmentAccount(1000);
        System.out.println(creditAccount4.equals(creditAccount3));
        System.out.println(creditAccount4.hashCode());
        System.out.println(debitAccount.equals(debitAccount1));
        System.out.println(debitAccount.hashCode());
        naturalClient.addAccount(account);
        naturalClient.addAccount(account1);
        System.out.println(naturalClient.getAccount(1));
        System.out.println(naturalClient.getAccounts());
        System.out.println(naturalClient.amountBalance());
        System.out.println(naturalClient.getPlusAccounts());
        naturalClient.deleteAccount(1);
        naturalClient.addAccount(account1);
        naturalClient.addCreditAccount(creditAccount);
        naturalClient.addDebitAccount(debitAccount2);
        naturalClient.reduceBalance(1, 100);
        naturalClient.increaseBalance(1, 1000);
        System.out.println(naturalClient.getDebitAccounts());
        System.out.println(naturalClient.getCreditAccounts());
        System.out.println(naturalClient.amountDebitAccounts());
        System.out.println(naturalClient.amountOfDebt());
        double sum = 100;
        try {
            if (sum > creditAccount4.getBalance()) {
                throw new InsufficientFundsException("Exception: The entered number is greater than the allowed");
            }
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        creditAccount4.writeOffSum(sum);
    }
}
