package admissionCommittee.Service;

import admissionCommittee.EducationalProgram;
import admissionCommittee.LimitExceededException;

import java.time.LocalDate;
import java.util.List;

public interface Enrollee {

    String getFullName();

    void setFullName(String fullName);

    String getGender();

    void setGender(String gender);

    String getPhone();

    void setPhone(String phone);

    String getEducation();

    void setEducation(String education);

    LocalDate getDateOfBirthday();

    void setDateOfBirthday(LocalDate dateOfBirthday);

    String getAddress();

    void setAddress(String address);

    String getPassport();

    void setPassport(String passport);

    byte getEduProgramChoiceConstraint();

    List<EducationalProgram> getSelectedEducationalPrograms();

    String[] getSelectedSubjects();

    long getId();

    List<Integer> getExamScores();

    void addSelectedEducationalProgram(EducationalProgram educationalProgram) throws LimitExceededException;

    void addExamScore(int score);
}
