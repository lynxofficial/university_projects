package admissionCommittee.postgreObjects;

import admissionCommittee.dao.AbstractDao;
import admissionCommittee.objects.Enrollee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgreEnrollee extends AbstractDao {
    public PostgreEnrollee() throws SQLException {
    }

    @Override
    public void insert(Object o) throws SQLException {
        Enrollee enrollee = (Enrollee) o;
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "insert into acd.enrollees values (?, ?, ?)");
        preparedStatement.setInt(1, enrollee.getRegistrationNumber());
        preparedStatement.setInt(2, enrollee.getSpecialtyCode());
        preparedStatement.setBoolean(3, enrollee.isAchievements());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void delete(Object o) throws SQLException {
        Enrollee enrollee = (Enrollee) o;
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "delete from acd.enrollees where registration_number=?");
        preparedStatement.setInt(1, enrollee.getRegistrationNumber());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void update(int id, Object o) throws SQLException {
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "update acd.enrollees set achievements=? where specialty_code=?");
        preparedStatement.setBoolean(1, (Boolean) o);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public List getAll() throws SQLException {
        List<Enrollee> enrollees = new ArrayList<>();
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "select * from acd.enrollees");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Enrollee enrollee = new Enrollee();
            enrollee.setRegistrationNumber(resultSet.getInt(1));
            enrollee.setSpecialtyCode(resultSet.getInt(2));
            enrollee.setAchievements(resultSet.getBoolean(3));
            enrollees.add(enrollee);
        }
        return enrollees;
    }
}
