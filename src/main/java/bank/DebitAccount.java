package bank;


public class DebitAccount extends Account {

    public DebitAccount(long unique_number) {
        super(unique_number);
    }

    public DebitAccount(long unique_number, double balance) {
        super(unique_number, balance);
    }

    public DebitAccount(long unique_number, double balance, double commission) {
        super(unique_number, balance, commission, Currency.RUB);
    }

    public DebitAccount(long unique_number, double balance, double commission, Currency currency) {
        super(unique_number, balance, commission, currency);
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
