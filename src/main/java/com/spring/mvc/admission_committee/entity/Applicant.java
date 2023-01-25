package com.spring.mvc.admission_committee.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "applicants")
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicant_id")
    private Integer applicantId;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "points")
    private Integer points;
    @ManyToMany
    @JoinTable(name = "applicant_specialty",
            joinColumns = @JoinColumn(name = "applicant_id"), inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private List<Specialty> specialties;

    public Applicant() {
    }

    public Applicant(String lastName, String firstName, String middleName, String phone, String email, Integer points) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.phone = phone;
        this.email = email;
        this.points = points;
    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void addSpecialty(Specialty specialty) {
        if (specialties == null) {
            specialties = new ArrayList<>();
        }
        specialties.add(specialty);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Applicant applicant = (Applicant) o;
        return Objects.equals(applicantId, applicant.applicantId)
                && Objects.equals(lastName, applicant.lastName)
                && Objects.equals(firstName, applicant.firstName)
                && Objects.equals(middleName, applicant.middleName)
                && Objects.equals(phone, applicant.phone)
                && Objects.equals(email, applicant.email)
                && Objects.equals(points, applicant.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicantId, lastName, firstName, middleName, phone, email, points);
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "applicantId=" + applicantId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", points=" + points +
                '}';
    }
}
