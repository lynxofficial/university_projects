package admissionCommittee;

public class LimitExceededException extends Throwable {
    public LimitExceededException(String message) {
        super(message);
    }
}
