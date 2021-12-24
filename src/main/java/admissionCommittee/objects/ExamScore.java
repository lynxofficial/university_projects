package admissionCommittee.objects;

import java.util.Arrays;
import java.util.Objects;

public class ExamScore {
    private int examScoreId;
    private int registrationNumber;
    private int[] examScores;

    public ExamScore() {
        examScores = new int[3];
    }

    public int getExamScoreId() {
        return examScoreId;
    }

    public void setExamScoreId(int examScoreId) {
        this.examScoreId = examScoreId;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int[] getExamScores() {
        return examScores;
    }

    public void setExamScores(int[] examScores) {
        this.examScores = examScores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ExamScore examScore = (ExamScore) o;
        return examScoreId == examScore.examScoreId
                && registrationNumber == examScore.registrationNumber
                && Arrays.equals(examScores, examScore.examScores);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(examScoreId, registrationNumber);
        result = 31 * result + Arrays.hashCode(examScores);
        return result;
    }

    @Override
    public String toString() {
        return "ExamScore{" +
                "examScoreId=" + examScoreId +
                ", registrationNumber=" + registrationNumber +
                ", examScores=" + Arrays.toString(examScores) +
                '}';
    }
}
