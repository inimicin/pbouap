/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.*;

/**
 *
 * @author A S U S
 */
public class dataModeler {
    public static Connection conn;

    public dataModeler() {
        dbHelper helper = new dbHelper();
        this.conn = helper.getConnection();
    }
    
    public Connection startConnection() {    
        return conn;
    }
    
    public boolean getStatus() {
        return this.conn == null;
    }
}
