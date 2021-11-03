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
        University university = new University("ПГУТИ");
        List<String> requiredExams = new ArrayList<>();
        requiredExams.add("Русский язык");
        requiredExams.add("Математика");
        requiredExams.add("Физика");
        EducationalProgram educationalProgram = new EducationalProgram(
                university.getUniversityName(), "ФИСТ",
                requiredExams, "09.03.01",
                "Информатика и вычислительная техника"
        );
        System.out.println(educationalProgram.getEducationalProgramCode());
        educationalProgram.setAdmissionPlan(2);
        System.out.println(EnrolleeIdGenerator.getId());
        DefaultEnrollee defaultEnrollee = new DefaultEnrollee(EnrolleeIdGenerator.getNext(),
                "Иванов Иван Иванович", "Мужской",
                "+7927456123", "ГБОУ СОШ №8, г. Новокуйбышевск", "2000-10-05",
                "ул. Пушкина, д. Колотушкина 45", "3671 746254",
                "Русский язык, Математика, Физика");
        Faculty faculty = new Faculty("ПГУТИ", "ФИСТ", requiredExams);
        faculty.addEducationalProgram(educationalProgram);
        List<Faculty> faculties = new ArrayList<>();
        faculties.add(faculty);
        defaultEnrollee.addExamScore(89);
        defaultEnrollee.addExamScore(90);
        defaultEnrollee.addExamScore(70);
        defaultEnrollee.addSelectedEducationalProgram(educationalProgram);
        DefaultEnrollee defaultEnrollee2 = new DefaultEnrollee(EnrolleeIdGenerator.getNext(),
                "Привет Иван Иванович", "Мужской",
                "+7927456123", "ГБОУ СОШ №1, г. Новокуйбышевск", "2000-10-05",
                "ул. Пушкина, д. Колотушкина 45", "3671 746254",
                "Русский язык, Математика, Физика");
        defaultEnrollee2.addExamScore(64);
        defaultEnrollee2.addExamScore(65);
        defaultEnrollee2.addExamScore(25);
        defaultEnrollee2.addSelectedEducationalProgram(educationalProgram);
        DefaultEnrollee defaultEnrollee3 = new DefaultEnrollee(EnrolleeIdGenerator.getNext(),
                "Здравствуй Иван Иванович", "Мужской",
                "+7927456123", "ГБОУ СОШ №3, г. Новокуйбышевск", "2000-10-05",
                "ул. Пушкина, д. Колотушкина 45", "3671 746254",
                "Русский язык, Математика, Физика");
        defaultEnrollee3.addExamScore(25);
        defaultEnrollee3.addExamScore(25);
        defaultEnrollee3.addExamScore(25);
        defaultEnrollee3.addSelectedEducationalProgram(educationalProgram);
        DefaultAdmissionCommittee defaultAdmissionCommittee = new DefaultAdmissionCommittee(
                "ПГУТИ", faculties);
        List<DefaultEnrollee> defaultEnrollees = new ArrayList<>();
        DefaultEnrollee defaultEnrollee4 = new DefaultEnrollee(EnrolleeIdGenerator.getNext(),
                "Пока Иван Иванович", "Мужской",
                "+7927456123", "ГБОУ СОШ №5, г. Новокуйбышевск", "2000-10-05",
                "ул. Пушкина, д. Колотушкина 45", "3671 746254",
                "Русский язык, Математика, Физика");
        defaultEnrollee4.addExamScore(67);
        defaultEnrollee4.addExamScore(45);
        defaultEnrollee4.addExamScore(72);
        defaultEnrollee4.addSelectedEducationalProgram(educationalProgram);
        defaultEnrollees.add(defaultEnrollee2);
        defaultEnrollees.add(defaultEnrollee);
        defaultEnrollees.add(defaultEnrollee3);
        defaultEnrollees.add(defaultEnrollee4);
        defaultAdmissionCommittee.distributeEnrollees(defaultEnrollees);
        printMap(defaultAdmissionCommittee.getEnrollees());
        System.out.println("------------------------------------------");
        defaultAdmissionCommittee.sortEnrolleesByScore();
        printMap(defaultAdmissionCommittee.getEnrollees());
        System.out.println("--------------------------------------");
        defaultAdmissionCommittee.createMapOfApplicants();
        printMap(defaultAdmissionCommittee.getEnrollees());
        EnrolleeIdGenerator.reset();
    }
}
