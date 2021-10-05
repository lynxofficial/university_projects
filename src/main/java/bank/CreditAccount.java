package bank;

import java.time.LocalDate;
import java.util.Objects;

public class CreditAccount extends Account {
    private double percent = 0, assessed_percents = 0, assessed_commissions = 0;
    private long limit = 0;

    public CreditAccount(long unique_number) {
        super(unique_number);
    }

    public CreditAccount(long unique_number, double balance) {
        super(unique_number, balance);
    }

    public CreditAccount(long unique_number, double balance, double commission) {
        super(unique_number, balance, commission, Currency.RUB);
    }

    public CreditAccount(long unique_number, double balance, double commission, Currency currency) {
        super(unique_number, balance, commission, currency);
    }

    public CreditAccount(long unique_number, double balance, double commission, Currency currency, double percent, long limit) {
        super(unique_number, balance, commission, currency);
        this.percent = percent;
        this.limit = limit;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

    public double getAssessed_percents() {
        return assessed_percents;
    }

    public double getAssessed_commissions() {
        return assessed_commissions;
    }

    public void increasePercent(int year) {
        LocalDate localDate = LocalDate.of(year, 12, 31);
        if (getBalance() < limit) {
            assessed_percents = (limit - getBalance()) * (percent / localDate.getDayOfYear()) / 100;
        }
    }

    @Override
    public void reduceCommissionFromBalance() {
        double cmn = getCommission();
        cmn += assessed_commissions;
        setCommission(cmn);
    }

    @Override
    public void replenishmentAccount(double sum) {
        decreaseBalance(assessed_commissions + assessed_percents);
        super.replenishmentAccount(sum);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        CreditAccount that = (CreditAccount) object;
        return Double.compare(that.percent, percent) == 0 && Double.compare(that.assessed_percents, assessed_percents) == 0 && Double.compare(that.assessed_commissions, assessed_commissions) == 0 && limit == that.limit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(percent, assessed_percents, assessed_commissions, limit);
    }

    @Override
    public String toString() {
        return "percent: " + percent + "\n" + "assessed_percents: " + assessed_percents + "\n" + "assessed_commissions: " + assessed_commissions + "\n" + "limit: " + limit + "\n";
    }
}
