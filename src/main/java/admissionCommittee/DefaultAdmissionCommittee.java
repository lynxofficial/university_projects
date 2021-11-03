package admissionCommittee;

import java.util.*;

public class DefaultAdmissionCommittee extends University implements AdmissionCommittee {
    private List<Faculty> faculties;
    private Map<String, List<DefaultEnrollee>> enrollees;

    public DefaultAdmissionCommittee(String universityName, List<Faculty> faculties) {
        super(universityName);
        this.faculties = faculties;
        this.enrollees = new HashMap<>();
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public Map<String, List<DefaultEnrollee>> getEnrollees() {
        return enrollees;
    }

    public void distributeEnrollees(List<DefaultEnrollee> newDefaultEnrollees) {
        for (DefaultEnrollee defaultEnrollee : newDefaultEnrollees) {
            for (EducationalProgram educationalProgram : defaultEnrollee.getSelectedEducationalPrograms()) {
                if (!enrollees.containsKey(educationalProgram.getNameOfEducationalProgram())) {
                    enrollees.put(educationalProgram.getNameOfEducationalProgram(), new ArrayList<>());
                }
                enrollees.get(educationalProgram.getNameOfEducationalProgram()).add(defaultEnrollee);
            }
        }
    }

    public void sortEnrolleesByScore() {
        for (Map.Entry<String, List<DefaultEnrollee>> map : enrollees.entrySet()) {
            enrollees.get(map.getKey()).sort((defaultEnrollee, t1) -> {
                int sum1 = 0;
                int sum2 = 0;
                for (int i = 0; i < defaultEnrollee.getExamScores().size(); i++) {
                    sum1 += defaultEnrollee.getExamScores().get(i);
                    sum2 += t1.getExamScores().get(i);
                }
                return sum2 - sum1;
            });
        }
    }

    public void createMapOfApplicants() {
        List<DefaultEnrollee> additionalListOfDefaultEnrollees = new ArrayList<>();
        int newAdmissionPlan = 0;
        for (Faculty faculty : faculties) {
            for (EducationalProgram educationalProgram : faculty.getEducationalPrograms()) {
                newAdmissionPlan = educationalProgram.getAdmissionPlan();
                addEnrolleesToAdditionalList(additionalListOfDefaultEnrollees, newAdmissionPlan, educationalProgram);
                enrollees.get(educationalProgram.getNameOfEducationalProgram()).clear();
                enrollees.get(educationalProgram.getNameOfEducationalProgram())
                        .addAll(additionalListOfDefaultEnrollees);
                additionalListOfDefaultEnrollees.clear();
            }
        }
    }

    private void addEnrolleesToAdditionalList(List<DefaultEnrollee> additionalListOfDefaultEnrollees,
                                              int newAdmissionPlan, EducationalProgram educationalProgram) {
        for (DefaultEnrollee defaultEnrollee : enrollees.get(educationalProgram.getNameOfEducationalProgram())) {
            if (newAdmissionPlan == 0) {
                break;
            }
            additionalListOfDefaultEnrollees.add(defaultEnrollee);
            newAdmissionPlan--;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DefaultAdmissionCommittee that = (DefaultAdmissionCommittee) o;
        return Objects.equals(faculties, that.faculties) && Objects.equals(enrollees, that.enrollees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculties, enrollees);
    }
}
