package bank;


public class DebitAccount extends Account {

    public DebitAccount(long unique_number) {
        super(unique_number);
        remainder = 0;
    }

    public DebitAccount(long unique_number, double remainder) {
        super(unique_number, remainder);
    }

    public DebitAccount(long unique_number, double remainder, double commission) {
        super(unique_number, remainder);
        setCommission(commission);
        setCurrency(Currency.RUB);
    }

    public DebitAccount(long unique_number, double remainder, double commission, Currency currency) {
        super(unique_number, remainder);
        this.remainder = remainder;
        setCommission(commission);
        setCurrency(currency);
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
