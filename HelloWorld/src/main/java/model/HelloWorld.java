/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import model.ConnectionBuilder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author yeen
 */
public class HelloWorld {

    private int idName;
    private String name;

    public HelloWorld(ResultSet rs) throws SQLException {
        idName = rs.getInt("idName");
        name = rs.getString("name");
    }

    public HelloWorld() {
    }

    public String getMessageName() {
        return name;
    }

    public void setMessageName(String messageName) {
        this.name = messageName;
    }

    public String showMessage() {
        String SQL = "SELECT * FROM HelloWorld";
        Connection con = null;
        String world = "";
        try {
            con = (Connection) ConnectionBuilder.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                world = rs.getString("name");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return world;
    }

    public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();
        System.out.println(hw.showMessage());
    }
}
