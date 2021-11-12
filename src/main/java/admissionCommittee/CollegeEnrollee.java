package admissionCommittee;

public class CollegeEnrollee extends DefaultEnrollee {
    public CollegeEnrollee(long id, String fullName, String gender, String phone, String education,
                           String dateOfBirthday, String address, String passport, String selectedSubjects) {
        super(id, fullName, gender, phone, education, dateOfBirthday, address, passport, selectedSubjects);
    }
}
