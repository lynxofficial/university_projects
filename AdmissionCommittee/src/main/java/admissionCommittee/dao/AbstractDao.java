package admissionCommittee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDao<T> {
    protected final Connection DEFAULT_CONNECTION = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/admission_committee_database",
            "postgres",
            "1234");

    protected AbstractDao() throws SQLException {
    }

    public abstract void insert(T t) throws SQLException;

    public abstract void delete(T t) throws SQLException;

    public abstract void update(int id, Object o) throws SQLException;

    public abstract List<T> getAll() throws SQLException;

}
