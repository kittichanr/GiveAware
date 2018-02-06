package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionBuilder {

    public static Connection getConnection() throws ClassNotFoundException {

        Connection conn = null;

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();

        try {

            Properties prop = new Properties();

            InputStream input = classloader.getResourceAsStream("config.properties");

            prop.load(input);

            String DB = prop.getProperty("jdbc.db");

            String USERNAME = prop.getProperty("jdbc.username");

            String PASSWORD = prop.getProperty("jdbc.password");

            String PORT = prop.getProperty("jdbc.port");

            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://" + DB + ":" + PORT + "/GiveAware?zeroDateTimeBehavior=convertToNull", USERNAME, PASSWORD);

        } catch (SQLException | ClassCastException | IOException err) {

            System.err.println(err);

        }

        return conn;
//---

    }
}
