package bank;


public class DebitAccount extends Account {

    public DebitAccount(long id) {
        super(id);
    }

    public DebitAccount(long id, double balance) {
        super(id, balance);
    }

    public DebitAccount(long id, double balance, double commission) {
        super(id, balance, commission);
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
