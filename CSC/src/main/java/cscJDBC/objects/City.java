package cscJDBC.objects;

import java.util.Objects;

public class City {
    private String title;
    private String code;
    private boolean defaultCity;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isDefaultCity() {
        return defaultCity;
    }

    public void setDefaultCity(boolean defaultCity) {
        this.defaultCity = defaultCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        City city = (City) o;
        return defaultCity == city.defaultCity && Objects.equals(title, city.title) && Objects.equals(code, city.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, code, defaultCity);
    }

    @Override
    public String toString() {
        return "City{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", defaultCity=" + defaultCity +
                '}';
    }
}
