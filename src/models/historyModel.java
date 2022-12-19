/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import db.dataModeler;
import entity.Barang;
import entity.History;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author adiha
 */
public class historyModel {
     private Connection conn;

    public historyModel() {
        dataModeler model = new dataModeler();
        this.conn = model.startConnection();
    }
    
    public ObservableList<History> getAllData(){
        ObservableList<History> data = FXCollections.observableArrayList();
        
        try {
            String sql = "SELECT *"
                       + " FROM data_pembelian;";
            
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while(rs.next()){
                data.add(new History(rs.getInt(1), rs.getDouble(2)));
            }
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        
        return data;
    }
    
    public void addHistory(double total) {
        PreparedStatement state = null;
        String query;
        
        try{
            query = "INSERT INTO \"data_pembelian\"\n" +
                          " (\"total_harga\")\n" +
                          " VALUES (?);";

            state = this.conn.prepareStatement(query);
            state.setDouble(1, total);
            state.execute();
            
            System.out.println("Berhasil Ditambahkan!");
        }catch(Exception e){
            System.out.println("Error : " + e);
        }
    }
    
    public void deleteHistory(int id){
        PreparedStatement state = null;
        String query;
        
        try{
            query = "DELETE FROM data_pembelian WHERE id=".concat(Integer.toString(id)).concat(";");

            state = this.conn.prepareStatement(query);
            state.execute();
            
            System.out.println("Berhasil Dihapus!");
        }catch(Exception e){
            System.out.println("Error : " + e);
        }
    }
}
