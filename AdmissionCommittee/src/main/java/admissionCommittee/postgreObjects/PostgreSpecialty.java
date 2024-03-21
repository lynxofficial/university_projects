package admissionCommittee.postgreObjects;

import admissionCommittee.dao.AbstractDao;
import admissionCommittee.objects.Specialty;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgreSpecialty extends AbstractDao {
    public PostgreSpecialty() throws SQLException {
    }

    @Override
    public void insert(Object o) throws SQLException {
        Specialty specialty = (Specialty) o;
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "insert into acd.specialties values (?, ?, ?, ?)");
        preparedStatement.setInt(1, specialty.getSpecialtyCode());
        preparedStatement.setString(2, specialty.getSpecialtyName());
        preparedStatement.setInt(3, specialty.getFacultyCode());
        preparedStatement.setInt(4, specialty.getAdmissionPlan());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void delete(Object o) throws SQLException {
        Specialty specialty = (Specialty) o;
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "delete from acd.specialties where specialty_code=?");
        preparedStatement.setInt(1, specialty.getSpecialtyCode());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void update(int id, Object o) throws SQLException {
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "update acd.specialties set specialty_name=? where specialty_code=?");
        preparedStatement.setString(1, (String) o);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public List getAll() throws SQLException {
        List<Specialty> specialties = new ArrayList<>();
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "select * from acd.specialties");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Specialty specialty = new Specialty();
            specialty.setSpecialtyCode(resultSet.getInt(1));
            specialty.setSpecialtyName(resultSet.getString(2));
            specialty.setFacultyCode(resultSet.getInt(3));
            specialty.setAdmissionPlan(resultSet.getInt(4));
            specialties.add(specialty);
        }
        return specialties;
    }
}
