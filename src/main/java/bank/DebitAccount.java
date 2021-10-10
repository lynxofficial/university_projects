package bank;


public class DebitAccount extends Account {

    public DebitAccount(long uniqueNumber) {
        super(uniqueNumber);
    }

    public DebitAccount(long uniqueNumber, double balance) {
        super(uniqueNumber, balance);
    }

    public DebitAccount(long uniqueNumber, double balance, double commission) {
        super(uniqueNumber, balance, commission);
    }

    public DebitAccount(long uniqueNumber, double balance, double commission, Currency currency) {
        super(uniqueNumber, balance, commission, currency);
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
