package admissionCommittee;

import java.util.Objects;

public class EducationalProgram {
    private static final int DEFAULT_ADMISSION_PLAN = 3;

    private String educationalProgramCode;
    private String nameOfEducationalProgram;
    private int admissionPlan;

    public String getEducationalProgramCode() {
        return educationalProgramCode;
    }

    public String getNameOfEducationalProgram() {
        return nameOfEducationalProgram;
    }

    public int getAdmissionPlan() {
        return admissionPlan;
    }

    public void setAdmissionPlan(int admissionPlan) {
        this.admissionPlan = admissionPlan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        EducationalProgram that = (EducationalProgram) o;
        return admissionPlan == that.admissionPlan
                && Objects.equals(educationalProgramCode, that.educationalProgramCode)
                && Objects.equals(nameOfEducationalProgram, that.nameOfEducationalProgram);
    }

    @Override
    public int hashCode() {
        return Objects.hash(educationalProgramCode, nameOfEducationalProgram, admissionPlan);
    }
}
