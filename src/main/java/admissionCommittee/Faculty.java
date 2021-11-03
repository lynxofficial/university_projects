package admissionCommittee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculty extends University {
    private String facultyName;
    private List<String> requiredExams;
    private List<EducationalProgram> educationalPrograms;

    public Faculty(String universityName, String facultyName, List<String> requiredExams) {
        super(universityName);
        this.facultyName = facultyName;
        this.requiredExams = requiredExams;
        this.educationalPrograms = new ArrayList<>();
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public List<String> getRequiredExams() {
        return requiredExams;
    }

    public List<EducationalProgram> getEducationalPrograms() {
        return educationalPrograms;
    }

    public void addEducationalProgram(EducationalProgram educationalProgram) {
        educationalPrograms.add(educationalProgram);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(facultyName, faculty.facultyName)
                && Objects.equals(requiredExams, faculty.requiredExams)
                && Objects.equals(educationalPrograms, faculty.educationalPrograms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyName, requiredExams, educationalPrograms);
    }
}
