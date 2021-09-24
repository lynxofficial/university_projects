package bank;

import java.util.ArrayList;

public interface Client {
    Account getAccount(long uniq);

    ArrayList<Account> getAccounts();

    ArrayList<DebitAccount> getDebitAccounts();

    ArrayList<CreditAccount> getCreditAccounts();

    double ammountDebitAccounts();

    double ammountOfDebt();

    ArrayList<Account> getAccountsPositive();

    void deleteAccount(long uniq);

    void addAccount(Account account);

    void addCreditAccount(CreditAccount creditAccount);

    void addDebitAccount(DebitAccount debitAccount);


    void reduceBalance(long uniq, double red);

    void increaseBalance(long uniq, double inc);
}
