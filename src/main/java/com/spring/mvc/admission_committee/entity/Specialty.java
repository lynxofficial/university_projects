package com.spring.mvc.admission_committee.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "specialties")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialty_id")
    private Integer specialtyId;
    @Column(name = "specialty_code")
    private String specialtyCode;
    @Column(name = "specialty_name")
    private String specialtyName;
    @Column(name = "quota")
    private Integer quota;
    @ManyToMany
    @JoinTable(name = "applicant_specialty",
            joinColumns = @JoinColumn(name = "specialty_id"), inverseJoinColumns = @JoinColumn(name = "applicant_id"))
    private List<Applicant> applicants;

    public Specialty() {
    }

    public Specialty(String specialtyCode, String specialtyName, Integer quota) {
        this.specialtyCode = specialtyCode;
        this.specialtyName = specialtyName;
        this.quota = quota;
    }

    public Integer getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Integer specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getSpecialtyCode() {
        return specialtyCode;
    }

    public void setSpecialtyCode(String specialtyCode) {
        this.specialtyCode = specialtyCode;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Specialty specialty = (Specialty) o;
        return Objects.equals(specialtyId, specialty.specialtyId)
                && Objects.equals(specialtyCode, specialty.specialtyCode)
                && Objects.equals(specialtyName, specialty.specialtyName)
                && Objects.equals(quota, specialty.quota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialtyId, specialtyCode, specialtyName, quota);
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "specialtyId=" + specialtyId +
                ", specialtyCode='" + specialtyCode + '\'' +
                ", specialtyName='" + specialtyName + '\'' +
                ", quota=" + quota +
                '}';
    }
}
