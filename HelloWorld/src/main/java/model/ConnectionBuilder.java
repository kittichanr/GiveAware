/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author yeen
 */
public class ConnectionBuilder {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        String username = "root";
        String password = "Attapon1840%";
        //String url = "jdbc:derby://localhost:1527/Hello";
        String url = "jdbc:mysql://13.250.20.158:3306/GiveAware?zeroDateTimeBehavior=convertToNull";

        Connection con = null;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, username, password);
        return con;
    }

    public static Connection getCon() {

        Connection con = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://13.250.20.158:3306/GiveAware?zeroDateTimeBehavior=convertToNull", "root", "password");

        } catch (Exception e) {

            System.out.println(e);

        }

        return con;

    }
}
