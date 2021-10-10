package bank;

class Account {
    public static final int DEFAULT_BALANCE = 0;
    public static final int DEFAULT_COMMISSION = 0;
    public static final Currency DEFAULT_CURRENCY = Currency.RUB;
    private long uniqueNumber;
    private double balance = 0;
    private double commission;
    private Currency currency;
    private final Currency[] currencies = {Currency.USD, Currency.EUR, Currency.JOY, Currency.TRY, Currency.AED, Currency.RUB};
    private final double[][] currenciesCoefficients = {{1, 1.1, 0.009, 0.1, 0.2, 0.1}, {0.8, 1, 0.007, 0.09, 0.23, 0.01},
            {109.9, 128.9, 1, 12.5, 29.9, 1.5}, {8.7, 10.2, 0.07, 1, 2.3, 0.1},
            {3.6, 4.3, 0.03, 0.4, 1, 0.05}, {72.6, 85.2, 0.6, 8.3, 19.8, 1}};


    public Account(long uniqueNumber) {
        this(uniqueNumber, DEFAULT_BALANCE, DEFAULT_COMMISSION, DEFAULT_CURRENCY);
    }

    public Account(long uniqueNumber, double balance) {
        this(uniqueNumber, balance, DEFAULT_COMMISSION, DEFAULT_CURRENCY);
    }

    public Account(long uniqueNumber, double balance, double commission) {
        this(uniqueNumber, balance, commission, DEFAULT_CURRENCY);
    }

    public Account(long uniqueNumber, double balance, double commission, Currency currency) {
        this.uniqueNumber = uniqueNumber;
        this.balance = balance;
        this.commission = commission;
        this.currency = currency;
    }

    public long getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(long uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
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

    public int getIdCurrency(Currency currency) {
        int id = 0;
        for (int i = 0; i < currencies.length; i++) {
            if (currency == currencies[i]) {
                id = i;
                break;
            }
        }
        return id;
    }

    public void setCurrency(Currency currency) {
        int indexThisCurrency = getIdCurrency(this.currency);
        int indexNewCurrency = getIdCurrency(currency);
        this.currency = currency;
        commission *= currenciesCoefficients[indexNewCurrency][indexThisCurrency];
        balance *= currenciesCoefficients[indexNewCurrency][indexThisCurrency];
    }

    public void printCurrencyCoefficients() {
        for (int i = 0; i < currencies.length; i++) {
            System.out.print(String.format("%9s", currencies[i]));
        }
        System.out.println();
        for (int i = 0; i < currencies.length; i++) {
            System.out.print(currencies[i]);
            for (int j = 0; j < currencies.length; j++) {
                System.out.printf(" %7.2f", currenciesCoefficients[i][j]);
            }
            System.out.println();
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
