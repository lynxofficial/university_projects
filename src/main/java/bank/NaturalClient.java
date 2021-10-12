package bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NaturalClient implements Client {
    private String firstName;
    private String lastName;
    private String passport;
    private List<Account> accounts = new ArrayList<>();

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
            if (account.getId() == uniq) {
                return account;
            }
        }
        return new Account(uniq);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public long totalBalance() {
        long sum = 0;
        for (Account account : accounts) {
            if (account.getBalance() > 0) {
                sum += account.getBalance();
            }
        }
        return sum;
    }

    public List<Account> getAccountsWithNonNegativeBalance() {
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
            if (account.getId() == uniq) {
                accounts.remove(account);
                break;
            }
        }
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }


    public void addDebitAccount(DebitAccount debitAccount) {
        accounts.add(debitAccount);
    }

    public void addCreditAccount(CreditAccount creditAccount) {
        accounts.add(creditAccount);
    }

    public void subtractBalance(long uniq, double red) {
        for (Account account : accounts) {
            if (account.getId() == uniq) {
                account.subtractBalance(red);
                break;
            }
        }
    }

    public void refillBalance(long uniq, double inc) {
        for (Account account : accounts) {
            if (account.getId() == uniq) {
                account.refillAccount(inc);
                break;
            }
        }
    }

    public List<DebitAccount> getDebitAccounts() {
        List<DebitAccount> debitAccounts = new ArrayList<>();
        for (Account account : accounts) {
            if (account instanceof DebitAccount) {
                debitAccounts.add((DebitAccount) account);
            }
        }
        return debitAccounts;
    }

    public List<CreditAccount> getCreditAccounts() {
        List<CreditAccount> creditAccounts = new ArrayList<>();
        for (Account account : accounts) {
            if (account instanceof CreditAccount) {
                creditAccounts.add((CreditAccount) account);
            }
        }
        return creditAccounts;
    }

    public double sumOfDebitAccounts() {
        double sum = 0;
        for (Account account : accounts) {
            if (account instanceof DebitAccount) {
                sum += account.getBalance();
            }
        }
        return sum;
    }

    public double sumOfDebt() {
        double sum = 0;
        for (Account account : accounts) {
            if (account instanceof CreditAccount) {
                sum += ((CreditAccount) account).getPlusCommissions();
                sum += ((CreditAccount) account).getPlusPercents();
                if (account.getBalance() < 0) {
                    sum += account.getBalance();
                }
            }
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NaturalClient that = (NaturalClient) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(passport, that.passport) && Objects.equals(accounts, that.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, passport, accounts);
    }

    @Override
    public String toString() {
        return "firstName: " + firstName + "\n" + "lastName: " + lastName + "\n" + "passport: " + passport + "\n";
    }
}
