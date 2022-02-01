package cscJDBC.postgresObjects;

import cscJDBC.dao.AbstractDao;
import cscJDBC.objects.City;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgresCity extends AbstractDao {
    public PostgresCity() throws SQLException {
    }

    @Override
    public void insert(Object o) throws SQLException {
        City city = (City) o;
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "insert into css.\"City\" values (?, ?)");
        preparedStatement.setString(1, city.getTitle());
        preparedStatement.setString(2, city.getCode());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void delete(Object o) throws SQLException {
        City city = (City) o;
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "delete from css.\"City\" where code=?");
        preparedStatement.setString(1, city.getCode());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void update(Object o, String title, String key) throws SQLException {
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "update css.\"City\" set name=? where code=?");
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, key);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public List getAll() throws SQLException {
        List<City> list = new ArrayList<>();
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement("select * from css.\"City\"");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            City city = new City();
            city.setTitle(resultSet.getString(1));
            city.setCode(resultSet.getString(2));
            list.add(city);
        }
        preparedStatement.close();
        return list;
    }
}
