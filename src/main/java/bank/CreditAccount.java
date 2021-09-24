package bank;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class CreditAccount extends Account {
    private double procent, assessed_procents, assessed_commissions;
    private long limit;

    public CreditAccount(long unique_number) {
        super(unique_number);
        remainder = 0;
        procent = 0;
        assessed_commissions = 0;
        assessed_procents = 0;
        limit = 0;
    }

    public CreditAccount(long unique_number, double remainder) {
        super(unique_number, remainder);
        procent = 0;
        assessed_commissions = 0;
        assessed_procents = 0;
        limit = 0;
    }

    public CreditAccount(long unique_number, double remainder, double commission) {
        super(unique_number, remainder);
        setCommission(commission);
        setCurrency(Currency.RUB);
        procent = 0;
        assessed_commissions = 0;
        assessed_procents = 0;
        limit = 0;
    }

    public CreditAccount(long unique_number, double remainder, double commission, Currency currency) {
        super(unique_number, remainder);
        this.remainder = remainder;
        setCommission(commission);
        setCurrency(currency);
        procent = 0;
        assessed_commissions = 0;
        assessed_procents = 0;
        limit = 0;
    }

    public CreditAccount(long unique_number, double remainder, double commission, Currency currency, double procent, long limit) {
        super(unique_number, remainder, commission, currency);
        this.procent = procent;
        this.limit = limit;
        assessed_procents = 0;
        assessed_commissions = 0;
    }

    public double getProcent() {
        return procent;
    }

    public void setProcent(double procent) {
        this.procent = procent;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

    public double getAssessed_procents() {
        return assessed_procents;
    }

    public double getAssessed_commissions() {
        return assessed_commissions;
    }

    public void increaseProcent(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(year, 0, 1));
        if (remainder < limit) {
            assessed_procents = (limit - remainder) * (procent / calendar.getActualMaximum(Calendar.DAY_OF_YEAR)) / 100;
        }
    }

    @Override
    public void reduceCommissionFromRemainder() {
        double cmn = getCommission();
        cmn += assessed_commissions;
        setCommission(cmn);
    }

    @Override
    public void replenishmentAccount(double sum) {
        remainder -= assessed_commissions + assessed_procents;
        remainder += sum;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        CreditAccount that = (CreditAccount) object;
        return Double.compare(that.procent, procent) == 0 && Double.compare(that.assessed_procents, assessed_procents) == 0 && Double.compare(that.assessed_commissions, assessed_commissions) == 0 && limit == that.limit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(procent, assessed_procents, assessed_commissions, limit);
    }

    @Override
    public String toString() {
        return "procent: " + procent + "\n" + "assessed_procents: " + assessed_procents + "\n" + "assessed_commissions: " + assessed_commissions + "\n" + "limit: " + limit + "\n";
    }
}
