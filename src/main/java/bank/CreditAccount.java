package bank;

import java.time.LocalDate;
import java.util.Objects;

public class CreditAccount extends Account {
    private double percent = 0;
    private double assessedPercents = 0;
    private double assessedCommissions = 0;
    private long limit = 0;

    public CreditAccount(long uniqueNumber) {
        super(uniqueNumber);
    }

    public CreditAccount(long uniqueNumber, double balance) {
        super(uniqueNumber, balance);
    }

    public CreditAccount(long uniqueNumber, double balance, double commission) {
        super(uniqueNumber, balance, commission, DEFAULT_CURRENCY);
    }

    public CreditAccount(long uniqueNumber, double balance, double commission, Currency currency) {
        super(uniqueNumber, balance, commission, currency);
    }

    public CreditAccount(long uniqueNumber, double balance, double commission, Currency currency, double percent, long limit) {
        super(uniqueNumber, balance, commission, currency);
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

    public double getAssessedPercents() {
        return assessedPercents;
    }

    public double getAssessedCommissions() {
        return assessedCommissions;
    }

    public void increasePercent(int year) {
        LocalDate localDate = LocalDate.of(year, 12, 31);
        if (getBalance() < limit) {
            assessedPercents = (limit - getBalance()) * (percent / localDate.getDayOfYear()) / 100;
        }
    }

    @Override
    public void reduceCommissionFromBalance() {
        double cmn = getCommission();
        cmn += assessedCommissions;
        setCommission(cmn);
    }

    @Override
    public void replenishmentAccount(double sum) {
        decreaseBalance(assessedCommissions + assessedPercents);
        super.replenishmentAccount(sum);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        CreditAccount that = (CreditAccount) object;
        return Double.compare(that.percent, percent) == 0 && Double.compare(that.assessedPercents, assessedPercents) == 0 && Double.compare(that.assessedCommissions, assessedCommissions) == 0 && limit == that.limit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(percent, assessedPercents, assessedCommissions, limit);
    }

    @Override
    public String toString() {
        return "percent: " + percent + "\n" + "assessed_percents: " + assessedPercents + "\n" + "assessed_commissions: " + assessedCommissions + "\n" + "limit: " + limit + "\n";
    }
}
