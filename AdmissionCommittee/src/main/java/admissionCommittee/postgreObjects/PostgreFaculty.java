package admissionCommittee.postgreObjects;

import admissionCommittee.dao.AbstractDao;
import admissionCommittee.objects.Faculty;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgreFaculty extends AbstractDao {
    public PostgreFaculty() throws SQLException {
    }

    @Override
    public void insert(Object o) throws SQLException {
        Faculty faculty = (Faculty) o;
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "insert into acd.faculties values (?, ?, ?, ?, ?)");
        preparedStatement.setInt(1, faculty.getFacultyCode());
        preparedStatement.setString(2, faculty.getFacultyName());
        preparedStatement.setString(3, faculty.getExams()[0]);
        preparedStatement.setString(4, faculty.getExams()[1]);
        preparedStatement.setObject(5, faculty.getExams()[2]);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void delete(Object o) throws SQLException {
        Faculty faculty = (Faculty) o;
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "delete from acd.faculties where faculty_code=?");
        preparedStatement.setInt(1, faculty.getFacultyCode());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void update(int id, Object o) throws SQLException {
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "update acd.faculties set faculty_name=? where faculty_code=?");
        preparedStatement.setString(1, (String) o);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public List getAll() throws SQLException {
        List<Faculty> faculties = new ArrayList<>();
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "select * from acd.faculties");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Faculty faculty = new Faculty();
            faculty.setFacultyCode(resultSet.getInt(1));
            faculty.setFacultyName(resultSet.getString(2));
            String[] exams = {resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)};
            faculty.setExams(exams);
            faculties.add(faculty);
        }
        return faculties;
    }
}
