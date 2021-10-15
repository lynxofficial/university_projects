package bank;

public class AccountNumberGenerator {
    private final static long DEFAULT_ID = 0;

    private static long id;

    public static long getNext() {
        return id++;
    } // увеличение id счета

    public static long getCurrent() {
        return id;
    }

    public static void reset() {
        id = DEFAULT_ID;
    }

}
