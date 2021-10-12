package bank;

import java.util.List;

public interface Client {

    Account getAccount(long uniq);

    List<Account> getAccounts();

    List<DebitAccount> getDebitAccounts();

    List<CreditAccount> getCreditAccounts();

    double sumOfDebitAccounts();

    double sumOfDebt();

    List<Account> getAccountsWithNonNegativeBalance();

    void deleteAccount(long uniq);

    void addAccount(Account account);

    void addCreditAccount(CreditAccount creditAccount);

    void addDebitAccount(DebitAccount debitAccount);

    void subtractBalance(long uniq, double red);

    void refillBalance(long uniq, double inc);
}
