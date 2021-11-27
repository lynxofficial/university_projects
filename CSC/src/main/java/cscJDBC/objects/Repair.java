package cscJDBC.objects;

import java.util.Objects;

public class Repair {
    private String description;
    private CarServiceCenter center;
    private Employee employee;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CarServiceCenter getCenter() {
        return center;
    }

    public void setCenter(CarServiceCenter center) {
        this.center = center;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Repair repair = (Repair) o;
        return Objects.equals(description, repair.description)
                && Objects.equals(center, repair.center)
                && Objects.equals(employee, repair.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, center, employee);
    }

    @Override
    public String toString() {
        return "Repair{" +
                "description='" + description + '\'' +
                ", center=" + center +
                ", employee=" + employee +
                '}';
    }
}
