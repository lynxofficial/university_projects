package bank;

import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;

public class CreditAccount extends Account {
    private static final double DEFAULT_PERCENT = 0;
    private static final long DEFAULT_CARD_LIMIT = 0;
    private double percent;
    private long cardLimit;
    private double plusPercents;
    private double plusCommissions;

    public CreditAccount(long id) {
        this(id, DEFAULT_BALANCE, DEFAULT_COMMISSION, DEFAULT_CURRENCY, DEFAULT_PERCENT, DEFAULT_CARD_LIMIT);
    }

    public CreditAccount(long id, double balance) {
        this(id, balance, DEFAULT_COMMISSION, DEFAULT_CURRENCY, DEFAULT_PERCENT, DEFAULT_CARD_LIMIT);
    }

    public CreditAccount(long id, double balance, double commission) {
        this(id, balance, commission, DEFAULT_CURRENCY, DEFAULT_PERCENT, DEFAULT_CARD_LIMIT);
    }

    public CreditAccount(long id, double balance, double commission, Currency currency) {
        this(id, balance, commission, currency, DEFAULT_PERCENT, DEFAULT_CARD_LIMIT);
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
    }

    @Override
    public void refillAccount(double sum) {
        super.refillAccount(sum);
        subtractBalance(plusCommissions + plusPercents);
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
        return "percent: " + percent + "\n"
                + "plusPercents: " + plusPercents + "\n"
                + "plusCommissions: " + plusCommissions + "\n"
                + "cardLimit: " + cardLimit + "\n";
    }
}
