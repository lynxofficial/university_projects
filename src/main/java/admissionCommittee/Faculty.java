package admissionCommittee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Faculty {
    private String facultyName;
    private List<String> requiredExams;
    private List<EducationalProgram> educationalPrograms;
    private int[] minExamScores;

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

    public int[] getMinExamScores() {
        return minExamScores;
    }

    public int getSumOfMinScores() {
        return Arrays.stream(minExamScores).sum();
    }

    public void addMinScores(int[] minScores) {
        for (int i = 0; i < minScores.length; i++) {
            this.minExamScores[i] = minScores[i];
        }
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
