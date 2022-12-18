/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import db.dataModeler;
import entity.History;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
