package admissionCommittee.objects;

import java.util.Objects;

public class Specialty {
    private int specialtyCode;
    private int facultyCode;
    private String specialtyName;
    private int admissionPlan;

    public int getSpecialtyCode() {
        return specialtyCode;
    }

    public void setSpecialtyCode(int specialtyCode) {
        this.specialtyCode = specialtyCode;
    }

    public int getFacultyCode() {
        return facultyCode;
    }

    public void setFacultyCode(int facultyCode) {
        this.facultyCode = facultyCode;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
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
        Specialty specialty = (Specialty) o;
        return specialtyCode == specialty.specialtyCode
                && facultyCode == specialty.facultyCode
                && admissionPlan == specialty.admissionPlan
                && Objects.equals(specialtyName, specialty.specialtyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialtyCode, facultyCode, specialtyName, admissionPlan);
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "specialtyCode=" + specialtyCode +
                ", facultyCode=" + facultyCode +
                ", specialtyName='" + specialtyName + '\'' +
                ", admissionPlan=" + admissionPlan +
                '}';
    }
}
