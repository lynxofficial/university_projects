import cscJDBC.objects.City;
import cscJDBC.postgresObjects.DaoCity;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainTest {
    @Test
    public static void testConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/css_database",
                "postgres",
                "1234");
        Connection connection1 = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/css_database",
                "postgres",
                "1234");
        Assert.assertNotEquals(connection, connection1);
    }

    @Test
    public static void testInsertData() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/css_database",
                "postgres",
                "1234");
        City city = new City();
        city.setCode("6");
        city.setTitle("TestCity");
        DaoCity daoCity = new DaoCity();
        daoCity.insert(city);
        city.setCode("7");
        DaoCity daoCity1 = new DaoCity();
        daoCity1.insert(city);
        Assert.assertNotEquals(daoCity, daoCity1);
    }

    @Test
    public static void testDeleteData() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/css_database",
                "postgres",
                "1234");
        City city = new City();
        city.setCode("7");
        city.setTitle("TestCity");
        DaoCity daoCity = new DaoCity();
        daoCity.delete(city);
        city.setCode("6");
        DaoCity daoCity1 = new DaoCity();
        daoCity1.delete(city);
        Assert.assertNotEquals(daoCity, daoCity1);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        testConnection();
        testInsertData();
        testDeleteData();

        //System.out.println("It's okay");
        //City city = new City();
        //city.setTitle("Saint-Petersburg");
        //city.setCode("99");
        //PostgresCity postgresCity = new PostgresCity();
        //postgresCity.insert(city);
        //System.out.println("Successful!");
        //postgresCity.delete(city);
        //System.out.println("Successful deleted!");
        //postgresCity.update(city, "Saint", "78");
        //System.out.println(postgresCity.getAll());
        //PostgresCarServiceCenter postgresCarServiceCenter = new PostgresCarServiceCenter();
    }
}
