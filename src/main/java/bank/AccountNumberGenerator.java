package bank;

public class AccountNumberGenerator {
    private static int stat = 0;

    public static int getNext() {
        return ++stat;
    }

    public static int getCurrent() {
        return stat;
    }

    public static void reset() {
        stat = 0;
    }

}
