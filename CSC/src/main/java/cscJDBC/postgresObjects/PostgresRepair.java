package cscJDBC.postgresObjects;

import cscJDBC.dao.AbstractDao;
import cscJDBC.objects.CarServiceCenter;
import cscJDBC.objects.Employee;
import cscJDBC.objects.Repair;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgresRepair extends AbstractDao {
    public PostgresRepair() throws SQLException {
    }

    @Override
    public void insert(Object o) throws SQLException {
        Repair repair = (Repair) o;
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "insert into css.\"Repair\" values (?, ?, ?)");
        preparedStatement.setString(1, repair.getDescription());
        preparedStatement.setObject(2, repair.getCenter());
        preparedStatement.setObject(3, repair.getEmployee());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void delete(Object o) throws SQLException {
        Repair repair = (Repair) o;
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "delete from css.\"Repair\" where description=?");
        preparedStatement.setString(1, repair.getDescription());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void update(Object o, String desc, String key) throws SQLException {
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "update css.\"Repair\" set description=? where center=?");
        preparedStatement.setString(1, desc);
        preparedStatement.setString(2, key);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public List getAll() throws SQLException {
        List<Repair> list = new ArrayList<>();
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement("select * from css.\"Repair\"");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Repair repair = new Repair();
            repair.setDescription(resultSet.getString(1));
            repair.setCenter((CarServiceCenter) resultSet.getObject(2));
            repair.setEmployee((Employee) resultSet.getObject(3));
            list.add(repair);
        }
        preparedStatement.close();
        return list;
    }
}
