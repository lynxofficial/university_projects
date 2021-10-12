package bank;

public class AccountNumberGenerator {
    private static long stat = 0;

    public static long getNext() {
        return stat++;
    } // увеличение id счета

    public static long getCurrent() {
        return stat;
    }

    public static void reset() {
        stat = 0;
    }

}
