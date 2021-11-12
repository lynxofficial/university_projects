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
        EducationalProgram educationalProgram2 = new EducationalProgram(
                university.getUniversityName(), "ФИСТ",
                requiredExams, "09.03.04",
                "Программная инженерия"
        );
        System.out.println(educationalProgram.getEducationalProgramCode());
        educationalProgram.setAdmissionPlan(3);
        System.out.println(EnrolleeIdGenerator.getId());
        SchoolEnrollee schoolEnrollee = new SchoolEnrollee(EnrolleeIdGenerator.getNext(),
                "Иванов Иван Иванович", "Мужской",
                "+7927456123", "ГБОУ СОШ №8, г. Новокуйбышевск", "2000-10-05",
                "ул. Пушкина, д. Колотушкина 45", "3671 746254",
                "Русский язык, Математика, Физика");
        Faculty faculty = new Faculty("ПГУТИ", "ФИСТ", requiredExams);
        faculty.addEducationalProgram(educationalProgram);
        faculty.addEducationalProgram(educationalProgram2);
        faculty.addMinScores(new int[]{30, 30, 30});
        List<Faculty> faculties = new ArrayList<>();
        faculties.add(faculty);
        schoolEnrollee.addExamScore(89);
        schoolEnrollee.addExamScore(90);
        schoolEnrollee.addExamScore(70);
        schoolEnrollee.addSelectedEducationalProgram(educationalProgram);
        SchoolEnrollee schoolEnrollee2 = new SchoolEnrollee(EnrolleeIdGenerator.getNext(),
                "Привет Иван Иванович", "Мужской",
                "+7927456123", "ГБОУ СОШ №1, г. Новокуйбышевск", "2000-10-05",
                "ул. Пушкина, д. Колотушкина 45", "3671 746254",
                "Русский язык, Математика, Физика");
        schoolEnrollee2.addExamScore(64);
        schoolEnrollee2.addExamScore(65);
        schoolEnrollee2.addExamScore(35);
        schoolEnrollee2.addSelectedEducationalProgram(educationalProgram);
        CollegeEnrollee collegeEnrollee3 = new CollegeEnrollee(EnrolleeIdGenerator.getNext(),
                "Здравствуй Иван Иванович", "Мужской",
                "+7927456123", "ГБОУ СОШ №3, г. Новокуйбышевск", "2000-10-05",
                "ул. Пушкина, д. Колотушкина 45", "3671 746254",
                "Русский язык, Математика, Физика");
        collegeEnrollee3.addExamScore(45);
        collegeEnrollee3.addExamScore(42);
        collegeEnrollee3.addExamScore(41);
        collegeEnrollee3.addSelectedEducationalProgram(educationalProgram);
        DefaultAdmissionCommittee defaultAdmissionCommittee = new DefaultAdmissionCommittee(
                "ПГУТИ", faculties);
        List<DefaultEnrollee> Enrollees = new ArrayList<>();
        SchoolEnrollee schoolEnrollee4 = new SchoolEnrollee(EnrolleeIdGenerator.getNext(),
                "Пока Иван Иванович", "Мужской",
                "+7927456123", "ГБОУ СОШ №5, г. Новокуйбышевск", "2000-10-05",
                "ул. Пушкина, д. Колотушкина 45", "3671 746254",
                "Русский язык, Математика, Физика");
        schoolEnrollee4.addExamScore(67);
        schoolEnrollee4.addExamScore(45);
        schoolEnrollee4.addExamScore(72);
        schoolEnrollee4.addSelectedEducationalProgram(educationalProgram);
        Enrollees.add(schoolEnrollee2);
        Enrollees.add(schoolEnrollee);
        Enrollees.add(collegeEnrollee3);
        Enrollees.add(schoolEnrollee4);
        SchoolEnrollee schoolEnrollee5 = new SchoolEnrollee(EnrolleeIdGenerator.getNext(),
                "Иванов Иван Иванович", "Мужской",
                "+7927456123", "ГБОУ СОШ №8, г. Новокуйбышевск", "2000-10-05",
                "ул. Пушкина, д. Колотушкина 45", "3671 746254",
                "Русский язык, Математика, Физика");
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
        EnrolleeIdGenerator.reset();
        System.out.println(faculty.getSumOfMinScores());
        System.out.println(schoolEnrollee.getSumOfExamScores());
    }
}
