package cscJDBC.postgresObjects;

import cscJDBC.dao.AbstractDao;
import cscJDBC.objects.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgresCustomer extends AbstractDao {
    public PostgresCustomer() throws SQLException {
    }

    @Override
    public void insert(Object o) throws SQLException {
        Customer customer = (Customer) o;
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "insert into css.\"CarServiceCenter\" values (?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, customer.getName());
        preparedStatement.setString(2, customer.getPhone());
        preparedStatement.setString(3, customer.getEmail());
        preparedStatement.setObject(4, customer.getCenters());
        preparedStatement.setObject(5, customer.getPassportNo());
        preparedStatement.setObject(6, customer.getInn());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void delete(Object o) throws SQLException {
        Customer customer = (Customer) o;
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "delete from css.\"Customer\" where name=?");
        if (customer.getPassportNo() != null) {
            preparedStatement.setString(1, customer.getPassportNo());
        } else {
            preparedStatement.setString(1, customer.getInn());
        }
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void update(Object o, String phone, String name) throws SQLException {
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "update css.\"Customer\" set phone=? where name=?");
        preparedStatement.setString(1, phone);
        preparedStatement.setString(2, name);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public List getAll() throws SQLException {
        List<Customer> list = new ArrayList<>();
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "select * from css.\"Customer\"");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setName(resultSet.getString(1));
            customer.setPhone(resultSet.getString(2));
            customer.setEmail(resultSet.getString(3));
            customer.setCenters((List<CarServiceCenter>) resultSet.getObject(4));
            customer.setPassportNo(resultSet.getString(5));
            customer.setInn(resultSet.getString(6));
            list.add(customer);
        }
        return list;
    }
}
