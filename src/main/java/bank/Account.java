package bank;

public class Account {
    public long unique_number;
    public double remainder;
    private double commission;
    private Currency currency;


    public Account(long unique_number) {
        this.unique_number = unique_number;
        remainder = 0;
    }

    public Account(long unique_number, double remainder) {
        this.unique_number = unique_number;
        this.remainder = remainder;
    }

    public Account(long unique_number, double remainder, double commission) {
        this.unique_number = unique_number;
        this.remainder = remainder;
        this.commission = commission;
        currency = Currency.RUB;
    }

    public Account(long unique_number, double remainder, double commission, Currency currency) {
        this.unique_number = unique_number;
        this.remainder = remainder;
        this.commission = commission;
        this.currency = currency;
    }

    public long getUnique_number() {
        return unique_number;
    }

    public void setUnique_number(long Unique_number) {
        unique_number = Unique_number;
    }

    public double getRemainder() {
        return remainder;
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
                remainder *= 0.05;
            } else if (currency == Currency.EUR) {
                this.currency = currency;
                commission *= 0.01;
                remainder *= 0.01;
            } else if (currency == Currency.JOY) {
                this.currency = currency;
                commission *= 1.5;
                remainder *= 1.5;
            } else if (currency == Currency.TRY) {
                this.currency = currency;
                commission *= 0.1;
                remainder *= 0.1;
            } else if (currency == Currency.USD) {
                this.currency = currency;
                commission *= 0.1;
                remainder *= 0.1;
            }
        } else if (this.currency == Currency.AED) {
            if (currency == Currency.RUB) {
                this.currency = currency;
                commission *= 19.8;
                remainder *= 19.8;
            } else if (currency == Currency.EUR) {
                this.currency = currency;
                commission *= 0.23;
                remainder *= 0.23;
            } else if (currency == Currency.JOY) {
                this.currency = currency;
                commission *= 29.9;
                remainder *= 29.9;
            } else if (currency == Currency.TRY) {
                this.currency = currency;
                commission *= 2.3;
                remainder *= 2.3;
            } else if (currency == Currency.USD) {
                this.currency = currency;
                commission *= 0.2;
                remainder *= 0.2;
            }
        } else if (this.currency == Currency.EUR) {
            if (currency == Currency.RUB) {
                this.currency = currency;
                commission *= 85.2;
                remainder *= 85.2;
            } else if (currency == Currency.AED) {
                this.currency = currency;
                commission *= 4.3;
                remainder *= 4.3;
            } else if (currency == Currency.JOY) {
                this.currency = currency;
                commission *= 128.9;
                remainder *= 128.9;
            } else if (currency == Currency.TRY) {
                this.currency = currency;
                commission *= 10.2;
                remainder *= 10.2;
            } else if (currency == Currency.USD) {
                this.currency = currency;
                commission *= 1.1;
                remainder *= 1.1;
            }
        } else if (this.currency == Currency.JOY) {
            if (currency == Currency.RUB) {
                this.currency = currency;
                commission *= 0.6;
                remainder *= 0.6;
            } else if (currency == Currency.AED) {
                this.currency = currency;
                commission *= 0.03;
                remainder *= 0.03;
            } else if (currency == Currency.EUR) {
                this.currency = currency;
                commission *= 0.007;
                remainder *= 0.007;
            } else if (currency == Currency.TRY) {
                this.currency = currency;
                commission *= 0.07;
                remainder *= 0.07;
            } else if (currency == Currency.USD) {
                this.currency = currency;
                commission *= 0.009;
                remainder *= 0.009;
            }
        } else if (this.currency == Currency.TRY) {
            if (currency == Currency.RUB) {
                this.currency = currency;
                commission *= 8.3;
                remainder *= 8.3;
            } else if (currency == Currency.AED) {
                this.currency = currency;
                commission *= 0.4;
                remainder *= 0.4;
            } else if (currency == Currency.EUR) {
                this.currency = currency;
                commission *= 0.09;
                remainder *= 0.09;
            } else if (currency == Currency.JOY) {
                this.currency = currency;
                commission *= 12.5;
                remainder *= 12.5;
            } else if (currency == Currency.USD) {
                this.currency = currency;
                commission *= 0.1;
                remainder *= 0.1;
            }
        } else if (this.currency == Currency.USD) {
            if (currency == Currency.RUB) {
                this.currency = currency;
                commission *= 72.7;
                remainder *= 72.7;
            } else if (currency == Currency.AED) {
                this.currency = currency;
                commission *= 3.6;
                remainder *= 3.6;
            } else if (currency == Currency.EUR) {
                this.currency = currency;
                commission *= 0.8;
                remainder *= 0.8;
            } else if (currency == Currency.JOY) {
                this.currency = currency;
                commission *= 109.9;
                remainder *= 109.9;
            } else if (currency == Currency.TRY) {
                this.currency = currency;
                commission *= 8.7;
                remainder *= 8.7;
            }
        }
    }

    public void reduceCommissionFromRemainder() {
        remainder -= commission;
    }

    public void writeOffSum(double sum) {
        try {
            if (sum > remainder) {
                throw new InsufficientFundsException();
            }
        } catch (InsufficientFundsException e) {
            System.err.println("Exception: The entered number is greater than the allowed");
        }
        remainder -= sum;
    }

    public void replenishmentAccount(double sum) {
        remainder += sum;
    }

}
