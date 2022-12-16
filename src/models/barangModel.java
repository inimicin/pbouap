/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import db.dataModeler;
import entity.Barang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author A S U S
 */
public class barangModel {
    private Connection conn;

    public barangModel() {
        dataModeler model = new dataModeler();
        this.conn = model.startConnection();
    }
    
    public ObservableList<Barang> getAllBarang() {
        ObservableList<Barang> data = FXCollections.observableArrayList();
        
        try {
            String sql = "SELECT produk.nama_produk, produk.harga, produk.jumlah, produk.diskon, barang.barcode, barang.expired"
                       + " FROM produk, barang"
                       + " WHERE produk.id_produk = barang.id_produk;";
            
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while(rs.next()){
                data.add(new Barang(rs.getString(5), rs.getString(6), null, rs.getString(1), rs.getDouble(2), rs.getInt(3), rs.getDouble(4)));
            }
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        
        return data;
    }
    
    public void addBarang(Barang barang, String newID){
        PreparedStatement state = null;
        String queryProduk, queryBarang;
        
        try{
            queryProduk = "INSERT INTO \"produk\"\n" +
                          " (\"id_produk\", \"nama_produk\", \"harga\", \"jumlah\", \"diskon\")\n" +
                          " VALUES (?, ?, ?, ?, ?);";
            
            queryBarang = "INSERT INTO \"barang\"\n" +
                          " (\"barcode\", \"expired\", \"id_produk\")\n" +
                          " VALUES (?, ?, ?);";

            state = this.conn.prepareStatement(queryProduk);
            state.setString(1, newID);
            state.setString(2, barang.getNama_produk());
            state.setDouble(3, barang.getHarga());
            state.setInt(4, barang.getJumlah());
            state.setDouble(5, barang.getDiskon());
            state.execute();
            
            state = this.conn.prepareStatement(queryBarang);
            state.setString(1, barang.getBarcode());
            state.setString(2, barang.getExpired());
            state.setString(3, newID);
            state.execute();
            
            System.out.println("Berhasil Ditambahkan!");
        }catch(Exception e){
            System.out.println("Error : " + e);
        }
    }
}