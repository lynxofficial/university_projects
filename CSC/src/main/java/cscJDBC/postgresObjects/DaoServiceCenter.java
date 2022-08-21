package cscJDBC.postgresObjects;

import cscJDBC.configuration.ConfigurationInfo;
import cscJDBC.dao.AbstractDao;
import cscJDBC.objects.ServiceCenter;
import cscJDBC.objects.City;
import cscJDBC.objects.Employee;
import cscJDBC.objects.Repair;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoServiceCenter implements AbstractDao {

    @Override
    public void insert(Object o) throws SQLException {
        ServiceCenter serviceCenter = (ServiceCenter) o;
        PreparedStatement preparedStatement = ConfigurationInfo.DEFAULT_CONNECTION.prepareStatement(
                "insert into css.\"CarServiceCenter\" values (?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, serviceCenter.getTitle());
        preparedStatement.setString(2, serviceCenter.getPhone());
        preparedStatement.setObject(3, serviceCenter.getCity());
        preparedStatement.setString(4, serviceCenter.getAddress());
        preparedStatement.setObject(5, serviceCenter.getEmployees());
        preparedStatement.setObject(6, serviceCenter.getRepairs());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void delete(Object o) throws SQLException {
        ServiceCenter serviceCenter = (ServiceCenter) o;
        PreparedStatement preparedStatement = ConfigurationInfo.DEFAULT_CONNECTION.prepareStatement(
                "delete from css.\"CarServiceCenter\" where name=?");
        preparedStatement.setString(1, serviceCenter.getTitle());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void update(Object o, String address, String key) throws SQLException {
        PreparedStatement preparedStatement = ConfigurationInfo.DEFAULT_CONNECTION.prepareStatement(
                "update css.\"CarServiceCenter\" set address=? where name=?");
        preparedStatement.setString(1, address);
        preparedStatement.setString(2, key);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public List getAll() throws SQLException {
        List<ServiceCenter> list = new ArrayList<>();
        PreparedStatement preparedStatement = ConfigurationInfo.DEFAULT_CONNECTION.prepareStatement(
                "select * from css.\"CarServiceCenter\"");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            ServiceCenter serviceCenter = new ServiceCenter();
            serviceCenter.setTitle(resultSet.getString(1));
            serviceCenter.setPhone(resultSet.getString(2));
            serviceCenter.setCity((City) resultSet.getObject(3));
            serviceCenter.setAddress(resultSet.getString(4));
            serviceCenter.setEmployees((List<Employee>) resultSet.getObject(5));
            serviceCenter.setRepairs((List<Repair>) resultSet.getObject(6));
            list.add(serviceCenter);
        }
        preparedStatement.close();
        return list;
    }
}
