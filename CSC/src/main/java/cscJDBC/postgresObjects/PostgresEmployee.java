package cscJDBC.postgresObjects;

import cscJDBC.dao.AbstractDao;
import cscJDBC.objects.CarServiceCenter;
import cscJDBC.objects.Employee;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostgresEmployee extends AbstractDao {
    public PostgresEmployee() throws SQLException {
    }

    @Override
    public void insert(Object o) throws SQLException {
        Employee employee = (Employee) o;
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "insert into css.\"Employee\" values (?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, employee.getFirstName());
        preparedStatement.setString(2, employee.getLastName());
        preparedStatement.setObject(3, employee.getBirthDate());
        preparedStatement.setString(4, employee.getEmail());
        preparedStatement.setObject(5, employee.getSalary());
        preparedStatement.setObject(6, employee.getCenter());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void delete(Object o) throws SQLException {
        Employee employee = (Employee) o;
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "delete from css.\"Employee\" where \"birthDate\"=?");
        preparedStatement.setObject(1, employee.getBirthDate());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void update(Object o, String lName, String date) throws SQLException {
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "update css.\"Employee\" set \"lastName\"=? where \"birthDate\"=?");
        preparedStatement.setString(1, lName);
        preparedStatement.setObject(2, date);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public List getAll() throws SQLException {
        List<Employee> list = new ArrayList<>();
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "select * from css.\"Employee\"");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Employee employee = new Employee();
            employee.setFirstName(resultSet.getString(1));
            employee.setLastName(resultSet.getString(2));
            employee.setBirthDate((Date) resultSet.getObject(3));
            employee.setEmail(resultSet.getString(4));
            employee.setSalary((BigDecimal) resultSet.getObject(5));
            employee.setCenter((CarServiceCenter) resultSet.getObject(6));
            list.add(employee);
        }
        return list;
    }
}
