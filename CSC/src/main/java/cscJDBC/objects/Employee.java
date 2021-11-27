package cscJDBC.objects;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Employee {
    private CarServiceCenter center;
    private String lastName;
    private String email;
    private BigDecimal salary;
    private String firstName;
    private Date birthDate;

    public CarServiceCenter getCenter() {
        return center;
    }

    public void setCenter(CarServiceCenter center) {
        this.center = center;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(center, employee.center)
                && Objects.equals(lastName, employee.lastName)
                && Objects.equals(email, employee.email)
                && Objects.equals(salary, employee.salary)
                && Objects.equals(firstName, employee.firstName)
                && Objects.equals(birthDate, employee.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, lastName, email, salary, firstName, birthDate);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "center=" + center +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", firstName='" + firstName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
