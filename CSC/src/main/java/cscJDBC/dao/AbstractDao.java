package cscJDBC.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDao<T> {
    protected final Connection DEFAULT_CONNECTION = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/css_database",
            "postgres",
            "1234");

    protected AbstractDao() throws SQLException {
    }

    public abstract void insert(T t) throws SQLException;

    public abstract void delete(T t) throws SQLException;

    public abstract void update(T t, String title, String key) throws SQLException;

    public abstract List<T> getAll() throws SQLException;
}
