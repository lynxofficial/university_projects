package admissionCommittee.objects;

import java.util.Objects;

public class Form {
    private int formId;
    private int registrationNumber;
    private String lastName;
    private String firstName;
    private String middleName;
    private String dateOfBirthday;
    private String country;
    private String city;
    private String educationEstablishment;

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEducationEstablishment() {
        return educationEstablishment;
    }

    public void setEducationEstablishment(String educationEstablishment) {
        this.educationEstablishment = educationEstablishment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Form form = (Form) o;
        return formId == form.formId
                && registrationNumber == form.registrationNumber
                && Objects.equals(lastName, form.lastName)
                && Objects.equals(firstName, form.firstName)
                && Objects.equals(middleName, form.middleName)
                && Objects.equals(dateOfBirthday, form.dateOfBirthday)
                && Objects.equals(country, form.country)
                && Objects.equals(city, form.city)
                && Objects.equals(educationEstablishment, form.educationEstablishment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formId,
                registrationNumber,
                lastName,
                firstName,
                middleName,
                dateOfBirthday,
                country,
                city,
                educationEstablishment);
    }

    @Override
    public String toString() {
        return "Form{" +
                "formId=" + formId +
                ", registrationNumber=" + registrationNumber +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", dateOfBirthday='" + dateOfBirthday + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", educationEstablishment='" + educationEstablishment + '\'' +
                '}';
    }
}
