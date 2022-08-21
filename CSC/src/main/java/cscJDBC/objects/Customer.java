package cscJDBC.objects;

import java.util.List;
import java.util.Objects;

public class Customer extends ServiceCenter {
    private String name;
    private String email;
    private List<ServiceCenter> centers;
    private String phone;
    private String passportNo;
    private String inn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ServiceCenter> getCenters() {
        return centers;
    }

    public void setCenters(List<ServiceCenter> centers) {
        this.centers = centers;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name)
                && Objects.equals(email, customer.email)
                && Objects.equals(centers, customer.centers)
                && Objects.equals(phone, customer.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, centers, phone);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", centers=" + centers +
                ", phone='" + phone + '\'' +
                '}';
    }
}
