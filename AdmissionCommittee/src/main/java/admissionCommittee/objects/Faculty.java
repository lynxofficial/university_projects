package admissionCommittee.objects;

import java.util.Objects;

public class Faculty {
    private String[] exams;
    private int facultyCode;
    private String facultyName;

    public Faculty() {
        exams = new String[3];
    }

    public String[] getExams() {
        return exams;
    }

    public void setExams(String[] exams) {
        this.exams = exams;
    }

    public int getFacultyCode() {
        return facultyCode;
    }

    public void setFacultyCode(int facultyCode) {
        this.facultyCode = facultyCode;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Faculty faculty = (Faculty) o;
        return facultyCode == faculty.facultyCode && Objects.equals(facultyName, faculty.facultyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyCode, facultyName);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyCode=" + facultyCode +
                ", facultyName='" + facultyName + '\'' +
                '}';
    }
}
