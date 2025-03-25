package com.randyn1080.jdbctutorial.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static final Properties properties = new Properties();
    private static final String PROPERTIES_FILE = "database.properties";

    private static String URL;
    private static String USER;
    private static String PASSWORD;

    private static ConnectionFactory instance;

    private ConnectionFactory() {
        try {
            // load the properties
            loadProperties();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file", e);
        }
    }

    private void loadProperties() throws IOException {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                throw new IOException("unable to find "+ PROPERTIES_FILE);
            }

            // load properties
            properties.load(input);

            // Set the database properties
            URL = properties.getProperty("jdbc.url");
            USER = properties.getProperty("jdbc.username");
            PASSWORD = properties.getProperty("jdbc.password");

        }
    }

    public static ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
