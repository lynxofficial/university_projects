package bank;

class Account {
    protected static final double DEFAULT_BALANCE = 0;
    protected static final double DEFAULT_COMMISSION = 0;
    protected static final Currency DEFAULT_CURRENCY = Currency.RUB;
    private long id;
    private double balance;
    private double commission;
    private Currency currency;
    private final double[][] currenciesCoefficients = {{1, 1.1, 0.009, 0.1, 0.2, 0.1}, {0.8, 1, 0.007, 0.09, 0.23, 0.01},
            {109.9, 128.9, 1, 12.5, 29.9, 1.5}, {8.7, 10.2, 0.07, 1, 2.3, 0.1},
            {3.6, 4.3, 0.03, 0.4, 1, 0.05}, {72.6, 85.2, 0.6, 8.3, 19.8, 1}};


    public Account(long id) {
        this(id, DEFAULT_BALANCE, DEFAULT_COMMISSION, DEFAULT_CURRENCY);
    }

    public Account(long id, double balance) {
        this(id, balance, DEFAULT_COMMISSION, DEFAULT_CURRENCY);
    }

    public Account(long id, double balance, double commission) {
        this(id, balance, commission, DEFAULT_CURRENCY);
    }

    public Account(long id, double balance, double commission, Currency currency) {
        this.id = id;
        this.balance = balance;
        this.commission = commission;
        this.currency = currency;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void subtractBalance(double balance) {
        this.balance -= balance;
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

    public int getCurrencyId(Currency currency) {
        int id = 0;
        for (int i = 0; i < Currency.values().length; i++) {
            if (currency == Currency.values()[i]) {
                id = i;
                break;
            }
        }
        return id;
    }

    public void setCurrency(Currency currency) {
        int indexThisCurrency = getCurrencyId(this.currency);
        int indexNewCurrency = getCurrencyId(currency);
        this.currency = currency;
        commission *= currenciesCoefficients[indexNewCurrency][indexThisCurrency];
        balance *= currenciesCoefficients[indexNewCurrency][indexThisCurrency];
    }

    public void subtractCommissionFromBalance() {
        balance -= commission;
    }

    public void writeOffSum(double sum) {
        balance -= sum;
    }

    public void refillAccount(double sum) {
        balance += sum;
    }
}
