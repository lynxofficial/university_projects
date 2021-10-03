package bank;

import java.util.ArrayList;
import java.util.List;

public class NaturalClient implements Client {
    private String firstName;
    private String lastName;
    private String passport;
    private List<Account> accounts = new ArrayList<>();
    private List<DebitAccount> debitAccounts = new ArrayList<>();
    private List<CreditAccount> creditAccounts = new ArrayList<>();

    public NaturalClient(String firstName, String lastName, String passport) {
        this(firstName, lastName, passport, new ArrayList<>());
    }

    public NaturalClient(String firstName, String lastName, String passport, List<Account> accounts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
        this.accounts = accounts;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Account getAccount(long uniq) {
        for (Account account : accounts) {
            if (account.getUnique_number() == uniq) {
                return account;
            }
        }
        return new Account(uniq);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public long amountBalance() {
        long sum = 0;
        for (Account account : accounts) {
            if (account.getBalance() > 0) {
                sum += account.getBalance();
            }
        }
        return sum;
    }

    public List<Account> getPlusAccounts() {
        List<Account> plusAccounts = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getBalance() >= 0) {
                plusAccounts.add(account);
            }
        }
        return plusAccounts;
    }

    public void deleteAccount(long uniq) {
        for (Account account : accounts) {
            if (account.getUnique_number() == uniq) {
                accounts.remove(account);
                break;
            }
        }
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }


    public void addDebitAccount(DebitAccount debitAccount) {
        debitAccounts.add(debitAccount);
    }

    public void addCreditAccount(CreditAccount creditAccount) {
        creditAccounts.add(creditAccount);
    }

    public void reduceBalance(long uniq, double red) {
        for (Account account : accounts) {
            if (account.getUnique_number() == uniq) {
                account.decreaseBalance(red);
                break;
            }
        }
    }

    public void increaseBalance(long uniq, double inc) {
        for (Account account : accounts) {
            if (account.getUnique_number() == uniq) {
                account.replenishmentAccount(inc);
                break;
            }
        }
    }

    public List<DebitAccount> getDebitAccounts() {
        return debitAccounts;
    }

    public List<CreditAccount> getCreditAccounts() {
        return creditAccounts;
    }

    public double amountDebitAccounts() {
        double sum = 0;
        for (DebitAccount debitAccount : debitAccounts) {
            sum += debitAccount.getBalance();
        }
        return sum;
    }

    public double amountOfDebt() {
        double sum = 0;
        for (CreditAccount creditAccount : creditAccounts) {
            sum += creditAccount.getAssessed_commissions();
            sum += creditAccount.getAssessed_percents();
            if (creditAccount.getBalance() < 0) {
                sum += creditAccount.getBalance();
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        return "firstName: " + firstName + "\n" + "lastName: " + lastName + "\n" + "passport: " + passport + "\n";
    }
}
