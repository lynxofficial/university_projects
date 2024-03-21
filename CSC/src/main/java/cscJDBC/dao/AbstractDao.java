package cscJDBC.dao;

import java.sql.SQLException;
import java.util.List;

public interface AbstractDao<T> {

    void insert(T t) throws SQLException;

    void delete(T t) throws SQLException;

    void update(T t, String title, String key) throws SQLException;

    List<T> getAll() throws SQLException;
}
