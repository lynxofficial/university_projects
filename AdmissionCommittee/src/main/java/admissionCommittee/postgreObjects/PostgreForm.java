package admissionCommittee.postgreObjects;

import admissionCommittee.dao.AbstractDao;
import admissionCommittee.objects.Form;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgreForm extends AbstractDao {
    public PostgreForm() throws SQLException {
    }

    @Override
    public void insert(Object o) throws SQLException {
        Form form = (Form) o;
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "insert into acd.forms values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setInt(1, form.getFormId());
        preparedStatement.setString(2, form.getLastName());
        preparedStatement.setString(3, form.getFirstName());
        preparedStatement.setString(4, form.getMiddleName());
        preparedStatement.setString(5, form.getDateOfBirthday());
        preparedStatement.setString(6, form.getCountry());
        preparedStatement.setString(7, form.getCity());
        preparedStatement.setString(8, form.getEducationEstablishment());
        preparedStatement.setInt(9, form.getRegistrationNumber());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void delete(Object o) throws SQLException {
        Form form = (Form) o;
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "delete from acd.forms where form_id=?");
        preparedStatement.setInt(1, form.getFormId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void update(int id, Object o) throws SQLException {
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "update acd.forms set last_name=? where form_id=?");
        preparedStatement.setString(1, (String) o);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public List getAll() throws SQLException {
        List<Form> forms = new ArrayList<>();
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "select * from acd.forms");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Form form = new Form();
            form.setFormId(resultSet.getInt(1));
            form.setLastName(resultSet.getString(2));
            form.setFirstName(resultSet.getString(3));
            form.setMiddleName(resultSet.getString(4));
            form.setDateOfBirthday(resultSet.getString(5));
            form.setCountry(resultSet.getString(6));
            form.setCity(resultSet.getString(7));
            form.setEducationEstablishment(resultSet.getString(8));
            form.setRegistrationNumber(resultSet.getInt(9));
            forms.add(form);
        }
        return forms;
    }
}
