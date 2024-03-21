package admissionCommittee.objects;

import java.util.Objects;

public class Enrollee {
    private int registrationNumber;
    private int specialtyCode;
    private boolean achievements;

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getSpecialtyCode() {
        return specialtyCode;
    }

    public void setSpecialtyCode(int specialtyCode) {
        this.specialtyCode = specialtyCode;
    }

    public boolean isAchievements() {
        return achievements;
    }

    public void setAchievements(boolean achievements) {
        this.achievements = achievements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Enrollee enrollee = (Enrollee) o;
        return registrationNumber == enrollee.registrationNumber
                && specialtyCode == enrollee.specialtyCode
                && achievements == enrollee.achievements;
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber, specialtyCode, achievements);
    }

    @Override
    public String toString() {
        return "Enrollee{" +
                "registrationNumber=" + registrationNumber +
                ", specialtyCode=" + specialtyCode +
                ", achievements=" + achievements +
                '}';
    }
}
