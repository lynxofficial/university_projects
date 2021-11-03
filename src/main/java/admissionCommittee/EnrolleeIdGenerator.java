package admissionCommittee;

public class EnrolleeIdGenerator {
    private static final long DEFAULT_ID = 0;

    private static long id;

    public EnrolleeIdGenerator(long id) {
        this.id = id;
    }

    public static long getId() {
        return id;
    }

    public static long getNext() {
        return id++;
    }

    public static void reset() {
        id = DEFAULT_ID;
    }
}
