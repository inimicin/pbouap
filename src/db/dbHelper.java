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
public class dbHelper {
    Connection con = null;
    
    public Connection getConnection(){
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:src\\db\\data.db");
            System.out.println("Success!");
            
            return con;
        }catch(Exception e){
            System.out.println("Connection Failed : " + e);
            
            return null;
        }
    }
    
    public void createTable(){
        Connection con = getConnection();
        PreparedStatement state = null;
        
        String query;

        try{
            // Create table nasabah
            query = "CREATE TABLE IF NOT EXISTS \"produk\" (\n" +
                    "	\"id_produk\"	VARCHAR(255) NOT NULL,\n" +
                    "	\"nama_produk\"	VARCHAR(255) NOT NULL,\n" +
                    "	\"harga\"	REAL NOT NULL,\n" +
                    "	\"jumlah\"	INTEGER NOT NULL,\n" +
                    "	\"diskon\"	REAL NOT NULL,\n" +
                    "	PRIMARY KEY(\"id_produk\")\n" +
                    ");";
            
            state = con.prepareStatement(query);
            state.execute();
            
            query = "CREATE TABLE IF NOT EXISTS \"kategori\" (\n" +
                    "	\"id\"	INTEGER NOT NULL,\n" +
                    "	\"nama_kategori\"	VARCHAR(255) NOT NULL,\n" +
                    "	\"id_produk\"	VARCHAR(255) NOT NULL,\n" +
                    "	PRIMARY KEY(\"id\" AUTOINCREMENT),\n" +
                    "	FOREIGN KEY(\"id_produk\") REFERENCES produk(id_produk)\n" +
                    ");";
            
            state = con.prepareStatement(query);
            state.execute();
            
            query = "CREATE TABLE IF NOT EXISTS \"barang\" (\n" +
                    "	\"id\"	INTEGER NOT NULL,\n" +
                    "	\"barcode\"	VARCHAR(255) NOT NULL,\n" +
                    "   \"expired\"	VARCHAR(255) NOT NULL,\n" +
                    "	\"id_produk\"	VARCHAR(255) NOT NULL,\n" +
                    "	PRIMARY KEY(\"id\" AUTOINCREMENT),\n" +
                    "	FOREIGN KEY(\"id_produk\") REFERENCES produk(id_produk)\n" +
                    ");";
            
            state = con.prepareStatement(query);
            state.execute();
            
            con.close();
        }catch(Exception e){
            System.out.println("Error : " + e);
        }
    }
}
