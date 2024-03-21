package admissionCommittee.postgreObjects;

import admissionCommittee.dao.AbstractDao;
import admissionCommittee.objects.Result;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgreResult extends AbstractDao {
    public PostgreResult() throws SQLException {
    }

    @Override
    public void insert(Object o) throws SQLException {
        Result result = (Result) o;
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "insert into acd.results values (?, ?, ?)");
        preparedStatement.setInt(1, result.getResultId());
        preparedStatement.setInt(2, result.getRegistrationNumber());
        preparedStatement.setBoolean(3, result.isEnrollment());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void delete(Object o) throws SQLException {
        Result enrollee = (Result) o;
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "delete from acd.results where result_id=?");
        preparedStatement.setInt(1, enrollee.getResultId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void update(int id, Object o) throws SQLException {
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "update acd.results set enrollment=? where result_id=?");
        preparedStatement.setBoolean(1, (Boolean) o);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public List getAll() throws SQLException {
        List<Result> results = new ArrayList<>();
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "select * from acd.results");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Result result = new Result();
            result.setResultId(resultSet.getInt(1));
            result.setRegistrationNumber(resultSet.getInt(2));
            result.setEnrollment(resultSet.getBoolean(3));
            results.add(result);
        }
        return results;
    }
}
