package org.cst8288Lab2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 
 * @author moztu
 */

public class DatabaseUtil {

    private static String url;
    private static String username;
    private static String password;

    static {
        try (InputStream input = DatabaseUtil.class.getClassLoader().getResourceAsStream("data/database.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find database.properties");
                throw new IOException("Database properties file not found");
            } else {
                prop.load(input);
                url = prop.getProperty("db.url");
                username = prop.getProperty("db.username");
                password = prop.getProperty("db.password");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            if (url == null || username == null || password == null) {
                throw new SQLException("Database connection properties are not set");
            }
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
