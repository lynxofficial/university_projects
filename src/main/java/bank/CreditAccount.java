package bank;

import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;

public class CreditAccount extends Account {
    private double percent;
    private long cardLimit;
    private double plusPercents;
    private double plusCommissions;

    public CreditAccount(long id) {
        super(id);
    }

    public CreditAccount(long id, double balance) {
        super(id, balance);
    }

    public CreditAccount(long id, double balance, double commission) {
        super(id, balance, commission, DEFAULT_CURRENCY);
    }

    public CreditAccount(long id, double balance, double commission, Currency currency) {
        super(id, balance, commission, currency);
    }

    public CreditAccount(long id, double balance, double commission, Currency currency, double percent, long cardLimit) {
        super(id, balance, commission, currency);
        this.percent = percent;
        this.cardLimit = cardLimit;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public long getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(long cardLimit) {
        this.cardLimit = cardLimit;
    }

    public double getPlusPercents() {
        return plusPercents;
    }

    public double getPlusCommissions() {
        return plusCommissions;
    }

    public void increasePercent(int year) {
        LocalDate localDate = LocalDate.of(year, Month.DECEMBER.getValue(), Month.JANUARY.maxLength());
        if (getBalance() < cardLimit) {
            plusPercents = (cardLimit - getBalance()) * (percent / localDate.getDayOfYear()) / 100;
        }
    }

    @Override
    public void subtractCommissionFromBalance() {
        plusCommissions += getCommission();
        setCommission(getCommission() + plusCommissions);
    }

    @Override
    public void refillAccount(double sum) {
        subtractBalance(plusCommissions + plusPercents);
        super.refillAccount(sum);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        CreditAccount that = (CreditAccount) object;
        return Double.compare(that.percent, percent) == 0 && Double.compare(that.plusPercents, plusPercents) == 0 && Double.compare(that.plusCommissions, plusCommissions) == 0 && cardLimit == that.cardLimit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(percent, plusPercents, plusCommissions, cardLimit);
    }

    @Override
    public String toString() {
        return "percent: " + percent + "\n" + "assessed_percents: " + plusPercents + "\n" + "assessed_commissions: " + plusCommissions + "\n" + "limit: " + cardLimit + "\n";
    }
}
