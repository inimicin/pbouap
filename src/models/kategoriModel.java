/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import db.dataModeler;
import db.dbHelper;
import entity.Barang;
import entity.Kategori;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author adiha
 */
public class kategoriModel {
    private Connection conn;

    public kategoriModel() {
        this.conn = dataModeler.conn;
    }
    
    public void addData(Kategori kategori, String idProduk) {
        PreparedStatement state = null;
        String query;
        
        try{
            query = "INSERT INTO \"kategori\"\n" +
                          " (\"nama_kategori\", \"id_produk\")\n" +
                          " VALUES (?, ?);";

            state = this.conn.prepareStatement(query);
            state.setString(1, kategori.getNama_kategori());
            state.setString(2, idProduk);
            state.execute();
            
            System.out.println("Berhasil Ditambahkan!");
        }catch(Exception e){
            System.out.println("Error : " + e);
        }
    }
    
    public ObservableList<Kategori> getAllData(){
        ObservableList<Kategori> data = FXCollections.observableArrayList();
        
        try {
            String sql = "SELECT id, nama_kategori"
                       + " FROM kategori;";
            
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while(rs.next()){
                data.add(new Kategori(rs.getString(2), rs.getInt(1)));
            }
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        
        return data;
    }
    
    public void deleteData(int id) {
        PreparedStatement state = null;
        String query;
        
        try{
            query = "DELETE FROM kategori WHERE id=".concat(Integer.toString(id)).concat(";");

            state = this.conn.prepareStatement(query);
            state.execute();
            
            System.out.println("Berhasil Dihapus!");
        }catch(Exception e){
            System.out.println("Error : " + e);
        }
    }
}
