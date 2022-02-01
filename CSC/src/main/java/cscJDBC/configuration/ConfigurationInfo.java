package cscJDBC.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigurationInfo {
    protected final Connection DEFAULT_CONNECTION = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/css_database",
            "postgres",
            "1234");

    public ConfigurationInfo() throws SQLException {
    }
}
