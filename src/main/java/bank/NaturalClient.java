package bank;

import java.util.ArrayList;

public class NaturalClient implements Client {
    public String firstName, lastName, passport;
    public ArrayList<Account> accounts = new ArrayList<Account>();
    public ArrayList<DebitAccount> debitAccounts = new ArrayList<DebitAccount>();
    public ArrayList<CreditAccount> creditAccounts = new ArrayList<CreditAccount>();

    public NaturalClient(String firstName, String lastName, String passport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
        accounts = new ArrayList<Account>();
    }

    public NaturalClient(String firstName, String lastName, String passport, ArrayList<Account> accounts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
        this.accounts = accounts;
    }

    public Account getAccount(long uniq) {
        for (Account account : accounts) {
            if (account.unique_number == uniq) {
                return account;
            }
        }
        return new Account(uniq);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public long ammountRemainder() {
        long sum = 0;
        for (Account account : accounts) {
            if (account.remainder > 0) {
                sum += account.remainder;
            }
        }
        return sum;
    }

    public ArrayList<Account> getAccountsPositive() {
        ArrayList<Account> accounts_new = new ArrayList<>();
        for (Account account : accounts) {
            if (account.remainder >= 0) {
                accounts_new.add(account);
            }
        }
        return accounts_new;
    }

    public void deleteAccount(long uniq) {
        for (Account account : accounts) {
            if (account.unique_number == uniq) {
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
            if (account.unique_number == uniq) {
                account.remainder -= red;
                break;
            }
        }
    }

    public void increaseBalance(long uniq, double inc) {
        for (Account account : accounts) {
            if (account.unique_number == uniq) {
                account.remainder += inc;
                break;
            }
        }
    }

    public ArrayList<DebitAccount> getDebitAccounts() {
        return debitAccounts;
    }

    public ArrayList<CreditAccount> getCreditAccounts() {
        return creditAccounts;
    }

    public double ammountDebitAccounts() {
        double sum = 0;
        for (DebitAccount debitAccount : debitAccounts) {
            sum += debitAccount.remainder;
        }
        return sum;
    }

    public double ammountOfDebt() {
        double sum = 0;
        for (CreditAccount creditAccount : creditAccounts) {
            sum += creditAccount.getAssessed_commissions();
            sum += creditAccount.getAssessed_procents();
            if (creditAccount.remainder < 0) {
                sum += creditAccount.remainder;
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        return "firstName: " + firstName + "\n" + "lastName: " + lastName + "\n" + "passport: " + passport + "\n";
    }
}
