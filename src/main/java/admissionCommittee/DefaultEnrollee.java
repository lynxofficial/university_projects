package admissionCommittee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DefaultEnrollee implements Enrollee {
    private static final int DEFAULT_EDU_PROGRAM_CHOICE_CONSTRAINT = 3;

    private long id;
    private String fullName;
    private String gender;
    private String phone;
    private String education;
    private LocalDate dateOfBirthday;
    private String address;
    private String passport;
    private List<EducationalProgram> selectedEducationalPrograms;
    private List<Integer> examScores;
    private String[] selectedSubjects;
    private byte eduProgramChoiceConstraint;

    public DefaultEnrollee(long id, String fullName, String gender, String phone, String education, String dateOfBirthday,
                           String address, String passport, String selectedSubjects) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.phone = phone;
        this.education = education;
        this.dateOfBirthday = LocalDate.parse(dateOfBirthday);
        this.address = address;
        this.passport = passport;
        this.eduProgramChoiceConstraint = DEFAULT_EDU_PROGRAM_CHOICE_CONSTRAINT;
        this.selectedSubjects = selectedSubjects.split(", ");
        this.examScores = new ArrayList<>();
        this.selectedEducationalPrograms = new ArrayList<>();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDate dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public byte getEduProgramChoiceConstraint() {
        return eduProgramChoiceConstraint;
    }

    public List<EducationalProgram> getSelectedEducationalPrograms() {
        return selectedEducationalPrograms;
    }

    public String[] getSelectedSubjects() {
        return selectedSubjects;
    }

    public long getId() {
        return id;
    }

    public List<Integer> getExamScores() {
        return examScores;
    }

    public int getSumOfExamScores() {
        return examScores.stream().mapToInt(x -> x).sum();
    }

    public void addSelectedEducationalProgram(EducationalProgram educationalProgram) throws LimitExceededException {
        if (eduProgramChoiceConstraint == 0) {
            throw new LimitExceededException(Messages.DEFAULT_LIMIT_EXCEED_MESSAGE);
        }
        selectedEducationalPrograms.add(educationalProgram);
        eduProgramChoiceConstraint--;
    }

    public void addExamScore(int score) {
        examScores.add(Integer.valueOf(score));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DefaultEnrollee that = (DefaultEnrollee) o;
        return Objects.equals(fullName, that.fullName)
                && Objects.equals(gender, that.gender)
                && Objects.equals(phone, that.phone)
                && Objects.equals(education, that.education)
                && Objects.equals(dateOfBirthday, that.dateOfBirthday)
                && Objects.equals(address, that.address)
                && Objects.equals(passport, that.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, gender, phone, education, dateOfBirthday, address, passport);
    }
}
