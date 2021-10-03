package bank;

class Account {
    private long unique_number;
    private double balance = 0;
    private double commission;
    private Currency currency;


    public Account(long unique_number) {
        this(unique_number, 0, 0, Currency.RUB);
    }

    public Account(long unique_number, double balance) {
        this(unique_number, balance, 0, Currency.RUB);
    }

    public Account(long unique_number, double balance, double commission) {
        this(unique_number, balance, commission, Currency.RUB);
    }

    public Account(long unique_number, double balance, double commission, Currency currency) {
        this.unique_number = unique_number;
        this.balance = balance;
        this.commission = commission;
        this.currency = currency;
    }

    public long getUnique_number() {
        return unique_number;
    }

    public void setUnique_number(long Unique_number) {
        unique_number = Unique_number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double decreaseBalance(double decr) {
        return balance -= decr;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        if (this.currency == Currency.RUB) {
            if (currency == Currency.AED) {
                this.currency = currency;
                commission *= 0.05;
                balance *= 0.05;
            } else if (currency == Currency.EUR) {
                this.currency = currency;
                commission *= 0.01;
                balance *= 0.01;
            } else if (currency == Currency.JOY) {
                this.currency = currency;
                commission *= 1.5;
                balance *= 1.5;
            } else if (currency == Currency.TRY) {
                this.currency = currency;
                commission *= 0.1;
                balance *= 0.1;
            } else if (currency == Currency.USD) {
                this.currency = currency;
                commission *= 0.1;
                balance *= 0.1;
            }
        } else if (this.currency == Currency.AED) {
            if (currency == Currency.RUB) {
                this.currency = currency;
                commission *= 19.8;
                balance *= 19.8;
            } else if (currency == Currency.EUR) {
                this.currency = currency;
                commission *= 0.23;
                balance *= 0.23;
            } else if (currency == Currency.JOY) {
                this.currency = currency;
                commission *= 29.9;
                balance *= 29.9;
            } else if (currency == Currency.TRY) {
                this.currency = currency;
                commission *= 2.3;
                balance *= 2.3;
            } else if (currency == Currency.USD) {
                this.currency = currency;
                commission *= 0.2;
                balance *= 0.2;
            }
        } else if (this.currency == Currency.EUR) {
            if (currency == Currency.RUB) {
                this.currency = currency;
                commission *= 85.2;
                balance *= 85.2;
            } else if (currency == Currency.AED) {
                this.currency = currency;
                commission *= 4.3;
                balance *= 4.3;
            } else if (currency == Currency.JOY) {
                this.currency = currency;
                commission *= 128.9;
                balance *= 128.9;
            } else if (currency == Currency.TRY) {
                this.currency = currency;
                commission *= 10.2;
                balance *= 10.2;
            } else if (currency == Currency.USD) {
                this.currency = currency;
                commission *= 1.1;
                balance *= 1.1;
            }
        } else if (this.currency == Currency.JOY) {
            if (currency == Currency.RUB) {
                this.currency = currency;
                commission *= 0.6;
                balance *= 0.6;
            } else if (currency == Currency.AED) {
                this.currency = currency;
                commission *= 0.03;
                balance *= 0.03;
            } else if (currency == Currency.EUR) {
                this.currency = currency;
                commission *= 0.007;
                balance *= 0.007;
            } else if (currency == Currency.TRY) {
                this.currency = currency;
                commission *= 0.07;
                balance *= 0.07;
            } else if (currency == Currency.USD) {
                this.currency = currency;
                commission *= 0.009;
                balance *= 0.009;
            }
        } else if (this.currency == Currency.TRY) {
            if (currency == Currency.RUB) {
                this.currency = currency;
                commission *= 8.3;
                balance *= 8.3;
            } else if (currency == Currency.AED) {
                this.currency = currency;
                commission *= 0.4;
                balance *= 0.4;
            } else if (currency == Currency.EUR) {
                this.currency = currency;
                commission *= 0.09;
                balance *= 0.09;
            } else if (currency == Currency.JOY) {
                this.currency = currency;
                commission *= 12.5;
                balance *= 12.5;
            } else if (currency == Currency.USD) {
                this.currency = currency;
                commission *= 0.1;
                balance *= 0.1;
            }
        } else if (this.currency == Currency.USD) {
            if (currency == Currency.RUB) {
                this.currency = currency;
                commission *= 72.7;
                balance *= 72.7;
            } else if (currency == Currency.AED) {
                this.currency = currency;
                commission *= 3.6;
                balance *= 3.6;
            } else if (currency == Currency.EUR) {
                this.currency = currency;
                commission *= 0.8;
                balance *= 0.8;
            } else if (currency == Currency.JOY) {
                this.currency = currency;
                commission *= 109.9;
                balance *= 109.9;
            } else if (currency == Currency.TRY) {
                this.currency = currency;
                commission *= 8.7;
                balance *= 8.7;
            }
        }
    }

    public void reduceCommissionFromBalance() {
        balance -= commission;
    }

    public void writeOffSum(double sum) {
        balance -= sum;
    }

    public void replenishmentAccount(double sum) {
        balance += sum;
    }
}
