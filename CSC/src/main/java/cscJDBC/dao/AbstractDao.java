package cscJDBC.dao;

import cscJDBC.configuration.ConfigurationInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDao<T> extends ConfigurationInfo {
    protected AbstractDao() throws SQLException {
    }

    public abstract void insert(T t) throws SQLException;

    public abstract void delete(T t) throws SQLException;

    public abstract void update(T t, String title, String key) throws SQLException;

    public abstract List<T> getAll() throws SQLException;
}
