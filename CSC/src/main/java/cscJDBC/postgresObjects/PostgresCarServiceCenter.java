package cscJDBC.postgresObjects;

import cscJDBC.dao.AbstractDao;
import cscJDBC.objects.CarServiceCenter;
import cscJDBC.objects.City;
import cscJDBC.objects.Employee;
import cscJDBC.objects.Repair;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgresCarServiceCenter extends AbstractDao {
    public PostgresCarServiceCenter() throws SQLException {
    }

    @Override
    public void insert(Object o) throws SQLException {
        CarServiceCenter carServiceCenter = (CarServiceCenter) o;
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "insert into css.\"CarServiceCenter\" values (?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, carServiceCenter.getTitle());
        preparedStatement.setString(2, carServiceCenter.getPhone());
        preparedStatement.setObject(3, carServiceCenter.getCity());
        preparedStatement.setString(4, carServiceCenter.getAddress());
        preparedStatement.setObject(5, carServiceCenter.getEmployees());
        preparedStatement.setObject(6, carServiceCenter.getRepairs());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void delete(Object o) throws SQLException {
        CarServiceCenter carServiceCenter = (CarServiceCenter) o;
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "delete from css.\"CarServiceCenter\" where name=?");
        preparedStatement.setString(1, carServiceCenter.getTitle());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void update(Object o, String address, String key) throws SQLException {
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "update css.\"CarServiceCenter\" set address=? where name=?");
        preparedStatement.setString(1, address);
        preparedStatement.setString(2, key);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public List getAll() throws SQLException {
        List<CarServiceCenter> list = new ArrayList<>();
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "select * from css.\"CarServiceCenter\"");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            CarServiceCenter carServiceCenter = new CarServiceCenter();
            carServiceCenter.setTitle(resultSet.getString(1));
            carServiceCenter.setPhone(resultSet.getString(2));
            carServiceCenter.setCity((City) resultSet.getObject(3));
            carServiceCenter.setAddress(resultSet.getString(4));
            carServiceCenter.setEmployees((List<Employee>) resultSet.getObject(5));
            carServiceCenter.setRepairs((List<Repair>) resultSet.getObject(6));
            list.add(carServiceCenter);
        }
        return list;
    }
}
