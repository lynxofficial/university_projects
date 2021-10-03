package bank;

import java.util.List;

public interface Client {
    Account getAccount(long uniq);

    List<Account> getAccounts();

    List<DebitAccount> getDebitAccounts();

    List<CreditAccount> getCreditAccounts();

    double amountDebitAccounts();

    double amountOfDebt();

    List<Account> getPlusAccounts();

    void deleteAccount(long uniq);

    void addAccount(Account account);

    void addCreditAccount(CreditAccount creditAccount);

    void addDebitAccount(DebitAccount debitAccount);


    void reduceBalance(long uniq, double red);

    void increaseBalance(long uniq, double inc);
}
