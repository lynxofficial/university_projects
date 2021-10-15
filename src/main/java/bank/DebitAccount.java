package bank;


public class DebitAccount extends Account {

    public DebitAccount(long id) {
        this(id, DEFAULT_BALANCE, DEFAULT_COMMISSION, DEFAULT_CURRENCY);
    }

    public DebitAccount(long id, double balance) {
        this(id, balance, DEFAULT_COMMISSION, DEFAULT_CURRENCY);
    }

    public DebitAccount(long id, double balance, double commission) {
        this(id, balance, commission, DEFAULT_CURRENCY);
    }

    public DebitAccount(long id, double balance, double commission, Currency currency) {
        super(id, balance, commission, currency);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
