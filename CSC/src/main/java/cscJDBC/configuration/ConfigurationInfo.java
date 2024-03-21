package cscJDBC.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigurationInfo {
    public static final Connection DEFAULT_CONNECTION;

    static {
        try {
            DEFAULT_CONNECTION = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/css_database",
                    "postgres",
                    "1234");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
