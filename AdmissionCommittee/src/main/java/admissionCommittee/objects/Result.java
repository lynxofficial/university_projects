package admissionCommittee.objects;

import java.util.Objects;

public class Result {
    private int resultId;
    private int registrationNumber;
    private boolean enrollment;

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public boolean isEnrollment() {
        return enrollment;
    }

    public void setEnrollment(boolean enrollment) {
        this.enrollment = enrollment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Result result = (Result) o;
        return resultId == result.resultId
                && registrationNumber == result.registrationNumber
                && enrollment == result.enrollment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultId, registrationNumber, enrollment);
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultId=" + resultId +
                ", registrationNumber=" + registrationNumber +
                ", enrollment=" + enrollment +
                '}';
    }
}
