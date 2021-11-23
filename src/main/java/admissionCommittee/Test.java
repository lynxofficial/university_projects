package admissionCommittee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {
    public static void printMap(Map<String, List<DefaultEnrollee>> map) {
        for (Map.Entry<String, List<DefaultEnrollee>> newMap : map.entrySet()) {
            System.out.println("Название направления: " + newMap.getKey() + "\n" + "Список абитуриентов:");
            for (DefaultEnrollee defaultEnrollee : newMap.getValue()) {
                System.out.println(defaultEnrollee.getFullName());
            }
        }
    }

    public static void main(String[] args) throws LimitExceededException {
        University university = new University();
        List<String> requiredExams = new ArrayList<>();
        requiredExams.add("Русский язык");
        requiredExams.add("Математика");
        requiredExams.add("Физика");
        EducationalProgram educationalProgram = new EducationalProgram();
        EducationalProgram educationalProgram2 = new EducationalProgram();
        System.out.println(educationalProgram.getEducationalProgramCode());
        educationalProgram.setAdmissionPlan(3);
        DefaultEnrollee defaultEnrollee = new DefaultEnrollee();
        Faculty faculty = new Faculty();
        faculty.addEducationalProgram(educationalProgram);
        faculty.addEducationalProgram(educationalProgram2);
        faculty.addMinScores(new int[]{30, 30, 30});
        List<Faculty> faculties = new ArrayList<>();
        faculties.add(faculty);
        defaultEnrollee.addExamScore(89);
        defaultEnrollee.addExamScore(90);
        defaultEnrollee.addExamScore(70);
        defaultEnrollee.addSelectedEducationalProgram(educationalProgram);
        DefaultEnrollee schoolEnrollee2 = new DefaultEnrollee();
        schoolEnrollee2.addExamScore(64);
        schoolEnrollee2.addExamScore(65);
        schoolEnrollee2.addExamScore(35);
        schoolEnrollee2.addSelectedEducationalProgram(educationalProgram);
        DefaultEnrollee collegeEnrollee3 = new DefaultEnrollee();
        collegeEnrollee3.addExamScore(45);
        collegeEnrollee3.addExamScore(42);
        collegeEnrollee3.addExamScore(41);
        collegeEnrollee3.addSelectedEducationalProgram(educationalProgram);
        DefaultAdmissionCommittee defaultAdmissionCommittee = new DefaultAdmissionCommittee();
        List<DefaultEnrollee> Enrollees = new ArrayList<>();
        DefaultEnrollee schoolEnrollee4 = new DefaultEnrollee();
        schoolEnrollee4.addExamScore(67);
        schoolEnrollee4.addExamScore(45);
        schoolEnrollee4.addExamScore(72);
        schoolEnrollee4.addSelectedEducationalProgram(educationalProgram);
        Enrollees.add(schoolEnrollee2);
        Enrollees.add(defaultEnrollee);
        Enrollees.add(collegeEnrollee3);
        Enrollees.add(schoolEnrollee4);
        DefaultEnrollee schoolEnrollee5 = new DefaultEnrollee();
        schoolEnrollee5.addExamScore(35);
        schoolEnrollee5.addExamScore(70);
        schoolEnrollee5.addExamScore(85);
        schoolEnrollee5.addSelectedEducationalProgram(educationalProgram2);
        Enrollees.add(schoolEnrollee5);
        defaultAdmissionCommittee.distributeEnrollees(Enrollees);
        printMap(defaultAdmissionCommittee.getEnrollees());
        System.out.println("------------------------------------------");
        defaultAdmissionCommittee.sortEnrolleesByScore();
        printMap(defaultAdmissionCommittee.getEnrollees());
        System.out.println("--------------------------------------");
        defaultAdmissionCommittee.createMapOfApplicants();
        printMap(defaultAdmissionCommittee.getEnrollees());
        System.out.println(faculty.getSumOfMinScores());
        System.out.println(defaultEnrollee.getSumOfExamScores());
    }
}
