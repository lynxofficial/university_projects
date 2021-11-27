package cscJDBC.objects;

import java.util.List;
import java.util.Objects;

public class CarServiceCenter {
    private List<Employee> employees;
    private String title;
    private City city;
    private String phone;
    private String address;
    private List<Customer> customers;
    private List<Repair> repairs;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CarServiceCenter that = (CarServiceCenter) o;
        return Objects.equals(employees, that.employees)
                && Objects.equals(title, that.title)
                && Objects.equals(city, that.city)
                && Objects.equals(phone, that.phone)
                && Objects.equals(address, that.address)
                && Objects.equals(customers, that.customers)
                && Objects.equals(repairs, that.repairs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employees, title, city, phone, address, customers, repairs);
    }

    @Override
    public String toString() {
        return "CarServiceCenter{" +
                "employees=" + employees +
                ", title='" + title + '\'' +
                ", city=" + city +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", customers=" + customers +
                ", repairs=" + repairs +
                '}';
    }
}
