package bank;

import java.util.List;

public interface Client {

    Account getAccount(long id);

    List<Account> getAccounts();

    List<? extends Account> getDefiniteAccounts(boolean flag);


    double sumOfDebitAccounts();

    double sumOfDebt();

    List<Account> getPlusBalancesAccounts();

    void deleteAccount(long id);

    void addAccount(Account account);

    void addCreditAccount(CreditAccount creditAccount);

    void addDebitAccount(DebitAccount debitAccount);

    void subtractBalance(long id, double red);

    void refillBalance(long id, double inc);
}
